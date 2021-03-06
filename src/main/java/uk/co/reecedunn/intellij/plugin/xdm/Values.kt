/*
 * Copyright (C) 2017-2018 Reece H. Dunn
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
package uk.co.reecedunn.intellij.plugin.xdm

import uk.co.reecedunn.intellij.plugin.core.data.Cacheable
import uk.co.reecedunn.intellij.plugin.core.data.CacheableProperty
import uk.co.reecedunn.intellij.plugin.core.data.CachingBehaviour
import uk.co.reecedunn.intellij.plugin.core.data.`is`
import uk.co.reecedunn.intellij.plugin.xdm.datatype.QName
import uk.co.reecedunn.intellij.plugin.xdm.model.XdmSequenceType
import uk.co.reecedunn.intellij.plugin.xdm.model.XdmStaticValue
import uk.co.reecedunn.intellij.plugin.xdm.model.XdmTypeCastResult
import java.lang.ref.WeakReference

private class XdmLiteralValue(override val staticValue: Any?,
                              private val cachedStaticType: CacheableProperty<XdmSequenceType>) : XdmStaticValue {

    // NOTE: The staticType may not be initialized yet (i.e. for QNames), so use
    // CacheableProperty to lazy-load the parameter.
    override val staticType get(): XdmSequenceType = cachedStaticType.get()!!

    override val cacheable: CachingBehaviour = CachingBehaviour.Cache
}

fun createString(value: String): XdmStaticValue {
    return XdmLiteralValue(value, CacheableProperty { XsString `is` Cacheable })
}

fun createQName(namespace: String, localName: String): QName {
    return createQName(namespace, null, localName)
}

fun createQName(namespace: String, prefix: String?, localName: String): QName {
    return QName(
            prefix?.let { XdmLiteralValue(prefix, CacheableProperty { XsNCName `is` Cacheable }) },
            XdmLiteralValue(namespace, CacheableProperty { XsAnyURI `is` Cacheable }),
            XdmLiteralValue(localName, CacheableProperty { XsNCName `is` Cacheable }),
            null,
            false)
}

fun createQName(namespace: XdmStaticValue, localName: XdmStaticValue, declaration: XdmStaticValue): QName {
    return QName(null, namespace, localName, WeakReference(declaration), false)
}

fun createLexicalQName(prefix: String?, localName: String): QName {
    return QName(
            prefix?.let { XdmLiteralValue(prefix, CacheableProperty { XsNCName `is` Cacheable }) },
            null,
            XdmLiteralValue(localName, CacheableProperty { XsNCName `is` Cacheable }),
            null,
            true)
}

fun createLexicalQName(prefix: XdmStaticValue?, localName: XdmStaticValue, declaration: XdmStaticValue): QName {
    return QName(prefix, null, localName, WeakReference(declaration), true)
}

fun XdmSequenceType.cast(expr: XdmStaticValue): XdmTypeCastResult {
    return cast(expr.staticValue, expr.staticType)
}
