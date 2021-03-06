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
package uk.co.reecedunn.intellij.plugin.xquery.parser

import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import uk.co.reecedunn.intellij.plugin.core.parser.ICompositeElementType
import uk.co.reecedunn.intellij.plugin.xpath.psi.impl.xpath.*
import uk.co.reecedunn.intellij.plugin.xquery.lang.XQuery
import uk.co.reecedunn.intellij.plugin.xquery.lexer.XQueryTokenType
import uk.co.reecedunn.intellij.plugin.xquery.psi.impl.basex.BaseXFTFuzzyOptionPsiImpl
import uk.co.reecedunn.intellij.plugin.xquery.psi.impl.basex.BaseXUpdateExprPsiImpl
import uk.co.reecedunn.intellij.plugin.xquery.psi.impl.full.text.*
import uk.co.reecedunn.intellij.plugin.xquery.psi.impl.marklogic.*
import uk.co.reecedunn.intellij.plugin.xquery.psi.impl.saxon.SaxonTupleFieldImpl
import uk.co.reecedunn.intellij.plugin.xquery.psi.impl.saxon.SaxonTupleTypeImpl
import uk.co.reecedunn.intellij.plugin.xquery.psi.impl.saxon.SaxonTypeDeclImpl
import uk.co.reecedunn.intellij.plugin.xquery.psi.impl.saxon.SaxonUnionTypeImpl
import uk.co.reecedunn.intellij.plugin.xquery.psi.impl.scripting.*
import uk.co.reecedunn.intellij.plugin.xquery.psi.impl.update.facility.*
import uk.co.reecedunn.intellij.plugin.xquery.psi.impl.xquery.*

object XQueryElementType {
    val FILE = IFileElementType(XQuery)

    // region XQuery 1.0

    val CDATA_SECTION: IElementType = ICompositeElementType("XQUERY_CDATA_SECTION", XQueryCDataSectionPsiImpl::class.java, XQuery)
    val COMMENT: IElementType = ICompositeElementType("XQUERY_COMMENT", XPathCommentPsiImpl::class.java, XQuery)
    val NCNAME: IElementType = ICompositeElementType("XQUERY_NCNAME", XPathNCNamePsiImpl::class.java, XQuery)
    val QNAME: IElementType = ICompositeElementType("XQUERY_QNAME", XPathQNamePsiImpl::class.java, XQuery)
    val URI_LITERAL: IElementType = ICompositeElementType("XQUERY_URI_LITERAL", XQueryUriLiteralPsiImpl::class.java, XQuery)
    val VAR_NAME: IElementType = ICompositeElementType("XQUERY_VAR_NAME", XPathVarNamePsiImpl::class.java, XQuery)

    val LITERAL: IElementType = ICompositeElementType("XQUERY_LITERAL", XPathLiteralPsiImpl::class.java, XQuery)
    val STRING_LITERAL: IElementType = ICompositeElementType("XQUERY_STRING_LITERAL", XPathStringLiteralPsiImpl::class.java, XQuery)
    val VAR_REF: IElementType = ICompositeElementType("XQUERY_VAR_REF", XPathVarRefPsiImpl::class.java, XQuery)
    val PARENTHESIZED_EXPR: IElementType = ICompositeElementType("XQUERY_PARENTHESIZED_EXPR", XPathParenthesizedExprPsiImpl::class.java, XQuery)
    val CONTEXT_ITEM_EXPR: IElementType = ICompositeElementType("XQUERY_CONTEXT_ITEM_EXPR", XPathContextItemExprPsiImpl::class.java, XQuery)
    val ORDERED_EXPR: IElementType = ICompositeElementType("XQUERY_ORDERED_EXPR", XQueryOrderedExprPsiImpl::class.java, XQuery)
    val UNORDERED_EXPR: IElementType = ICompositeElementType("XQUERY_UNORDERED_EXPR", XQueryUnorderedExprPsiImpl::class.java, XQuery)
    val FUNCTION_CALL: IElementType = ICompositeElementType("XQUERY_FUNCTION_CALL", XPathFunctionCallPsiImpl::class.java, XQuery)

    val AXIS_STEP: IElementType = ICompositeElementType("XQUERY_AXIS_STEP", XPathAxisStepPsiImpl::class.java, XQuery)
    val FORWARD_STEP: IElementType = ICompositeElementType("XQUERY_FORWARD_STEP", XPathForwardStepPsiImpl::class.java, XQuery)
    val FORWARD_AXIS: IElementType = ICompositeElementType("XQUERY_FORWARD_AXIS", XPathForwardAxisPsiImpl::class.java, XQuery)
    val ABBREV_FORWARD_STEP: IElementType = ICompositeElementType("XQUERY_ABBREV_FORWARD_STEP", XPathAbbrevForwardStepPsiImpl::class.java, XQuery)
    val REVERSE_STEP: IElementType = ICompositeElementType("XQUERY_REVERSE_STEP", XPathReverseStepPsiImpl::class.java, XQuery)
    val REVERSE_AXIS: IElementType = ICompositeElementType("XQUERY_REVERSE_AXIS", XPathReverseAxisPsiImpl::class.java, XQuery)
    val ABBREV_REVERSE_STEP: IElementType = ICompositeElementType("XQUERY_ABBREV_REVERSE_STEP", XPathAbbrevReverseStepPsiImpl::class.java, XQuery)
    val NODE_TEST: IElementType = ICompositeElementType("XQUERY_NODE_TEST", XPathNodeTestPsiImpl::class.java, XQuery)
    val NAME_TEST: IElementType = ICompositeElementType("XQUERY_NAME_TEST", XPathNameTestPsiImpl::class.java, XQuery)
    val WILDCARD: IElementType = ICompositeElementType("XQUERY_WILDCARD", XPathWildcardPsiImpl::class.java, XQuery)
    val PREDICATE_LIST: IElementType = ICompositeElementType("XQUERY_PREDICATE_LIST", XPathPredicateListPsiImpl::class.java, XQuery)
    val PREDICATE: IElementType = ICompositeElementType("XQUERY_PREDICATE", XPathPredicatePsiImpl::class.java, XQuery)

    val RELATIVE_PATH_EXPR: IElementType = ICompositeElementType("XQUERY_RELATIVE_PATH_EXPR", XPathRelativePathExprPsiImpl::class.java, XQuery)
    val PATH_EXPR: IElementType = ICompositeElementType("XQUERY_PATH_EXPR", XPathPathExprPsiImpl::class.java, XQuery)
    val PRAGMA: IElementType = ICompositeElementType("XQUERY_PRAGMA", XQueryPragmaPsiImpl::class.java, XQuery)
    val EXTENSION_EXPR: IElementType = ICompositeElementType("XQUERY_EXTENSION_EXPR", XQueryExtensionExprPsiImpl::class.java, XQuery)
    val VALIDATE_EXPR: IElementType = ICompositeElementType("XQUERY_VALIDATE_EXPR", XQueryValidateExprPsiImpl::class.java, XQuery)

