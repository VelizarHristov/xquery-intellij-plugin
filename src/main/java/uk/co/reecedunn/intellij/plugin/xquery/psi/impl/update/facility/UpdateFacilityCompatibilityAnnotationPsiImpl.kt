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
package uk.co.reecedunn.intellij.plugin.xquery.psi.impl.update.facility

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import uk.co.reecedunn.intellij.plugin.xquery.ast.update.facility.UpdateFacilityCompatibilityAnnotation
import uk.co.reecedunn.intellij.plugin.xquery.lang.ImplementationItem
import uk.co.reecedunn.intellij.plugin.xquery.lang.UpdateFacility
import uk.co.reecedunn.intellij.plugin.xquery.lang.XQueryVersion
import uk.co.reecedunn.intellij.plugin.xquery.parser.XQueryElementType
import uk.co.reecedunn.intellij.plugin.xquery.psi.XQueryConformanceCheck
import uk.co.reecedunn.intellij.plugin.xquery.resources.XQueryBundle

class UpdateFacilityCompatibilityAnnotationPsiImpl(node: ASTNode) : ASTWrapperPsiElement(node), UpdateFacilityCompatibilityAnnotation, XQueryConformanceCheck {
    override fun conformsTo(implementation: ImplementationItem): Boolean {
        val version = implementation.getVersion(UpdateFacility)
        val varDecl = parent.node.findChildByType(XQueryElementType.VAR_DECL)
        return version.supportsVersion(if (varDecl == null) XQueryVersion.VERSION_1_0 else XQueryVersion.VERSION_3_0)
    }

    override val conformanceElement get(): PsiElement =
        firstChild

    override val conformanceErrorMessage get(): String {
        val varDecl = parent.node.findChildByType(XQueryElementType.VAR_DECL)
        val version = if (varDecl == null) XQueryVersion.VERSION_1_0 else XQueryVersion.VERSION_3_0
        return XQueryBundle.message("requires.feature.update-facility.version", version)
    }
}