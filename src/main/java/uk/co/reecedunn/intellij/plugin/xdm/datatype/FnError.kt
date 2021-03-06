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
package uk.co.reecedunn.intellij.plugin.xdm.datatype

import uk.co.reecedunn.intellij.plugin.xdm.err
import uk.co.reecedunn.intellij.plugin.xdm.model.XdmStaticValue

val FOCA0002 = err("FOCA0002") // Cannot cast to 'type'. (Invalid lexical value.)
val FOER0000 = err("FOER0000") // Unspecified error.
val FORG0001 = err("FORG0001") // Cannot cast to 'type'. (Generic cast error.)
val XPTY0004 = err("XPTY0004") // Cannot use 'type' here.

data class FnErrorObject(val code: QName,
                         val description: XdmStaticValue?,
                         val errorObject: List<XdmStaticValue>) {

    @Suppress("unused")
    constructor(): this(FOER0000, null, listOf())

    @Suppress("unused")
    constructor(code: QName): this(code, null, listOf())

    constructor(code: QName, description: XdmStaticValue): this(code, description, listOf())
}
