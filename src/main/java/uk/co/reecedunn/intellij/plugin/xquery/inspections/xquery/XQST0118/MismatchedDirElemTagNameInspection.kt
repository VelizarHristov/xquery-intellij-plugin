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
package uk.co.reecedunn.intellij.plugin.xquery.inspections.xquery.XQST0118

import com.intellij.codeInspection.*
import com.intellij.psi.PsiFile
import com.intellij.util.SmartList
import uk.co.reecedunn.intellij.plugin.core.extensions.*
import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.*
import uk.co.reecedunn.intellij.plugin.xquery.psi.XQueryNamespace
import uk.co.reecedunn.intellij.plugin.xquery.psi.XQueryPrologResolver
import uk.co.reecedunn.intellij.plugin.xquery.resources.XQueryBundle

/** XQST0118 error condition
 *
 * It is a *static error* if a direct element constructor has a close tag that
 * does not match the open tag (prefix and local name).
 */
class MismatchedDirElemTagNameInspection : LocalInspectionTool() {
    override fun getDisplayName(): String =
        XQueryBundle.message("inspection.XQST0118.mismatched-dir-elem-tag-name.display-name")

    override fun getDescriptionFileName(): String? =
        id + ".html"

    override fun checkFile(file: PsiFile, manager: InspectionManager, isOnTheFly: Boolean): Array<ProblemDescriptor>? {
        if (file !is XQueryFile) return null

        val descriptors = SmartList<ProblemDescriptor>()
        file.walkTree().filterIsInstance<XQueryDirElemConstructor>().forEach { elem ->
            val closeTag = elem.closeTag ?: return@forEach
            val openTag = elem.openTag!!

            val closeLocalName = closeTag.localName
            val openLocalName = openTag.localName
            if ((openTag.prefix?.text != closeTag.prefix?.text || openLocalName?.text != closeLocalName?.text) &&
                 closeLocalName != null && openLocalName != null) {
                val closeTagName = closeTag.prefix?.let { "${it.text}:${closeLocalName.text}" } ?: closeLocalName.text
                val openTagName = openTag.prefix?.let { "${it.text}:${openTag.localName?.text}" } ?: openTag.localName?.text

                val description = XQueryBundle.message("inspection.XQST0118.mismatched-dir-elem-tag-name.message", closeTagName, openTagName)
                descriptors.add(manager.createProblemDescriptor(closeTag, description, null as LocalQuickFix?, ProblemHighlightType.GENERIC_ERROR, isOnTheFly))
            }
        }
        return descriptors.toTypedArray()
    }
}