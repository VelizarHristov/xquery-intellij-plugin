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
package uk.co.reecedunn.intellij.plugin.xquery.tests.parser;

import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.XQueryFile;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BaseXParserTest extends ParserTestCase {
    // region BaseX 7.8 :: UpdateExpr

    public void testUpdateExpr() {
        final String expected = loadResource("tests/parser/basex-7.8/UpdateExpr.txt");
        final XQueryFile actual = parseResource("tests/parser/basex-7.8/UpdateExpr.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testUpdateExpr_MissingExpr() {
        final String expected = loadResource("tests/parser/basex-7.8/UpdateExpr_MissingExpr.txt");
        final XQueryFile actual = parseResource("tests/parser/basex-7.8/UpdateExpr_MissingExpr.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testUpdateExpr_Multiple() {
        final String expected = loadResource("tests/parser/basex-7.8/UpdateExpr_Multiple.txt");
        final XQueryFile actual = parseResource("tests/parser/basex-7.8/UpdateExpr_Multiple.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
    // region BaseX 8.5 :: UpdateExpr

    public void testUpdateExpr_Block() {
        final String expected = loadResource("tests/parser/basex-8.5/UpdateExpr.txt");
        final XQueryFile actual = parseResource("tests/parser/basex-8.5/UpdateExpr.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testUpdateExpr_Block_MissingExpr() {
        final String expected = loadResource("tests/parser/basex-8.5/UpdateExpr_MissingExpr.txt");
        final XQueryFile actual = parseResource("tests/parser/basex-8.5/UpdateExpr_MissingExpr.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testUpdateExpr_Block_MissingClosingBrace() {
        final String expected = loadResource("tests/parser/basex-8.5/UpdateExpr_MissingClosingBrace.txt");
        final XQueryFile actual = parseResource("tests/parser/basex-8.5/UpdateExpr_MissingClosingBrace.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    public void testUpdateExpr_Block_Multiple() {
        final String expected = loadResource("tests/parser/basex-8.5/UpdateExpr_Multiple.txt");
        final XQueryFile actual = parseResource("tests/parser/basex-8.5/UpdateExpr_Multiple.xq");
        assertThat(prettyPrintASTNode(actual), is(expected));
    }

    // endregion
}