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
package uk.co.reecedunn.intellij.plugin.xquery.tests.parser;

import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.XQueryFile;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MarkLogicParserTest extends ParserTestCase {
    // region MarkLogic 6.0 :: Transactions + TransactionSeparator

    public void testTransactions_WithVersionDecl() {
        final String expected = loadResource("tests/parser/marklogic-6.0/Transactions_WithVersionDecl.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/Transactions_WithVersionDecl.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testTransactions_LibraryModule() {
        final String expected = loadResource("tests/parser/marklogic-6.0/Transactions_LibraryModule.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/Transactions_LibraryModule.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testTransactions_Prolog_ImportStatement() {
        final String expected = loadResource("tests/parser/marklogic-6.0/Transactions_Prolog_ImportStatement.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/Transactions_Prolog_ImportStatement.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testTransactions_Prolog_DeclareStatement() {
        final String expected = loadResource("tests/parser/marklogic-6.0/Transactions_Prolog_DeclareStatement.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/Transactions_Prolog_DeclareStatement.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testTransactions_AfterApplyExpr() {
        final String expected = loadResource("tests/parser/marklogic-6.0/Transactions_AfterApplyExpr.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/Transactions_AfterApplyExpr.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 6.0 :: CompatibilityAnnotation

    public void testCompatibilityAnnotation_FunctionDecl() {
        final String expected = loadResource("tests/parser/marklogic-6.0/CompatibilityAnnotation_FunctionDecl.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/CompatibilityAnnotation_FunctionDecl.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testCompatibilityAnnotation_FunctionDecl_MissingFunctionKeyword() {
        final String expected = loadResource("tests/parser/marklogic-6.0/CompatibilityAnnotation_FunctionDecl_MissingFunctionKeyword.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/CompatibilityAnnotation_FunctionDecl_MissingFunctionKeyword.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testCompatibilityAnnotation_VarDecl() {
        final String expected = loadResource("tests/parser/marklogic-6.0/CompatibilityAnnotation_VarDecl.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/CompatibilityAnnotation_VarDecl.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testCompatibilityAnnotation_VarDecl_MissingVariableKeyword() {
        final String expected = loadResource("tests/parser/marklogic-6.0/CompatibilityAnnotation_VarDecl_MissingVariableKeyword.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/CompatibilityAnnotation_VarDecl_MissingVariableKeyword.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 6.0 :: StylesheetImport

    public void testStylesheetImport() {
        final String expected = loadResource("tests/parser/marklogic-6.0/StylesheetImport.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/StylesheetImport.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testStylesheetImport_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-6.0/StylesheetImport_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/StylesheetImport_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testStylesheetImport_MissingAtKeyword() {
        final String expected = loadResource("tests/parser/marklogic-6.0/StylesheetImport_MissingAtKeyword.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/StylesheetImport_MissingAtKeyword.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testStylesheetImport_MissingUriLiteral() {
        final String expected = loadResource("tests/parser/marklogic-6.0/StylesheetImport_MissingUriLiteral.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/StylesheetImport_MissingUriLiteral.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 6.0 :: CatchClause + TryCatchExpr

    public void testCatchClause() {
        final String expected = loadResource("tests/parser/marklogic-6.0/CatchClause.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/CatchClause.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testCatchClause_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-6.0/CatchClause_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/CatchClause_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testCatchClause_MissingVariableIndicator() {
        final String expected = loadResource("tests/parser/marklogic-6.0/CatchClause_MissingVariableIndicator.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/CatchClause_MissingVariableIndicator.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testCatchClause_MissingVarName() {
        final String expected = loadResource("tests/parser/marklogic-6.0/CatchClause_MissingVarName.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/CatchClause_MissingVarName.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testCatchClause_MissingClosingParenthesis() {
        final String expected = loadResource("tests/parser/marklogic-6.0/CatchClause_MissingClosingParenthesis.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/CatchClause_MissingClosingParenthesis.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testCatchClause_EmptyExpr() {
        final String expected = loadResource("tests/parser/marklogic-6.0/CatchClause_EmptyExpr.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/CatchClause_EmptyExpr.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testCatchClause_Multiple() {
        final String expected = loadResource("tests/parser/marklogic-6.0/CatchClause_Multiple.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/CatchClause_Multiple.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 6.0 :: ValidateExpr

    public void testValidateExpr_ValidateAs() {
        final String expected = loadResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testValidateExpr_ValidateAs_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testValidateExpr_ValidateAs_MissingTypeName() {
        final String expected = loadResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs_MissingTypeName.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs_MissingTypeName.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testValidateExpr_ValidateAs_MissingOpeningBrace() {
        final String expected = loadResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs_MissingOpeningBrace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs_MissingOpeningBrace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testValidateExpr_ValidateAs_EQName() {
        final String expected = loadResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs_EQName.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/ValidateExpr_ValidateAs_EQName.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 6.0 :: ForwardAxis

    public void testForwardAxis_Namespace() {
        final String expected = loadResource("tests/parser/marklogic-6.0/ForwardAxis_Namespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/ForwardAxis_Namespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testForwardAxis_Namespace_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-6.0/ForwardAxis_Namespace_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/ForwardAxis_Namespace_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testForwardAxis_Property() {
        final String expected = loadResource("tests/parser/marklogic-6.0/ForwardAxis_Property.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/ForwardAxis_Property.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testForwardAxis_Property_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-6.0/ForwardAxis_Property_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/ForwardAxis_Property_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 6.0 :: BinaryConstructor

    public void testBinaryConstructor() {
        final String expected = loadResource("tests/parser/marklogic-6.0/BinaryConstructor.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/BinaryConstructor.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testBinaryConstructor_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-6.0/BinaryConstructor_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/BinaryConstructor_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testBinaryConstructor_NoExpr() {
        final String expected = loadResource("tests/parser/marklogic-6.0/BinaryConstructor_NoExpr.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/BinaryConstructor_NoExpr.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testBinaryConstructor_MissingClosingBrace() {
        final String expected = loadResource("tests/parser/marklogic-6.0/BinaryConstructor_MissingClosingBrace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/BinaryConstructor_MissingClosingBrace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 6.0 :: BinaryTest

    public void testBinaryTest() {
        final String expected = loadResource("tests/parser/marklogic-6.0/BinaryTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/BinaryTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testBinaryTest_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-6.0/BinaryTest_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/BinaryTest_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testBinaryTest_MissingClosingParenthesis() {
        final String expected = loadResource("tests/parser/marklogic-6.0/BinaryTest_MissingClosingParenthesis.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-6.0/BinaryTest_MissingClosingParenthesis.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 7.0 :: AttributeDeclTest

    public void testAttributeDeclTest() {
        final String expected = loadResource("tests/parser/marklogic-7.0/AttributeDeclTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/AttributeDeclTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testAttributeDeclTest_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-7.0/AttributeDeclTest_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/AttributeDeclTest_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testAttributeDeclTest_MissingClosingParenthesis() {
        final String expected = loadResource("tests/parser/marklogic-7.0/AttributeDeclTest_MissingClosingParenthesis.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/AttributeDeclTest_MissingClosingParenthesis.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 7.0 :: ComplexTypeTest

    public void testComplexTypeTest() {
        final String expected = loadResource("tests/parser/marklogic-7.0/ComplexTypeTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/ComplexTypeTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testComplexTypeTest_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-7.0/ComplexTypeTest_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/ComplexTypeTest_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testComplexTypeTest_MissingClosingParenthesis() {
        final String expected = loadResource("tests/parser/marklogic-7.0/ComplexTypeTest_MissingClosingParenthesis.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/ComplexTypeTest_MissingClosingParenthesis.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 7.0 :: ElementDeclTest

    public void testElementDeclTest() {
        final String expected = loadResource("tests/parser/marklogic-7.0/ElementDeclTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/ElementDeclTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testElementDeclTest_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-7.0/ElementDeclTest_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/ElementDeclTest_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testElementDeclTest_MissingClosingParenthesis() {
        final String expected = loadResource("tests/parser/marklogic-7.0/ElementDeclTest_MissingClosingParenthesis.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/ElementDeclTest_MissingClosingParenthesis.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 7.0 :: SchemaComponentTest

    public void testSchemaComponentTest() {
        final String expected = loadResource("tests/parser/marklogic-7.0/SchemaComponentTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/SchemaComponentTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testSchemaComponentTest_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-7.0/SchemaComponentTest_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/SchemaComponentTest_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testSchemaComponentTest_MissingClosingParenthesis() {
        final String expected = loadResource("tests/parser/marklogic-7.0/SchemaComponentTest_MissingClosingParenthesis.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/SchemaComponentTest_MissingClosingParenthesis.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 7.0 :: SchemaParticleTest

    public void testSchemaParticleTest() {
        final String expected = loadResource("tests/parser/marklogic-7.0/SchemaParticleTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/SchemaParticleTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testSchemaParticleTest_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-7.0/SchemaParticleTest_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/SchemaParticleTest_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testSchemaParticleTest_MissingClosingParenthesis() {
        final String expected = loadResource("tests/parser/marklogic-7.0/SchemaParticleTest_MissingClosingParenthesis.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/SchemaParticleTest_MissingClosingParenthesis.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 7.0 :: SchemaRootTest

    public void testSchemaRootTest() {
        final String expected = loadResource("tests/parser/marklogic-7.0/SchemaRootTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/SchemaRootTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testSchemaRootTest_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-7.0/SchemaRootTest_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/SchemaRootTest_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testSchemaRootTest_MissingClosingParenthesis() {
        final String expected = loadResource("tests/parser/marklogic-7.0/SchemaRootTest_MissingClosingParenthesis.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/SchemaRootTest_MissingClosingParenthesis.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 7.0 :: SchemaTypeTest

    public void testSchemaTypeTest() {
        final String expected = loadResource("tests/parser/marklogic-7.0/SchemaTypeTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/SchemaTypeTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testSchemaTypeTest_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-7.0/SchemaTypeTest_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/SchemaTypeTest_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testSchemaTypeTest_MissingClosingParenthesis() {
        final String expected = loadResource("tests/parser/marklogic-7.0/SchemaTypeTest_MissingClosingParenthesis.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/SchemaTypeTest_MissingClosingParenthesis.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 7.0 :: SimpleTypeTest

    public void testSimpleTypeTest() {
        final String expected = loadResource("tests/parser/marklogic-7.0/SimpleTypeTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/SimpleTypeTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testSimpleTypeTest_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-7.0/SimpleTypeTest_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/SimpleTypeTest_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testSimpleTypeTest_MissingClosingParenthesis() {
        final String expected = loadResource("tests/parser/marklogic-7.0/SimpleTypeTest_MissingClosingParenthesis.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-7.0/SimpleTypeTest_MissingClosingParenthesis.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 8.0 :: ArrayConstructor

    public void testArrayConstructor() {
        final String expected = loadResource("tests/parser/marklogic-8.0/ArrayConstructor.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/ArrayConstructor.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testArrayConstructor_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/ArrayConstructor_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/ArrayConstructor_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testArrayConstructor_MissingExpr() {
        final String expected = loadResource("tests/parser/marklogic-8.0/ArrayConstructor_MissingExpr.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/ArrayConstructor_MissingExpr.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testArrayConstructor_MissingClosingBrace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/ArrayConstructor_MissingClosingBrace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/ArrayConstructor_MissingClosingBrace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testArrayConstructor_Multiple() {
        final String expected = loadResource("tests/parser/marklogic-8.0/ArrayConstructor_Multiple.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/ArrayConstructor_Multiple.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testArrayConstructor_Multiple_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/ArrayConstructor_Multiple_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/ArrayConstructor_Multiple_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testArrayConstructor_Multiple_MissingExpr() {
        final String expected = loadResource("tests/parser/marklogic-8.0/ArrayConstructor_Multiple_MissingExpr.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/ArrayConstructor_Multiple_MissingExpr.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 8.0 :: BooleanConstructor

    public void testBooleanConstructor() {
        final String expected = loadResource("tests/parser/marklogic-8.0/BooleanConstructor.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/BooleanConstructor.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testBooleanConstructor_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/BooleanConstructor_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/BooleanConstructor_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testBooleanConstructor_MissingExpr() {
        final String expected = loadResource("tests/parser/marklogic-8.0/BooleanConstructor_MissingExpr.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/BooleanConstructor_MissingExpr.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testBooleanConstructor_MissingClosingBrace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/BooleanConstructor_MissingClosingBrace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/BooleanConstructor_MissingClosingBrace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 8.0 :: NullConstructor

    public void testNullConstructor() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NullConstructor.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NullConstructor.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testNullConstructor_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NullConstructor_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NullConstructor_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testNullConstructor_MissingClosingBrace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NullConstructor_MissingClosingBrace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NullConstructor_MissingClosingBrace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 8.0 :: NumberConstructor

    public void testNumberConstructor() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NumberConstructor.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NumberConstructor.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testNumberConstructor_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NumberConstructor_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NumberConstructor_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testNumberConstructor_MissingExpr() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NumberConstructor_MissingExpr.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NumberConstructor_MissingExpr.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testNumberConstructor_MissingClosingBrace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NumberConstructor_MissingClosingBrace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NumberConstructor_MissingClosingBrace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 8.0 :: MapConstructor

    public void testMapConstructor() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapConstructor.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapConstructor.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapConstructor_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapConstructor_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapConstructor_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapConstructor_MissingClosingBrace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapConstructor_MissingClosingBrace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapConstructor_MissingClosingBrace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 8.0 :: MapConstructorEntry + MapConstructor

    public void testMapConstructorEntry() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapConstructorEntry_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapConstructorEntry_MissingSeparator() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_MissingSeparator.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_MissingSeparator.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapConstructorEntry_MissingValueExpr() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_MissingValueExpr.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_MissingValueExpr.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapConstructorEntry_Multiple() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_Multiple.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_Multiple.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapConstructorEntry_Multiple_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_Multiple_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_Multiple_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapConstructorEntry_Multiple_MissingEntry() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_Multiple_MissingEntry.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_Multiple_MissingEntry.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapConstructorEntry_NCName() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_NCName.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_NCName.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapConstructorEntry_NCName_WhitespaceAfterColon() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_NCName_WhitespaceAfterColon.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_NCName_WhitespaceAfterColon.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapConstructorEntry_NCName_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_NCName_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_NCName_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapConstructorEntry_QName_KeyExpr() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_QName_KeyExpr.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_QName_KeyExpr.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapConstructorEntry_QName_ValueExpr() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_QName_ValueExpr.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_QName_ValueExpr.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapConstructorEntry_QName_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_QName_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_QName_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapConstructorEntry_VarRef_NCName() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapConstructorEntry_VarRef_NCName.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapConstructorEntry_VarRef_NCName.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 8.0 :: AnyKindTest

    public void testAnyKindTest_KeyName() {
        final String expected = loadResource("tests/parser/marklogic-8.0/AnyKindTest_KeyName.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/AnyKindTest_KeyName.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testAnyKindTest_KeyName_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/AnyKindTest_KeyName_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/AnyKindTest_KeyName_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testAnyKindTest_Wildcard() {
        final String expected = loadResource("tests/parser/marklogic-8.0/AnyKindTest_Wildcard.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/AnyKindTest_Wildcard.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testAnyKindTest_Wildcard_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/AnyKindTest_Wildcard_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/AnyKindTest_Wildcard_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 8.0 :: TextTest

    public void testTextTest_KeyName() {
        final String expected = loadResource("tests/parser/marklogic-8.0/TextTest_KeyName.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/TextTest_KeyName.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testTextTest_KeyName_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/TextTest_KeyName_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/TextTest_KeyName_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testTextTest_Wildcard() {
        final String expected = loadResource("tests/parser/marklogic-8.0/TextTest_Wildcard.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/TextTest_Wildcard.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testTextTest_Wildcard_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/TextTest_Wildcard_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/TextTest_Wildcard_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 8.0 :: ArrayTest

    public void testArrayTest() {
        final String expected = loadResource("tests/parser/marklogic-8.0/ArrayTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/ArrayTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testArrayTest_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/ArrayTest_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/ArrayTest_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testArrayTest_MissingClosingParenthesis() {
        final String expected = loadResource("tests/parser/marklogic-8.0/ArrayTest_MissingClosingParenthesis.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/ArrayTest_MissingClosingParenthesis.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testArrayTest_KeyName() {
        final String expected = loadResource("tests/parser/marklogic-8.0/ArrayTest_KeyName.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/ArrayTest_KeyName.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testArrayTest_KeyName_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/ArrayTest_KeyName_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/ArrayTest_KeyName_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testArrayTest_Wildcard() {
        final String expected = loadResource("tests/parser/marklogic-8.0/ArrayTest_Wildcard.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/ArrayTest_Wildcard.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testArrayTest_Wildcard_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/ArrayTest_Wildcard_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/ArrayTest_Wildcard_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 8.0 :: BooleanTest

    public void testBooleanTest() {
        final String expected = loadResource("tests/parser/marklogic-8.0/BooleanTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/BooleanTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testBooleanTest_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/BooleanTest_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/BooleanTest_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testBooleanTest_MissingClosingParenthesis() {
        final String expected = loadResource("tests/parser/marklogic-8.0/BooleanTest_MissingClosingParenthesis.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/BooleanTest_MissingClosingParenthesis.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testBooleanTest_KeyName() {
        final String expected = loadResource("tests/parser/marklogic-8.0/BooleanTest_KeyName.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/BooleanTest_KeyName.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testBooleanTest_KeyName_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/BooleanTest_KeyName_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/BooleanTest_KeyName_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testBooleanTest_Wildcard() {
        final String expected = loadResource("tests/parser/marklogic-8.0/BooleanTest_Wildcard.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/BooleanTest_Wildcard.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testBooleanTest_Wildcard_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/BooleanTest_Wildcard_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/BooleanTest_Wildcard_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 8.0 :: NullTest

    public void testNullTest() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NullTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NullTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testNullTest_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NullTest_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NullTest_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testNullTest_MissingClosingParenthesis() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NullTest_MissingClosingParenthesis.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NullTest_MissingClosingParenthesis.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testNullTest_KeyName() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NullTest_KeyName.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NullTest_KeyName.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testNullTest_KeyName_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NullTest_KeyName_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NullTest_KeyName_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testNullTest_Wildcard() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NullTest_Wildcard.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NullTest_Wildcard.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testNullTest_Wildcard_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NullTest_Wildcard_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NullTest_Wildcard_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 8.0 :: NumberTest

    public void testNumberTest() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NumberTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NumberTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testNumberTest_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NumberTest_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NumberTest_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testNumberTest_MissingClosingParenthesis() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NumberTest_MissingClosingParenthesis.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NumberTest_MissingClosingParenthesis.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testNumberTest_KeyName() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NumberTest_KeyName.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NumberTest_KeyName.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testNumberTest_KeyName_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NumberTest_KeyName_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NumberTest_KeyName_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testNumberTest_Wildcard() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NumberTest_Wildcard.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NumberTest_Wildcard.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testNumberTest_Wildcard_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NumberTest_Wildcard_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NumberTest_Wildcard_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 8.0 :: MapTest

    public void testMapTest() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapTest_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapTest_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapTest_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapTest_MissingClosingParenthesis() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapTest_MissingClosingParenthesis.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapTest_MissingClosingParenthesis.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapTest_KeyName() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapTest_KeyName.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapTest_KeyName.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapTest_KeyName_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapTest_KeyName_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapTest_KeyName_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapTest_Wildcard() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapTest_Wildcard.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapTest_Wildcard.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testMapTest_Wildcard_CompactWhitespace() {
        final String expected = loadResource("tests/parser/marklogic-8.0/MapTest_Wildcard_CompactWhitespace.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/MapTest_Wildcard_CompactWhitespace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region MarkLogic 8.0 :: NodeTest + KindTest

    public void testKindTest_ArrayTest() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NodeTest_ArrayTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NodeTest_ArrayTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testKindTest_ArrayTest_StringLiteral() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NodeTest_ArrayTest_StringLiteral.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NodeTest_ArrayTest_StringLiteral.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testKindTest_ArrayTest_FunctionCallLike() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NodeTest_ArrayTest_FunctionCallLike.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NodeTest_ArrayTest_FunctionCallLike.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testKindTest_BooleanTest() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NodeTest_BooleanTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NodeTest_BooleanTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testKindTest_BooleanTest_StringLiteral() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NodeTest_BooleanTest_StringLiteral.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NodeTest_BooleanTest_StringLiteral.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testKindTest_BooleanTest_FunctionCallLike() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NodeTest_BooleanTest_FunctionCallLike.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NodeTest_BooleanTest_FunctionCallLike.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testKindTest_NullTest() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NodeTest_NullTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NodeTest_NullTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testKindTest_NullTest_StringLiteral() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NodeTest_NullTest_StringLiteral.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NodeTest_NullTest_StringLiteral.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testKindTest_NullTest_FunctionCallLike() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NodeTest_NullTest_FunctionCallLike.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NodeTest_NullTest_FunctionCallLike.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testKindTest_NumberTest() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NodeTest_NumberTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NodeTest_NumberTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testKindTest_NumberTest_StringLiteral() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NodeTest_NumberTest_StringLiteral.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NodeTest_NumberTest_StringLiteral.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testKindTest_NumberTest_FunctionCallLike() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NodeTest_NumberTest_FunctionCallLike.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NodeTest_NumberTest_FunctionCallLike.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testKindTest_MapTest() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NodeTest_MapTest.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NodeTest_MapTest.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testKindTest_MapTest_StringLiteral() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NodeTest_MapTest_StringLiteral.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NodeTest_MapTest_StringLiteral.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testKindTest_MapTest_FunctionCallLike() {
        final String expected = loadResource("tests/parser/marklogic-8.0/NodeTest_MapTest_FunctionCallLike.txt");
        final XQueryFile actual = parseResource("tests/parser/marklogic-8.0/NodeTest_MapTest_FunctionCallLike.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
}
