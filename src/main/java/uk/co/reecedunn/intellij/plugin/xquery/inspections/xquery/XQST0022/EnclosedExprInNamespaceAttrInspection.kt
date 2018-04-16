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
@file:Suppress("PackageName")

package uk.co.reecedunn.intellij.plugin.xquery.inspections.xquery.XQST0022

import com.intellij.codeInspection.*
import com.intellij.psi.PsiFile
import com.intellij.util.SmartList
import uk.co.reecedunn.intellij.plugin.core.sequences.children
import uk.co.reecedunn.intellij.plugin.core.sequences.walkTree
import uk.co.reecedunn.intellij.plugin.xpath.ast.xpath.XPathEnclosedExpr
import uk.co.reecedunn.intellij.plugin.xpath.model.XPathNamespaceDeclaration
import uk.co.reecedunn.intellij.plugin.xpath.model.XPathNamespaceType
import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.XQueryDirAttribute
import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.XQueryModule
import uk.co.reecedunn.intellij.plugin.xquery.resources.XQueryBundle

/** XQST0022 error condition
 *
 * It is a *static error* if an EnclosedExpr is contained within a namespace attribute.
 */
class EnclosedExprInNamespaceAttrInspection : LocalInspectionTool() {
    override fun getDisplayName(): String =
        XQueryBundle.message("inspection.XQST0022.enclosed-expr-in-namespace-attr.display-name")

    override fun getDescriptionFileName(): String? =
            "$id.html"

    override fun checkFile(file: PsiFile, manager: InspectionManager, isOnTheFly: Boolean): Array<ProblemDescriptor>? {
        if (file !is XQueryModule) return null

        val descriptors = SmartList<ProblemDescriptor>()
        file.walkTree().filterIsInstance<XQueryDirAttribute>().forEach { attr ->
            val ns = attr as XPathNamespaceDeclaration
            if (ns.namespaceType != XPathNamespaceType.Unknown) {
                attr.walkTree().find { e -> e is XPathEnclosedExpr }?.let { expr ->
                    val description = XQueryBundle.message("inspection.XQST0022.enclosed-expr-in-namespace-attr.message")
                    descriptors.add(manager.createProblemDescriptor(expr, description, null as LocalQuickFix?, ProblemHighlightType.GENERIC_ERROR, isOnTheFly))
                }
            }
        }
        return descriptors.toTypedArray()
    }
}
