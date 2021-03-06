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
package uk.co.reecedunn.intellij.plugin.xquery.psi.impl.basex

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import uk.co.reecedunn.intellij.plugin.xquery.ast.basex.BaseXUpdateExpr
import uk.co.reecedunn.intellij.plugin.xquery.lang.BaseX
import uk.co.reecedunn.intellij.plugin.xquery.lang.Version
import uk.co.reecedunn.intellij.plugin.xquery.lexer.XQueryTokenType
import uk.co.reecedunn.intellij.plugin.xquery.psi.XQueryConformance

private val BASEX78: List<Version> = listOf(BaseX.VERSION_7_8)
private val BASEX85: List<Version> = listOf(BaseX.VERSION_8_5)

class BaseXUpdateExprPsiImpl(node: ASTNode) : ASTWrapperPsiElement(node), BaseXUpdateExpr, XQueryConformance {
    override val requiresConformance get(): List<Version> {
        if (findChildByType<PsiElement>(XQueryTokenType.BLOCK_OPEN) != null) {
            return BASEX85
        }
        return BASEX78
    }

    override val conformanceElement get(): PsiElement {
        val element = findChildByType<PsiElement>(XQueryTokenType.BLOCK_OPEN)
        return element ?: findChildByType(XQueryTokenType.K_UPDATE) ?: firstChild
    }
}
