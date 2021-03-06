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
package uk.co.reecedunn.intellij.plugin.xquery.tests.reference

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiReference
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import uk.co.reecedunn.intellij.plugin.core.sequences.children
import uk.co.reecedunn.intellij.plugin.core.sequences.descendants
import uk.co.reecedunn.intellij.plugin.core.sequences.walkTree
import uk.co.reecedunn.intellij.plugin.xpath.ast.xpath.*
import uk.co.reecedunn.intellij.plugin.xquery.ast.xquery.*
import uk.co.reecedunn.intellij.plugin.xquery.psi.impl.XmlNCNameImpl
import uk.co.reecedunn.intellij.plugin.xquery.tests.parser.ParserTestCase

class XQueryReferenceTest : ParserTestCase() {
    // region PsiNameIdentifierOwner

    fun testPsiNameIdentifierOwner_NCName() {
        val name = parse<XPathNCName>("(: :) test")[0] as PsiNameIdentifierOwner

        assertThat(name.name, `is`("test"))
        assertThat(name.textOffset, `is`(6))

        assertThat(name.nameIdentifier, `is`(instanceOf(XmlNCNameImpl::class.java)))
        assertThat(name.nameIdentifier?.text, `is`("test"))
    }

    fun testPsiNameIdentifierOwner_QName() {
        val name = parse<XPathQName>("(: :) a:test")[0] as PsiNameIdentifierOwner

        assertThat(name.name, `is`("test"))
        assertThat(name.textOffset, `is`(8))

        assertThat(name.nameIdentifier, `is`(instanceOf(XmlNCNameImpl::class.java)))
        assertThat(name.nameIdentifier?.text, `is`("test"))
    }

    fun testPsiNameIdentifierOwner_URIQualifiedName() {
        val name = parse<XPathURIQualifiedName>("(: :) Q{http://www.example.com}test")[0] as PsiNameIdentifierOwner

        assertThat(name.name, `is`("test"))
        assertThat(name.textOffset, `is`(31))

        assertThat(name.nameIdentifier, `is`(instanceOf(XmlNCNameImpl::class.java)))
        assertThat(name.nameIdentifier?.text, `is`("test"))
    }

    // endregion
    // region Files
    // region URILiteral

    fun testURILiteral_HttpUri() {
        val file = parseResource("tests/resolve/files/ModuleImport_URILiteral_SameDirectory.xq")

        val moduleImportPsi = file.descendants().filterIsInstance<XQueryModuleImport>().first()
        assertThat(moduleImportPsi, `is`(notNullValue()))

        val uriLiterals = moduleImportPsi.children().filterIsInstance<XQueryUriLiteral>().toList()
        assertThat(uriLiterals.count(), `is`(2))

        val httpUriRef = uriLiterals.first().reference
        assertThat(httpUriRef!!.canonicalText, `is`("http://example.com/test"))
        assertThat(httpUriRef.rangeInElement.startOffset, `is`(1))
        assertThat(httpUriRef.rangeInElement.endOffset, `is`(24))
        assertThat(httpUriRef.variants.size, `is`(0))

        val resolved = httpUriRef.resolve()
        assertThat<PsiElement>(resolved, `is`(nullValue()))
    }

    fun testURILiteral_SameDirectory() {
        val file = parseResource("tests/resolve/files/ModuleImport_URILiteral_SameDirectory.xq")

        val moduleImportPsi = file.descendants().filterIsInstance<XQueryModuleImport>().first()
        assertThat(moduleImportPsi, `is`(notNullValue()))

        val uriLiterals = moduleImportPsi.children().filterIsInstance<XQueryUriLiteral>().toList()
        assertThat(uriLiterals.count(), `is`(2))

        val ref = uriLiterals.last().reference
        assertThat(ref!!.canonicalText, `is`("test.xq"))
        assertThat(ref.rangeInElement.startOffset, `is`(1))
        assertThat(ref.rangeInElement.endOffset, `is`(8))
        assertThat(ref.variants.size, `is`(0))

        val resolved = ref.resolve()
        assertThat<PsiElement>(resolved, `is`(notNullValue()))
        assertThat<PsiElement>(resolved, instanceOf<PsiElement>(XQueryModule::class.java))
        assertThat(resolved!!.containingFile.name, `is`("test.xq"))
    }

