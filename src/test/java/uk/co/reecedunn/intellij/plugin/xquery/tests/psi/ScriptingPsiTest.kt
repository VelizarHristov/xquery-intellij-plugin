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

import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import uk.co.reecedunn.intellij.plugin.xquery.ast.scripting.*
import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.*
import uk.co.reecedunn.intellij.plugin.xquery.lang.Implementations
import uk.co.reecedunn.intellij.plugin.xquery.lexer.XQueryTokenType
import uk.co.reecedunn.intellij.plugin.xquery.parser.XQueryElementType
import uk.co.reecedunn.intellij.plugin.xquery.psi.XQueryConformanceCheck
import uk.co.reecedunn.intellij.plugin.xquery.psi.XQueryVariableResolver
import uk.co.reecedunn.intellij.plugin.xquery.tests.parser.ParserTestCase

import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import uk.co.reecedunn.intellij.plugin.core.extensions.children
import uk.co.reecedunn.intellij.plugin.core.extensions.descendants
import uk.co.reecedunn.intellij.plugin.xquery.psi.XQueryVariable

class ScriptingPsiTest : ParserTestCase() {
    // region XQueryConformanceCheck
    // region ApplyExpr

    fun testApplyExpr_Single_NoSemicolon() {
        val file = parseResource("tests/parser/xquery-1.0/IntegerLiteral.xq")!!

        val applyExpr = file.descendants().filterIsInstance<ScriptingApplyExpr>().first()
        val versioned = applyExpr as XQueryConformanceCheck

        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0")), `is`(true))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-update")), `is`(true))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-scripting")), `is`(true))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0")), `is`(true))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0-update")), `is`(true))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.1")), `is`(true))

        assertThat(versioned.conformanceErrorMessage,
                `is`("XPST0003: This expression requires Scripting Extension 1.0 or later."))

        assertThat(versioned.conformanceElement, `is`(notNullValue()))
        assertThat<IElementType>(versioned.conformanceElement.node.elementType,
                `is`<IElementType>(XQueryElementType.CONCAT_EXPR))
    }

    fun testApplyExpr_Single_Semicolon() {
        val file = parseResource("tests/parser/xquery-sx-1.0/ApplyExpr_Single_SemicolonAtEnd.xq")!!

        val applyExpr = file.descendants().filterIsInstance<ScriptingApplyExpr>().first()
        val versioned = applyExpr as XQueryConformanceCheck

        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-scripting")), `is`(true))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.1")), `is`(false))

        assertThat(versioned.conformanceErrorMessage,
                `is`("XPST0003: This expression requires Scripting Extension 1.0 or later."))

        assertThat(versioned.conformanceElement, `is`(notNullValue()))
        assertThat(versioned.conformanceElement.node.elementType,
                `is`<IElementType>(XQueryTokenType.SEPARATOR))
    }

    fun testApplyExpr_Multiple() {
        val file = parseResource("tests/parser/xquery-sx-1.0/ApplyExpr_TwoExpr_SemicolonAtEnd.xq")!!

        val applyExpr = file.descendants().filterIsInstance<ScriptingApplyExpr>().first()
        val versioned = applyExpr as XQueryConformanceCheck

        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-scripting")), `is`(true))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.1")), `is`(false))

        assertThat(versioned.conformanceErrorMessage,
                `is`("XPST0003: This expression requires Scripting Extension 1.0 or later."))

        assertThat(versioned.conformanceElement, `is`(notNullValue()))
        assertThat(versioned.conformanceElement.node.elementType,
                `is`<IElementType>(XQueryTokenType.SEPARATOR))
    }

    // endregion
    // region AssignmentExpr

    fun testAssignmentExpr() {
        val file = parseResource("tests/parser/xquery-sx-1.0/AssignmentExpr.xq")!!

        val assignmentExpr = file.descendants().filterIsInstance<ScriptingAssignmentExpr>().first()
        val versioned = assignmentExpr as XQueryConformanceCheck

        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-scripting")), `is`(true))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.1")), `is`(false))

        assertThat(versioned.conformanceErrorMessage,
                `is`("XPST0003: This expression requires Scripting Extension 1.0 or later."))

        assertThat(versioned.conformanceElement, `is`(notNullValue()))
        assertThat(versioned.conformanceElement.node.elementType,
                `is`<IElementType>(XQueryTokenType.ASSIGN_EQUAL))
    }

    // endregion
    // region BlockExpr

    fun testBlockExpr() {
        val file = parseResource("tests/parser/xquery-sx-1.0/BlockExpr.xq")!!

        val blockExpr = file.descendants().filterIsInstance<ScriptingBlockExpr>().first()
        val versioned = blockExpr as XQueryConformanceCheck

        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-scripting")), `is`(true))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.1")), `is`(false))

        assertThat(versioned.conformanceErrorMessage,
                `is`("XPST0003: This expression requires Scripting Extension 1.0 or later."))

        assertThat(versioned.conformanceElement, `is`(notNullValue()))
        assertThat(versioned.conformanceElement.node.elementType,
                `is`<IElementType>(XQueryTokenType.K_BLOCK))
    }

    // endregion
    // region BlockVarDecl

    fun testBlockVarDecl() {
        val file = parseResource("tests/parser/xquery-sx-1.0/BlockVarDecl.xq")!!

        val annotatedDeclPsi = file.descendants().filterIsInstance<XQueryAnnotatedDecl>().first()
        val functionDeclPsi = annotatedDeclPsi.children().filterIsInstance<XQueryFunctionDecl>().first()
        val blockPsi = functionDeclPsi.children().filterIsInstance<ScriptingBlock>().first()
        val blockDeclsPsi = blockPsi.children().filterIsInstance<ScriptingBlockDecls>().first()
        val blockVarDeclPsi = blockDeclsPsi.children().filterIsInstance<ScriptingBlockVarDecl>().first()
        val versioned = blockVarDeclPsi as XQueryConformanceCheck

        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-scripting")), `is`(true))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.1")), `is`(false))

        assertThat(versioned.conformanceErrorMessage,
                `is`("XPST0003: This expression requires Scripting Extension 1.0 or later."))

        assertThat(versioned.conformanceElement, `is`(notNullValue()))
        assertThat(versioned.conformanceElement.node.elementType,
                `is`<IElementType>(XQueryTokenType.K_DECLARE))
    }

    // endregion
    // region ExitExpr

    fun testExitExpr() {
        val file = parseResource("tests/parser/xquery-sx-1.0/ExitExpr.xq")!!

        val exitExpr = file.descendants().filterIsInstance<ScriptingExitExpr>().first()
        val versioned = exitExpr as XQueryConformanceCheck

        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-scripting")), `is`(true))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.1")), `is`(false))

        assertThat(versioned.conformanceErrorMessage,
                `is`("XPST0003: This expression requires Scripting Extension 1.0 or later."))

        assertThat(versioned.conformanceElement, `is`(notNullValue()))
        assertThat(versioned.conformanceElement.node.elementType,
                `is`<IElementType>(XQueryTokenType.K_EXIT))
    }

    // endregion
    // region FunctionDecl

    fun testFunctionDecl_Simple() {
        val file = parseResource("tests/parser/xquery-sx-1.0/FunctionDecl_Simple.xq")!!

        val annotatedDeclPsi = file.descendants().filterIsInstance<XQueryAnnotatedDecl>().first()
        val scriptingCompatibilityAnnotationPsi = annotatedDeclPsi.children().filterIsInstance<ScriptingCompatibilityAnnotation>().first()
        val versioned = scriptingCompatibilityAnnotationPsi as XQueryConformanceCheck

        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-scripting")), `is`(true))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.1")), `is`(false))

        assertThat(versioned.conformanceErrorMessage,
                `is`("XPST0003: This expression requires Scripting Extension 1.0 or later."))

        assertThat(versioned.conformanceElement, `is`(notNullValue()))
        assertThat(versioned.conformanceElement.node.elementType,
                `is`<IElementType>(XQueryTokenType.K_SIMPLE))
    }

    fun testFunctionDecl_Sequential() {
        val file = parseResource("tests/parser/xquery-sx-1.0/FunctionDecl_Sequential.xq")!!

        val annotatedDeclPsi = file.descendants().filterIsInstance<XQueryAnnotatedDecl>().first()
        val scriptingCompatibilityAnnotationPsi = annotatedDeclPsi.children().filterIsInstance<ScriptingCompatibilityAnnotation>().first()
        val versioned = scriptingCompatibilityAnnotationPsi as XQueryConformanceCheck

        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-scripting")), `is`(true))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.1")), `is`(false))

        assertThat(versioned.conformanceErrorMessage,
                `is`("XPST0003: This expression requires Scripting Extension 1.0 or later."))

        assertThat(versioned.conformanceElement, `is`(notNullValue()))
        assertThat(versioned.conformanceElement.node.elementType,
                `is`<IElementType>(XQueryTokenType.K_SEQUENTIAL))
    }

    // endregion
    // region VarDecl

    fun testVarDecl_Assignable() {
        val file = parseResource("tests/parser/xquery-sx-1.0/VarDecl_Assignable.xq")!!

        val annotatedDeclPsi = file.descendants().filterIsInstance<XQueryAnnotatedDecl>().first()
        val scriptingCompatibilityAnnotationPsi = annotatedDeclPsi.children().filterIsInstance<ScriptingCompatibilityAnnotation>().first()
        val versioned = scriptingCompatibilityAnnotationPsi as XQueryConformanceCheck

        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-scripting")), `is`(true))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.1")), `is`(false))

        assertThat(versioned.conformanceErrorMessage,
                `is`("XPST0003: This expression requires Scripting Extension 1.0 or later."))

        assertThat(versioned.conformanceElement, `is`(notNullValue()))
        assertThat(versioned.conformanceElement.node.elementType,
                `is`<IElementType>(XQueryTokenType.K_ASSIGNABLE))
    }

    fun testVarDecl_Unassignable() {
        val file = parseResource("tests/parser/xquery-sx-1.0/VarDecl_Unassignable.xq")!!

        val annotatedDeclPsi = file.descendants().filterIsInstance<XQueryAnnotatedDecl>().first()
        val scriptingCompatibilityAnnotationPsi = annotatedDeclPsi.children().filterIsInstance<ScriptingCompatibilityAnnotation>().first()
        val versioned = scriptingCompatibilityAnnotationPsi as XQueryConformanceCheck

        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-scripting")), `is`(true))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.1")), `is`(false))

        assertThat(versioned.conformanceErrorMessage,
                `is`("XPST0003: This expression requires Scripting Extension 1.0 or later."))

        assertThat(versioned.conformanceElement, `is`(notNullValue()))
        assertThat(versioned.conformanceElement.node.elementType,
                `is`<IElementType>(XQueryTokenType.K_UNASSIGNABLE))
    }

    // endregion
    // region WhileExpr

    fun testWhileExpr() {
        val file = parseResource("tests/parser/xquery-sx-1.0/WhileExpr.xq")!!

        val whileExpr = file.descendants().filterIsInstance<ScriptingWhileExpr>().first()
        val versioned = whileExpr as XQueryConformanceCheck

        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/1.0-scripting")), `is`(true))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.0-update")), `is`(false))
        assertThat(versioned.conformsTo(Implementations.getItemById("w3c/3.1")), `is`(false))

        assertThat(versioned.conformanceErrorMessage,
                `is`("XPST0003: This expression requires Scripting Extension 1.0 or later."))

        assertThat(versioned.conformanceElement, `is`(notNullValue()))
        assertThat(versioned.conformanceElement.node.elementType,
                `is`<IElementType>(XQueryTokenType.K_WHILE))
    }

    // endregion
    // endregion
    // region XQueryVariableResolver
    // region BlockVarDecl

    fun testBlockVarDecl_VariableResolver() {
        val file = parseResource("tests/parser/xquery-sx-1.0/BlockVarDecl.xq")!!

        val annotatedDeclPsi = file.descendants().filterIsInstance<XQueryAnnotatedDecl>().first()
        val functionDeclPsi = annotatedDeclPsi.children().filterIsInstance<XQueryFunctionDecl>().first()
        val blockPsi = functionDeclPsi.children().filterIsInstance<ScriptingBlock>().first()
        val blockDeclsPsi = blockPsi.children().filterIsInstance<ScriptingBlockDecls>().first()
        val blockVarDeclPsi = blockDeclsPsi.children().filterIsInstance<ScriptingBlockVarDecl>().first()
        val varNamePsi = blockVarDeclPsi.children().filterIsInstance<XQueryEQName>().first()

        val provider = blockVarDeclPsi as XQueryVariableResolver
        assertThat(provider.resolveVariable(null), `is`(nullValue()))

        val variable = provider.resolveVariable(varNamePsi)!!

        assertThat(variable.variable, `is`(instanceOf(XQueryEQName::class.java)))
        assertThat(variable.variable, `is`<PsiElement>(varNamePsi))

        assertThat(variable.declaration, `is`(instanceOf(ScriptingBlockVarDecl::class.java)))
        assertThat(variable.declaration, `is`(blockVarDeclPsi))
    }

    // endregion
    // endregion
}