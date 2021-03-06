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
@file:Suppress("PackageName")

package uk.co.reecedunn.intellij.plugin.xquery.tests.inspections.xquery.XQST0033

import com.intellij.codeInspection.ProblemHighlightType
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import uk.co.reecedunn.intellij.plugin.xquery.inspections.xquery.XQST0033.DuplicateNamespacePrefixInspection
import uk.co.reecedunn.intellij.plugin.xquery.lexer.XQueryTokenType
import uk.co.reecedunn.intellij.plugin.xquery.tests.inspections.InspectionTestCase

class DuplicateNamespacePrefixInspectionTest : InspectionTestCase() {
    // region Inspection Details

    fun testDisplayName() {
        val inspection = DuplicateNamespacePrefixInspection()
        assertThat(inspection.displayName, `is`(notNullValue()))
    }

    fun testDescription() {
        val inspection = DuplicateNamespacePrefixInspection()
        assertThat(inspection.loadDescription(), `is`(notNullValue()))
    }

    // endregion
    // region XQuery 1.0

    fun testNoDuplicates() {
        val file = parseResource("tests/inspections/xquery/XQST0033/no-duplicates.xq")

        val problems = inspect(file, DuplicateNamespacePrefixInspection())
        assertThat(problems, `is`(notNullValue()))
        assertThat(problems!!.size, `is`(0))
    }

    fun testModuleDecl_ModuleImport() {
        val file = parseResource("tests/inspections/xquery/XQST0033/ModuleDecl-ModuleImport.xq")

        val problems = inspect(file, DuplicateNamespacePrefixInspection())
        assertThat(problems, `is`(notNullValue()))
        assertThat(problems!!.size, `is`(1))

        assertThat(problems[0].highlightType, `is`(ProblemHighlightType.GENERIC_ERROR))
        assertThat(problems[0].descriptionTemplate, `is`("XQST0033: The namespace prefix 'test' has already been defined."))
        assertThat(problems[0].psiElement.node.elementType, `is`(XQueryTokenType.NCNAME))
        assertThat(problems[0].psiElement.text, `is`("test"))
    }

    fun testModuleDecl_NoUri() {
        val file = parseResource("tests/inspections/xquery/XQST0033/ModuleDecl-no-uri.xq")

        val problems = inspect(file, DuplicateNamespacePrefixInspection())
        assertThat(problems, `is`(notNullValue()))
        assertThat(problems!!.size, `is`(0))
    }

    fun testModuleImport_NamespaceDecl() {
        val file = parseResource("tests/inspections/xquery/XQST0033/ModuleImport-NamespaceDecl.xq")

        val problems = inspect(file, DuplicateNamespacePrefixInspection())
        assertThat(problems, `is`(notNullValue()))
        assertThat(problems!!.size, `is`(1))

        assertThat(problems[0].highlightType, `is`(ProblemHighlightType.GENERIC_ERROR))
        assertThat(problems[0].descriptionTemplate, `is`("XQST0033: The namespace prefix 'one' has already been defined."))
        assertThat(problems[0].psiElement.node.elementType, `is`(XQueryTokenType.NCNAME))
        assertThat(problems[0].psiElement.text, `is`("one"))
    }

    fun testNamespaceDecl_SchemaImport() {
        val file = parseResource("tests/inspections/xquery/XQST0033/NamespaceDecl-SchemaImport.xq")

        val problems = inspect(file, DuplicateNamespacePrefixInspection())
        assertThat(problems, `is`(notNullValue()))
        assertThat(problems!!.size, `is`(1))

        assertThat(problems[0].highlightType, `is`(ProblemHighlightType.GENERIC_ERROR))
        assertThat(problems[0].descriptionTemplate, `is`("XQST0033: The namespace prefix 'one' has already been defined."))
        assertThat(problems[0].psiElement.node.elementType, `is`(XQueryTokenType.NCNAME))
        assertThat(problems[0].psiElement.text, `is`("one"))
    }

    fun testSchemaImport_ModuleImport() {
        val file = parseResource("tests/inspections/xquery/XQST0033/SchemaImport-ModuleImport.xq")

        val problems = inspect(file, DuplicateNamespacePrefixInspection())
        assertThat(problems, `is`(notNullValue()))
        assertThat(problems!!.size, `is`(1))

        assertThat(problems[0].highlightType, `is`(ProblemHighlightType.GENERIC_ERROR))
        assertThat(problems[0].descriptionTemplate, `is`("XQST0033: The namespace prefix 'one' has already been defined."))
        assertThat(problems[0].psiElement.node.elementType, `is`(XQueryTokenType.NCNAME))
        assertThat(problems[0].psiElement.text, `is`("one"))
    }

    // endregion
    // region MarkLogic 6.0

    fun testOtherTransaction_NoDuplicates() {
        val file = parseResource("tests/inspections/xquery/XQST0033/other-transaction-no-duplicates.xq")

        val problems = inspect(file, DuplicateNamespacePrefixInspection())
        assertThat(problems, `is`(notNullValue()))
        assertThat(problems!!.size, `is`(0))
    }

    fun testOtherTransaction_Duplicates() {
        val file = parseResource("tests/inspections/xquery/XQST0033/other-transaction-duplicates.xq")

        val problems = inspect(file, DuplicateNamespacePrefixInspection())
        assertThat(problems, `is`(notNullValue()))
        assertThat(problems!!.size, `is`(1))

        assertThat(problems[0].highlightType, `is`(ProblemHighlightType.GENERIC_ERROR))
        assertThat(problems[0].descriptionTemplate, `is`("XQST0033: The namespace prefix 'one' has already been defined."))
        assertThat(problems[0].psiElement.node.elementType, `is`(XQueryTokenType.NCNAME))
        assertThat(problems[0].psiElement.text, `is`("one"))
    }

    // endregion
}
