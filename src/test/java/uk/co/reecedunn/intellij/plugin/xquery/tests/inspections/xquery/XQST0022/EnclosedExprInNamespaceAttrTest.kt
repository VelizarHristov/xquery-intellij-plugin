/*
 * Copyright (C) 2018 Reece H. Dunn
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

package uk.co.reecedunn.intellij.plugin.xquery.tests.inspections.xquery.XQST0022

import com.intellij.codeInspection.ProblemHighlightType
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import uk.co.reecedunn.intellij.plugin.xquery.inspections.xquery.XQST0022.EnclosedExprInNamespaceAttrInspection
import uk.co.reecedunn.intellij.plugin.xquery.parser.XQueryElementType
import uk.co.reecedunn.intellij.plugin.xquery.tests.inspections.InspectionTestCase

class EnclosedExprInNamespaceAttrTest : InspectionTestCase() {
    // region Inspection Details

    fun testDisplayName() {
        val inspection = EnclosedExprInNamespaceAttrInspection()
        assertThat(inspection.displayName, `is`(notNullValue()))
    }

    fun testDescription() {
        val inspection = EnclosedExprInNamespaceAttrInspection()
        assertThat(inspection.loadDescription(), `is`(notNullValue()))
    }

    // endregion
    // region Inspection Tests

    fun testElement_NoNamespaceAttr_String() {
        val file = parseResource("tests/inspections/xquery/XQST0022/element-no-nsattr-string.xq")

        val problems = inspect(file, EnclosedExprInNamespaceAttrInspection())
        assertThat(problems, `is`(notNullValue()))
        assertThat(problems!!.size, `is`(0))
    }

    fun testElement_NoNamespaceAttr_EnclosedExpr() {
        val file = parseResource("tests/inspections/xquery/XQST0022/element-no-nsattr-enclosedexpr.xq")

        val problems = inspect(file, EnclosedExprInNamespaceAttrInspection())
        assertThat(problems, `is`(notNullValue()))
        assertThat(problems!!.size, `is`(0))
    }

    fun testElement_NamespaceAttr_String() {
        val file = parseResource("tests/inspections/xquery/XQST0022/element-nsattr-string.xq")

        val problems = inspect(file, EnclosedExprInNamespaceAttrInspection())
        assertThat(problems, `is`(notNullValue()))
        assertThat(problems!!.size, `is`(0))
    }

    fun testElement_NamespaceAttr_EnclosedExpr() {
        val file = parseResource("tests/inspections/xquery/XQST0022/element-nsattr-enclosedexpr.xq")

        val problems = inspect(file, EnclosedExprInNamespaceAttrInspection())
        assertThat(problems, `is`(notNullValue()))
        assertThat(problems!!.size, `is`(1))

        assertThat(problems[0].highlightType, `is`(ProblemHighlightType.GENERIC_ERROR))
        assertThat(problems[0].descriptionTemplate, `is`("XQST0022: Enclosed expressions are not allowed in namespace declaration attributes."))
        assertThat(problems[0].psiElement.node.elementType, `is`(XQueryElementType.ENCLOSED_EXPR))
        assertThat(problems[0].psiElement.text, `is`("{\"http://www.example.com\"}"))
    }

    fun testElement_NamespaceAttr_Prefix_String() {
        val file = parseResource("tests/inspections/xquery/XQST0022/element-nsattr-prefix-string.xq")

        val problems = inspect(file, EnclosedExprInNamespaceAttrInspection())
        assertThat(problems, `is`(notNullValue()))
        assertThat(problems!!.size, `is`(0))
    }

    fun testElement_NamespaceAttr_Prefix_EnclosedExpr() {
        val file = parseResource("tests/inspections/xquery/XQST0022/element-nsattr-prefix-enclosedexpr.xq")

        val problems = inspect(file, EnclosedExprInNamespaceAttrInspection())
        assertThat(problems, `is`(notNullValue()))
        assertThat(problems!!.size, `is`(1))

        assertThat(problems[0].highlightType, `is`(ProblemHighlightType.GENERIC_ERROR))
        assertThat(problems[0].descriptionTemplate, `is`("XQST0022: Enclosed expressions are not allowed in namespace declaration attributes."))
        assertThat(problems[0].psiElement.node.elementType, `is`(XQueryElementType.ENCLOSED_EXPR))
        assertThat(problems[0].psiElement.text, `is`("{\"http://www.example.com\"}"))
    }

    fun testElement_NamespaceAttr_Prefix_Mixed() {
        val file = parseResource("tests/inspections/xquery/XQST0022/element-nsattr-prefix-mixed.xq")

        val problems = inspect(file, EnclosedExprInNamespaceAttrInspection())
        assertThat(problems, `is`(notNullValue()))
        assertThat(problems!!.size, `is`(1))

        assertThat(problems[0].highlightType, `is`(ProblemHighlightType.GENERIC_ERROR))
        assertThat(problems[0].descriptionTemplate, `is`("XQST0022: Enclosed expressions are not allowed in namespace declaration attributes."))
        assertThat(problems[0].psiElement.node.elementType, `is`(XQueryElementType.ENCLOSED_EXPR))
        assertThat(problems[0].psiElement.text, `is`("{\"example\"}"))
    }

    // endregion
}