    val SINGLE_TYPE: IElementType = ICompositeElementType("XQUERY_SINGLE_TYPE", XPathSingleTypePsiImpl::class.java, XQuery)
    val UNARY_EXPR: IElementType = ICompositeElementType("XQUERY_UNARY_EXPR", XPathUnaryExprPsiImpl::class.java, XQuery)
    val CAST_EXPR: IElementType = ICompositeElementType("XQUERY_CAST_EXPR", XPathCastExprPsiImpl::class.java, XQuery)
    val CASTABLE_EXPR: IElementType = ICompositeElementType("XQUERY_CASTABLE_EXPR", XPathCastableExprPsiImpl::class.java, XQuery)
    val TREAT_EXPR: IElementType = ICompositeElementType("XQUERY_TREAT_EXPR", XPathTreatExprPsiImpl::class.java, XQuery)
    val INSTANCEOF_EXPR: IElementType = ICompositeElementType("XQUERY_INSTANCEOF_EXPR", XPathInstanceofExprPsiImpl::class.java, XQuery)
    val INTERSECT_EXCEPT_EXPR: IElementType = ICompositeElementType("XQUERY_INTERSECT_EXCEPT_EXPR", XPathIntersectExceptExprPsiImpl::class.java, XQuery)
    val UNION_EXPR: IElementType = ICompositeElementType("XQUERY_UNION_EXPR", XPathUnionExprPsiImpl::class.java, XQuery)
    val MULTIPLICATIVE_EXPR: IElementType = ICompositeElementType("XQUERY_MULTIPLICATIVE_EXPR", XPathMultiplicativeExprPsiImpl::class.java, XQuery)
    val ADDITIVE_EXPR: IElementType = ICompositeElementType("XQUERY_ADDITIVE_EXPR", XPathAdditiveExprPsiImpl::class.java, XQuery)
    val RANGE_EXPR: IElementType = ICompositeElementType("XQUERY_RANGE_EXPR", XPathRangeExprPsiImpl::class.java, XQuery)
    val COMPARISON_EXPR: IElementType = ICompositeElementType("XQUERY_COMPARISON_EXPR", XPathComparisonExprPsiImpl::class.java, XQuery)
    val AND_EXPR: IElementType = ICompositeElementType("XQUERY_AND_EXPR", XPathAndExprPsiImpl::class.java, XQuery)
    val OR_EXPR: IElementType = ICompositeElementType("XQUERY_OR_EXPR", XPathOrExprPsiImpl::class.java, XQuery)

    val ORDER_MODIFIER: IElementType = ICompositeElementType("XQUERY_ORDER_MODIFIER", XQueryOrderModifierPsiImpl::class.java, XQuery)
    val ORDER_SPEC: IElementType = ICompositeElementType("XQUERY_ORDER_SPEC", XQueryOrderSpecPsiImpl::class.java, XQuery)
    val ORDER_SPEC_LIST: IElementType = ICompositeElementType("XQUERY_ORDER_SPEC_LIST", XQueryOrderSpecListPsiImpl::class.java, XQuery)
    val POSITIONAL_VAR: IElementType = ICompositeElementType("XQUERY_POSITIONAL_VAR", XQueryPositionalVarPsiImpl::class.java, XQuery)
    val ORDER_BY_CLAUSE: IElementType = ICompositeElementType("XQUERY_ORDER_BY_CLAUSE", XQueryOrderByClausePsiImpl::class.java, XQuery)
    val WHERE_CLAUSE: IElementType = ICompositeElementType("XQUERY_WHERE_CLAUSE", XQueryWhereClausePsiImpl::class.java, XQuery)
    val LET_CLAUSE: IElementType = ICompositeElementType("XQUERY_LET_CLAUSE", XQueryLetClausePsiImpl::class.java, XQuery)
    val FOR_CLAUSE: IElementType = ICompositeElementType("XQUERY_FOR_CLAUSE", XQueryForClausePsiImpl::class.java, XQuery)
    val FLWOR_EXPR: IElementType = ICompositeElementType("XQUERY_FLWOR_EXPR", XQueryFLWORExprPsiImpl::class.java, XQuery)

    val QUANTIFIED_EXPR: IElementType = ICompositeElementType("XQUERY_QUANTIFIED_EXPR", XPathQuantifiedExprPsiImpl::class.java, XQuery)
    val TYPESWITCH_EXPR: IElementType = ICompositeElementType("XQUERY_TYPESWITCH_EXPR", XQueryTypeswitchExprPsiImpl::class.java, XQuery)
    val CASE_CLAUSE: IElementType = ICompositeElementType("XQUERY_CASE_CLAUSE", XQueryCaseClausePsiImpl::class.java, XQuery)
    val DEFAULT_CASE_CLAUSE: IElementType = ICompositeElementType("XQUERY_DEFAULT_CASE_CLAUSE", XQueryDefaultCaseClausePsiImpl::class.java, XQuery)
    val IF_EXPR: IElementType = ICompositeElementType("XQUERY_IF_EXPR", XPathIfExprPsiImpl::class.java, XQuery)

    val QUERY_BODY: IElementType = ICompositeElementType("XQUERY_QUERY_BODY", XQueryQueryBodyPsiImpl::class.java, XQuery)
    val EXPR: IElementType = ICompositeElementType("XQUERY_EXPR", XPathExprPsiImpl::class.java, XQuery)
    val ENCLOSED_EXPR: IElementType = ICompositeElementType("XQUERY_ENCLOSED_EXPR", XPathEnclosedExprPsiImpl::class.java, XQuery)

    val IMPORT: IElementType = ICompositeElementType("XQUERY_IMPORT", XQueryImportPsiImpl::class.java, XQuery)
    val SCHEMA_PREFIX: IElementType = ICompositeElementType("XQUERY_SCHEMA_PREFIX", XQuerySchemaPrefixPsiImpl::class.java, XQuery)
    val NAMESPACE_DECL: IElementType = ICompositeElementType("XQUERY_NAMESPACE_DECL", XQueryNamespaceDeclPsiImpl::class.java, XQuery)
    val SCHEMA_IMPORT: IElementType = ICompositeElementType("XQUERY_SCHEMA_IMPORT", XQuerySchemaImportPsiImpl::class.java, XQuery)
    val MODULE_IMPORT: IElementType = ICompositeElementType("XQUERY_MODULE_IMPORT", XQueryModuleImportPsiImpl::class.java, XQuery)
    val PROLOG: IElementType = ICompositeElementType("XQUERY_PROLOG", XQueryPrologPsiImpl::class.java, XQuery)

