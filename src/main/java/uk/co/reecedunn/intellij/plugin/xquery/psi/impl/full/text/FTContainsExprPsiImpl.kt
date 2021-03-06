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
package uk.co.reecedunn.intellij.plugin.xquery.psi.impl.full.text

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import uk.co.reecedunn.intellij.plugin.xquery.ast.full.text.FTContainsExpr
import uk.co.reecedunn.intellij.plugin.xquery.lang.FullText
import uk.co.reecedunn.intellij.plugin.xquery.lang.Version
import uk.co.reecedunn.intellij.plugin.xquery.lexer.XQueryTokenType
import uk.co.reecedunn.intellij.plugin.xquery.psi.XQueryConformance

private val FULL_TEXT: List<Version> = listOf(FullText.REC_1_0_20110317)
private val XQUERY: List<Version> = listOf()

class FTContainsExprPsiImpl(node: ASTNode) : ASTWrapperPsiElement(node), FTContainsExpr, XQueryConformance {
    override val requiresConformance get(): List<Version> {
        return if (conformanceElement.node.elementType == XQueryTokenType.K_CONTAINS)
            FULL_TEXT
        else
            XQUERY
    }

    override val conformanceElement get(): PsiElement =
        findChildByType(XQueryTokenType.K_CONTAINS) ?: firstChild
}