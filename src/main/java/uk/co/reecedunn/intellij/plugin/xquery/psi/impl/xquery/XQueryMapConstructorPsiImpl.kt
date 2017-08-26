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
import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.XQueryMapConstructor
import uk.co.reecedunn.intellij.plugin.xquery.lang.*
import uk.co.reecedunn.intellij.plugin.xquery.lexer.XQueryTokenType
import uk.co.reecedunn.intellij.plugin.xquery.psi.XQueryConformanceCheck
import uk.co.reecedunn.intellij.plugin.xquery.resources.XQueryBundle

class XQueryMapConstructorPsiImpl(node: ASTNode) : ASTWrapperPsiElement(node), XQueryMapConstructor, XQueryConformanceCheck {
    override fun conformsTo(implementation: ImplementationItem): Boolean {
        if (conformanceElement.node.elementType === XQueryTokenType.K_OBJECT_NODE) {
            return implementation.getVersion(MarkLogic).supportsVersion(XQueryVersion.VERSION_8_0)
        }
        return implementation.getVersion(XQuery).supportsVersion(XQueryVersion.VERSION_3_1) ||
               implementation.getVersion(Saxon).supportsVersion(XQueryVersion.VERSION_9_4)
    }

    override val conformanceElement get(): PsiElement =
        firstChild

    override val conformanceErrorMessage get(): String {
        if (conformanceElement.node.elementType === XQueryTokenType.K_OBJECT_NODE) {
            return XQueryBundle.message("requires.feature.marklogic.version", XQueryVersion.VERSION_8_0)
        }
        return XQueryBundle.message("requires.feature.saxon-xquery.version")
    }
}