/*
 * Copyright (C) 2017 Reece H. Dunn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.co.reecedunn.intellij.plugin.xquery.lang

// region BaseX

private class BaseXProduct(id: String, name: String, implementation: Implementation) : Product(id, name, implementation) {
    override fun toString(): String = name

    override fun supportsFeature(version: Version, feature: XQueryFeature): Boolean = true

    override fun conformsTo(productVersion: Version, ref: Version): Boolean = when (ref) {
        XmlSchema.REC_1_0_20041028, XmlSchema.REC_1_1_20120405 -> true
        XQuery.REC_3_0_20140408 -> productVersion.value >= 7.7 // Full implementation.
        XQuery.CR_3_1_20151217  -> productVersion.value <= 8.5
        XQuery.REC_3_1_20170321 -> productVersion.value >= 8.6
        FullText.REC_1_0_20110317, FullText.REC_3_0_20151124 -> true
        UpdateFacility.REC_1_0_20110317 -> true
        UpdateFacility.NOTE_3_0_20170124 -> productVersion.value >= 8.5
        FunctionsAndOperators.REC_3_0_20140408 -> productVersion.value >= 7.7
        FunctionsAndOperators.REC_3_1_20170321 -> productVersion.value >= 8.6
        else -> ref.kind === implementation && ref.value <= productVersion.value
    }

    @Suppress("PropertyName")
    val FLAVOURS_XQUERY: List<Versioned> = listOf(BaseX, XQuery, FullText, UpdateFacility)
    @Suppress("PropertyName")
    val FLAVOURS_UNSUPPORTED: List<Versioned> = listOf()

    override fun flavoursForXQueryVersion(productVersion: Version, version: String): List<Versioned> = when (version) {
        "3.0", "3.1" -> FLAVOURS_XQUERY
        else -> FLAVOURS_UNSUPPORTED
    }
}

object BaseX : Implementation("basex", "BaseX", "http://www.basex.org/") {
    val VERSION_6_1: Version = ProductVersion("6.1", this) // Conformance with Update Facility and Full Text.
    val VERSION_7_8: Version = ProductVersion("7.8", this) // Introduction of the BaseX UpdateExpr.
    val VERSION_8_4: Version = ProductVersion("8.4", this)
    val VERSION_8_5: Version = ProductVersion("8.5", this)
    val VERSION_8_6: Version = ProductVersion("8.6", this)

    override val versions: List<Version> = listOf(
        VERSION_8_4,
        VERSION_8_5,
        VERSION_8_6)

    val BASEX: Product = BaseXProduct("basex", "BaseX", this)

    override val products: List<Product> = listOf(BASEX)

    override fun supportsDialect(dialect: Versioned): Boolean =
        dialect === this ||
        dialect === FullText ||
        dialect === UpdateFacility ||
        dialect === XQuery

    override fun staticContext(product: Product?, productVersion: Version?, xqueryVersion: Specification?): String? = when (xqueryVersion) {
        XQuery.REC_1_0_20070123, XQuery.REC_1_0_20101214 ->
            "res://www.w3.org/TR/xquery.xqy"
        XQuery.REC_3_0_20140408 ->
            "res://www.w3.org/TR/xquery-30.xqy"
        XQuery.REC_3_1_20170321, XQuery.CR_3_1_20151217 ->
            "res://www.w3.org/TR/xquery-31.xqy"
        else -> null
    }
}

// endregion
// region MarkLogic

private class MarkLogicProduct(id: String, name: String, implementation: Implementation) : Product(id, name, implementation) {
    override fun toString(): String = name

    override fun supportsFeature(version: Version, feature: XQueryFeature): Boolean = true

    override fun conformsTo(productVersion: Version, ref: Version): Boolean = when (ref) {
        XmlSchema.REC_1_0_20041028 -> true
        XmlSchema.REC_1_1_20120405 -> productVersion.value >= 9.0
        XQuery.REC_1_0_20070123 -> true
        XQuery.MARKLOGIC_0_9 -> true
        XQuery.MARKLOGIC_1_0 -> true
        FunctionsAndOperators.REC_1_0_20070123 -> true
        FunctionsAndOperators.REC_3_0_20140408 -> true
        else -> ref.kind === implementation && ref.value <= productVersion.value
    }

    @Suppress("PropertyName")
    val FLAVOURS_XQUERY: List<Versioned> = listOf(XQuery)
    @Suppress("PropertyName")
    val FLAVOURS_MARKLOGIC: List<Versioned> = listOf(MarkLogic)
    @Suppress("PropertyName")
    val FLAVOURS_UNSUPPORTED: List<Versioned> = listOf()

    override fun flavoursForXQueryVersion(productVersion: Version, version: String): List<Versioned> = when (version) {
        "0.9-ml" -> FLAVOURS_MARKLOGIC
        "1.0" -> FLAVOURS_XQUERY
        "1.0-ml" -> FLAVOURS_MARKLOGIC
        else -> FLAVOURS_UNSUPPORTED
    }
}

object MarkLogic : Implementation("marklogic", "MarkLogic", "http://www.marklogic.com/") {
    val VERSION_4_0: Version = ProductVersion("4.0", this) // Introduction of the 1.0-ml syntax.
    val VERSION_6_0: Version = ProductVersion("6.0", this)
    val VERSION_7_0: Version = ProductVersion("7.0", this)
    val VERSION_8_0: Version = ProductVersion("8.0", this)
    val VERSION_9_0: Version = ProductVersion("9.0", this)

    override val versions: List<Version> = listOf(
        VERSION_6_0,
        VERSION_7_0,
        VERSION_8_0,
        VERSION_9_0)

    val MARKLOGIC: Product = MarkLogicProduct("marklogic", "MarkLogic", this)

    override val products: List<Product> = listOf(MARKLOGIC)

    override fun supportsDialect(dialect: Versioned): Boolean =
        dialect === this || dialect === XQuery

    override fun staticContext(product: Product?, productVersion: Version?, xqueryVersion: Specification?): String? {
        if (productVersion == null) return null
        return when (xqueryVersion) {
            XQuery.REC_1_0_20070123, XQuery.REC_1_0_20101214 ->
                "res://marklogic.com/${productVersion.value}/1.0.xqy"
            XQuery.MARKLOGIC_1_0 ->
                "res://marklogic.com/${productVersion.value}/1.0-ml.xqy"
            else -> null
        }
    }
}

// endregion
// region Saxon (Saxonica)

private class SaxonProduct(id: String, name: String, implementation: Implementation) : Product(id, name, implementation) {
    override fun supportsFeature(version: Version, feature: XQueryFeature): Boolean = when (feature) {
        // http://www.saxonica.com/products/feature-matrix-9-8.xml:
        XQueryFeature.MINIMAL_CONFORMANCE, XQueryFeature.FULL_AXIS, XQueryFeature.MODULE, XQueryFeature.SERIALIZATION ->
            true
        XQueryFeature.HIGHER_ORDER_FUNCTION ->
            this !== Saxon.HE
        XQueryFeature.SCHEMA_IMPORT, XQueryFeature.SCHEMA_VALIDATION, XQueryFeature.TYPED_DATA ->
            this === Saxon.EE || this == Saxon.EE_Q
        XQueryFeature.STATIC_TYPING ->
            false
    }

    override fun conformsTo(productVersion: Version, ref: Version): Boolean = when (ref) {
        XmlSchema.REC_1_0_20041028, XmlSchema.REC_1_1_20120405 ->
            true
        XQuery.REC_1_0_20070123 -> true
        XQuery.REC_3_0_20140408 -> productVersion.value >= 9.6 || (productVersion.value >= 9.5 && this !== Saxon.HE)
        XQuery.CR_3_1_20151217  -> productVersion === Saxon.VERSION_9_7
        XQuery.REC_3_1_20170321 -> productVersion.value >= 9.8
        UpdateFacility.REC_1_0_20110317 -> this !== Saxon.HE && this !== Saxon.PE
        FunctionsAndOperators.REC_1_0_20070123 -> true
        FunctionsAndOperators.REC_3_0_20140408 -> productVersion.value >= 9.6 || (productVersion.value >= 9.5 && this !== Saxon.HE)
        FunctionsAndOperators.REC_3_1_20170321 -> productVersion.value >= 9.8
        else -> ref.kind === implementation && ref.value <= productVersion.value
    }

    // UpdateFacility support requires EE (http://www.saxonica.com/products/feature-matrix-9-8.xml)
    // Saxon extensions require PE or EE (http://www.saxonica.com/documentation/index.html#!extensions/syntax-extensions)
    @Suppress("PropertyName")
    val FLAVOURS_EE: List<Versioned> = listOf(Saxon, XQuery, UpdateFacility)
    @Suppress("PropertyName")
    val FLAVOURS_PE: List<Versioned> = listOf(Saxon, XQuery)
    @Suppress("PropertyName")
    val FLAVOURS_HE: List<Versioned> = listOf(XQuery)
    @Suppress("PropertyName")
    val FLAVOURS_UNSUPPORTED: List<Versioned> = listOf()

    override fun flavoursForXQueryVersion(productVersion: Version, version: String): List<Versioned> = when (version) {
        "1.0", "3.0", "3.1" -> when (this) {
            Saxon.EE, Saxon.EE_Q, Saxon.EE_V, Saxon.EE_T -> FLAVOURS_EE
            Saxon.PE -> FLAVOURS_PE
            Saxon.HE -> FLAVOURS_HE
            else -> FLAVOURS_UNSUPPORTED
        }
        else -> FLAVOURS_UNSUPPORTED
    }
}

object Saxon : Implementation("saxon", "Saxon", "http://www.saxonica.com") {
    val VERSION_9_4: Version = ProductVersion("9.4", this) // Introduction of the `map` vendor extension in XQuery 3.0
    val VERSION_9_5: Version = ProductVersion("9.5", this)
    val VERSION_9_6: Version = ProductVersion("9.6", this)
    val VERSION_9_7: Version = ProductVersion("9.7", this)
    val VERSION_9_8: Version = ProductVersion("9.8", this)

    override val versions: List<Version> = listOf(
        VERSION_9_5,
        VERSION_9_6,
        VERSION_9_7,
        VERSION_9_8)

    val HE: Product = SaxonProduct("HE", "Home Edition", this)
    val PE: Product = SaxonProduct("PE", "Professional Edition", this)
    val EE: Product = SaxonProduct("EE", "Enterprise Edition", this)
    val EE_T: Product = SaxonProduct("EE-T", "Enterprise Edition (Transformation package)", this)
    val EE_Q: Product = SaxonProduct("EE-Q", "Enterprise Edition (Query package)", this)
    val EE_V: Product = SaxonProduct("EE-V", "Enterprise Edition (Validation package)", this)

    override val products: List<Product> = listOf(HE, PE, EE, EE_T, EE_Q, EE_V)

    override fun supportsDialect(dialect: Versioned): Boolean =
        dialect === this || dialect === UpdateFacility || dialect === XQuery

    override fun staticContext(product: Product?, productVersion: Version?, xqueryVersion: Specification?): String? = when (xqueryVersion) {
        XQuery.REC_1_0_20070123, XQuery.REC_1_0_20101214 ->
            "res://www.w3.org/TR/xquery.xqy"
        XQuery.REC_3_0_20140408 ->
            "res://www.w3.org/TR/xquery-30.xqy"
        XQuery.REC_3_1_20170321, XQuery.CR_3_1_20151217 ->
            "res://www.w3.org/TR/xquery-31.xqy"
        else -> null
    }
}

// endregion
// region W3C Specifications

private class W3CProduct(id: String, name: String, implementation: Implementation) : Product(id, name, implementation) {
    override fun supportsFeature(version: Version, feature: XQueryFeature): Boolean = true

    override fun conformsTo(productVersion: Version, ref: Version): Boolean = when (ref) {
        XmlSchema.REC_1_0_20041028, XmlSchema.REC_1_1_20120405 ->
            true
        XQuery.REC_1_0_20070123, XQuery.REC_3_0_20140408, XQuery.REC_3_1_20170321 ->
            productVersion === W3C.FIRST_EDITION
        XQuery.REC_1_0_20101214 ->
            productVersion === W3C.SECOND_EDITION
        FullText.REC_1_0_20110317, FullText.REC_3_0_20151124 ->
            productVersion === W3C.FIRST_EDITION
        UpdateFacility.REC_1_0_20110317, UpdateFacility.NOTE_3_0_20170124 ->
            productVersion === W3C.FIRST_EDITION
        Scripting.NOTE_1_0_20140918 ->
            productVersion === W3C.FIRST_EDITION
        FunctionsAndOperators.REC_1_0_20070123, FunctionsAndOperators.REC_3_0_20140408, FunctionsAndOperators.REC_3_1_20170321 ->
            productVersion === W3C.FIRST_EDITION
        FunctionsAndOperators.REC_1_0_20101214 ->
            productVersion === W3C.SECOND_EDITION
        else -> false // NOTE: 1ed/2ed conformance is done at the Specification level.
    }

    @Suppress("PropertyName")
    val FLAVOURS_XQUERY_1_0: List<Versioned> = listOf(XQuery, FullText, UpdateFacility, Scripting)
    @Suppress("PropertyName")
    val FLAVOURS_XQUERY_3_0: List<Versioned> = listOf(XQuery, FullText, UpdateFacility)
    @Suppress("PropertyName")
    val FLAVOURS_XQUERY: List<Versioned> = listOf(XQuery)
    @Suppress("PropertyName")
    val FLAVOURS_UNSUPPORTED: List<Versioned> = listOf()

    override fun flavoursForXQueryVersion(productVersion: Version, version: String): List<Versioned> = when (version) {
        "1.0" -> if (productVersion === W3C.FIRST_EDITION) FLAVOURS_XQUERY_1_0 else FLAVOURS_XQUERY
        "3.0" -> if (productVersion === W3C.FIRST_EDITION) FLAVOURS_XQUERY_3_0 else FLAVOURS_XQUERY
        "3.1" -> FLAVOURS_XQUERY
        else -> FLAVOURS_UNSUPPORTED
    }
}

object W3C : Implementation("w3c", "W3C", "https://www.w3.org/XML/Query/") {
    val FIRST_EDITION: NamedVersion = NamedVersion("1ed", 1.0, "First Edition", this)
    val SECOND_EDITION: NamedVersion = NamedVersion("2ed", 2.0, "Second Edition", this)

    override val versions: List<Version> = listOf(FIRST_EDITION, SECOND_EDITION)

    val SPECIFICATIONS: Product = W3CProduct("spec", "Specifications", this)

    override val products: List<Product> = listOf(SPECIFICATIONS)

    override fun staticContext(product: Product?, productVersion: Version?, xqueryVersion: Specification?): String? = when (xqueryVersion) {
        XQuery.REC_1_0_20070123, XQuery.REC_1_0_20101214 ->
            "res://www.w3.org/TR/xquery.xqy"
        XQuery.REC_3_0_20140408 ->
            "res://www.w3.org/TR/xquery-30.xqy"
        XQuery.REC_3_1_20170321, XQuery.CR_3_1_20151217 ->
            "res://www.w3.org/TR/xquery-31.xqy"
        else -> null
    }
}

// endregion

val PRODUCTS: List<Product> = listOf(
    BaseX.BASEX,
    MarkLogic.MARKLOGIC,
    Saxon.HE,
    Saxon.PE,
    Saxon.EE,
    Saxon.EE_Q,
    Saxon.EE_T,
    Saxon.EE_V,
    W3C.SPECIFICATIONS)

fun defaultStaticContext(xquery: Specification?): String? = when (xquery) {
    XQuery.REC_1_0_20070123, XQuery.REC_1_0_20101214 ->
        W3C.staticContext(W3C.SPECIFICATIONS, W3C.FIRST_EDITION, xquery)
    XQuery.REC_3_0_20140408 ->
        W3C.staticContext(W3C.SPECIFICATIONS, W3C.FIRST_EDITION, xquery)
    XQuery.REC_3_1_20170321, XQuery.CR_3_1_20151217 ->
        W3C.staticContext(W3C.SPECIFICATIONS, W3C.FIRST_EDITION, xquery)
    XQuery.MARKLOGIC_1_0, XQuery.MARKLOGIC_0_9 ->
        MarkLogic.staticContext(MarkLogic.MARKLOGIC, MarkLogic.VERSION_9_0, xquery)
    else -> null
}