    fun testURILiteral_ParentDirectory() {
        val file = parseResource("tests/resolve/files/ModuleImport_URILiteral_ParentDirectory.xq")

        val moduleImportPsi = file.descendants().filterIsInstance<XQueryModuleImport>().first()
        assertThat(moduleImportPsi, `is`(notNullValue()))

        val uriLiterals = moduleImportPsi.children().filterIsInstance<XQueryUriLiteral>().toList()
        assertThat(uriLiterals.count(), `is`(2))

        val ref = uriLiterals.last().reference
        assertThat(ref!!.canonicalText, `is`("namespaces/ModuleDecl.xq"))
        assertThat(ref.rangeInElement.startOffset, `is`(1))
        assertThat(ref.rangeInElement.endOffset, `is`(25))
        assertThat(ref.variants.size, `is`(0))

        val resolved = ref.resolve()
        assertThat<PsiElement>(resolved, `is`(notNullValue()))
        assertThat<PsiElement>(resolved, instanceOf<PsiElement>(XQueryModule::class.java))
        assertThat(resolved!!.containingFile.name, `is`("ModuleDecl.xq"))
    }

    fun testURILiteral_BuiltinResource() {
        val file = parseResource("tests/resolve/files/ModuleImport_URILiteral_ResourceFile.xq")

        val moduleImportPsi = file.descendants().filterIsInstance<XQueryModuleImport>().first()
        assertThat(moduleImportPsi, `is`(notNullValue()))

        val uriLiterals = moduleImportPsi.children().filterIsInstance<XQueryUriLiteral>().toList()
        assertThat(uriLiterals.count(), `is`(2))

        val ref = uriLiterals.last().reference
        assertThat(ref!!.canonicalText, `is`("res://www.w3.org/2005/xpath-functions/array.xqy"))
        assertThat(ref.rangeInElement.startOffset, `is`(1))
        assertThat(ref.rangeInElement.endOffset, `is`(48))
        assertThat(ref.variants.size, `is`(0))

        val resolved = ref.resolve()
        assertThat<PsiElement>(resolved, `is`(notNullValue()))
        assertThat<PsiElement>(resolved, instanceOf<PsiElement>(XQueryModule::class.java))
        assertThat(resolved!!.containingFile.name, `is`("array.xqy"))
    }

    fun testURILiteral_BuiltinResource_NotFound() {
        val file = parseResource("tests/resolve/files/ModuleImport_URILiteral_ResourceFileNotFound.xq")

        val moduleImportPsi = file.descendants().filterIsInstance<XQueryModuleImport>().first()
        assertThat(moduleImportPsi, `is`(notNullValue()))

        val uriLiterals = moduleImportPsi.children().filterIsInstance<XQueryUriLiteral>().toList()
        assertThat(uriLiterals.count(), `is`(2))

        val ref = uriLiterals.last().reference
        assertThat(ref!!.canonicalText, `is`("res://this-resource-does-not-exist.xqy"))
        assertThat(ref.rangeInElement.startOffset, `is`(1))
        assertThat(ref.rangeInElement.endOffset, `is`(39))
        assertThat(ref.variants.size, `is`(0))

        val resolved = ref.resolve()
        assertThat<PsiElement>(resolved, `is`(nullValue()))
    }

    fun testURILiteral_Empty() {
        val file = parseResource("tests/resolve/files/ModuleImport_URILiteral_Empty.xq")

        val moduleImportPsi = file.descendants().filterIsInstance<XQueryModuleImport>().first()
        assertThat(moduleImportPsi, `is`(notNullValue()))

        val uriLiterals = moduleImportPsi.children().filterIsInstance<XQueryUriLiteral>().toList()
        assertThat(uriLiterals.count(), `is`(2))

        val ref = uriLiterals.last().reference
        assertThat(ref!!.canonicalText, `is`(""))
        assertThat(ref.rangeInElement.startOffset, `is`(1))
        assertThat(ref.rangeInElement.endOffset, `is`(1))
        assertThat(ref.variants.size, `is`(0))

        val resolved = ref.resolve()
        assertThat<PsiElement>(resolved, `is`(nullValue()))
    }

