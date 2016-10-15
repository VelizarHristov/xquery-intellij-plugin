package uk.co.reecedunn.intellij.plugin.xquery.resolve.reference;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.*;
import uk.co.reecedunn.intellij.plugin.xquery.psi.PsiNavigation;
import uk.co.reecedunn.intellij.plugin.xquery.psi.XQueryModuleProvider;
import uk.co.reecedunn.intellij.plugin.xquery.psi.XQueryNamespace;

import java.util.List;

public class XQueryFunctionNameReference extends PsiReferenceBase<XQueryEQName> {
    public XQueryFunctionNameReference(XQueryEQName element, TextRange range) {
        super(element, range);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        XQueryNamespace ns = getElement().resolvePrefixNamespace();
        if (ns == null) {
            return null;
        }

        if (ns.getDeclaration() instanceof XQueryModuleProvider) {
            XQueryModuleProvider provider = (XQueryModuleProvider)ns.getDeclaration();
            PsiElement prolog = provider.getReferencedProlog();
            if (prolog == null) {
                return null;
            }

            CharSequence localName = getElement().getLocalName().getText();
            PsiElement annotation = prolog.getFirstChild();
            while (annotation != null) {
                if (annotation instanceof XQueryAnnotatedDecl) {
                    XQueryFunctionDecl functionDecl = PsiNavigation.findChildByClass(annotation, XQueryFunctionDecl.class);
                    if (functionDecl != null) {
                        XQueryEQName functionName = PsiNavigation.findChildByClass(functionDecl, XQueryEQName.class);
                        if (functionName != null && functionName.getLocalName().getText().equals(localName)) {
                            // TODO: Check function arity.
                            return functionName;
                        }
                    }
                }

                annotation = annotation.getNextSibling();
            }
        }
        return null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0];
    }
}