    val TYPE_NAME: IElementType = ICompositeElementType("XQUERY_TYPE_NAME", XPathTypeNamePsiImpl::class.java, XQuery)
    val ELEMENT_NAME_OR_WILDCARD: IElementType = ICompositeElementType("XQUERY_ELEMENT_NAME_OR_WILDCARD", XPathElementNameOrWildcardPsiImpl::class.java, XQuery)
    val ELEMENT_NAME: IElementType = ICompositeElementType("XQUERY_ELEMENT_NAME", XPathElementNamePsiImpl::class.java, XQuery)
    val ELEMENT_DECLARATION: IElementType = ICompositeElementType("XQUERY_ELEMENT_DECLARATION", XPathElementDeclarationPsiImpl::class.java, XQuery)
    val ATTRIB_NAME_OR_WILDCARD: IElementType = ICompositeElementType("XQUERY_ATTRIB_NAME_OR_WILDCARD", XPathAttribNameOrWildcardPsiImpl::class.java, XQuery)
    val ATTRIBUTE_NAME: IElementType = ICompositeElementType("XQUERY_ATTRIBUTE_NAME", XPathAttributeNamePsiImpl::class.java, XQuery)
    val ATTRIBUTE_DECLARATION: IElementType = ICompositeElementType("XQUERY_ATTRIBUTE_DECLARATION", XPathAttributeDeclarationPsiImpl::class.java, XQuery)

    val DOCUMENT_TEST: IElementType = ICompositeElementType("XQUERY_DOCUMENT_TEST", XPathDocumentTestPsiImpl::class.java, XQuery)
    val ELEMENT_TEST: IElementType = ICompositeElementType("XQUERY_ELEMENT_TEST", XPathElementTestPsiImpl::class.java, XQuery)
    val SCHEMA_ELEMENT_TEST: IElementType = ICompositeElementType("XQUERY_SCHEMA_ELEMENT_TEST", XPathSchemaElementTestPsiImpl::class.java, XQuery)
    val ATTRIBUTE_TEST: IElementType = ICompositeElementType("XQUERY_ATTRIBUTE_TEST", XPathAttributeTestPsiImpl::class.java, XQuery)
    val SCHEMA_ATTRIBUTE_TEST: IElementType = ICompositeElementType("XQUERY_SCHEMA_ATTRIBUTE_TEST", XPathSchemaAttributeTestPsiImpl::class.java, XQuery)
    val PI_TEST: IElementType = ICompositeElementType("XQUERY_PI_TEST", XPathPITestPsiImpl::class.java, XQuery)
    val COMMENT_TEST: IElementType = ICompositeElementType("XQUERY_COMMENT_TEST", XPathCommentTestPsiImpl::class.java, XQuery)
    val TEXT_TEST: IElementType = ICompositeElementType("XQUERY_TEXT_TEST", XPathTextTestPsiImpl::class.java, XQuery)
    val ANY_KIND_TEST: IElementType = ICompositeElementType("XQUERY_ANY_KIND_TEST", XPathAnyKindTestPsiImpl::class.java, XQuery)
    val ITEM_TYPE: IElementType = ICompositeElementType("XQUERY_ITEM_TYPE", XPathItemTypePsiImpl::class.java, XQuery)
    val OCCURRENCE_INDICATOR: IElementType = ICompositeElementType("XQUERY_OCCURRENCE_INDICATOR", XPathOccurrenceIndicatorPsiImpl::class.java, XQuery)
    val TYPE_DECLARATION: IElementType = ICompositeElementType("XQUERY_TYPE_DECLARATION", XPathTypeDeclarationPsiImpl::class.java, XQuery)
    val SEQUENCE_TYPE: IElementType = ICompositeElementType("XQUERY_SEQUENCE_TYPE", XPathSequenceTypePsiImpl::class.java, XQuery)

    val PARAM: IElementType = ICompositeElementType("XQUERY_PARAM", XPathParamPsiImpl::class.java, XQuery)
    val PARAM_LIST: IElementType = ICompositeElementType("XQUERY_PARAM_LIST", XPathParamListPsiImpl::class.java, XQuery)

    val FUNCTION_DECL: IElementType = ICompositeElementType("XQUERY_FUNCTION_DECL", XQueryFunctionDeclPsiImpl::class.java, XQuery)
    val CONSTRUCTION_DECL: IElementType = ICompositeElementType("XQUERY_CONSTRUCTION_DECL", XQueryConstructionDeclPsiImpl::class.java, XQuery)
    val VAR_DECL: IElementType = ICompositeElementType("XQUERY_VAR_DECL", XQueryVarDeclPsiImpl::class.java, XQuery)
    val BASE_URI_DECL: IElementType = ICompositeElementType("XQUERY_BASE_URI_DECL", XQueryBaseURIDeclPsiImpl::class.java, XQuery)
    val DEFAULT_COLLATION_DECL: IElementType = ICompositeElementType("XQUERY_DEFAULT_COLLATION_DECL", XQueryDefaultCollationDeclPsiImpl::class.java, XQuery)
    val COPY_NAMESPACES_DECL: IElementType = ICompositeElementType("XQUERY_COPY_NAMESPACES_DECL", XQueryCopyNamespacesDeclPsiImpl::class.java, XQuery)
    val EMPTY_ORDER_DECL: IElementType = ICompositeElementType("XQUERY_EMPTY_ORDER_DECL", XQueryEmptyOrderDeclPsiImpl::class.java, XQuery)
    val ORDERING_MODE_DECL: IElementType = ICompositeElementType("XQUERY_ORDERING_MODE_DECL", XQueryOrderingModeDeclPsiImpl::class.java, XQuery)
    val OPTION_DECL: IElementType = ICompositeElementType("XQUERY_OPTION_DECL", XQueryOptionDeclPsiImpl::class.java, XQuery)
    val DEFAULT_NAMESPACE_DECL: IElementType = ICompositeElementType("XQUERY_DEFAULT_NAMESPACE_DECL", XQueryDefaultNamespaceDeclPsiImpl::class.java, XQuery)
    val BOUNDARY_SPACE_DECL: IElementType = ICompositeElementType("XQUERY_BOUNDARY_SPACE_DECL", XQueryBoundarySpaceDeclPsiImpl::class.java, XQuery)
    val UNKNOWN_DECL: IElementType = ICompositeElementType("XQUERY_UNKNOWN_DECL", XQueryUnknownDeclPsiImpl::class.java, XQuery)
    val MODULE_DECL: IElementType = ICompositeElementType("XQUERY_MODULE_DECL", XQueryModuleDeclPsiImpl::class.java, XQuery)
    val VERSION_DECL: IElementType = ICompositeElementType("XQUERY_VERSION_DECL", XQueryVersionDeclPsiImpl::class.java, XQuery)
    val MAIN_MODULE: IElementType = ICompositeElementType("XQUERY_MAIN_MODULE", XQueryMainModulePsiImpl::class.java, XQuery)
    val LIBRARY_MODULE: IElementType = ICompositeElementType("XQUERY_LIBRARY_MODULE", XQueryLibraryModulePsiImpl::class.java, XQuery)

