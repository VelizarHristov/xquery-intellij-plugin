/*
 * Copyright (C) 2016 Reece H. Dunn
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
package uk.co.reecedunn.intellij.plugin.xquery.psi.impl.xquery;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.XQuerySequenceTypeUnion;
import uk.co.reecedunn.intellij.plugin.xquery.lang.ImplementationItem;
import uk.co.reecedunn.intellij.plugin.xquery.lang.XQueryConformance;
import uk.co.reecedunn.intellij.plugin.xquery.lang.XQueryVersion;
import uk.co.reecedunn.intellij.plugin.xquery.lexer.XQueryTokenType;
import uk.co.reecedunn.intellij.plugin.xquery.psi.XQueryConformanceCheck;
import uk.co.reecedunn.intellij.plugin.xquery.resources.XQueryBundle;

public class XQuerySequenceTypeUnionPsiImpl extends ASTWrapperPsiElement implements XQuerySequenceTypeUnion, XQueryConformanceCheck {
    public XQuerySequenceTypeUnionPsiImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public boolean conformsTo(ImplementationItem implementation) {
        if (getConformanceElement() == getFirstChild()) {
            return true;
        }

        final XQueryVersion minimalConformance = implementation.getVersion(XQueryConformance.MINIMAL_CONFORMANCE);
        final XQueryVersion marklogic = implementation.getVersion(XQueryConformance.MARKLOGIC);
        return (minimalConformance != null && minimalConformance.supportsVersion(XQueryVersion.VERSION_3_0))
            || (marklogic != null && marklogic.supportsVersion(XQueryVersion.VERSION_6_0));
    }

    @Override
    public PsiElement getConformanceElement() {
        PsiElement element = findChildByType(XQueryTokenType.UNION);
        return element == null ? getFirstChild() : element;
    }

    @Override
    public String getConformanceErrorMessage() {
        return XQueryBundle.message("requires.feature.marklogic-xquery.version");
    }
}