    // endregion
    // endregion
    // region Namespaces
    // region QName

    fun testQName() {
        val file = parseResource("tests/resolve/namespaces/ModuleDecl.xq")

        val modulePsi = file.descendants().filterIsInstance<XQueryLibraryModule>().first()
        val prologPsi = modulePsi.children().filterIsInstance<XQueryProlog>().first()
        val annotatedDeclPsi = prologPsi.descendants().filterIsInstance<XQueryAnnotatedDecl>().first()
        val functionDeclPsi = annotatedDeclPsi.children().filterIsInstance<XQueryFunctionDecl>().first()
        assertThat(functionDeclPsi, `is`(notNullValue()))

        val qname = functionDeclPsi.children().filterIsInstance<XPathQName>().first()
        assertThat(qname, `is`(notNullValue()))

        val ref: PsiReference = qname.reference!!
        assertThat(ref.canonicalText, `is`("test"))
        assertThat(ref.rangeInElement.startOffset, `is`(0))
        assertThat(ref.rangeInElement.endOffset, `is`(4))
        assertThat(ref.variants.size, `is`(0))

        var resolved: PsiElement = ref.resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XmlNCNameImpl::class.java)))
        assertThat(resolved.text, `is`("test"))
        assertThat(resolved.parent.parent, `is`(instanceOf<PsiElement>(XQueryModuleDecl::class.java)))

        val refs = qname.references
        assertThat(refs.size, `is`(1))

        assertThat(refs[0].canonicalText, `is`("test"))
        assertThat(refs[0].rangeInElement.startOffset, `is`(0))
        assertThat(refs[0].rangeInElement.endOffset, `is`(4))
        assertThat(refs[0].variants.size, `is`(0))

        resolved = refs[0].resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XmlNCNameImpl::class.java)))
        assertThat(resolved.text, `is`("test"))
        assertThat(resolved.parent.parent, `is`(instanceOf<PsiElement>(XQueryModuleDecl::class.java)))
    }

    // endregion
    // region EQName

    fun testEQName_NCName() {
        val file = parseResource("tests/resolve/namespaces/FunctionDecl_WithNCNameReturnType.xq")

        val modulePsi = file.descendants().filterIsInstance<XQueryLibraryModule>().first()
        val prologPsi = modulePsi.children().filterIsInstance<XQueryProlog>().first()
        val annotatedDeclPsi = prologPsi.children().filterIsInstance<XQueryAnnotatedDecl>().first()
        val functionDeclPsi = annotatedDeclPsi.children().filterIsInstance<XQueryFunctionDecl>().first()
        val sequenceTypePsi = functionDeclPsi.children().filterIsInstance<XPathSequenceType>().first()
        assertThat(sequenceTypePsi, `is`(notNullValue()))

        val eqname = sequenceTypePsi.descendants().filterIsInstance<XPathEQName>().first()
        assertThat(eqname, `is`(notNullValue()))

        val ref = eqname.reference
        assertThat(ref, `is`(nullValue()))

        val refs = eqname.references
        assertThat(refs.size, `is`(0))
    }

    fun testEQName_QName() {
        val file = parseResource("tests/resolve/namespaces/FunctionDecl_WithQNameReturnType.xq")

        val modulePsi = file.descendants().filterIsInstance<XQueryLibraryModule>().first()
        val prologPsi = modulePsi.children().filterIsInstance<XQueryProlog>().first()
        val annotatedDeclPsi = prologPsi.children().filterIsInstance<XQueryAnnotatedDecl>().first()
        val functionDeclPsi = annotatedDeclPsi.children().filterIsInstance<XQueryFunctionDecl>().first()
        val sequenceTypePsi = functionDeclPsi.children().filterIsInstance<XPathSequenceType>().first()
        assertThat(sequenceTypePsi, `is`(notNullValue()))

        val eqname = sequenceTypePsi.descendants().filterIsInstance<XPathEQName>().first()
        assertThat(eqname, `is`(notNullValue()))

        val ref = eqname.reference!!
        assertThat(ref.canonicalText, `is`("xs"))
        assertThat(ref.rangeInElement.startOffset, `is`(0))
        assertThat(ref.rangeInElement.endOffset, `is`(2))
        assertThat(ref.variants.size, `is`(0))

        var resolved: PsiElement = ref.resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XmlNCNameImpl::class.java)))
        assertThat(resolved.text, `is`("xs"))
        assertThat(resolved.parent.parent, `is`(instanceOf<PsiElement>(XQueryNamespaceDecl::class.java)))

        val refs = eqname.references
        assertThat(refs.size, `is`(1))

        assertThat(refs[0].canonicalText, `is`("xs"))
        assertThat(refs[0].rangeInElement.startOffset, `is`(0))
        assertThat(refs[0].rangeInElement.endOffset, `is`(2))
        assertThat(refs[0].variants.size, `is`(0))

        resolved = refs[0].resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XmlNCNameImpl::class.java)))
        assertThat(resolved.text, `is`("xs"))
        assertThat(resolved.parent.parent, `is`(instanceOf<PsiElement>(XQueryNamespaceDecl::class.java)))
    }

    fun testEQName_URIQualifiedName() {
        val file = parseResource("tests/resolve/namespaces/FunctionDecl_WithURIQualifiedNameReturnType.xq")

        val modulePsi = file.descendants().filterIsInstance<XQueryLibraryModule>().first()
        val prologPsi = modulePsi.children().filterIsInstance<XQueryProlog>().first()
        val annotatedDeclPsi = prologPsi.children().filterIsInstance<XQueryAnnotatedDecl>().first()
        val functionDeclPsi = annotatedDeclPsi.children().filterIsInstance<XQueryFunctionDecl>().first()
        val sequenceTypePsi = functionDeclPsi.children().filterIsInstance<XPathSequenceType>().first()
        assertThat(sequenceTypePsi, `is`(notNullValue()))

        val eqname = sequenceTypePsi.descendants().filterIsInstance<XPathEQName>().first()
        assertThat(eqname, `is`(notNullValue()))

        val ref = eqname.reference
        assertThat(ref, `is`(nullValue()))

        val refs = eqname.references
        assertThat(refs.size, `is`(0))
    }

    // endregion
    // endregion
    // region Variables

    fun testForBinding() {
        val file = parseResource("tests/parser/xquery-1.0/ForClause.xq")

        val forClausePsi = file.descendants().filterIsInstance<XQueryForClause>().first()
        val forBindingPsi = forClausePsi.children().filterIsInstance<XQueryForBinding>().first()
        val varNamePsi = forBindingPsi.children().filterIsInstance<XPathVarName>().first()
        val varQNamePsi = varNamePsi.children().filterIsInstance<XPathEQName>().first()

        val flworExprPsi = file.descendants().filterIsInstance<XQueryFLWORExpr>().first()
        val returnClausePsi = flworExprPsi.children().filterIsInstance<XQueryReturnClause>().first()
        val varRefNamePsi = returnClausePsi.walkTree().filterIsInstance<XPathEQName>().first()

        val ref = varRefNamePsi.reference
        assertThat(ref!!.canonicalText, `is`("x"))
        assertThat(ref.rangeInElement.startOffset, `is`(0))
        assertThat(ref.rangeInElement.endOffset, `is`(1))
        assertThat(ref.variants.size, `is`(0))

        var resolved: PsiElement = ref.resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XPathNCName::class.java)))
        assertThat(resolved, `is`<PsiElement>(varQNamePsi))

        val refs = varRefNamePsi.references
        assertThat(refs.size, `is`(1))

        assertThat(refs[0].canonicalText, `is`("x"))
        assertThat(refs[0].rangeInElement.startOffset, `is`(0))
        assertThat(refs[0].rangeInElement.endOffset, `is`(1))
        assertThat(refs[0].variants.size, `is`(0))

        resolved = refs[0].resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XPathNCName::class.java)))
        assertThat(resolved, `is`<PsiElement>(varQNamePsi))
    }

    fun testIntermediateClause() {
        val file = parseResource("tests/resolve/variables/IntermediateClause_ReturnInnerForVariable.xq")

        val flworExprPsi = file.descendants().filterIsInstance<XQueryFLWORExpr>().first()
        val intermediateClausePsi = flworExprPsi.children().filterIsInstance<XQueryIntermediateClause>().first()
        val forClausePsi = intermediateClausePsi.descendants().filterIsInstance<XQueryForClause>().first()
        val forBindingPsi = forClausePsi.children().filterIsInstance<XQueryForBinding>().first()
        val varNamePsi = forBindingPsi.children().filterIsInstance<XPathVarName>().first()
        val varQNamePsi = varNamePsi.children().filterIsInstance<XPathEQName>().first()

        val returnClausePsi = flworExprPsi.children().filterIsInstance<XQueryReturnClause>().first()
        val varRefNamePsi = returnClausePsi.walkTree().filterIsInstance<XPathEQName>().first()

        val ref = varRefNamePsi.reference!!
        assertThat(ref.canonicalText, `is`("z"))
        assertThat(ref.rangeInElement.startOffset, `is`(0))
        assertThat(ref.rangeInElement.endOffset, `is`(1))
        assertThat(ref.variants.size, `is`(0))

        var resolved: PsiElement = ref.resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XPathNCName::class.java)))
        assertThat(resolved, `is`<PsiElement>(varQNamePsi))

        val refs = varRefNamePsi.references
        assertThat(refs.size, `is`(1))

        assertThat(refs[0].canonicalText, `is`("z"))
        assertThat(refs[0].rangeInElement.startOffset, `is`(0))
        assertThat(refs[0].rangeInElement.endOffset, `is`(1))
        assertThat(refs[0].variants.size, `is`(0))

        resolved = refs[0].resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XPathNCName::class.java)))
        assertThat(resolved, `is`<PsiElement>(varQNamePsi))
    }

    fun testLetBinding() {
        val file = parseResource("tests/parser/xquery-1.0/LetClause.xq")

        val letClausePsi = file.descendants().filterIsInstance<XQueryLetClause>().first()
        val letBindingPsi = letClausePsi.children().filterIsInstance<XQueryLetBinding>().first()
        val varNamePsi = letBindingPsi.children().filterIsInstance<XPathVarName>().first()
        val varQNamePsi = varNamePsi.children().filterIsInstance<XPathEQName>().first()

        val flworExprPsi = file.descendants().filterIsInstance<XQueryFLWORExpr>().first()
        val returnClausePsi = flworExprPsi.children().filterIsInstance<XQueryReturnClause>().first()
        val varRefNamePsi = returnClausePsi.walkTree().filterIsInstance<XPathEQName>().first()

        val ref = varRefNamePsi.reference!!
        assertThat(ref.canonicalText, `is`("x"))
        assertThat(ref.rangeInElement.startOffset, `is`(0))
        assertThat(ref.rangeInElement.endOffset, `is`(1))
        assertThat(ref.variants.size, `is`(0))

        var resolved: PsiElement = ref.resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XPathNCName::class.java)))
        assertThat(resolved, `is`<PsiElement>(varQNamePsi))

        val refs = varRefNamePsi.references
        assertThat(refs.size, `is`(1))

        assertThat(refs[0].canonicalText, `is`("x"))
        assertThat(refs[0].rangeInElement.startOffset, `is`(0))
        assertThat(refs[0].rangeInElement.endOffset, `is`(1))
        assertThat(refs[0].variants.size, `is`(0))

        resolved = refs[0].resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XPathNCName::class.java)))
        assertThat(resolved, `is`<PsiElement>(varQNamePsi))
    }

    fun testParam() {
        val file = parseResource("tests/resolve/variables/FunctionDecl_ReturningSpecifiedParam.xq")

        val annotatedDeclPsi = file.descendants().filterIsInstance<XQueryAnnotatedDecl>().first()
        val functionDeclPsi = annotatedDeclPsi.children().filterIsInstance<XQueryFunctionDecl>().first()
        val paramListPsi = functionDeclPsi.children().filterIsInstance<XPathParamList>().first()
        val paramPsi = paramListPsi.children().filterIsInstance<XPathParam>().first()
        val paramNamePsi = paramPsi.children().filterIsInstance<XPathEQName>().first()

        val functionBodyPsi = functionDeclPsi.children().filterIsInstance<XPathFunctionBody>().first()
        val varRefNamePsi = functionBodyPsi.walkTree().filterIsInstance<XPathEQName>().first()

        val ref = varRefNamePsi.reference!!
        assertThat(ref.canonicalText, `is`("x"))
        assertThat(ref.rangeInElement.startOffset, `is`(0))
        assertThat(ref.rangeInElement.endOffset, `is`(1))
        assertThat(ref.variants.size, `is`(0))

        var resolved: PsiElement = ref.resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XPathNCName::class.java)))
        assertThat(resolved, `is`<PsiElement>(paramNamePsi))

        val refs = varRefNamePsi.references
        assertThat(refs.size, `is`(1))

        assertThat(refs[0].canonicalText, `is`("x"))
        assertThat(refs[0].rangeInElement.startOffset, `is`(0))
        assertThat(refs[0].rangeInElement.endOffset, `is`(1))
        assertThat(refs[0].variants.size, `is`(0))

        resolved = refs[0].resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XPathNCName::class.java)))
        assertThat(resolved, `is`<PsiElement>(paramNamePsi))
    }

    fun testPositionalVar() {
        val file = parseResource("tests/resolve/variables/PositionalVar_ReturnThePosition.xq")

        val forClausePsi = file.descendants().filterIsInstance<XQueryForClause>().first()
        val forBindingPsi = forClausePsi.children().filterIsInstance<XQueryForBinding>().first()
        val positionalVarPsi = forBindingPsi.children().filterIsInstance<XQueryPositionalVar>().first()
        val varNamePsi = positionalVarPsi.children().filterIsInstance<XPathVarName>().first()
        val varQNamePsi = varNamePsi.children().filterIsInstance<XPathEQName>().first()

        val flworExprPsi = file.descendants().filterIsInstance<XQueryFLWORExpr>().first()
        val returnClausePsi = flworExprPsi.children().filterIsInstance<XQueryReturnClause>().first()
        val varRefNamePsi = returnClausePsi.walkTree().filterIsInstance<XPathEQName>().first()

        val ref = varRefNamePsi.reference!!
        assertThat(ref.canonicalText, `is`("i"))
        assertThat(ref.rangeInElement.startOffset, `is`(0))
        assertThat(ref.rangeInElement.endOffset, `is`(1))
        assertThat(ref.variants.size, `is`(0))

        var resolved: PsiElement = ref.resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XPathNCName::class.java)))
        assertThat(resolved, `is`<PsiElement>(varQNamePsi))

        val refs = varRefNamePsi.references
        assertThat(refs.size, `is`(1))

        assertThat(refs[0].canonicalText, `is`("i"))
        assertThat(refs[0].rangeInElement.startOffset, `is`(0))
        assertThat(refs[0].rangeInElement.endOffset, `is`(1))
        assertThat(refs[0].variants.size, `is`(0))

        resolved = refs[0].resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XPathNCName::class.java)))
        assertThat(resolved, `is`<PsiElement>(varQNamePsi))
    }

    fun testSlidingWindowClause() {
        val file = parseResource("tests/parser/xquery-3.0/SlidingWindowClause.xq")

        val windowClausePsi = file.descendants().filterIsInstance<XQueryWindowClause>().first()
        val slidingWindowClausePsi = windowClausePsi.children().filterIsInstance<XQuerySlidingWindowClause>().first()
        val varNamePsi = slidingWindowClausePsi.children().filterIsInstance<XPathVarName>().first()
        val varQNamePsi = varNamePsi.children().filterIsInstance<XPathEQName>().first()

        val flworExprPsi = file.descendants().filterIsInstance<XQueryFLWORExpr>().first()
        val returnClausePsi = flworExprPsi.children().filterIsInstance<XQueryReturnClause>().first()
        val varRefNamePsi = returnClausePsi.walkTree().filterIsInstance<XPathEQName>().first()

        val ref = varRefNamePsi.reference!!
        assertThat(ref.canonicalText, `is`("x"))
        assertThat(ref.rangeInElement.startOffset, `is`(0))
        assertThat(ref.rangeInElement.endOffset, `is`(1))
        assertThat(ref.variants.size, `is`(0))

        var resolved: PsiElement = ref.resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XPathNCName::class.java)))
        assertThat(resolved, `is`<PsiElement>(varQNamePsi))

        val refs = varRefNamePsi.references
        assertThat(refs.size, `is`(1))

        assertThat(refs[0].canonicalText, `is`("x"))
        assertThat(refs[0].rangeInElement.startOffset, `is`(0))
        assertThat(refs[0].rangeInElement.endOffset, `is`(1))
        assertThat(refs[0].variants.size, `is`(0))

        resolved = refs[0].resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XPathNCName::class.java)))
        assertThat(resolved, `is`<PsiElement>(varQNamePsi))
    }

    fun testTumblingWindowClause() {
        val file = parseResource("tests/parser/xquery-3.0/TumblingWindowClause.xq")

        val windowClausePsi = file.descendants().filterIsInstance<XQueryWindowClause>().first()
        val tumblingWindowClausePsi = windowClausePsi.children().filterIsInstance<XQueryTumblingWindowClause>().first()
        val varNamePsi = tumblingWindowClausePsi.children().filterIsInstance<XPathVarName>().first()
        val varQNamePsi = varNamePsi.children().filterIsInstance<XPathEQName>().first()

        val flworExprPsi = file.descendants().filterIsInstance<XQueryFLWORExpr>().first()
        val returnClausePsi = flworExprPsi.children().filterIsInstance<XQueryReturnClause>().first()
        val varRefNamePsi = returnClausePsi.walkTree().filterIsInstance<XPathEQName>().first()

        val ref = varRefNamePsi.reference!!
        assertThat(ref.canonicalText, `is`("x"))
        assertThat(ref.rangeInElement.startOffset, `is`(0))
        assertThat(ref.rangeInElement.endOffset, `is`(1))
        assertThat(ref.variants.size, `is`(0))

        var resolved: PsiElement = ref.resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XPathNCName::class.java)))
        assertThat(resolved, `is`<PsiElement>(varQNamePsi))

        val refs = varRefNamePsi.references
        assertThat(refs.size, `is`(1))

        assertThat(refs[0].canonicalText, `is`("x"))
        assertThat(refs[0].rangeInElement.startOffset, `is`(0))
        assertThat(refs[0].rangeInElement.endOffset, `is`(1))
        assertThat(refs[0].variants.size, `is`(0))

        resolved = refs[0].resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XPathNCName::class.java)))
        assertThat(resolved, `is`<PsiElement>(varQNamePsi))
    }

    fun testVarDecl() {
        val file = parseResource("tests/resolve/variables/VarDecl_VarRef_NCName.xq")

        val annotatedDeclPsi = file.descendants().filterIsInstance<XQueryAnnotatedDecl>().first()
        val varDeclQNamePsi = annotatedDeclPsi.walkTree().filterIsInstance<XPathEQName>().first()

        val mainModulePsi = file.descendants().filterIsInstance<XQueryMainModule>().first()
        val queryBodyPsi = mainModulePsi.children().filterIsInstance<XQueryQueryBody>().first()
        val varRefNamePsi = queryBodyPsi.walkTree().filterIsInstance<XPathEQName>().first()

        val ref = varRefNamePsi.reference!!
        assertThat(ref.canonicalText, `is`("value"))
        assertThat(ref.rangeInElement.startOffset, `is`(0))
        assertThat(ref.rangeInElement.endOffset, `is`(5))
        assertThat(ref.variants.size, `is`(0))

        var resolved: PsiElement = ref.resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XPathNCName::class.java)))
        assertThat(resolved, `is`<PsiElement>(varDeclQNamePsi))

        val refs = varRefNamePsi.references
        assertThat(refs.size, `is`(1))

        assertThat(refs[0].canonicalText, `is`("value"))
        assertThat(refs[0].rangeInElement.startOffset, `is`(0))
        assertThat(refs[0].rangeInElement.endOffset, `is`(5))
        assertThat(refs[0].variants.size, `is`(0))

        resolved = refs[0].resolve()!!
        assertThat(resolved, `is`(instanceOf<PsiElement>(XPathNCName::class.java)))
        assertThat(resolved, `is`<PsiElement>(varDeclQNamePsi))
    }

    // endregion
}
