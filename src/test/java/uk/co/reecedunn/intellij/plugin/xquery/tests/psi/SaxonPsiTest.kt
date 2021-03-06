/*
 * Copyright (C) 2016-2017 Reece H. Dunn
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
package uk.co.reecedunn.intellij.plugin.xquery.tests.psi

import com.intellij.psi.tree.IElementType
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import uk.co.reecedunn.intellij.plugin.core.sequences.children
import uk.co.reecedunn.intellij.plugin.core.sequences.descendants
import uk.co.reecedunn.intellij.plugin.xpath.ast.xpath.XPathMapConstructor
import uk.co.reecedunn.intellij.plugin.xpath.ast.xpath.XPathMapConstructorEntry
import uk.co.reecedunn.intellij.plugin.xpath.ast.xpath.XPathSequenceType
import uk.co.reecedunn.intellij.plugin.xpath.ast.xpath.XPathTypeDeclaration
import uk.co.reecedunn.intellij.plugin.xquery.ast.saxon.SaxonTupleType
import uk.co.reecedunn.intellij.plugin.xquery.ast.saxon.SaxonTypeDecl
import uk.co.reecedunn.intellij.plugin.xquery.ast.saxon.SaxonUnionType
import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.XQueryAnnotatedDecl
import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.XQueryVarDecl
import uk.co.reecedunn.intellij.plugin.xquery.lang.Saxon
import uk.co.reecedunn.intellij.plugin.xquery.lang.Version
import uk.co.reecedunn.intellij.plugin.xquery.lexer.XQueryTokenType
import uk.co.reecedunn.intellij.plugin.xquery.psi.XQueryConformance
import uk.co.reecedunn.intellij.plugin.xquery.tests.parser.ParserTestCase

class SaxonPsiTest : ParserTestCase() {
    // region XQueryConformance
    // region TupleType

    fun testTupleType() {
        val file = parseResource("tests/parser/saxon-9.8/TupleType.xq")

        val annotatedDeclPsi = file.descendants().filterIsInstance<XQueryAnnotatedDecl>().first()
        val varDeclPsi = annotatedDeclPsi.children().filterIsInstance<XQueryVarDecl>().first()
        val typeDeclarationPsi = varDeclPsi.children().filterIsInstance<XPathTypeDeclaration>().first()
        val sequenceTypePsi = typeDeclarationPsi.children().filterIsInstance<XPathSequenceType>().first()
        val tupleTypePsi = sequenceTypePsi.descendants().filterIsInstance<SaxonTupleType>().first()
        val conformance = tupleTypePsi as XQueryConformance

        assertThat(conformance.requiresConformance.size, `is`(1))
        assertThat(conformance.requiresConformance[0], `is`<Version>(Saxon.VERSION_9_8))

        assertThat(conformance.conformanceElement, `is`(CoreMatchers.notNullValue()))
        assertThat(conformance.conformanceElement.node.elementType,
                `is`<IElementType>(XQueryTokenType.K_TUPLE))
    }

    // endregion
    // region TypeDecl

    fun testTypeDecl() {
        val file = parseResource("tests/parser/saxon-9.8/TypeDecl.xq")

        val typeDeclPsi = file.descendants().filterIsInstance<SaxonTypeDecl>().first()
        val conformance = typeDeclPsi as XQueryConformance

        assertThat(conformance.requiresConformance.size, `is`(1))
        assertThat(conformance.requiresConformance[0], `is`<Version>(Saxon.VERSION_9_8))

        assertThat(conformance.conformanceElement, `is`(CoreMatchers.notNullValue()))
        assertThat(conformance.conformanceElement.node.elementType,
                `is`<IElementType>(XQueryTokenType.K_TYPE))
    }

    // endregion
    // region UnionType

    fun testUnionType() {
        val file = parseResource("tests/parser/saxon-9.8/UnionType.xq")

        val annotatedDeclPsi = file.descendants().filterIsInstance<XQueryAnnotatedDecl>().first()
        val varDeclPsi = annotatedDeclPsi.children().filterIsInstance<XQueryVarDecl>().first()
        val typeDeclarationPsi = varDeclPsi.children().filterIsInstance<XPathTypeDeclaration>().first()
        val sequenceTypePsi = typeDeclarationPsi.children().filterIsInstance<XPathSequenceType>().first()
        val unionTypePsi = sequenceTypePsi.descendants().filterIsInstance<SaxonUnionType>().first()
        val conformance = unionTypePsi as XQueryConformance

        assertThat(conformance.requiresConformance.size, `is`(1))
        assertThat(conformance.requiresConformance[0], `is`<Version>(Saxon.VERSION_9_8))

        assertThat(conformance.conformanceElement, `is`(CoreMatchers.notNullValue()))
        assertThat(conformance.conformanceElement.node.elementType,
                `is`<IElementType>(XQueryTokenType.K_UNION))
    }

    // endregion
    // endregion
    // region XPathMapConstructorEntry

    fun testMapConstructorEntry() {
        val file = parseResource("tests/parser/saxon-9.4/MapConstructorEntry.xq")

        val mapConstructorPsi = file.descendants().filterIsInstance<XPathMapConstructor>().first()
        val mapConstructorEntryPsi = mapConstructorPsi.children().filterIsInstance<XPathMapConstructorEntry>().first()

        assertThat(mapConstructorEntryPsi.separator.node.elementType,
                `is`<IElementType>(XQueryTokenType.ASSIGN_EQUAL))
    }

    // endregion
}