    val DIR_ELEM_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_DIR_ELEM_CONSTRUCTOR", XQueryDirElemConstructorPsiImpl::class.java, XQuery)
    val DIR_ATTRIBUTE_LIST: IElementType = ICompositeElementType("XQUERY_DIR_ATTRIBUTE_LIST", XQueryDirAttributeListPsiImpl::class.java, XQuery)
    val DIR_ATTRIBUTE: IElementType = ICompositeElementType("XQUERY_DIR_ATTRIBUTE", XQueryDirAttributePsiImpl::class.java, XQuery)
    val DIR_ATTRIBUTE_VALUE: IElementType = ICompositeElementType("XQUERY_DIR_ATTRIBUTE_VALUE", XQueryDirAttributeValuePsiImpl::class.java, XQuery)
    val DIR_COMMENT_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_DIR_COMMENT_CONSTRUCTOR", XQueryDirCommentConstructorPsiImpl::class.java, XQuery)
    val DIR_PI_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_DIR_PI_CONSTRUCTOR", XQueryDirPIConstructorPsiImpl::class.java, XQuery)
    val DIR_ELEM_CONTENT: IElementType = ICompositeElementType("XQUERY_DIR_ELEM_CONTENT", XQueryDirElemContentPsiImpl::class.java, XQuery)
    val COMP_DOC_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_COMP_DOC_CONSTRUCTOR", XQueryCompDocConstructorPsiImpl::class.java, XQuery)
    val COMP_ELEM_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_COMP_ELEM_CONSTRUCTOR", XQueryCompElemConstructorPsiImpl::class.java, XQuery)
    val COMP_ATTR_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_COMP_ATTR_CONSTRUCTOR", XQueryCompAttrConstructorPsiImpl::class.java, XQuery)
    val COMP_TEXT_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_COMP_TEXT_CONSTRUCTOR", XQueryCompTextConstructorPsiImpl::class.java, XQuery)
    val COMP_COMMENT_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_COMP_COMMENT_CONSTRUCTOR", XQueryCompCommentConstructorPsiImpl::class.java, XQuery)
    val COMP_PI_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_COMP_PI_CONSTRUCTOR", XQueryCompPIConstructorPsiImpl::class.java, XQuery)

    // endregion
    // region XQuery 3.0

    val BRACED_URI_LITERAL: IElementType = ICompositeElementType("XQUERY_BRACED_URI_LITERAL", XPathBracedURILiteralPsiImpl::class.java, XQuery)
    val URI_QUALIFIED_NAME: IElementType = ICompositeElementType("XQUERY_URI_QUALIFIED_NAME", XPathURIQualifiedNamePsiImpl::class.java, XQuery)

    val DECIMAL_FORMAT_DECL: IElementType = ICompositeElementType("XQUERY_DECIMAL_FORMAT_DECL", XQueryDecimalFormatDeclPsiImpl::class.java, XQuery)
    val DF_PROPERTY_NAME: IElementType = ICompositeElementType("XQUERY_DF_PROPERTY_NAME", XQueryDFPropertyNamePsiImpl::class.java, XQuery)
    val CONTEXT_ITEM_DECL: IElementType = ICompositeElementType("XQUERY_CONTEXT_ITEM_DECL", XQueryContextItemDeclPsiImpl::class.java, XQuery)

    val FUNCTION_BODY: IElementType = ICompositeElementType("XQUERY_FUNCTION_BODY", XPathFunctionBodyPsiImpl::class.java, XQuery)
    val VAR_VALUE: IElementType = ICompositeElementType("XQUERY_VAR_VALUE", XQueryVarValuePsiImpl::class.java, XQuery)
    val VAR_DEFAULT_VALUE: IElementType = ICompositeElementType("XQUERY_VAR_DEFAULT_VALUE", XQueryVarDefaultValuePsiImpl::class.java, XQuery)

    val ATOMIC_OR_UNION_TYPE: IElementType = ICompositeElementType("XQUERY_ATOMIC_OR_UNION_TYPE", XPathAtomicOrUnionTypePsiImpl::class.java, XQuery)
    val SIMPLE_TYPE_NAME: IElementType = ICompositeElementType("XQUERY_SIMPLE_TYPE_NAME", XPathSimpleTypeNamePsiImpl::class.java, XQuery)
    val SEQUENCE_TYPE_UNION: IElementType = ICompositeElementType("XQUERY_SEQUENCE_TYPE_UNION", XQuerySequenceTypeUnionPsiImpl::class.java, XQuery)

    val FUNCTION_TEST: IElementType = ICompositeElementType("XQUERY_FUNCTION_TEST", XPathFunctionTestPsiImpl::class.java, XQuery)
    val ANY_FUNCTION_TEST: IElementType = ICompositeElementType("XQUERY_ANY_FUNCTION_TEST", XPathAnyFunctionTestPsiImpl::class.java, XQuery)
    val TYPED_FUNCTION_TEST: IElementType = ICompositeElementType("XQUERY_TYPED_FUNCTION_TEST", XPathTypedFunctionTestPsiImpl::class.java, XQuery)
    val PARENTHESIZED_ITEM_TYPE: IElementType = ICompositeElementType("XQUERY_PARENTHESIZED_ITEM_TYPE", XPathParenthesizedItemTypePsiImpl::class.java, XQuery)

    val NAMESPACE_NODE_TEST: IElementType = ICompositeElementType("XQUERY_NAMESPACE_NODE_TEST", XPathNamespaceNodeTestPsiImpl::class.java, XQuery)

    val ANNOTATED_DECL: IElementType = ICompositeElementType("XQUERY_ANNOTATED_DECL", XQueryAnnotatedDeclPsiImpl::class.java, XQuery)
    val ANNOTATION: IElementType = ICompositeElementType("XQUERY_ANNOTATION", XQueryAnnotationPsiImpl::class.java, XQuery)

    val SWITCH_EXPR: IElementType = ICompositeElementType("XQUERY_SWITCH_EXPR", XQuerySwitchExprPsiImpl::class.java, XQuery)
    val SWITCH_CASE_CLAUSE: IElementType = ICompositeElementType("XQUERY_SWITCH_CASE_CLAUSE", XQuerySwitchCaseClausePsiImpl::class.java, XQuery)
    val SWITCH_CASE_OPERAND: IElementType = ICompositeElementType("XQUERY_SWITCH_CASE_OPERAND", XQuerySwitchCaseOperandPsiImpl::class.java, XQuery)

    val TRY_CATCH_EXPR: IElementType = ICompositeElementType("XQUERY_TRY_CATCH_EXPR", XQueryTryCatchExprPsiImpl::class.java, XQuery)
    val TRY_CLAUSE: IElementType = ICompositeElementType("XQUERY_TRY_CLAUSE", XQueryTryClausePsiImpl::class.java, XQuery)
    val CATCH_CLAUSE: IElementType = ICompositeElementType("XQUERY_CATCH_CLAUSE", XQueryCatchClausePsiImpl::class.java, XQuery)
    val CATCH_ERROR_LIST: IElementType = ICompositeElementType("XQUERY_CATCH_ERROR_LIST", XQueryCatchErrorListPsiImpl::class.java, XQuery)

