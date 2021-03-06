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
package uk.co.reecedunn.intellij.plugin.xquery.tests.parser

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

class FullTextParserTest : ParserTestCase() {
    // region Full Text 1.0 :: FTOptionDecl + FTMatchOptions

    fun testFTOptionDecl() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLanguageOption.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLanguageOption.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTOptionDecl_MissingFTMatchOptions() {
        val expected = loadResource("tests/parser/full-text-1.0/FTOptionDecl_MissingFTMatchOptions.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTOptionDecl_MissingFTMatchOptions.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTOptionDecl_MissingFTOption() {
        val expected = loadResource("tests/parser/full-text-1.0/FTMatchOptions_MissingFTMatchOption.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTMatchOptions_MissingFTMatchOption.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTOptionDecl_NoKeywordOnly() {
        val expected = loadResource("tests/parser/full-text-1.0/FTMatchOptions_NoKeywordOnly.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTMatchOptions_NoKeywordOnly.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: ForBinding + FTScoreVar

    fun testForBinding_FTScoreVar() {
        val expected = loadResource("tests/parser/full-text-1.0/ForBinding_FTScoreVar.txt")
        val actual = parseResource("tests/parser/full-text-1.0/ForBinding_FTScoreVar.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testForBinding_FTScoreVar_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/ForBinding_FTScoreVar_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/ForBinding_FTScoreVar_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testForBinding_FTScoreVar_MissingInKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/ForBinding_FTScoreVar_MissingInKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/ForBinding_FTScoreVar_MissingInKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTScoreVar

    fun testFTScoreVar() {
        val expected = loadResource("tests/parser/full-text-1.0/ForBinding_FTScoreVar.txt")
        val actual = parseResource("tests/parser/full-text-1.0/ForBinding_FTScoreVar.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTScoreVar_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/ForBinding_FTScoreVar_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/ForBinding_FTScoreVar_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTScoreVar_MissingVarIndicator() {
        val expected = loadResource("tests/parser/full-text-1.0/FTScoreVar_MissingVarIndicator.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTScoreVar_MissingVarIndicator.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTScoreVar_MissingVarName() {
        val expected = loadResource("tests/parser/full-text-1.0/FTScoreVar_MissingVarName.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTScoreVar_MissingVarName.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: LetBinding + FTScoreVar

    fun testLetBinding_FTScoreVar() {
        val expected = loadResource("tests/parser/full-text-1.0/LetBinding_FTScoreVar.txt")
        val actual = parseResource("tests/parser/full-text-1.0/LetBinding_FTScoreVar.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testLetBinding_FTScoreVar_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/LetBinding_FTScoreVar_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/LetBinding_FTScoreVar_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTContainsExpr

    fun testFTContainsExpr() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWordsValue.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWordsValue.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTContainsExpr_FTIgnoreOption() {
        val expected = loadResource("tests/parser/full-text-1.0/FTIgnoreOption.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTIgnoreOption.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTContainsExpr_MissingTextKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTContainsExpr_MissingTextKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTContainsExpr_MissingTextKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTContainsExpr_MissingFTSelection() {
        val expected = loadResource("tests/parser/full-text-1.0/FTContainsExpr_MissingFTSelection.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTContainsExpr_MissingFTSelection.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTSelection

    fun testFTSelection() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWordsValue.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWordsValue.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTSelection_FTPosFilter_Single() {
        val expected = loadResource("tests/parser/full-text-1.0/FTOrder.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTOrder.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTSelection_FTPosFilter_Multiple() {
        val expected = loadResource("tests/parser/full-text-1.0/FTSelection_FTPosFilter_Multiple.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTSelection_FTPosFilter_Multiple.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTWeight

    fun testFTWeight() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWeight.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWeight.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTWeight_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWeight_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWeight_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTWeight_MissingExpr() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWeight_MissingExpr.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWeight_MissingExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTWeight_MissingClosingBrace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWeight_MissingClosingBrace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWeight_MissingClosingBrace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTOr

    fun testFTOr() {
        val expected = loadResource("tests/parser/full-text-1.0/FTOr.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTOr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTOr_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTOr_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTOr_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTOr_Multiple() {
        val expected = loadResource("tests/parser/full-text-1.0/FTOr_Multiple.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTOr_Multiple.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTOr_Multiple_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTOr_Multiple_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTOr_Multiple_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTOr_MissingFTAnd() {
        val expected = loadResource("tests/parser/full-text-1.0/FTOr_MissingFTAnd.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTOr_MissingFTAnd.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTAnd

    fun testFTAnd() {
        val expected = loadResource("tests/parser/full-text-1.0/FTAnd.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTAnd.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTAnd_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTAnd_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTAnd_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTAnd_Multiple() {
        val expected = loadResource("tests/parser/full-text-1.0/FTAnd_Multiple.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTAnd_Multiple.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTAnd_Multiple_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTAnd_Multiple_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTAnd_Multiple_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTAnd_MissingFTMildNot() {
        val expected = loadResource("tests/parser/full-text-1.0/FTAnd_MissingFTMildNot.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTAnd_MissingFTMildNot.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTMildNot

    fun testFTMildNot() {
        val expected = loadResource("tests/parser/full-text-1.0/FTMildNot.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTMildNot.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTMildNot_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTMildNot_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTMildNot_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTMildNot_Multiple() {
        val expected = loadResource("tests/parser/full-text-1.0/FTMildNot_Multiple.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTMildNot_Multiple.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTMildNot_Multiple_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTMildNot_Multiple_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTMildNot_Multiple_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTMildNot_MissingInKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTMildNot_MissingInKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTMildNot_MissingInKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTMildNot_MissingFTUnaryNot() {
        val expected = loadResource("tests/parser/full-text-1.0/FTMildNot_MissingFTUnaryNot.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTMildNot_MissingFTUnaryNot.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTUnaryNot

    fun testFTUnaryNot() {
        val expected = loadResource("tests/parser/full-text-1.0/FTUnaryNot.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTUnaryNot.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTPrimaryWithOptions

    fun testFTPrimaryWithOptions_MatchOptions() {
        val expected = loadResource("tests/parser/full-text-1.0/FTPrimaryWithOptions_MatchOptions.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTPrimaryWithOptions_MatchOptions.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTPrimaryWithOptions_FTWeight() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWeight.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWeight.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTPrimaryWithOptions_MatchOptionsAndWeight() {
        val expected = loadResource("tests/parser/full-text-1.0/FTPrimaryWithOptions_MatchOptionsAndWeight.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTPrimaryWithOptions_MatchOptionsAndWeight.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTPrimary

    fun testFTPrimary_Words() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWordsValue.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWordsValue.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTPrimary_WordsTimes() {
        val expected = loadResource("tests/parser/full-text-1.0/FTRange_AtLeast.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTRange_AtLeast.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTPrimary_Parenthesis() {
        val expected = loadResource("tests/parser/full-text-1.0/FTPrimary_Parenthesis.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTPrimary_Parenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTPrimary_Parenthesis_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTPrimary_Parenthesis_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTPrimary_Parenthesis_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTPrimary_Parenthesis_MissingFTSelection() {
        val expected = loadResource("tests/parser/full-text-1.0/FTPrimary_Parenthesis_MissingFTSelection.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTPrimary_Parenthesis_MissingFTSelection.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTPrimary_Parenthesis_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/full-text-1.0/FTPrimary_Parenthesis_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTPrimary_Parenthesis_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTPrimary_ExtensionSelection() {
        val expected = loadResource("tests/parser/full-text-1.0/FTExtensionSelection.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTExtensionSelection.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTWordsValue

    fun testFTWordsValue() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWordsValue.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWordsValue.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTWordsValue_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWordsValue_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWordsValue_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTWordsValue_Expr() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWordsValue_Expr.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWordsValue_Expr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTWordsValue_Expr_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWordsValue_Expr_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWordsValue_Expr_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTWordsValue_Expr_MissingExpr() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWordsValue_Expr_MissingExpr.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWordsValue_Expr_MissingExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTWordsValue_Expr_MissingClosingBrace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWordsValue_Expr_MissingClosingBrace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWordsValue_Expr_MissingClosingBrace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTExtensionSelection

    fun testFTExtensionSelection() {
        val expected = loadResource("tests/parser/full-text-1.0/FTExtensionSelection.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTExtensionSelection.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTExtensionSelection_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTExtensionSelection_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTExtensionSelection_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTExtensionSelection_MultiplePragmas() {
        val expected = loadResource("tests/parser/full-text-1.0/FTExtensionSelection_MultiplePragmas.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTExtensionSelection_MultiplePragmas.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTExtensionSelection_MissingOpenBrace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTExtensionSelection_MissingOpenBrace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTExtensionSelection_MissingOpenBrace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTExtensionSelection_MissingFTSelection() {
        val expected = loadResource("tests/parser/full-text-1.0/FTExtensionSelection_MissingFTSelection.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTExtensionSelection_MissingFTSelection.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTExtensionSelection_MissingCloseBrace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTExtensionSelection_MissingCloseBrace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTExtensionSelection_MissingCloseBrace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTAnyallOption

    fun testFTAnyallOption_Any() {
        val expected = loadResource("tests/parser/full-text-1.0/FTAnyallOption_Any.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTAnyallOption_Any.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTAnyallOption_AnyWord() {
        val expected = loadResource("tests/parser/full-text-1.0/FTAnyallOption_AnyWord.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTAnyallOption_AnyWord.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTAnyallOption_All() {
        val expected = loadResource("tests/parser/full-text-1.0/FTAnyallOption_All.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTAnyallOption_All.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTAnyallOption_AllWords() {
        val expected = loadResource("tests/parser/full-text-1.0/FTAnyallOption_AllWords.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTAnyallOption_AllWords.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTAnyallOption_Phrase() {
        val expected = loadResource("tests/parser/full-text-1.0/FTAnyallOption_Phrase.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTAnyallOption_Phrase.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTTimes

    fun testFTTimes() {
        val expected = loadResource("tests/parser/full-text-1.0/FTRange_AtLeast.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTRange_AtLeast.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTTimes_MissingFTRange() {
        val expected = loadResource("tests/parser/full-text-1.0/FTTimes_MissingFTRange.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTTimes_MissingFTRange.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTTimes_MissingTimesKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTTimes_MissingTimesKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTTimes_MissingTimesKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTRange

    fun testFTRange_Exactly() {
        val expected = loadResource("tests/parser/full-text-1.0/FTRange_Exactly.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTRange_Exactly.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTRange_Exactly_MissingAdditiveExpr() {
        val expected = loadResource("tests/parser/full-text-1.0/FTRange_Exactly_MissingAdditiveExpr.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTRange_Exactly_MissingAdditiveExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTRange_At_MissingQualifier() {
        val expected = loadResource("tests/parser/full-text-1.0/FTRange_At_MissingQualifier.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTRange_At_MissingQualifier.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTRange_AtLeast() {
        val expected = loadResource("tests/parser/full-text-1.0/FTRange_AtLeast.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTRange_AtLeast.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTRange_AtLeast_MissingAdditiveExpr() {
        val expected = loadResource("tests/parser/full-text-1.0/FTRange_AtLeast_MissingAdditiveExpr.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTRange_AtLeast_MissingAdditiveExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTRange_AtMost() {
        val expected = loadResource("tests/parser/full-text-1.0/FTRange_AtMost.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTRange_AtMost.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTRange_AtMost_MissingAdditiveExpr() {
        val expected = loadResource("tests/parser/full-text-1.0/FTRange_AtMost_MissingAdditiveExpr.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTRange_AtMost_MissingAdditiveExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTRange_FromTo() {
        val expected = loadResource("tests/parser/full-text-1.0/FTRange_FromTo.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTRange_FromTo.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTRange_FromTo_MissingFromExpr() {
        val expected = loadResource("tests/parser/full-text-1.0/FTRange_FromTo_MissingFromExpr.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTRange_FromTo_MissingFromExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTRange_FromTo_MissingToKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTRange_FromTo_MissingToKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTRange_FromTo_MissingToKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTRange_FromTo_MissingToExpr() {
        val expected = loadResource("tests/parser/full-text-1.0/FTRange_FromTo_MissingToExpr.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTRange_FromTo_MissingToExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTOrder

    fun testFTOrder() {
        val expected = loadResource("tests/parser/full-text-1.0/FTOrder.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTOrder.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTWindow

    fun testFTWindow() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWindow.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWindow.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTWindow_MissingAdditiveExpr() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWindow_MissingAdditiveExpr.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWindow_MissingAdditiveExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTWindow_MissingFTUnit() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWindow_MissingFTUnit.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWindow_MissingFTUnit.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTDistance

    fun testFTDistance() {
        val expected = loadResource("tests/parser/full-text-1.0/FTDistance.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTDistance.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTDistance_MissingFTRange() {
        val expected = loadResource("tests/parser/full-text-1.0/FTDistance_MissingFTRange.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTDistance_MissingFTRange.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTDistance_MissingFTUnit() {
        val expected = loadResource("tests/parser/full-text-1.0/FTDistance_MissingFTUnit.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTDistance_MissingFTUnit.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTUnit

    fun testFTUnit_Words() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWindow.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWindow.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTUnit_Sentences() {
        val expected = loadResource("tests/parser/full-text-1.0/FTUnit_Sentences.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTUnit_Sentences.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTUnit_Paragraphs() {
        val expected = loadResource("tests/parser/full-text-1.0/FTUnit_Paragraphs.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTUnit_Paragraphs.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTScope

    fun testFTScope_Same() {
        val expected = loadResource("tests/parser/full-text-1.0/FTScope_Same.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTScope_Same.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTScope_Same_MissingFTBigUnit() {
        val expected = loadResource("tests/parser/full-text-1.0/FTScope_Same_MissingFTBigUnit.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTScope_Same_MissingFTBigUnit.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTScope_Different() {
        val expected = loadResource("tests/parser/full-text-1.0/FTScope_Different.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTScope_Different.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTScope_Different_MissingFTBigUnit() {
        val expected = loadResource("tests/parser/full-text-1.0/FTScope_Different_MissingFTBigUnit.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTScope_Different_MissingFTBigUnit.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTBigUnit

    fun testFTBigUnit_Sentence() {
        val expected = loadResource("tests/parser/full-text-1.0/FTScope_Same.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTScope_Same.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTBigUnit_Paragraph() {
        val expected = loadResource("tests/parser/full-text-1.0/FTBigUnit_Paragraph.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTBigUnit_Paragraph.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTContent

    fun testFTContent_AtStart() {
        val expected = loadResource("tests/parser/full-text-1.0/FTContent_AtStart.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTContent_AtStart.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTContent_AtEnd() {
        val expected = loadResource("tests/parser/full-text-1.0/FTContent_AtEnd.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTContent_AtEnd.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTContent_At_MissingStartEndKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTContent_At_MissingStartEndKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTContent_At_MissingStartEndKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTContent_EntireContent() {
        val expected = loadResource("tests/parser/full-text-1.0/FTContent_EntireContent.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTContent_EntireContent.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTContent_EntireContent_MissingContentKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTContent_EntireContent_MissingContentKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTContent_EntireContent_MissingContentKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTCaseOption

    fun testFTCaseOption_LowerCase() {
        val expected = loadResource("tests/parser/full-text-1.0/FTCaseOption_LowerCase.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTCaseOption_LowerCase.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTCaseOption_LowerCase_MissingUsingKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTCaseOption_LowerCase_MissingUsingKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTCaseOption_LowerCase_MissingUsingKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTCaseOption_UpperCase() {
        val expected = loadResource("tests/parser/full-text-1.0/FTCaseOption_UpperCase.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTCaseOption_UpperCase.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTCaseOption_UpperCase_MissingUsingKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTCaseOption_UpperCase_MissingUsingKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTCaseOption_UpperCase_MissingUsingKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTCaseOption_Case_Sensitive() {
        val expected = loadResource("tests/parser/full-text-1.0/FTCaseOption_Case_Sensitive.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTCaseOption_Case_Sensitive.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTCaseOption_Case_Insensitive() {
        val expected = loadResource("tests/parser/full-text-1.0/FTCaseOption_Case_Insensitive.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTCaseOption_Case_Insensitive.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTCaseOption_Case_MissingSensitivityKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTCaseOption_Case_MissingSensitivityKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTCaseOption_Case_MissingSensitivityKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTCaseOption_Case_MissingUsingKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTCaseOption_Case_MissingUsingKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTCaseOption_Case_MissingUsingKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTDiacriticsOption

    fun testFTDiacriticsOption_Sensitive() {
        val expected = loadResource("tests/parser/full-text-1.0/FTDiacriticsOption_Sensitive.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTDiacriticsOption_Sensitive.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTDiacriticsOption_Insensitive() {
        val expected = loadResource("tests/parser/full-text-1.0/FTDiacriticsOption_Insensitive.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTDiacriticsOption_Insensitive.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTDiacriticsOption_MissingSensitivityKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTDiacriticsOption_MissingSensitivityKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTDiacriticsOption_MissingSensitivityKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTDiacriticsOption_MissingUsingKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTDiacriticsOption_MissingUsingKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTDiacriticsOption_MissingUsingKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTStemOption

    fun testFTStemOption() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStemOption.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStemOption.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStemOption_MissingUsingKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStemOption_MissingUsingKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStemOption_MissingUsingKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStemOption_NoStemming() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStemOption_NoStemming.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStemOption_NoStemming.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStemOption_NoStemming_MissingUsingKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStemOption_NoStemming_MissingUsingKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStemOption_NoStemming_MissingUsingKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTThesaurusOption

    fun testFTThesaurusOption_Default() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_Default.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_Default.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_ThesaurusID() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusID.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusID.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_NoThesaurus() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_NoThesaurus.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_NoThesaurus.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_NoThesaurus_MissingUsingKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_NoThesaurus_MissingUsingKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_NoThesaurus_MissingUsingKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_MissingThesaurusID() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_MissingThesaurusID.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_MissingThesaurusID.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_Parenthesized_Default() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_Default.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_Default.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_Parenthesized_ThesaurusID() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_ThesaurusID.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_ThesaurusID.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_Parenthesized_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_Parenthesized_MissingThesaurusID() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_MissingThesaurusID.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_MissingThesaurusID.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_Parenthesized_MissingClosingParenthesis() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_MissingClosingParenthesis.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_MissingClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_Parenthesized_TwoItems() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_TwoItems.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_TwoItems.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_Parenthesized_TwoItems_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_TwoItems_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_TwoItems_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_Parenthesized_TwoItems_MissingThesaurusID() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_TwoItems_MissingThesaurusID.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_TwoItems_MissingThesaurusID.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_Parenthesized_Multiple() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_Multiple.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_Multiple.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_Parenthesized_Multiple_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_Multiple_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_Multiple_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_Parenthesized_Multiple_DefaultAfterFirstItem() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_Multiple_DefaultAfterFirstItem.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_Parenthesized_Multiple_DefaultAfterFirstItem.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_NoParenthesis_Multiple() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_NoParenthesis_Multiple.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_NoParenthesis_Multiple.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_NoParenthesis_Multiple_UnexpectedClosingParenthesis() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_NoParenthesis_Multiple_UnexpectedClosingParenthesis.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_NoParenthesis_Multiple_UnexpectedClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_UnexpectedClosingParenthesis() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_UnexpectedClosingParenthesis.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_UnexpectedClosingParenthesis.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusOption_MissingUsingKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusOption_MissingUsingKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusOption_MissingUsingKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTThesaurusID (FTThesaurusOption)

    fun testFTThesaurusID() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusID.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusID.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusID_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusID_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusID_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusID_MissingUriLiteral() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusID_MissingUriLiteral.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusID_MissingUriLiteral.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusID_Relationship() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusID_Relationship.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusID_Relationship.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusID_Relationship_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusID_Relationship_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusID_Relationship_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusID_Relationship_MissingStringLiteral() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusID_Relationship_MissingStringLiteral.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusID_Relationship_MissingStringLiteral.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusID_LiteralRange() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLiteralRange_Exactly.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLiteralRange_Exactly.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTThesaurusID_LiteralRange_MissingLevelsKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTThesaurusID_LiteralRange_MissingLevelsKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTThesaurusID_LiteralRange_MissingLevelsKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTLiteralRange (FTThesaurusOption)

    fun testFTLiteralRange_Exactly() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLiteralRange_Exactly.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLiteralRange_Exactly.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTLiteralRange_Exactly_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLiteralRange_Exactly_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLiteralRange_Exactly_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTLiteralRange_Exactly_MissingIntegerLiteral() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLiteralRange_Exactly_MissingIntegerLiteral.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLiteralRange_Exactly_MissingIntegerLiteral.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTLiteralRange_At_MissingQualifier() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLiteralRange_At_MissingQualifier.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLiteralRange_At_MissingQualifier.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTLiteralRange_AtLeast() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLiteralRange_AtLeast.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLiteralRange_AtLeast.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTLiteralRange_AtLeast_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLiteralRange_AtLeast_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLiteralRange_AtLeast_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTLiteralRange_AtLeast_MissingIntegerLiteral() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLiteralRange_AtLeast_MissingIntegerLiteral.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLiteralRange_AtLeast_MissingIntegerLiteral.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTLiteralRange_AtMost() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLiteralRange_AtMost.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLiteralRange_AtMost.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTLiteralRange_AtMost_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLiteralRange_AtMost_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLiteralRange_AtMost_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTLiteralRange_AtMost_MissingIntegerLiteral() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLiteralRange_AtMost_MissingIntegerLiteral.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLiteralRange_AtMost_MissingIntegerLiteral.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTLiteralRange_FromTo() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLiteralRange_FromTo.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLiteralRange_FromTo.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTLiteralRange_FromTo_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLiteralRange_FromTo_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLiteralRange_FromTo_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTLiteralRange_FromTo_MissingFromLiteral() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLiteralRange_FromTo_MissingFromLiteral.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLiteralRange_FromTo_MissingFromLiteral.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTLiteralRange_FromTo_MissingToKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLiteralRange_FromTo_MissingToKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLiteralRange_FromTo_MissingToKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTLiteralRange_FromTo_MissingToLiteral() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLiteralRange_FromTo_MissingToLiteral.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLiteralRange_FromTo_MissingToLiteral.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTStopWordOption

    fun testFTStopWordOption_Default() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordOption_Default.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordOption_Default.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordOption_Default_MissingWordsKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordOption_Default_MissingWordsKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordOption_Default_MissingWordsKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordOption_Default_FTStopWordsInclExcl() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordsInclExcl_Include.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordsInclExcl_Include.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordOption_Default_FTStopWordsInclExcl_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordsInclExcl_Include_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordsInclExcl_Include_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordOption_Default_FTStopWordsInclExcl_Multiple() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordOption_Default_FTStopWordsInclExcl_Multiple.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordOption_Default_FTStopWordsInclExcl_Multiple.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordOption_Default_FTStopWordsInclExcl_Multiple_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordOption_Default_FTStopWordsInclExcl_Multiple_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordOption_Default_FTStopWordsInclExcl_Multiple_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordOption_FTStopWords() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWords_List_Single.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWords_List_Single.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordOption_FTStopWords_FTStopWordsInclExcl() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordOption_FTStopWords_FTStopWordsInclExcl.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordOption_FTStopWords_FTStopWordsInclExcl.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordOption_FTStopWords_FTStopWordsInclExcl_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordOption_FTStopWords_FTStopWordsInclExcl_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordOption_FTStopWords_FTStopWordsInclExcl_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordOption_FTStopWords_FTStopWordsInclExcl_Multiple() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordOption_FTStopWords_FTStopWordsInclExcl_Multiple.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordOption_FTStopWords_FTStopWordsInclExcl_Multiple.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordOption_FTStopWords_FTStopWordsInclExcl_Multiple_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordOption_FTStopWords_FTStopWordsInclExcl_Multiple_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordOption_FTStopWords_FTStopWordsInclExcl_Multiple_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordOption_MissingStopWords() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordOption_MissingStopWords.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordOption_MissingStopWords.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordOption_MissingUsingKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordOption_MissingUsingKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordOption_MissingUsingKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordOption_NoStopWords() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordOption_NoStopWords.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordOption_NoStopWords.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordOption_NoStopWords_MissingWordsKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordOption_NoStopWords_MissingWordsKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordOption_NoStopWords_MissingWordsKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordOption_NoStopWords_MissingUsingKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordOption_NoStopWords_MissingUsingKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordOption_NoStopWords_MissingUsingKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTStopWords (FTStopWordOption)

    fun testFTStopWords_Location() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWords_Location.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWords_Location.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWords_Location_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWords_Location_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWords_Location_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWords_Location_MissingUriLiteral() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWords_Location_MissingUriLiteral.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWords_Location_MissingUriLiteral.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWords_List_MissingStopWord() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWords_List_MissingStopWord.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWords_List_MissingStopWord.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWords_List_Single() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWords_List_Single.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWords_List_Single.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWords_List_Single_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWords_List_Single_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWords_List_Single_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWords_List_TwoWords() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWords_List_TwoWords.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWords_List_TwoWords.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWords_List_TwoWords_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWords_List_TwoWords_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWords_List_TwoWords_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWords_List_TwoWords_MissingStopWord() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWords_List_TwoWords_MissingStopWord.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWords_List_TwoWords_MissingStopWord.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWords_List_Multiple() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWords_List_Multiple.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWords_List_Multiple.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWords_List_Multiple_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWords_List_Multiple_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWords_List_Multiple_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTStopWordsInclExcl (FTStopWordOption)

    fun testFTStopWordsInclExcl_Include() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordsInclExcl_Include.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordsInclExcl_Include.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordsInclExcl_Include_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordsInclExcl_Include_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordsInclExcl_Include_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordsInclExcl_Exclude() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordsInclExcl_Exclude.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordsInclExcl_Exclude.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordsInclExcl_Exclude_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordsInclExcl_Exclude_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordsInclExcl_Exclude_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTStopWordsInclExcl_MissingStopWords() {
        val expected = loadResource("tests/parser/full-text-1.0/FTStopWordsInclExcl_MissingStopWords.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTStopWordsInclExcl_MissingStopWords.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTLanguageOption

    fun testFTLanguageOption() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLanguageOption.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLanguageOption.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTLanguageOption_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLanguageOption_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLanguageOption_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTLanguageOption_MissingStringLiteral() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLanguageOption_MissingStringLiteral.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLanguageOption_MissingStringLiteral.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTLanguageOption_MissingUsingKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTLanguageOption_MissingUsingKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTLanguageOption_MissingUsingKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTWildCardOption

    fun testFTWildCardOption() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWildCardOption.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWildCardOption.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTWildCardOption_MissingUsingKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWildCardOption_MissingUsingKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWildCardOption_MissingUsingKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTWildCardOption_NoWildCards() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWildCardOption_NoWildCards.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWildCardOption_NoWildCards.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTWildCardOption_NoWildCards_MissingUsingKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTWildCardOption_NoWildCards_MissingUsingKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTWildCardOption_NoWildCards_MissingUsingKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTExtensionOption

    fun testFTExtensionOption() {
        val expected = loadResource("tests/parser/full-text-1.0/FTExtensionOption.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTExtensionOption.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTExtensionOption_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTExtensionOption_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTExtensionOption_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTExtensionOption_MissingOptionName() {
        val expected = loadResource("tests/parser/full-text-1.0/FTExtensionOption_MissingOptionName.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTExtensionOption_MissingOptionName.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTExtensionOption_MissingOptionValue() {
        val expected = loadResource("tests/parser/full-text-1.0/FTExtensionOption_MissingOptionValue.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTExtensionOption_MissingOptionValue.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTExtensionOption_MissingUsingKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTExtensionOption_MissingUsingKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTExtensionOption_MissingUsingKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
    // region Full Text 1.0 :: FTIgnoreOption

    fun testFTIgnoreOption() {
        val expected = loadResource("tests/parser/full-text-1.0/FTIgnoreOption.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTIgnoreOption.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTIgnoreOption_CompactWhitespace() {
        val expected = loadResource("tests/parser/full-text-1.0/FTIgnoreOption_CompactWhitespace.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTIgnoreOption_CompactWhitespace.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTIgnoreOption_MissingContentKeyword() {
        val expected = loadResource("tests/parser/full-text-1.0/FTIgnoreOption_MissingContentKeyword.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTIgnoreOption_MissingContentKeyword.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    fun testFTIgnoreOption_MissingUnionExpr() {
        val expected = loadResource("tests/parser/full-text-1.0/FTIgnoreOption_MissingUnionExpr.txt")
        val actual = parseResource("tests/parser/full-text-1.0/FTIgnoreOption_MissingUnionExpr.xq")
        assertThat(prettyPrintASTNode(actual), `is`(expected))
    }

    // endregion
}
