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
package uk.co.reecedunn.intellij.plugin.xquery.psi.impl.xquery

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import uk.co.reecedunn.intellij.plugin.core.extensions.children
import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.XQueryDFPropertyName
import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.XQueryDecimalFormatDecl
import uk.co.reecedunn.intellij.plugin.xquery.lang.ImplementationItem
import uk.co.reecedunn.intellij.plugin.xquery.lang.XQueryConformance
import uk.co.reecedunn.intellij.plugin.xquery.lang.XQueryVersion
import uk.co.reecedunn.intellij.plugin.xquery.lexer.XQueryTokenType
import uk.co.reecedunn.intellij.plugin.xquery.psi.XQueryConformanceCheck
import uk.co.reecedunn.intellij.plugin.xquery.resources.XQueryBundle

class XQueryDecimalFormatDeclPsiImpl(node: ASTNode) : ASTWrapperPsiElement(node), XQueryDecimalFormatDecl, XQueryConformanceCheck {
    private val requiredVersion get(): XQueryVersion =
        if (conformanceElement is XQueryDFPropertyName) XQueryVersion.VERSION_3_1 else XQueryVersion.VERSION_3_0

    override fun conformsTo(implementation: ImplementationItem): Boolean =
        implementation.getVersion(XQueryConformance.MINIMAL_CONFORMANCE).supportsVersion(requiredVersion)

    override fun getConformanceElement(): PsiElement? {
        val element = children().filterIsInstance<XQueryDFPropertyName>().filter { e ->
            e.firstChild.node.elementType === XQueryTokenType.K_EXPONENT_SEPARATOR
        }.firstOrNull()
        return if (element != null) element else findChildByType<PsiElement>(XQueryTokenType.K_DECIMAL_FORMAT)
    }

    override fun getConformanceErrorMessage(): String =
        XQueryBundle.message("requires.feature.minimal-conformance.version", requiredVersion)
}