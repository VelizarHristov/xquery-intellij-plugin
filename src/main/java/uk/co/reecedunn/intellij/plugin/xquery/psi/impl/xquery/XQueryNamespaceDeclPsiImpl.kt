/*
 * Copyright (C) 2016-2018 Reece H. Dunn
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
import uk.co.reecedunn.intellij.plugin.core.sequences.children
import uk.co.reecedunn.intellij.plugin.xdm.model.XdmStaticValue
import uk.co.reecedunn.intellij.plugin.xpath.ast.xpath.XPathNCName
import uk.co.reecedunn.intellij.plugin.xpath.model.XPathNamespaceDeclaration
import uk.co.reecedunn.intellij.plugin.xpath.model.XPathNamespaceType
import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.XQueryNamespaceDecl
import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.XQueryUriLiteral

class XQueryNamespaceDeclPsiImpl(node: ASTNode):
        ASTWrapperPsiElement(node),
        XQueryNamespaceDecl,
        XPathNamespaceDeclaration {
    // region XPathNamespaceDeclaration

    override val namespaceType get(): XPathNamespaceType {
        return if (namespacePrefix == null)
            XPathNamespaceType.Unknown
        else
            XPathNamespaceType.StaticallyKnown
    }

    override val namespacePrefix get(): XdmStaticValue? =
        children().filterIsInstance<XPathNCName>().firstOrNull()?.localName as? XdmStaticValue

    override val namespaceUri get(): XdmStaticValue? =
        children().filterIsInstance<XQueryUriLiteral>().firstOrNull() as? XdmStaticValue

    // endregion
}
