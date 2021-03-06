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
package uk.co.reecedunn.intellij.plugin.xquery.ast.xquery

import com.intellij.psi.PsiElement

enum class XQueryEntityRefType {
    XML,
    HTML4,
    HTML5,
    Unknown
}

data class XQueryEntityRef(val name: CharSequence, val value: CharSequence, val type: XQueryEntityRefType)

/**
 * An XQuery 1.0 `PredefinedEntityRef` node in the XQuery AST.
 */
interface XQueryPredefinedEntityRef : PsiElement {
    val entityRef: XQueryEntityRef
}
