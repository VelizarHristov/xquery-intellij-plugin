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
package uk.co.reecedunn.intellij.plugin.xquery.tests.parser

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

class MarkLogicParserTest : ParserTestCase() {
    // region MarkLogic 6.0 :: Transactions + TransactionSeparator

    fun testTransactions_WithVersionDecl() {
        val expected = loadResource("tests/parser/marklogic-6.0/Transactions_WithVersionDecl.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/Transactions_WithVersionDecl.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testTransactions_LibraryModule() {
        val expected = loadResource("tests/parser/marklogic-6.0/Transactions_LibraryModule.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/Transactions_LibraryModule.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testTransactions_Prolog_ImportStatement() {
        val expected = loadResource("tests/parser/marklogic-6.0/Transactions_Prolog_ImportStatement.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/Transactions_Prolog_ImportStatement.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testTransactions_Prolog_DeclareStatement() {
        val expected = loadResource("tests/parser/marklogic-6.0/Transactions_Prolog_DeclareStatement.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/Transactions_Prolog_DeclareStatement.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testTransactions_AfterApplyExpr() {
        val expected = loadResource("tests/parser/marklogic-6.0/Transactions_AfterApplyExpr.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/Transactions_AfterApplyExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 6.0 :: CompatibilityAnnotation

    fun testCompatibilityAnnotation_FunctionDecl() {
        val expected = loadResource("tests/parser/marklogic-6.0/CompatibilityAnnotation_FunctionDecl.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/CompatibilityAnnotation_FunctionDecl.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testCompatibilityAnnotation_FunctionDecl_MissingFunctionKeyword() {
        val expected = loadResource("tests/parser/marklogic-6.0/CompatibilityAnnotation_FunctionDecl_MissingFunctionKeyword.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/CompatibilityAnnotation_FunctionDecl_MissingFunctionKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testCompatibilityAnnotation_VarDecl() {
        val expected = loadResource("tests/parser/marklogic-6.0/CompatibilityAnnotation_VarDecl.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/CompatibilityAnnotation_VarDecl.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testCompatibilityAnnotation_VarDecl_MissingVariableKeyword() {
        val expected = loadResource("tests/parser/marklogic-6.0/CompatibilityAnnotation_VarDecl_MissingVariableKeyword.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/CompatibilityAnnotation_VarDecl_MissingVariableKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 6.0 :: StylesheetImport

    fun testStylesheetImport() {
        val expected = loadResource("tests/parser/marklogic-6.0/StylesheetImport.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/StylesheetImport.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testStylesheetImport_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-6.0/StylesheetImport_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/StylesheetImport_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testStylesheetImport_MissingAtKeyword() {
        val expected = loadResource("tests/parser/marklogic-6.0/StylesheetImport_MissingAtKeyword.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/StylesheetImport_MissingAtKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testStylesheetImport_MissingUriLiteral() {
        val expected = loadResource("tests/parser/marklogic-6.0/StylesheetImport_MissingUriLiteral.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/StylesheetImport_MissingUriLiteral.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 6.0 :: CatchClause + TryCatchExpr

    fun testCatchClause() {
        val expected = loadResource("tests/parser/marklogic-6.0/CatchClause.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/CatchClause.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testCatchClause_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-6.0/CatchClause_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/CatchClause_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testCatchClause_MissingVariableIndicator() {
        val expected = loadResource("tests/parser/marklogic-6.0/CatchClause_MissingVariableIndicator.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/CatchClause_MissingVariableIndicator.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testCatchClause_MissingVarName() {
        val expected = loadResource("tests/parser/marklogic-6.0/CatchClause_MissingVarName.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/CatchClause_MissingVarName.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testCatchClause_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/marklogic-6.0/CatchClause_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/CatchClause_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testCatchClause_EmptyExpr() {
        val expected = loadResource("tests/parser/marklogic-6.0/CatchClause_EmptyExpr.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/CatchClause_EmptyExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testCatchClause_Multiple() {
        val expected = loadResource("tests/parser/marklogic-6.0/CatchClause_Multiple.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/CatchClause_Multiple.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 6.0 :: ValidateExpr

    fun testValidateExpr_ValidateAs() {
        val expected = loadResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testValidateExpr_ValidateAs_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testValidateExpr_ValidateAs_MissingTypeName() {
        val expected = loadResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs_MissingTypeName.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs_MissingTypeName.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testValidateExpr_ValidateAs_MissingOpeningBrace() {
        val expected = loadResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs_MissingOpeningBrace.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs_MissingOpeningBrace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testValidateExpr_ValidateAs_EQName() {
        val expected = loadResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs_EQName.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs_EQName.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 6.0 :: ForwardAxis

    fun testForwardAxis_Namespace() {
        val expected = loadResource("tests/parser/marklogic-6.0/ForwardAxis_Namespace.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/ForwardAxis_Namespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testForwardAxis_Namespace_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-6.0/ForwardAxis_Namespace_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/ForwardAxis_Namespace_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testForwardAxis_Property() {
        val expected = loadResource("tests/parser/marklogic-6.0/ForwardAxis_Property.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/ForwardAxis_Property.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testForwardAxis_Property_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-6.0/ForwardAxis_Property_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/ForwardAxis_Property_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 6.0 :: BinaryConstructor

    fun testBinaryConstructor() {
        val expected = loadResource("tests/parser/marklogic-6.0/BinaryConstructor.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/BinaryConstructor.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testBinaryConstructor_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-6.0/BinaryConstructor_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/BinaryConstructor_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testBinaryConstructor_NoExpr() {
        val expected = loadResource("tests/parser/marklogic-6.0/BinaryConstructor_NoExpr.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/BinaryConstructor_NoExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testBinaryConstructor_MissingClosingBrace() {
        val expected = loadResource("tests/parser/marklogic-6.0/BinaryConstructor_MissingClosingBrace.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/BinaryConstructor_MissingClosingBrace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 6.0 :: BinaryTest

    fun testBinaryTest() {
        val expected = loadResource("tests/parser/marklogic-6.0/BinaryTest.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/BinaryTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testBinaryTest_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-6.0/BinaryTest_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/BinaryTest_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testBinaryTest_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/marklogic-6.0/BinaryTest_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/marklogic-6.0/BinaryTest_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 7.0 :: AttributeDeclTest

    fun testAttributeDeclTest() {
        val expected = loadResource("tests/parser/marklogic-7.0/AttributeDeclTest.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/AttributeDeclTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testAttributeDeclTest_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-7.0/AttributeDeclTest_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/AttributeDeclTest_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testAttributeDeclTest_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/marklogic-7.0/AttributeDeclTest_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/AttributeDeclTest_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 7.0 :: ComplexTypeTest

    fun testComplexTypeTest() {
        val expected = loadResource("tests/parser/marklogic-7.0/ComplexTypeTest.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/ComplexTypeTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testComplexTypeTest_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-7.0/ComplexTypeTest_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/ComplexTypeTest_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testComplexTypeTest_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/marklogic-7.0/ComplexTypeTest_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/ComplexTypeTest_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 7.0 :: ElementDeclTest

    fun testElementDeclTest() {
        val expected = loadResource("tests/parser/marklogic-7.0/ElementDeclTest.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/ElementDeclTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testElementDeclTest_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-7.0/ElementDeclTest_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/ElementDeclTest_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testElementDeclTest_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/marklogic-7.0/ElementDeclTest_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/ElementDeclTest_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 7.0 :: SchemaComponentTest

    fun testSchemaComponentTest() {
        val expected = loadResource("tests/parser/marklogic-7.0/SchemaComponentTest.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/SchemaComponentTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testSchemaComponentTest_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-7.0/SchemaComponentTest_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/SchemaComponentTest_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testSchemaComponentTest_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/marklogic-7.0/SchemaComponentTest_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/SchemaComponentTest_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 7.0 :: SchemaParticleTest

    fun testSchemaParticleTest() {
        val expected = loadResource("tests/parser/marklogic-7.0/SchemaParticleTest.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/SchemaParticleTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testSchemaParticleTest_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-7.0/SchemaParticleTest_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/SchemaParticleTest_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testSchemaParticleTest_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/marklogic-7.0/SchemaParticleTest_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/SchemaParticleTest_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 7.0 :: SchemaRootTest

    fun testSchemaRootTest() {
        val expected = loadResource("tests/parser/marklogic-7.0/SchemaRootTest.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/SchemaRootTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testSchemaRootTest_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-7.0/SchemaRootTest_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/SchemaRootTest_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testSchemaRootTest_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/marklogic-7.0/SchemaRootTest_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/SchemaRootTest_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 7.0 :: SchemaTypeTest

    fun testSchemaTypeTest() {
        val expected = loadResource("tests/parser/marklogic-7.0/SchemaTypeTest.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/SchemaTypeTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testSchemaTypeTest_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-7.0/SchemaTypeTest_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/SchemaTypeTest_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testSchemaTypeTest_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/marklogic-7.0/SchemaTypeTest_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/SchemaTypeTest_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 7.0 :: SimpleTypeTest

    fun testSimpleTypeTest() {
        val expected = loadResource("tests/parser/marklogic-7.0/SimpleTypeTest.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/SimpleTypeTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testSimpleTypeTest_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-7.0/SimpleTypeTest_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/SimpleTypeTest_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testSimpleTypeTest_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/marklogic-7.0/SimpleTypeTest_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/marklogic-7.0/SimpleTypeTest_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 8.0 :: SchemaFacetTest

    fun testSchemaFacetTest() {
        val expected = loadResource("tests/parser/marklogic-8.0/SchemaFacetTest.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/SchemaFacetTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testSchemaFacetTest_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/SchemaFacetTest_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/SchemaFacetTest_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testSchemaFacetTest_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/marklogic-8.0/SchemaFacetTest_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/SchemaFacetTest_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 8.0 :: ArrayConstructor

    fun testArrayConstructor() {
        val expected = loadResource("tests/parser/marklogic-8.0/ArrayConstructor.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/ArrayConstructor.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testArrayConstructor_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/ArrayConstructor_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/ArrayConstructor_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testArrayConstructor_MissingExpr() {
        val expected = loadResource("tests/parser/marklogic-8.0/ArrayConstructor_MissingExpr.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/ArrayConstructor_MissingExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testArrayConstructor_MissingClosingBrace() {
        val expected = loadResource("tests/parser/marklogic-8.0/ArrayConstructor_MissingClosingBrace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/ArrayConstructor_MissingClosingBrace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testArrayConstructor_Multiple() {
        val expected = loadResource("tests/parser/marklogic-8.0/ArrayConstructor_Multiple.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/ArrayConstructor_Multiple.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testArrayConstructor_Multiple_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/ArrayConstructor_Multiple_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/ArrayConstructor_Multiple_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testArrayConstructor_Multiple_MissingExpr() {
        val expected = loadResource("tests/parser/marklogic-8.0/ArrayConstructor_Multiple_MissingExpr.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/ArrayConstructor_Multiple_MissingExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 8.0 :: BooleanConstructor

    fun testBooleanConstructor() {
        val expected = loadResource("tests/parser/marklogic-8.0/BooleanConstructor.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/BooleanConstructor.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testBooleanConstructor_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/BooleanConstructor_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/BooleanConstructor_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testBooleanConstructor_MissingExpr() {
        val expected = loadResource("tests/parser/marklogic-8.0/BooleanConstructor_MissingExpr.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/BooleanConstructor_MissingExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testBooleanConstructor_MissingClosingBrace() {
        val expected = loadResource("tests/parser/marklogic-8.0/BooleanConstructor_MissingClosingBrace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/BooleanConstructor_MissingClosingBrace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 8.0 :: NullConstructor

    fun testNullConstructor() {
        val expected = loadResource("tests/parser/marklogic-8.0/NullConstructor.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NullConstructor.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testNullConstructor_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/NullConstructor_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NullConstructor_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testNullConstructor_MissingClosingBrace() {
        val expected = loadResource("tests/parser/marklogic-8.0/NullConstructor_MissingClosingBrace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NullConstructor_MissingClosingBrace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 8.0 :: NumberConstructor

    fun testNumberConstructor() {
        val expected = loadResource("tests/parser/marklogic-8.0/NumberConstructor.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NumberConstructor.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testNumberConstructor_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/NumberConstructor_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NumberConstructor_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testNumberConstructor_MissingExpr() {
        val expected = loadResource("tests/parser/marklogic-8.0/NumberConstructor_MissingExpr.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NumberConstructor_MissingExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testNumberConstructor_MissingClosingBrace() {
        val expected = loadResource("tests/parser/marklogic-8.0/NumberConstructor_MissingClosingBrace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NumberConstructor_MissingClosingBrace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 8.0 :: MapConstructor

    fun testMapConstructor() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapConstructor.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapConstructor.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapConstructor_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapConstructor_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapConstructor_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapConstructor_MissingClosingBrace() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapConstructor_MissingClosingBrace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapConstructor_MissingClosingBrace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 8.0 :: MapConstructorEntry + MapConstructor

    fun testMapConstructorEntry() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapConstructorEntry_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapConstructorEntry_MissingSeparator() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_MissingSeparator.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_MissingSeparator.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapConstructorEntry_MissingValueExpr() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_MissingValueExpr.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_MissingValueExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapConstructorEntry_Multiple() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_Multiple.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_Multiple.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapConstructorEntry_Multiple_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_Multiple_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_Multiple_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapConstructorEntry_Multiple_MissingEntry() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_Multiple_MissingEntry.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_Multiple_MissingEntry.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapConstructorEntry_NCName() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_NCName.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_NCName.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapConstructorEntry_NCName_WhitespaceAfterColon() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_NCName_WhitespaceAfterColon.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_NCName_WhitespaceAfterColon.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapConstructorEntry_NCName_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_NCName_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_NCName_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapConstructorEntry_QName_KeyExpr() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_QName_KeyExpr.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_QName_KeyExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapConstructorEntry_QName_ValueExpr() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_QName_ValueExpr.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_QName_ValueExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapConstructorEntry_QName_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_QName_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_QName_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapConstructorEntry_VarRef_NCName() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_VarRef_NCName.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_VarRef_NCName.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 8.0 :: AnyKindTest

    fun testAnyKindTest_KeyName() {
        val expected = loadResource("tests/parser/marklogic-8.0/AnyKindTest_KeyName.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/AnyKindTest_KeyName.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testAnyKindTest_KeyName_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/AnyKindTest_KeyName_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/AnyKindTest_KeyName_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testAnyKindTest_Wildcard() {
        val expected = loadResource("tests/parser/marklogic-8.0/AnyKindTest_Wildcard.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/AnyKindTest_Wildcard.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testAnyKindTest_Wildcard_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/AnyKindTest_Wildcard_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/AnyKindTest_Wildcard_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 8.0 :: TextTest

    fun testTextTest_KeyName() {
        val expected = loadResource("tests/parser/marklogic-8.0/TextTest_KeyName.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/TextTest_KeyName.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testTextTest_KeyName_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/TextTest_KeyName_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/TextTest_KeyName_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testTextTest_Wildcard() {
        val expected = loadResource("tests/parser/marklogic-8.0/TextTest_Wildcard.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/TextTest_Wildcard.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testTextTest_Wildcard_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/TextTest_Wildcard_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/TextTest_Wildcard_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 8.0 :: ArrayTest

    fun testArrayTest() {
        val expected = loadResource("tests/parser/marklogic-8.0/ArrayTest.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/ArrayTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testArrayTest_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/ArrayTest_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/ArrayTest_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testArrayTest_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/marklogic-8.0/ArrayTest_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/ArrayTest_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testArrayTest_KeyName() {
        val expected = loadResource("tests/parser/marklogic-8.0/ArrayTest_KeyName.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/ArrayTest_KeyName.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testArrayTest_KeyName_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/ArrayTest_KeyName_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/ArrayTest_KeyName_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testArrayTest_Wildcard() {
        val expected = loadResource("tests/parser/marklogic-8.0/ArrayTest_Wildcard.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/ArrayTest_Wildcard.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testArrayTest_Wildcard_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/ArrayTest_Wildcard_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/ArrayTest_Wildcard_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 8.0 :: BooleanTest

    fun testBooleanTest() {
        val expected = loadResource("tests/parser/marklogic-8.0/BooleanTest.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/BooleanTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testBooleanTest_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/BooleanTest_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/BooleanTest_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testBooleanTest_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/marklogic-8.0/BooleanTest_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/BooleanTest_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testBooleanTest_KeyName() {
        val expected = loadResource("tests/parser/marklogic-8.0/BooleanTest_KeyName.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/BooleanTest_KeyName.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testBooleanTest_KeyName_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/BooleanTest_KeyName_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/BooleanTest_KeyName_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testBooleanTest_Wildcard() {
        val expected = loadResource("tests/parser/marklogic-8.0/BooleanTest_Wildcard.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/BooleanTest_Wildcard.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testBooleanTest_Wildcard_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/BooleanTest_Wildcard_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/BooleanTest_Wildcard_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 8.0 :: NullTest

    fun testNullTest() {
        val expected = loadResource("tests/parser/marklogic-8.0/NullTest.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NullTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testNullTest_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/NullTest_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NullTest_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testNullTest_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/marklogic-8.0/NullTest_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NullTest_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testNullTest_KeyName() {
        val expected = loadResource("tests/parser/marklogic-8.0/NullTest_KeyName.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NullTest_KeyName.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testNullTest_KeyName_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/NullTest_KeyName_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NullTest_KeyName_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testNullTest_Wildcard() {
        val expected = loadResource("tests/parser/marklogic-8.0/NullTest_Wildcard.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NullTest_Wildcard.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testNullTest_Wildcard_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/NullTest_Wildcard_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NullTest_Wildcard_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 8.0 :: NumberTest

    fun testNumberTest() {
        val expected = loadResource("tests/parser/marklogic-8.0/NumberTest.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NumberTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testNumberTest_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/NumberTest_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NumberTest_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testNumberTest_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/marklogic-8.0/NumberTest_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NumberTest_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testNumberTest_KeyName() {
        val expected = loadResource("tests/parser/marklogic-8.0/NumberTest_KeyName.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NumberTest_KeyName.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testNumberTest_KeyName_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/NumberTest_KeyName_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NumberTest_KeyName_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testNumberTest_Wildcard() {
        val expected = loadResource("tests/parser/marklogic-8.0/NumberTest_Wildcard.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NumberTest_Wildcard.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testNumberTest_Wildcard_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/NumberTest_Wildcard_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NumberTest_Wildcard_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 8.0 :: MapTest

    fun testMapTest() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapTest.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapTest_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapTest_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapTest_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapTest_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapTest_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapTest_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapTest_KeyName() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapTest_KeyName.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapTest_KeyName.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapTest_KeyName_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapTest_KeyName_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapTest_KeyName_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapTest_Wildcard() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapTest_Wildcard.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapTest_Wildcard.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testMapTest_Wildcard_CompactWhitespace() {
        val expected = loadResource("tests/parser/marklogic-8.0/MapTest_Wildcard_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/MapTest_Wildcard_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 8.0 :: NodeTest + KindTest

    fun testKindTest_ArrayTest() {
        val expected = loadResource("tests/parser/marklogic-8.0/NodeTest_ArrayTest.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NodeTest_ArrayTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testKindTest_ArrayTest_StringLiteral() {
        val expected = loadResource("tests/parser/marklogic-8.0/NodeTest_ArrayTest_StringLiteral.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NodeTest_ArrayTest_StringLiteral.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testKindTest_ArrayTest_FunctionCallLike() {
        val expected = loadResource("tests/parser/marklogic-8.0/NodeTest_ArrayTest_FunctionCallLike.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NodeTest_ArrayTest_FunctionCallLike.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testKindTest_BooleanTest() {
        val expected = loadResource("tests/parser/marklogic-8.0/NodeTest_BooleanTest.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NodeTest_BooleanTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testKindTest_BooleanTest_StringLiteral() {
        val expected = loadResource("tests/parser/marklogic-8.0/NodeTest_BooleanTest_StringLiteral.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NodeTest_BooleanTest_StringLiteral.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testKindTest_BooleanTest_FunctionCallLike() {
        val expected = loadResource("tests/parser/marklogic-8.0/NodeTest_BooleanTest_FunctionCallLike.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NodeTest_BooleanTest_FunctionCallLike.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testKindTest_NullTest() {
        val expected = loadResource("tests/parser/marklogic-8.0/NodeTest_NullTest.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NodeTest_NullTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testKindTest_NullTest_StringLiteral() {
        val expected = loadResource("tests/parser/marklogic-8.0/NodeTest_NullTest_StringLiteral.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NodeTest_NullTest_StringLiteral.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testKindTest_NullTest_FunctionCallLike() {
        val expected = loadResource("tests/parser/marklogic-8.0/NodeTest_NullTest_FunctionCallLike.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NodeTest_NullTest_FunctionCallLike.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testKindTest_NumberTest() {
        val expected = loadResource("tests/parser/marklogic-8.0/NodeTest_NumberTest.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NodeTest_NumberTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testKindTest_NumberTest_StringLiteral() {
        val expected = loadResource("tests/parser/marklogic-8.0/NodeTest_NumberTest_StringLiteral.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NodeTest_NumberTest_StringLiteral.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testKindTest_NumberTest_FunctionCallLike() {
        val expected = loadResource("tests/parser/marklogic-8.0/NodeTest_NumberTest_FunctionCallLike.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NodeTest_NumberTest_FunctionCallLike.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testKindTest_MapTest() {
        val expected = loadResource("tests/parser/marklogic-8.0/NodeTest_MapTest.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NodeTest_MapTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testKindTest_MapTest_StringLiteral() {
        val expected = loadResource("tests/parser/marklogic-8.0/NodeTest_MapTest_StringLiteral.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NodeTest_MapTest_StringLiteral.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testKindTest_MapTest_FunctionCallLike() {
        val expected = loadResource("tests/parser/marklogic-8.0/NodeTest_MapTest_FunctionCallLike.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/NodeTest_MapTest_FunctionCallLike.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 8.0 :: DocumentTest + ArrayTest

    fun testDocumentTest_ArrayTest() {
        val expected = loadResource("tests/parser/marklogic-8.0/DocumentTest_ArrayTest.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/DocumentTest_ArrayTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testDocumentTest_ArrayTest_Wildcard() {
        val expected = loadResource("tests/parser/marklogic-8.0/DocumentTest_ArrayTest_Wildcard.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/DocumentTest_ArrayTest_Wildcard.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testDocumentTest_ArrayTest_StringLiteral() {
        val expected = loadResource("tests/parser/marklogic-8.0/DocumentTest_ArrayTest_StringLiteral.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/DocumentTest_ArrayTest_StringLiteral.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region MarkLogic 8.0 :: DocumentTest + MapTest

    fun testDocumentTest_MapTest() {
        val expected = loadResource("tests/parser/marklogic-8.0/DocumentTest_MapTest.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/DocumentTest_MapTest.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testDocumentTest_MapTest_Wildcard() {
        val expected = loadResource("tests/parser/marklogic-8.0/DocumentTest_MapTest_Wildcard.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/DocumentTest_MapTest_Wildcard.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testDocumentTest_MapTest_StringLiteral() {
        val expected = loadResource("tests/parser/marklogic-8.0/DocumentTest_MapTest_StringLiteral.txt")
        val actual = parseResource("tests/parser/marklogic-8.0/DocumentTest_MapTest_StringLiteral.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
}
