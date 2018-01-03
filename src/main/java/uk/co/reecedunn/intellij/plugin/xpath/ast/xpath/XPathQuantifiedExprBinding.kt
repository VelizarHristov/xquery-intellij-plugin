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
package uk.co.reecedunn.intellij.plugin.xpath.ast.xpath

/**
 * A `QuantifiedExprBinding` node in the XQuery AST.
 *
 * This is not part of the XPath/XQuery grammar. It is defined as:
 *
 *     QuantifiedExpr        := ("some" | "every") QuantifiedExprBinding ("," QuantifiedExprBinding)* "satisfies" ExprSingle
 *     QuantifiedExprBinding := "$" VarName TypeDeclaration? "in" ExprSingle
 *
 * This is to mirror the change made to the `for` and `let` statements with
 * `ForBinding` and `LetBinding` respectively.
 */
interface XPathQuantifiedExprBinding : XPathExprSingle