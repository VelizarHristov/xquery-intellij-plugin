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
package uk.co.reecedunn.intellij.plugin.xquery.psi.impl.marklogic;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import uk.co.reecedunn.intellij.plugin.xquery.ast.marklogic.MarkLogicBinaryKindTest;
import uk.co.reecedunn.intellij.plugin.xquery.lang.XQueryConformance;
import uk.co.reecedunn.intellij.plugin.xquery.lang.XQueryVersion;
import uk.co.reecedunn.intellij.plugin.xquery.lexer.XQueryTokenType;
import uk.co.reecedunn.intellij.plugin.xquery.psi.XQueryVersionedConstruct;

public class MarkLogicBinaryKindTestPsiImpl extends ASTWrapperPsiElement implements MarkLogicBinaryKindTest, XQueryVersionedConstruct {
    public MarkLogicBinaryKindTestPsiImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public XQueryVersion getConformanceVersion(XQueryConformance type) {
        if (type == XQueryConformance.MARKLOGIC) {
            return XQueryVersion.VERSION_6_0;
        }
        return null;
    }

    @Override
    public PsiElement getConformanceElement(XQueryConformance type) {
        if (type == XQueryConformance.MARKLOGIC) {
            final ASTNode node = getNode().findChildByType(XQueryTokenType.K_BINARY);
            return node == null ? null : node.getPsi();
        }
        return null;
    }
}