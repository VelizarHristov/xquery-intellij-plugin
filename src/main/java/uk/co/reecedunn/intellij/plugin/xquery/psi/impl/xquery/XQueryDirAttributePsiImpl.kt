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
import uk.co.reecedunn.intellij.plugin.core.data.Cacheable
import uk.co.reecedunn.intellij.plugin.core.data.CacheableProperty
import uk.co.reecedunn.intellij.plugin.core.data.CachingBehaviour
import uk.co.reecedunn.intellij.plugin.core.data.`is`
import uk.co.reecedunn.intellij.plugin.core.sequences.children
import uk.co.reecedunn.intellij.plugin.xdm.datatype.QName
import uk.co.reecedunn.intellij.plugin.xdm.model.XdmStaticValue
import uk.co.reecedunn.intellij.plugin.xpath.ast.xpath.XPathEQName
import uk.co.reecedunn.intellij.plugin.xpath.model.XPathNamespaceDeclaration
import uk.co.reecedunn.intellij.plugin.xpath.model.XPathNamespaceType
import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.XQueryDirAttribute
import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.XQueryDirAttributeValue

class XQueryDirAttributePsiImpl(node: ASTNode):
        ASTWrapperPsiElement(node),
        XQueryDirAttribute,
        XPathNamespaceDeclaration {

    override val namespaceType get(): XPathNamespaceType {
        return if (namespacePrefix == null)
            XPathNamespaceType.Unknown
        else
            XPathNamespaceType.StaticallyKnown
    }

    override fun subtreeChanged() {
        super.subtreeChanged()
        cachedNamespacePrefix.invalidate()
        cachedNamespaceUri.invalidate()
    }

    // region XQueryNamespaceDeclaration

    override val namespacePrefix get(): XdmStaticValue? = cachedNamespacePrefix.get()
    private val cachedNamespacePrefix = CacheableProperty {
        children().filterIsInstance<XPathEQName>().map { eqname ->
            val qname = (eqname as XdmStaticValue).staticValue as? QName
            qname?.let {
                if (it.prefix?.staticValue == "xmlns")
                    it.localName
                else
                    null
            }
        }.firstOrNull() `is` Cacheable
    }

    override val namespaceUri get(): XdmStaticValue? = cachedNamespaceUri.get()
    private val cachedNamespaceUri = CacheableProperty {
        children().filterIsInstance<XQueryDirAttributeValue>().map { value ->
            value as XdmStaticValue
        }.firstOrNull() `is` Cacheable
    }

    // endregion
}