    val FOR_BINDING: IElementType = ICompositeElementType("XQUERY_FOR_BINDING", XQueryForBindingPsiImpl::class.java, XQuery)
    val LET_BINDING: IElementType = ICompositeElementType("XQUERY_LET_BINDING", XQueryLetBindingPsiImpl::class.java, XQuery)
    val QUANTIFIED_EXPR_BINDING: IElementType = ICompositeElementType("XQUERY_QUANTIFIED_EXPR_BINDING", XPathQuantifiedExprBindingPsiImpl::class.java, XQuery)

    val ALLOWING_EMPTY: IElementType = ICompositeElementType("XQUERY_ALLOWING_EMPTY", XQueryAllowingEmptyPsiImpl::class.java, XQuery)
    val INTERMEDIATE_CLAUSE: IElementType = ICompositeElementType("XQUERY_INTERMEDIATE_CLAUSE", XQueryIntermediateClausePsiImpl::class.java, XQuery)
    val COUNT_CLAUSE: IElementType = ICompositeElementType("XQUERY_COUNT_CLAUSE", XQueryCountClausePsiImpl::class.java, XQuery)
    val RETURN_CLAUSE: IElementType = ICompositeElementType("XQUERY_RETURN_CLAUSE", XQueryReturnClausePsiImpl::class.java, XQuery)

    val WINDOW_CLAUSE: IElementType = ICompositeElementType("XQUERY_WINDOW_CLAUSE", XQueryWindowClausePsiImpl::class.java, XQuery)
    val TUMBLING_WINDOW_CLAUSE: IElementType = ICompositeElementType("XQUERY_TUMBLING_WINDOW_CLAUSE", XQueryTumblingWindowClausePsiImpl::class.java, XQuery)
    val SLIDING_WINDOW_CLAUSE: IElementType = ICompositeElementType("XQUERY_SLIDING_WINDOW_CLAUSE", XQuerySlidingWindowClausePsiImpl::class.java, XQuery)
    val WINDOW_START_CONDITION: IElementType = ICompositeElementType("XQUERY_WINDOW_START_CONDITION", XQueryWindowStartConditionPsiImpl::class.java, XQuery)
    val WINDOW_END_CONDITION: IElementType = ICompositeElementType("XQUERY_WINDOW_END_CONDITION", XQueryWindowEndConditionPsiImpl::class.java, XQuery)
    val WINDOW_VARS: IElementType = ICompositeElementType("XQUERY_WINDOW_VARS", XQueryWindowVarsPsiImpl::class.java, XQuery)
    val CURRENT_ITEM: IElementType = ICompositeElementType("XQUERY_CURRENT_ITEM", XQueryCurrentItemPsiImpl::class.java, XQuery)
    val PREVIOUS_ITEM: IElementType = ICompositeElementType("XQUERY_PREVIOUS_ITEM", XQueryPreviousItemPsiImpl::class.java, XQuery)
    val NEXT_ITEM: IElementType = ICompositeElementType("XQUERY_NEXT_ITEM", XQueryNextItemPsiImpl::class.java, XQuery)

    val GROUP_BY_CLAUSE: IElementType = ICompositeElementType("XQUERY_GROUP_BY_CLAUSE", XQueryGroupByClausePsiImpl::class.java, XQuery)
    val GROUPING_SPEC_LIST: IElementType = ICompositeElementType("XQUERY_GROUPING_SPEC_LIST", XQueryGroupingSpecListPsiImpl::class.java, XQuery)
    val GROUPING_SPEC: IElementType = ICompositeElementType("XQUERY_GROUPING_SPEC", XQueryGroupingSpecPsiImpl::class.java, XQuery)
    val GROUPING_VARIABLE: IElementType = ICompositeElementType("XQUERY_GROUPING_VARIABLE", XQueryGroupingVariablePsiImpl::class.java, XQuery)

    val STRING_CONCAT_EXPR: IElementType = ICompositeElementType("XQUERY_STRING_CONCAT_EXPR", XPathStringConcatExprPsiImpl::class.java, XQuery)
    val SIMPLE_MAP_EXPR: IElementType = ICompositeElementType("XQUERY_SIMPLE_MAP_EXPR", XPathSimpleMapExprPsiImpl::class.java, XQuery)

    val INLINE_FUNCTION_EXPR: IElementType = ICompositeElementType("XQUERY_INLINE_FUNCTION_EXPR", XPathInlineFunctionExprPsiImpl::class.java, XQuery)
    val NAMED_FUNCTION_REF: IElementType = ICompositeElementType("XQUERY_NAMED_FUNCTION_REF", XPathNamedFunctionRefPsiImpl::class.java, XQuery)

    val ARGUMENT_LIST: IElementType = ICompositeElementType("XQUERY_ARGUMENT_LIST", XPathArgumentListPsiImpl::class.java, XQuery)
    val ARGUMENT: IElementType = ICompositeElementType("XQUERY_ARGUMENT", XPathArgumentPsiImpl::class.java, XQuery)
    val ARGUMENT_PLACEHOLDER: IElementType = ICompositeElementType("XQUERY_ARGUMENT_PLACEHOLDER", XPathArgumentPlaceholderPsiImpl::class.java, XQuery)

    val COMP_NAMESPACE_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_COMP_NAMESPACE_CONSTRUCTOR", XQueryCompNamespaceConstructorPsiImpl::class.java, XQuery)
    val PREFIX: IElementType = ICompositeElementType("XQUERY_PREFIX", XQueryPrefixPsiImpl::class.java, XQuery)

    // endregion
    // region XQuery 3.1

    val POSTFIX_EXPR: IElementType = ICompositeElementType("XQUERY_POSTFIX_EXPR", XPathPostfixExprPsiImpl::class.java, XQuery)

    val ARROW_EXPR: IElementType = ICompositeElementType("XQUERY_ARROW_EXPR", XPathArrowExprPsiImpl::class.java, XQuery)
    val ARROW_FUNCTION_SPECIFIER: IElementType = ICompositeElementType("XQUERY_ARROW_FUNCTION_SPECIFIER", XPathArrowFunctionSpecifierPsiImpl::class.java, XQuery)

    val ENCLOSED_CONTENT_EXPR: IElementType = ICompositeElementType("XQUERY_ENCLOSED_CONTENT_EXPR", XQueryEnclosedContentExprPsiImpl::class.java, XQuery)
    val ENCLOSED_TRY_TARGET_EXPR: IElementType = ICompositeElementType("XQUERY_ENCLOSED_TRY_TARGET_EXPR", XQueryEnclosedTryTargetExprPsiImpl::class.java, XQuery)
    val ENCLOSED_URI_EXPR: IElementType = ICompositeElementType("XQUERY_ENCLOSED_URI_EXPR", XQueryEnclosedUriExprPsiImpl::class.java, XQuery)
    val ENCLOSED_PREFIX_EXPR: IElementType = ICompositeElementType("XQUERY_ENCLOSED_PREFIX_EXPR", XQueryEnclosedPrefixExprPsiImpl::class.java, XQuery)

    val NODE_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_NODE_CONSTRUCTOR", XQueryNodeConstructorPsiImpl::class.java, XQuery)

    val SQUARE_ARRAY_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_SQUARE_ARRAY_CONSTRUCTOR", XPathSquareArrayConstructorPsiImpl::class.java, XQuery)
    val CURLY_ARRAY_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_CURLY_ARRAY_CONSTRUCTOR", XPathCurlyArrayConstructorPsiImpl::class.java, XQuery)

    val MAP_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_MAP_CONSTRUCTOR", XPathMapConstructorPsiImpl::class.java, XQuery)
    val MAP_CONSTRUCTOR_ENTRY: IElementType = ICompositeElementType("XQUERY_MAP_CONSTRUCTOR_ENTRY", XPathMapConstructorEntryPsiImpl::class.java, XQuery)
    val MAP_KEY_EXPR: IElementType = ICompositeElementType("XQUERY_MAP_KEY_EXPR", XPathMapKeyExprPsiImpl::class.java, XQuery)
    val MAP_VALUE_EXPR: IElementType = ICompositeElementType("XQUERY_MAP_VALUE_EXPR", XPathMapValueExprPsiImpl::class.java, XQuery)

    val STRING_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_STRING_CONSTRUCTOR", XQueryStringConstructorPsiImpl::class.java, XQuery)
    val STRING_CONSTRUCTOR_CONTENT: IElementType = ICompositeElementType("XQUERY_STRING_CONSTRUCTOR_CONTENT", XQueryStringConstructorContentPsiImpl::class.java, XQuery)
    val STRING_CONSTRUCTOR_INTERPOLATION: IElementType = ICompositeElementType("XQUERY_STRING_CONSTRUCTOR_INTERPOLATION", XQueryStringConstructorInterpolationPsiImpl::class.java, XQuery)

    val ANY_MAP_TEST: IElementType = ICompositeElementType("XQUERY_ANY_MAP_TEST", XPathAnyMapTestPsiImpl::class.java, XQuery)
    val TYPED_MAP_TEST: IElementType = ICompositeElementType("XQUERY_TYPED_MAP_TEST", XPathTypedMapTestPsiImpl::class.java, XQuery)

    val ANY_ARRAY_TEST: IElementType = ICompositeElementType("XQUERY_ANY_ARRAY_TEST", XPathAnyArrayTestPsiImpl::class.java, XQuery)
    val TYPED_ARRAY_TEST: IElementType = ICompositeElementType("XQUERY_TYPED_ARRAY_TEST", XPathTypedArrayTestPsiImpl::class.java, XQuery)

    val UNARY_LOOKUP: IElementType = ICompositeElementType("XQUERY_UNARY_LOOKUP", XPathUnaryLookupPsiImpl::class.java, XQuery)
    val LOOKUP: IElementType = ICompositeElementType("XQUERY_LOOKUP", XPathLookupPsiImpl::class.java, XQuery)
    val KEY_SPECIFIER: IElementType = ICompositeElementType("XQUERY_KEY_SPECIFIER", XPathKeySpecifierPsiImpl::class.java, XQuery)

    // endregion
    // region Update Facility 1.0

    val REVALIDATION_DECL: IElementType = ICompositeElementType("XQUERY_REVALIDATION_DECL", UpdateFacilityRevalidationDeclPsiImpl::class.java, XQuery)

    val INSERT_EXPR: IElementType = ICompositeElementType("XQUERY_INSERT_EXPR", UpdateFacilityInsertExprPsiImpl::class.java, XQuery)
    val DELETE_EXPR: IElementType = ICompositeElementType("XQUERY_DELETE_EXPR", UpdateFacilityDeleteExprPsiImpl::class.java, XQuery)
    val REPLACE_EXPR: IElementType = ICompositeElementType("XQUERY_REPLACE_EXPR", UpdateFacilityReplaceExprPsiImpl::class.java, XQuery)
    val RENAME_EXPR: IElementType = ICompositeElementType("XQUERY_RENAME_EXPR", UpdateFacilityRenameExprPsiImpl::class.java, XQuery)

    val NEW_NAME_EXPR: IElementType = ICompositeElementType("XQUERY_NEW_NAME_EXPR", UpdateFacilityNewNameExprPsiImpl::class.java, XQuery)
    val SOURCE_EXPR: IElementType = ICompositeElementType("XQUERY_SOURCE_EXPR", UpdateFacilitySourceExprPsiImpl::class.java, XQuery)
    val TARGET_EXPR: IElementType = ICompositeElementType("XQUERY_TARGET_EXPR", UpdateFacilityTargetExprPsiImpl::class.java, XQuery)
    val INSERT_EXPR_TARGET_CHOICE: IElementType = ICompositeElementType("XQUERY_INSERT_EXPR_TARGET_CHOICE", UpdateFacilityInsertExprTargetChoicePsiImpl::class.java, XQuery)

    // endregion
    // region Update Facility 3.0

    val COMPATIBILITY_ANNOTATION: IElementType = ICompositeElementType("XQUERY_COMPATIBILITY_ANNOTATION", UpdateFacilityCompatibilityAnnotationPsiImpl::class.java, XQuery)

    val COPY_MODIFY_EXPR: IElementType = ICompositeElementType("XQUERY_COPY_MODIFY_EXPR", UpdateFacilityCopyModifyExprPsiImpl::class.java, XQuery)
    val UPDATING_FUNCTION_CALL: IElementType = ICompositeElementType("XQUERY_UPDATING_FUNCTION_CALL", UpdateFacilityUpdatingFunctionCallPsiImpl::class.java, XQuery)

    val TRANSFORM_WITH_EXPR: IElementType = ICompositeElementType("XQUERY_TRANSFORM_WITH_EXPR", UpdateFacilityTransformWithExprPsiImpl::class.java, XQuery)

    // endregion
    // region Full Text 1.0

    val FT_OPTION_DECL: IElementType = ICompositeElementType("XQUERY_FT_OPTION_DECL", FTOptionDeclPsiImpl::class.java, XQuery)
    val FT_MATCH_OPTIONS: IElementType = ICompositeElementType("XQUERY_FT_MATCH_OPTIONS", FTMatchOptionsPsiImpl::class.java, XQuery)
    val FT_CASE_OPTION: IElementType = ICompositeElementType("XQUERY_FT_CASE_OPTION", FTCaseOptionPsiImpl::class.java, XQuery)
    val FT_DIACRITICS_OPTION: IElementType = ICompositeElementType("XQUERY_FT_DIACRITICS_OPTION", FTDiacriticsOptionPsiImpl::class.java, XQuery)
    val FT_EXTENSION_OPTION: IElementType = ICompositeElementType("XQUERY_FT_EXTENSION_OPTION", FTExtensionOptionPsiImpl::class.java, XQuery)
    val FT_LANGUAGE_OPTION: IElementType = ICompositeElementType("XQUERY_FT_LANGUAGE_OPTION", FTLanguageOptionPsiImpl::class.java, XQuery)
    val FT_STEM_OPTION: IElementType = ICompositeElementType("XQUERY_FT_STEM_OPTION", FTStemOptionPsiImpl::class.java, XQuery)
    val FT_STOP_WORD_OPTION: IElementType = ICompositeElementType("XQUERY_FT_STOP_WORD_OPTION", FTStopWordOptionPsiImpl::class.java, XQuery)
    val FT_THESAURUS_OPTION: IElementType = ICompositeElementType("XQUERY_FT_THESAURUS_OPTION", FTThesaurusOptionPsiImpl::class.java, XQuery)
    val FT_WILDCARD_OPTION: IElementType = ICompositeElementType("XQUERY_FT_WILDCARD_OPTION", FTWildCardOptionPsiImpl::class.java, XQuery)

    val FT_THESAURUS_ID: IElementType = ICompositeElementType("XQUERY_FT_THESAURUS_ID", FTThesaurusIDPsiImpl::class.java, XQuery)
    val FT_LITERAL_RANGE: IElementType = ICompositeElementType("XQUERY_FT_LITERAL_RANGE", FTLiteralRangePsiImpl::class.java, XQuery)

    val FT_STOP_WORDS: IElementType = ICompositeElementType("XQUERY_FT_STOP_WORDS", FTStopWordsPsiImpl::class.java, XQuery)
    val FT_STOP_WORDS_INCL_EXCL: IElementType = ICompositeElementType("XQUERY_FT_STOP_WORDS_INCL_EXCL", FTStopWordsInclExclPsiImpl::class.java, XQuery)

    val FT_SCORE_VAR: IElementType = ICompositeElementType("XQUERY_FT_SCORE_VAR", FTScoreVarPsiImpl::class.java, XQuery)

    val FT_CONTAINS_EXPR: IElementType = ICompositeElementType("XQUERY_FT_CONTAINS_EXPR", FTContainsExprPsiImpl::class.java, XQuery)
    val FT_SELECTION: IElementType = ICompositeElementType("XQUERY_FT_SELECTION", FTSelectionPsiImpl::class.java, XQuery)
    val FT_OR: IElementType = ICompositeElementType("XQUERY_FT_OR", FTOrPsiImpl::class.java, XQuery)
    val FT_AND: IElementType = ICompositeElementType("XQUERY_FT_AND", FTAndPsiImpl::class.java, XQuery)
    val FT_MILD_NOT: IElementType = ICompositeElementType("XQUERY_FT_MILD_NOT", FTMildNotPsiImpl::class.java, XQuery)
    val FT_UNARY_NOT: IElementType = ICompositeElementType("XQUERY_FT_UNARY_NOT", FTUnaryNotPsiImpl::class.java, XQuery)
    val FT_PRIMARY_WITH_OPTIONS: IElementType = ICompositeElementType("XQUERY_FT_PRIMARY_WITH_OPTIONS", FTPrimaryWithOptionsPsiImpl::class.java, XQuery)
    val FT_PRIMARY: IElementType = ICompositeElementType("XQUERY_FT_PRIMARY", FTPrimaryPsiImpl::class.java, XQuery)
    val FT_WORDS: IElementType = ICompositeElementType("XQUERY_FT_WORDS", FTWordsPsiImpl::class.java, XQuery)
    val FT_WORDS_VALUE: IElementType = ICompositeElementType("XQUERY_FT_WORDS_VALUE", FTWordsValuePsiImpl::class.java, XQuery)

    val FT_EXTENSION_SELECTION: IElementType = ICompositeElementType("XQUERY_FT_EXTENSION_SELECTION", FTExtensionSelectionPsiImpl::class.java, XQuery)
    val FT_ANYALL_OPTION: IElementType = ICompositeElementType("XQUERY_FT_ANYALL_OPTION", FTAnyallOptionPsiImpl::class.java, XQuery)
    val FT_TIMES: IElementType = ICompositeElementType("XQUERY_FT_TIMES", FTTimesPsiImpl::class.java, XQuery)
    val FT_RANGE: IElementType = ICompositeElementType("XQUERY_FT_RANGE", FTRangePsiImpl::class.java, XQuery)
    val FT_WEIGHT: IElementType = ICompositeElementType("XQUERY_FT_WEIGHT", FTWeightPsiImpl::class.java, XQuery)

    val FT_ORDER: IElementType = ICompositeElementType("XQUERY_FT_ORDER", FTOrderPsiImpl::class.java, XQuery)
    val FT_WINDOW: IElementType = ICompositeElementType("XQUERY_FT_WINDOW", FTWindowPsiImpl::class.java, XQuery)
    val FT_DISTANCE: IElementType = ICompositeElementType("XQUERY_FT_DISTANCE", FTDistancePsiImpl::class.java, XQuery)
    val FT_SCOPE: IElementType = ICompositeElementType("XQUERY_FT_SCOPE", FTScopePsiImpl::class.java, XQuery)
    val FT_CONTENT: IElementType = ICompositeElementType("XQUERY_FT_CONTENT", FTContentPsiImpl::class.java, XQuery)

    val FT_UNIT: IElementType = ICompositeElementType("XQUERY_FT_UNIT", FTUnitPsiImpl::class.java, XQuery)
    val FT_BIG_UNIT: IElementType = ICompositeElementType("XQUERY_FT_BIG_UNIT", FTBigUnitPsiImpl::class.java, XQuery)

    val FT_IGNORE_OPTION: IElementType = ICompositeElementType("XQUERY_FT_IGNORE_OPTION", FTIgnoreOptionPsiImpl::class.java, XQuery)

    // endregion
    // region Scripting Extension 1.0

    val CONCAT_EXPR: IElementType = ICompositeElementType("XQUERY_CONCAT_EXPR", ScriptingConcatExprPsiImpl::class.java, XQuery)

    val COMPATBILITY_ANNOTATION_SCRIPTING: IElementType = ICompositeElementType("XQUERY_COMPATBILITY_ANNOTATION_SCRIPTING", ScriptingCompatibilityAnnotationPsiImpl::class.java, XQuery)

    val BLOCK: IElementType = ICompositeElementType("XQUERY_BLOCK", ScriptingBlockPsiImpl::class.java, XQuery)
    val BLOCK_BODY: IElementType = ICompositeElementType("XQUERY_BLOCK_BODY", ScriptingBlockBodyPsiImpl::class.java, XQuery)

    val BLOCK_DECLS: IElementType = ICompositeElementType("XQUERY_BLOCK_DECLS", ScriptingBlockDeclsPsiImpl::class.java, XQuery)
    val BLOCK_VAR_DECL: IElementType = ICompositeElementType("XQUERY_BLOCK_VAR_DECL", ScriptingBlockVarDeclPsiImpl::class.java, XQuery)
    val BLOCK_VAR_DECL_ENTRY: IElementType = ICompositeElementType("XQUERY_BLOCK_VAR_DECL_ENTRY", ScriptingBlockVarDeclEntryPsiImpl::class.java, XQuery)

    val BLOCK_EXPR: IElementType = ICompositeElementType("XQUERY_BLOCK_EXPR", ScriptingBlockExprPsiImpl::class.java, XQuery)
    val ASSIGNMENT_EXPR: IElementType = ICompositeElementType("XQUERY_ASSIGNMENT_EXPR", ScriptingAssignmentExprPsiImpl::class.java, XQuery)
    val EXIT_EXPR: IElementType = ICompositeElementType("XQUERY_EXIT_EXPR", ScriptingExitExprPsiImpl::class.java, XQuery)

    val WHILE_EXPR: IElementType = ICompositeElementType("XQUERY_WHILE_EXPR", ScriptingWhileExprPsiImpl::class.java, XQuery)
    val WHILE_BODY: IElementType = ICompositeElementType("XQUERY_WHILE_BODY", ScriptingWhileBodyPsiImpl::class.java, XQuery)

    // endregion
    // region MarkLogic 6.0

    val TRANSACTION_SEPARATOR: IElementType = ICompositeElementType("XQUERY_TRANSACTION_SEPARATOR", MarkLogicTransactionSeparatorPsiImpl::class.java, XQuery)

    val COMPATIBILITY_ANNOTATION_MARKLOGIC: IElementType = ICompositeElementType("XQUERY_COMPATIBILITY_ANNOTATION_MARKLOGIC", MarkLogicCompatibilityAnnotationPsiImpl::class.java, XQuery)
    val STYLESHEET_IMPORT: IElementType = ICompositeElementType("XQUERY_STYLESHEET_IMPORT", MarkLogicStylesheetImportPsiImpl::class.java, XQuery)

    val BINARY_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_BINARY_CONSTRUCTOR", MarkLogicBinaryConstructorPsiImpl::class.java, XQuery)
    val BINARY_TEST: IElementType = ICompositeElementType("XQUERY_BINARY_TEST", MarkLogicBinaryTestPsiImpl::class.java, XQuery)

    // endregion
    // region MarkLogic 7.0

    val ATTRIBUTE_DECL_TEST: IElementType = ICompositeElementType("XQUERY_ATTRIBUTE_DECL_TEST", MarkLogicAttributeDeclTestPsiImpl::class.java, XQuery)
    val COMPLEX_TYPE_TEST: IElementType = ICompositeElementType("XQUERY_COMPLEX_TYPE_TEST", MarkLogicComplexTypeTestPsiImpl::class.java, XQuery)
    val ELEMENT_DECL_TEST: IElementType = ICompositeElementType("XQUERY_ELEMENT_DECL_TEST", MarkLogicElementDeclTestPsiImpl::class.java, XQuery)
    val SCHEMA_COMPONENT_TEST: IElementType = ICompositeElementType("XQUERY_SCHEMA_COMPONENT_TEST", MarkLogicSchemaComponentTestPsiImpl::class.java, XQuery)
    val SCHEMA_PARTICLE_TEST: IElementType = ICompositeElementType("XQUERY_SCHEMA_PARTICLE_TEST", MarkLogicSchemaParticleTestPsiImpl::class.java, XQuery)
    val SCHEMA_ROOT_TEST: IElementType = ICompositeElementType("XQUERY_SCHEMA_ROOT_TEST", MarkLogicSchemaRootTestPsiImpl::class.java, XQuery)
    val SCHEMA_TYPE_TEST: IElementType = ICompositeElementType("XQUERY_SCHEMA_TYPE_TEST", MarkLogicSchemaTypeTestPsiImpl::class.java, XQuery)
    val SIMPLE_TYPE_TEST: IElementType = ICompositeElementType("XQUERY_SIMPLE_TYPE_TEST", MarkLogicSimpleTypeTestPsiImpl::class.java, XQuery)

    // endregion
    // region MarkLogic 8.0

    val SCHEMA_FACET_TEST: IElementType = ICompositeElementType("XQUERY_SCHEMA_FACET_TEST", MarkLogicSchemaFacetTestPsiImpl::class.java, XQuery)

    val ARRAY_TEST: IElementType = ICompositeElementType("XQUERY_ARRAY_TEST", MarkLogicArrayTestPsiImpl::class.java, XQuery)

    val BOOLEAN_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_BOOLEAN_CONSTRUCTOR", MarkLogicBooleanConstructorPsiImpl::class.java, XQuery)
    val BOOLEAN_TEST: IElementType = ICompositeElementType("XQUERY_BOOLEAN_TEST", MarkLogicBooleanTestPsiImpl::class.java, XQuery)

    val NULL_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_NULL_CONSTRUCTOR", MarkLogicNullConstructorPsiImpl::class.java, XQuery)
    val NULL_TEST: IElementType = ICompositeElementType("XQUERY_NULL_TEST", MarkLogicNullTestPsiImpl::class.java, XQuery)

    val NUMBER_CONSTRUCTOR: IElementType = ICompositeElementType("XQUERY_NUMBER_CONSTRUCTOR", MarkLogicNumberConstructorPsiImpl::class.java, XQuery)
    val NUMBER_TEST: IElementType = ICompositeElementType("XQUERY_NUMBER_TEST", MarkLogicNumberTestPsiImpl::class.java, XQuery)

    val MAP_TEST: IElementType = ICompositeElementType("XQUERY_MAP_TEST", MarkLogicMapTestPsiImpl::class.java, XQuery)

    // endregion
    // region BaseX

    val FT_FUZZY_OPTION: IElementType = ICompositeElementType("XQUERY_FT_FUZZY_OPTION", BaseXFTFuzzyOptionPsiImpl::class.java, XQuery)

    val UPDATE_EXPR: IElementType = ICompositeElementType("XQUERY_UPDATE_EXPR", BaseXUpdateExprPsiImpl::class.java, XQuery)

    // endregion
    // region Saxon

    val TYPE_DECL: IElementType = ICompositeElementType("XQUERY_TYPE_DECL", SaxonTypeDeclImpl::class.java, XQuery)

    val TUPLE_TYPE: IElementType = ICompositeElementType("XQUERY_TUPLE_TYPE", SaxonTupleTypeImpl::class.java, XQuery)
    val TUPLE_FIELD: IElementType = ICompositeElementType("XQUERY_TUPLE_FIELD", SaxonTupleFieldImpl::class.java, XQuery)

    val UNION_TYPE: IElementType = ICompositeElementType("XQUERY_UNION_TYPE", SaxonUnionTypeImpl::class.java, XQuery)

    // endregion

    val WHITESPACE_OR_COMMENT = TokenSet.create(XQueryTokenType.WHITE_SPACE, XQueryElementType.COMMENT)
}
