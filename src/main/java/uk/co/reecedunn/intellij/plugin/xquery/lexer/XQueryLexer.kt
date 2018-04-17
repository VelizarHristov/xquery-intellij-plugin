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
package uk.co.reecedunn.intellij.plugin.xquery.lexer

import uk.co.reecedunn.intellij.plugin.core.lexer.CharacterClass
import uk.co.reecedunn.intellij.plugin.core.lexer.CodePointRange
import uk.co.reecedunn.intellij.plugin.core.lexer.LexerImpl
import uk.co.reecedunn.intellij.plugin.core.lexer.STATE_DEFAULT

// region State Constants

private const val STATE_STRING_LITERAL_QUOTE = 1
private const val STATE_STRING_LITERAL_APOSTROPHE = 2
private const val STATE_DOUBLE_EXPONENT = 3
const val STATE_XQUERY_COMMENT = 4
private const val STATE_XML_COMMENT = 5
private const val STATE_UNEXPECTED_END_OF_BLOCK = 6
private const val STATE_CDATA_SECTION = 7
private const val STATE_PRAGMA_PRE_QNAME = 8
private const val STATE_PRAGMA_QNAME = 9
private const val STATE_PRAGMA_CONTENTS = 10
private const val STATE_DIR_ELEM_CONSTRUCTOR = 11
private const val STATE_DIR_ELEM_CONSTRUCTOR_CLOSING = 12
private const val STATE_DIR_ATTRIBUTE_VALUE_QUOTE = 13
private const val STATE_DIR_ATTRIBUTE_VALUE_APOSTROPHE = 14
private const val STATE_DEFAULT_ATTRIBUTE_QUOT = 15
private const val STATE_DEFAULT_ATTRIBUTE_APOSTROPHE = 16
private const val STATE_DIR_ELEM_CONTENT = 17
private const val STATE_DEFAULT_ELEM_CONTENT = 18
private const val STATE_XML_COMMENT_ELEM_CONTENT = 19
private const val STATE_CDATA_SECTION_ELEM_CONTENT = 20
private const val STATE_PROCESSING_INSTRUCTION = 21
private const val STATE_PROCESSING_INSTRUCTION_CONTENTS = 22
private const val STATE_PROCESSING_INSTRUCTION_ELEM_CONTENT = 23
private const val STATE_PROCESSING_INSTRUCTION_CONTENTS_ELEM_CONTENT = 24
private const val STATE_DIR_ATTRIBUTE_LIST = 25
private const val STATE_BRACED_URI_LITERAL = 26
private const val STATE_STRING_CONSTRUCTOR_CONTENTS = 27
private const val STATE_DEFAULT_STRING_INTERPOLATION = 28
const val STATE_MAYBE_DIR_ELEM_CONSTRUCTOR = 29
const val STATE_START_DIR_ELEM_CONSTRUCTOR = 30
private const val STATE_BRACED_URI_LITERAL_PRAGMA = 31

// endregion
// region Keywords

private val KEYWORDS = mapOf(
        "after" to XQueryTokenType.K_AFTER, // Update Facility 1.0
        "all" to XQueryTokenType.K_ALL, // Full Text 1.0
        "allowing" to XQueryTokenType.K_ALLOWING, // XQuery 3.0
        "ancestor" to XQueryTokenType.K_ANCESTOR,
        "ancestor-or-self" to XQueryTokenType.K_ANCESTOR_OR_SELF,
        "and" to XQueryTokenType.K_AND,
        "any" to XQueryTokenType.K_ANY, // Full Text 1.0
        "array" to XQueryTokenType.K_ARRAY, // XQuery 3.1
        "array-node" to XQueryTokenType.K_ARRAY_NODE, // MarkLogic 8.0
        "as" to XQueryTokenType.K_AS,
        "ascending" to XQueryTokenType.K_ASCENDING,
        "assignable" to XQueryTokenType.K_ASSIGNABLE, // Scripting Extension 1.0
        "at" to XQueryTokenType.K_AT,
        "attribute" to XQueryTokenType.K_ATTRIBUTE,
        "attribute-decl" to XQueryTokenType.K_ATTRIBUTE_DECL, // MarkLogic 7.0
        "base-uri" to XQueryTokenType.K_BASE_URI,
        "before" to XQueryTokenType.K_BEFORE, // Update Facility 1.0
        "binary" to XQueryTokenType.K_BINARY, // MarkLogic 6.0
        "block" to XQueryTokenType.K_BLOCK, // Scripting Extension 1.0
        "boolean-node" to XQueryTokenType.K_BOOLEAN_NODE, // MarkLogic 8.0
        "boundary-space" to XQueryTokenType.K_BOUNDARY_SPACE,
        "by" to XQueryTokenType.K_BY,
        "case" to XQueryTokenType.K_CASE,
        "cast" to XQueryTokenType.K_CAST,
        "castable" to XQueryTokenType.K_CASTABLE,
        "catch" to XQueryTokenType.K_CATCH, // XQuery 3.0
        "child" to XQueryTokenType.K_CHILD,
        "collation" to XQueryTokenType.K_COLLATION,
        "comment" to XQueryTokenType.K_COMMENT,
        "complex-type" to XQueryTokenType.K_COMPLEX_TYPE, // MarkLogic 7.0
        "construction" to XQueryTokenType.K_CONSTRUCTION,
        "contains" to XQueryTokenType.K_CONTAINS, // Full Text 1.0
        "content" to XQueryTokenType.K_CONTENT, // Full Text 1.0
        "context" to XQueryTokenType.K_CONTEXT, // XQuery 3.0
        "copy" to XQueryTokenType.K_COPY, // Update Facility 1.0
        "copy-namespaces" to XQueryTokenType.K_COPY_NAMESPACES,
        "count" to XQueryTokenType.K_COUNT, // XQuery 3.0
        "decimal-format" to XQueryTokenType.K_DECIMAL_FORMAT, // XQuery 3.0
        "decimal-separator" to XQueryTokenType.K_DECIMAL_SEPARATOR, // XQuery 3.0
        "declare" to XQueryTokenType.K_DECLARE,
        "default" to XQueryTokenType.K_DEFAULT,
        "delete" to XQueryTokenType.K_DELETE, // Update Facility 1.0
        "descendant" to XQueryTokenType.K_DESCENDANT,
        "descendant-or-self" to XQueryTokenType.K_DESCENDANT_OR_SELF,
        "descending" to XQueryTokenType.K_DESCENDING,
        "diacritics" to XQueryTokenType.K_DIACRITICS, // Full Text 1.0
        "different" to XQueryTokenType.K_DIFFERENT, // Full Text 1.0
        "digit" to XQueryTokenType.K_DIGIT, // XQuery 3.0
        "distance" to XQueryTokenType.K_DISTANCE, // Full Text 1.0
        "div" to XQueryTokenType.K_DIV,
        "document" to XQueryTokenType.K_DOCUMENT,
        "document-node" to XQueryTokenType.K_DOCUMENT_NODE,
        "element" to XQueryTokenType.K_ELEMENT,
        "element-decl" to XQueryTokenType.K_ELEMENT_DECL, // MarkLogic 7.0
        "else" to XQueryTokenType.K_ELSE,
        "empty" to XQueryTokenType.K_EMPTY,
        "empty-sequence" to XQueryTokenType.K_EMPTY_SEQUENCE,
        "encoding" to XQueryTokenType.K_ENCODING,
        "end" to XQueryTokenType.K_END, // XQuery 3.0
        "entire" to XQueryTokenType.K_ENTIRE, // Full Text 1.0
        "eq" to XQueryTokenType.K_EQ,
        "every" to XQueryTokenType.K_EVERY,
        "exactly" to XQueryTokenType.K_EXACTLY, // Full Text 1.0
        "except" to XQueryTokenType.K_EXCEPT,
        "exit" to XQueryTokenType.K_EXIT, // Scripting Extension 1.0
        "exponent-separator" to XQueryTokenType.K_EXPONENT_SEPARATOR, // XQuery 3.1
        "external" to XQueryTokenType.K_EXTERNAL,
        "first" to XQueryTokenType.K_FIRST, // Update Facility 1.0
        "following" to XQueryTokenType.K_FOLLOWING,
        "following-sibling" to XQueryTokenType.K_FOLLOWING_SIBLING,
        "for" to XQueryTokenType.K_FOR,
        "from" to XQueryTokenType.K_FROM, // Full Text 1.0
        "ft-option" to XQueryTokenType.K_FT_OPTION, // Full Text 1.0
        "ftand" to XQueryTokenType.K_FTAND, // Full Text 1.0
        "ftnot" to XQueryTokenType.K_FTNOT, // Full Text 1.0
        "ftor" to XQueryTokenType.K_FTOR, // Full Text 1.0
        "function" to XQueryTokenType.K_FUNCTION,
        "fuzzy" to XQueryTokenType.K_FUZZY, // BaseX 6.1
        "ge" to XQueryTokenType.K_GE,
        "greatest" to XQueryTokenType.K_GREATEST,
        "group" to XQueryTokenType.K_GROUP, // XQuery 3.0
        "grouping-separator" to XQueryTokenType.K_GROUPING_SEPARATOR, // XQuery 3.0
        "gt" to XQueryTokenType.K_GT,
        "idiv" to XQueryTokenType.K_IDIV,
        "if" to XQueryTokenType.K_IF,
        "import" to XQueryTokenType.K_IMPORT,
        "in" to XQueryTokenType.K_IN,
        "infinity" to XQueryTokenType.K_INFINITY, // XQuery 3.0
        "inherit" to XQueryTokenType.K_INHERIT,
        "insensitive" to XQueryTokenType.K_INSENSITIVE, // Full Text 1.0
        "insert" to XQueryTokenType.K_INSERT, // Update Facility 1.0
        "instance" to XQueryTokenType.K_INSTANCE,
        "intersect" to XQueryTokenType.K_INTERSECT,
        "into" to XQueryTokenType.K_INTO, // Update Facility 1.0
        "invoke" to XQueryTokenType.K_INVOKE, // Update Facility 3.0
        "is" to XQueryTokenType.K_IS,
        "item" to XQueryTokenType.K_ITEM,
        "language" to XQueryTokenType.K_LANGUAGE, // Full Text 1.0
        "last" to XQueryTokenType.K_LAST, // Update Facility 1.0
        "lax" to XQueryTokenType.K_LAX,
        "le" to XQueryTokenType.K_LE,
        "least" to XQueryTokenType.K_LEAST,
        "let" to XQueryTokenType.K_LET,
        "levels" to XQueryTokenType.K_LEVELS, // Full Text 1.0
        "lowercase" to XQueryTokenType.K_LOWERCASE, // Full Text 1.0
        "lt" to XQueryTokenType.K_LT,
        "map" to XQueryTokenType.K_MAP, // XQuery 3.1
        "minus-sign" to XQueryTokenType.K_MINUS_SIGN, // XQuery 3.0
        "mod" to XQueryTokenType.K_MOD,
        "modify" to XQueryTokenType.K_MODIFY, // Update Facility 1.0
        "module" to XQueryTokenType.K_MODULE,
        "most" to XQueryTokenType.K_MOST, // Full Text 1.0
        "namespace" to XQueryTokenType.K_NAMESPACE,
        "namespace-node" to XQueryTokenType.K_NAMESPACE_NODE, // XQuery 3.0
        "NaN" to XQueryTokenType.K_NAN, // XQuery 3.0
        "ne" to XQueryTokenType.K_NE,
        "next" to XQueryTokenType.K_NEXT, // XQuery 3.0
        "no" to XQueryTokenType.K_NO, // Full Text 1.0
        "no-inherit" to XQueryTokenType.K_NO_INHERIT,
        "no-preserve" to XQueryTokenType.K_NO_PRESERVE,
        "node" to XQueryTokenType.K_NODE,
        "nodes" to XQueryTokenType.K_NODES, // Update Facility 1.0
        "non-deterministic" to XQueryTokenType.K_NON_DETERMINISTIC, // BaseX 8.4
        "not" to XQueryTokenType.K_NOT, // Full Text 1.0
        "null-node" to XQueryTokenType.K_NULL_NODE, // MarkLogic 8.0
        "number-node" to XQueryTokenType.K_NUMBER_NODE, // MarkLogic 8.0
        "object-node" to XQueryTokenType.K_OBJECT_NODE, // MarkLogic 8.0
        "occurs" to XQueryTokenType.K_OCCURS, // Full Text 1.0
        "of" to XQueryTokenType.K_OF,
        "only" to XQueryTokenType.K_ONLY, // XQuery 3.0
        "option" to XQueryTokenType.K_OPTION,
        "or" to XQueryTokenType.K_OR,
        "order" to XQueryTokenType.K_ORDER,
        "ordered" to XQueryTokenType.K_ORDERED,
        "ordering" to XQueryTokenType.K_ORDERING,
        "paragraph" to XQueryTokenType.K_PARAGRAPH, // Full Text 1.0
        "paragraphs" to XQueryTokenType.K_PARAGRAPHS, // Full Text 1.0
        "parent" to XQueryTokenType.K_PARENT,
        "pattern-separator" to XQueryTokenType.K_PATTERN_SEPARATOR, // XQuery 3.0
        "per-mille" to XQueryTokenType.K_PER_MILLE, // XQuery 3.0
        "percent" to XQueryTokenType.K_PERCENT, // XQuery 3.0
        "phrase" to XQueryTokenType.K_PHRASE, // Full Text 1.0
        "preceding" to XQueryTokenType.K_PRECEDING,
        "preceding-sibling" to XQueryTokenType.K_PRECEDING_SIBLING,
        "preserve" to XQueryTokenType.K_PRESERVE,
        "previous" to XQueryTokenType.K_PREVIOUS, // XQuery 3.0
        "private" to XQueryTokenType.K_PRIVATE, // MarkLogic 6.0
        "processing-instruction" to XQueryTokenType.K_PROCESSING_INSTRUCTION,
        "property" to XQueryTokenType.K_PROPERTY, // MarkLogic 6.0
        "public" to XQueryTokenType.K_PUBLIC, // XQuery 3.0 (§4.15 -- Annotations)
        "relationship" to XQueryTokenType.K_RELATIONSHIP, // Full Text 1.0
        "rename" to XQueryTokenType.K_RENAME, // Update Facility 1.0
        "replace" to XQueryTokenType.K_REPLACE, // Update Facility 1.0
        "return" to XQueryTokenType.K_RETURN,
        "returning" to XQueryTokenType.K_RETURNING, // Scripting Extension 1.0
        "revalidation" to XQueryTokenType.K_REVALIDATION, // Update Facility 1.0
        "same" to XQueryTokenType.K_SAME, // Full Text 1.0
        "satisfies" to XQueryTokenType.K_SATISFIES,
        "schema" to XQueryTokenType.K_SCHEMA,
        "schema-attribute" to XQueryTokenType.K_SCHEMA_ATTRIBUTE,
        "schema-component" to XQueryTokenType.K_SCHEMA_COMPONENT, // MarkLogic 7.0
        "schema-element" to XQueryTokenType.K_SCHEMA_ELEMENT,
        "schema-facet" to XQueryTokenType.K_SCHEMA_FACET, // MarkLogic 8.0
        "schema-particle" to XQueryTokenType.K_SCHEMA_PARTICLE, // MarkLogic 7.0
        "schema-root" to XQueryTokenType.K_SCHEMA_ROOT, // MarkLogic 7.0
        "schema-type" to XQueryTokenType.K_SCHEMA_TYPE, // MarkLogic 7.0
        "score" to XQueryTokenType.K_SCORE, // Full Text 1.0
        "self" to XQueryTokenType.K_SELF,
        "sensitive" to XQueryTokenType.K_SENSITIVE, // Full Text 1.0
        "sentence" to XQueryTokenType.K_SENTENCE, // Full Text 1.0
        "sentences" to XQueryTokenType.K_SENTENCES, // Full Text 1.0
        "sequential" to XQueryTokenType.K_SEQUENTIAL, // Scripting Extension 1.0
        "simple" to XQueryTokenType.K_SIMPLE, // Scripting Extension 1.0
        "simple-type" to XQueryTokenType.K_SIMPLE_TYPE, // MarkLogic 7.0
        "skip" to XQueryTokenType.K_SKIP, // Update Facility 1.0
        "sliding" to XQueryTokenType.K_SLIDING, // XQuery 3.0
        "some" to XQueryTokenType.K_SOME,
        "stable" to XQueryTokenType.K_STABLE,
        "start" to XQueryTokenType.K_START, // XQuery 3.0
        "stemming" to XQueryTokenType.K_STEMMING, // Full Text 1.0
        "stop" to XQueryTokenType.K_STOP, // Full Text 1.0
        "strict" to XQueryTokenType.K_STRICT,
        "strip" to XQueryTokenType.K_STRIP,
        "stylesheet" to XQueryTokenType.K_STYLESHEET, // MarkLogic 6.0
        "switch" to XQueryTokenType.K_SWITCH, // XQuery 3.0
        "text" to XQueryTokenType.K_TEXT,
        "then" to XQueryTokenType.K_THEN,
        "thesaurus" to XQueryTokenType.K_THESAURUS, // Full Text 1.0
        "times" to XQueryTokenType.K_TIMES, // Full Text 1.0
        "to" to XQueryTokenType.K_TO,
        "transform" to XQueryTokenType.K_TRANSFORM, // Update Facility 3.0
        "treat" to XQueryTokenType.K_TREAT,
        "try" to XQueryTokenType.K_TRY, // XQuery 3.0
        "tumbling" to XQueryTokenType.K_TUMBLING, // XQuery 3.0
        "tuple" to XQueryTokenType.K_TUPLE, // Saxon 9.8
        "type" to XQueryTokenType.K_TYPE, // XQuery 3.0
        "typeswitch" to XQueryTokenType.K_TYPESWITCH,
        "unassignable" to XQueryTokenType.K_UNASSIGNABLE, // Scripting Extension 1.0
        "union" to XQueryTokenType.K_UNION,
        "unordered" to XQueryTokenType.K_UNORDERED,
        "update" to XQueryTokenType.K_UPDATE, // BaseX 7.8
        "updating" to XQueryTokenType.K_UPDATING, // Update Facility 1.0
        "uppercase" to XQueryTokenType.K_UPPERCASE, // Full Text 1.0
        "using" to XQueryTokenType.K_USING, // Full Text 1.0
        "validate" to XQueryTokenType.K_VALIDATE,
        "value" to XQueryTokenType.K_VALUE, // Update Facility 1.0
        "variable" to XQueryTokenType.K_VARIABLE,
        "version" to XQueryTokenType.K_VERSION,
        "weight" to XQueryTokenType.K_WEIGHT, // Full Text 1.0
        "when" to XQueryTokenType.K_WHEN, // XQuery 3.0
        "where" to XQueryTokenType.K_WHERE,
        "while" to XQueryTokenType.K_WHILE, // Scripting Extension 1.0
        "wildcards" to XQueryTokenType.K_WILDCARDS, // Full Text 1.0
        "window" to XQueryTokenType.K_WINDOW, // XQuery 3.0; Full Text 1.0
        "with" to XQueryTokenType.K_WITH, // Update Facility 1.0
        "without" to XQueryTokenType.K_WITHOUT, // Full Text 1.0
        "word" to XQueryTokenType.K_WORD, // Full Text 1.0
        "words" to XQueryTokenType.K_WORDS, // Full Text 1.0
        "xquery" to XQueryTokenType.K_XQUERY,
        "zero-digit" to XQueryTokenType.K_ZERO_DIGIT) // XQuery 3.0

// endregion

class XQueryLexer : LexerImpl(STATE_DEFAULT) {
    // region States

    private fun stateDefault(mState: Int) {
        var c = mTokenRange.codePoint
        var cc = CharacterClass.getCharClass(c)
        when (cc) {
            CharacterClass.WHITESPACE -> {
                mTokenRange.match()
                while (CharacterClass.getCharClass(mTokenRange.codePoint) == CharacterClass.WHITESPACE)
                    mTokenRange.match()
                mType = XQueryTokenType.WHITE_SPACE
            }
            CharacterClass.DOT -> {
                mTokenRange.save()
                mTokenRange.match()
                cc = CharacterClass.getCharClass(mTokenRange.codePoint)
                if (cc == CharacterClass.DOT) {
                    mTokenRange.match()
                    mType = XQueryTokenType.PARENT_SELECTOR
                    return
                } else if (cc != CharacterClass.DIGIT) {
                    mType = XQueryTokenType.DOT
                    return
                } else {
                    mTokenRange.restore()
                    mType = XQueryTokenType.DECIMAL_LITERAL
                }
                mTokenRange.match()
                while (CharacterClass.getCharClass(mTokenRange.codePoint) == CharacterClass.DIGIT)
                    mTokenRange.match()
                c = mTokenRange.codePoint
                if (c == 'e'.toInt() || c == 'E'.toInt()) {
                    mTokenRange.save()
                    mTokenRange.match()
                    c = mTokenRange.codePoint
                    if (c == '+'.toInt() || c == '-'.toInt()) {
                        mTokenRange.match()
                        c = mTokenRange.codePoint
                    }
                    if (CharacterClass.getCharClass(c) == CharacterClass.DIGIT) {
                        mTokenRange.match()
                        while (CharacterClass.getCharClass(mTokenRange.codePoint) == CharacterClass.DIGIT)
                            mTokenRange.match()
                        mType = XQueryTokenType.DOUBLE_LITERAL
                    } else {
                        pushState(STATE_DOUBLE_EXPONENT)
                        mTokenRange.restore()
                    }
                }
            }
            CharacterClass.DIGIT -> {
                mTokenRange.match()
                while (CharacterClass.getCharClass(mTokenRange.codePoint) == CharacterClass.DIGIT)
                    mTokenRange.match()
                mType = if (CharacterClass.getCharClass(mTokenRange.codePoint) == CharacterClass.DOT) {
                    mTokenRange.match()
                    while (CharacterClass.getCharClass(mTokenRange.codePoint) == CharacterClass.DIGIT)
                        mTokenRange.match()
                    XQueryTokenType.DECIMAL_LITERAL
                } else {
                    XQueryTokenType.INTEGER_LITERAL
                }
                c = mTokenRange.codePoint
                if (c == 'e'.toInt() || c == 'E'.toInt()) {
                    mTokenRange.save()
                    mTokenRange.match()
                    c = mTokenRange.codePoint
                    if (c == '+'.toInt() || c == '-'.toInt()) {
                        mTokenRange.match()
                        c = mTokenRange.codePoint
                    }
                    if (CharacterClass.getCharClass(c) == CharacterClass.DIGIT) {
                        mTokenRange.match()
                        while (CharacterClass.getCharClass(mTokenRange.codePoint) == CharacterClass.DIGIT)
                            mTokenRange.match()
                        mType = XQueryTokenType.DOUBLE_LITERAL
                    } else {
                        pushState(STATE_DOUBLE_EXPONENT)
                        mTokenRange.restore()
                    }
                }
            }
            CharacterClass.END_OF_BUFFER -> mType = null
            CharacterClass.QUOTE, CharacterClass.APOSTROPHE -> {
                mTokenRange.match()
                mType = XQueryTokenType.STRING_LITERAL_START
                pushState(if (cc == CharacterClass.QUOTE) STATE_STRING_LITERAL_QUOTE else STATE_STRING_LITERAL_APOSTROPHE)
            }
            CharacterClass.NAME_START_CHAR -> {
                mTokenRange.match()
                cc = CharacterClass.getCharClass(mTokenRange.codePoint)
                if (c == 'Q'.toInt() && cc == CharacterClass.CURLY_BRACE_OPEN) {
                    mTokenRange.match()
                    mType = XQueryTokenType.BRACED_URI_LITERAL_START
                    pushState(STATE_BRACED_URI_LITERAL)
                } else {
                    while (cc == CharacterClass.NAME_START_CHAR ||
                            cc == CharacterClass.DIGIT ||
                            cc == CharacterClass.DOT ||
                            cc == CharacterClass.HYPHEN_MINUS ||
                            cc == CharacterClass.NAME_CHAR) {
                        mTokenRange.match()
                        cc = CharacterClass.getCharClass(mTokenRange.codePoint)
                    }
                    mType = KEYWORDS[tokenText] ?: XQueryTokenType.NCNAME
                }
            }
            CharacterClass.PARENTHESIS_OPEN -> {
                mTokenRange.match()
                c = mTokenRange.codePoint
                if (c == ':'.toInt()) {
                    mTokenRange.match()
                    mType = XQueryTokenType.COMMENT_START_TAG
                    pushState(STATE_XQUERY_COMMENT)
                } else if (c == '#'.toInt()) {
                    mTokenRange.match()
                    mType = XQueryTokenType.PRAGMA_BEGIN
                    pushState(STATE_PRAGMA_PRE_QNAME)
                } else {
                    mType = XQueryTokenType.PARENTHESIS_OPEN
                }
            }
            CharacterClass.PARENTHESIS_CLOSE -> {
                mTokenRange.match()
                mType = XQueryTokenType.PARENTHESIS_CLOSE
            }
            CharacterClass.COLON -> {
                mTokenRange.match()
                c = mTokenRange.codePoint
                mType = if (c == ')'.toInt()) {
                    mTokenRange.match()
                    XQueryTokenType.COMMENT_END_TAG
                } else if (c == ':'.toInt()) {
                    mTokenRange.match()
                    XQueryTokenType.AXIS_SEPARATOR
                } else if (c == '='.toInt()) {
                    mTokenRange.match()
                    XQueryTokenType.ASSIGN_EQUAL
                } else {
                    XQueryTokenType.QNAME_SEPARATOR
                }
            }
            CharacterClass.HASH -> {
                mTokenRange.match()
                mType = if (mTokenRange.codePoint == ')'.toInt()) {
                    mTokenRange.match()
                    XQueryTokenType.PRAGMA_END
                } else {
                    XQueryTokenType.FUNCTION_REF_OPERATOR
                }
            }
            CharacterClass.EXCLAMATION_MARK -> {
                mTokenRange.match()
                mType = if (mTokenRange.codePoint == '='.toInt()) {
                    mTokenRange.match()
                    XQueryTokenType.NOT_EQUAL
                } else {
                    XQueryTokenType.MAP_OPERATOR // XQuery 3.0
                }
            }
            CharacterClass.DOLLAR -> {
                mTokenRange.match()
                mType = XQueryTokenType.VARIABLE_INDICATOR
            }
            CharacterClass.ASTERISK -> {
                mTokenRange.match()
                mType = XQueryTokenType.STAR
            }
            CharacterClass.PLUS -> {
                mTokenRange.match()
                mType = XQueryTokenType.PLUS
            }
            CharacterClass.COMMA -> {
                mTokenRange.match()
                mType = XQueryTokenType.COMMA
            }
            CharacterClass.HYPHEN_MINUS -> {
                mTokenRange.match()
                c = mTokenRange.codePoint
                mType = if (c == '-'.toInt()) {
                    mTokenRange.save()
                    mTokenRange.match()
                    if (mTokenRange.codePoint == '>'.toInt()) {
                        mTokenRange.match()
                        XQueryTokenType.XML_COMMENT_END_TAG
                    } else {
                        mTokenRange.restore()
                        XQueryTokenType.MINUS
                    }
                } else {
                    XQueryTokenType.MINUS
                }
            }
            CharacterClass.SEMICOLON -> {
                mTokenRange.match()
                mType = XQueryTokenType.SEPARATOR
            }
            CharacterClass.LESS_THAN -> {
                mTokenRange.match()
                c = mTokenRange.codePoint
                if (c == '/'.toInt()) {
                    mTokenRange.match()
                    mType = XQueryTokenType.CLOSE_XML_TAG
                } else if (c == '<'.toInt()) {
                    val position = mTokenRange.end
                    mTokenRange.match()
                    matchOpenXmlTag()
                    mType = if (mType === XQueryTokenType.DIRELEM_OPEN_XML_TAG) {
                        // For when adding a DirElemConstructor before another one -- i.e. <<a/>
                        mTokenRange.seek(position)
                        XQueryTokenType.LESS_THAN
                    } else {
                        mTokenRange.seek(position)
                        mTokenRange.match()
                        XQueryTokenType.NODE_BEFORE
                    }
                } else if (c == '='.toInt()) {
                    mTokenRange.match()
                    mType = XQueryTokenType.LESS_THAN_OR_EQUAL
                } else if (c == '?'.toInt()) {
                    mTokenRange.match()
                    mType = XQueryTokenType.PROCESSING_INSTRUCTION_BEGIN
                    pushState(STATE_PROCESSING_INSTRUCTION)
                } else if (c == '!'.toInt()) {
                    mTokenRange.match()
                    if (mTokenRange.codePoint == '-'.toInt()) {
                        mTokenRange.match()
                        if (mTokenRange.codePoint == '-'.toInt()) {
                            mTokenRange.match()
                            mType = XQueryTokenType.XML_COMMENT_START_TAG
                            pushState(STATE_XML_COMMENT)
                        } else {
                            mType = XQueryTokenType.INVALID
                        }
                    } else if (mTokenRange.codePoint == '['.toInt()) {
                        mTokenRange.match()
                        if (mTokenRange.codePoint == 'C'.toInt()) {
                            mTokenRange.match()
                            if (mTokenRange.codePoint == 'D'.toInt()) {
                                mTokenRange.match()
                                if (mTokenRange.codePoint == 'A'.toInt()) {
                                    mTokenRange.match()
                                    if (mTokenRange.codePoint == 'T'.toInt()) {
                                        mTokenRange.match()
                                        if (mTokenRange.codePoint == 'A'.toInt()) {
                                            mTokenRange.match()
                                            if (mTokenRange.codePoint == '['.toInt()) {
                                                mTokenRange.match()
                                                mType = XQueryTokenType.CDATA_SECTION_START_TAG
                                                pushState(STATE_CDATA_SECTION)
                                            } else {
                                                mType = XQueryTokenType.INVALID
                                            }
                                        } else {
                                            mType = XQueryTokenType.INVALID
                                        }
                                    } else {
                                        mType = XQueryTokenType.INVALID
                                    }
                                } else {
                                    mType = XQueryTokenType.INVALID
                                }
                            } else {
                                mType = XQueryTokenType.INVALID
                            }
                        } else {
                            mType = XQueryTokenType.INVALID
                        }
                    } else {
                        mType = XQueryTokenType.INVALID
                    }
                } else {
                    if (mState == STATE_MAYBE_DIR_ELEM_CONSTRUCTOR) {
                        mType = XQueryTokenType.LESS_THAN
                    } else {
                        matchOpenXmlTag()
                    }
                }
            }
            CharacterClass.GREATER_THAN -> {
                mTokenRange.match()
                c = mTokenRange.codePoint
                mType = if (c == '>'.toInt()) {
                    mTokenRange.match()
                    XQueryTokenType.NODE_AFTER
                } else if (c == '='.toInt()) {
                    mTokenRange.match()
                    XQueryTokenType.GREATER_THAN_OR_EQUAL
                } else {
                    XQueryTokenType.GREATER_THAN
                }
            }
            CharacterClass.EQUAL -> {
                mTokenRange.match()
                c = mTokenRange.codePoint
                mType = if (c == '>'.toInt()) {
                    mTokenRange.match()
                    XQueryTokenType.ARROW
                } else {
                    XQueryTokenType.EQUAL
                }
            }
            CharacterClass.CURLY_BRACE_OPEN -> {
                mTokenRange.match()
                mType = XQueryTokenType.BLOCK_OPEN
                pushState(mState)
            }
            CharacterClass.CURLY_BRACE_CLOSE -> {
                mTokenRange.match()
                mType = if (mTokenRange.codePoint == '`'.toInt() && mState == STATE_DEFAULT_STRING_INTERPOLATION) {
                    mTokenRange.match()
                    XQueryTokenType.STRING_INTERPOLATION_CLOSE
                } else {
                    XQueryTokenType.BLOCK_CLOSE
                }
                popState()
            }
            CharacterClass.VERTICAL_BAR -> {
                mTokenRange.match()
                mType = if (mTokenRange.codePoint == '|'.toInt()) {
                    mTokenRange.match()
                    XQueryTokenType.CONCATENATION
                } else {
                    XQueryTokenType.UNION
                }
            }
            CharacterClass.FORWARD_SLASH -> {
                mTokenRange.match()
                c = mTokenRange.codePoint
                mType = if (c == '/'.toInt()) {
                    mTokenRange.match()
                    XQueryTokenType.ALL_DESCENDANTS_PATH
                } else if (c == '>'.toInt()) {
                    mTokenRange.match()
                    XQueryTokenType.SELF_CLOSING_XML_TAG
                } else {
                    XQueryTokenType.DIRECT_DESCENDANTS_PATH
                }
            }
            CharacterClass.AT_SIGN -> {
                mTokenRange.match()
                mType = XQueryTokenType.ATTRIBUTE_SELECTOR
            }
            CharacterClass.SQUARE_BRACE_OPEN -> {
                mTokenRange.match()
                mType = XQueryTokenType.SQUARE_OPEN
            }
            CharacterClass.SQUARE_BRACE_CLOSE -> {
                mTokenRange.match()
                c = mTokenRange.codePoint
                if (c == ']'.toInt()) {
                    mTokenRange.save()
                    mTokenRange.match()
                    mType = if (mTokenRange.codePoint == '>'.toInt()) {
                        mTokenRange.match()
                        XQueryTokenType.CDATA_SECTION_END_TAG
                    } else {
                        mTokenRange.restore()
                        XQueryTokenType.SQUARE_CLOSE
                    }
                } else if (c == '`'.toInt()) {
                    mTokenRange.match()
                    mType = if (mTokenRange.codePoint == '`'.toInt()) {
                        mTokenRange.match()
                        XQueryTokenType.STRING_CONSTRUCTOR_END
                    } else {
                        XQueryTokenType.INVALID
                    }
                } else {
                    mType = XQueryTokenType.SQUARE_CLOSE
                }
            }
            CharacterClass.QUESTION_MARK -> {
                mTokenRange.match()
                c = mTokenRange.codePoint
                mType = if (c == '>'.toInt()) {
                    mTokenRange.match()
                    XQueryTokenType.PROCESSING_INSTRUCTION_END
                } else {
                    XQueryTokenType.OPTIONAL
                }
            }
            CharacterClass.PERCENT -> {
                mTokenRange.match()
                mType = XQueryTokenType.ANNOTATION_INDICATOR
            }
            CharacterClass.AMPERSAND -> {
                mTokenRange.match()
                mType = XQueryTokenType.ENTITY_REFERENCE_NOT_IN_STRING
            }
            CharacterClass.BACK_TICK -> {
                mTokenRange.match()
                c = mTokenRange.codePoint
                if (c == '`'.toInt()) {
                    mTokenRange.match()
                    if (mTokenRange.codePoint == '['.toInt()) {
                        mTokenRange.match()
                        mType = XQueryTokenType.STRING_CONSTRUCTOR_START
                        pushState(STATE_STRING_CONSTRUCTOR_CONTENTS)
                    } else {
                        mType = XQueryTokenType.INVALID
                    }
                } else {
                    mType = XQueryTokenType.INVALID
                }
            }
            else -> {
                mTokenRange.match()
                mType = XQueryTokenType.BAD_CHARACTER
            }
        }
    }

    private fun stateStringLiteral(type: Char) {
        var c = mTokenRange.codePoint
        if (c == type.toInt()) {
            mTokenRange.match()
            if (mTokenRange.codePoint == type.toInt() && type != '}') {
                mTokenRange.match()
                mType = XQueryTokenType.ESCAPED_CHARACTER
            } else {
                mType = if (type == '}') XQueryTokenType.BRACED_URI_LITERAL_END else XQueryTokenType.STRING_LITERAL_END
                popState()
            }
        } else if (c == '&'.toInt()) {
            matchEntityReference(if (type == '"') STATE_STRING_LITERAL_QUOTE else STATE_STRING_LITERAL_APOSTROPHE)
        } else if (c == '{'.toInt() && type == '}') {
            mTokenRange.match()
            mType = XQueryTokenType.BAD_CHARACTER
        } else if (c == CodePointRange.END_OF_BUFFER) {
            mType = null
        } else {
            while (c != type.toInt() && c != CodePointRange.END_OF_BUFFER && c != '&'.toInt() && !(type == '}' && c == '{'.toInt())) {
                mTokenRange.match()
                c = mTokenRange.codePoint
            }
            mType = XQueryTokenType.STRING_LITERAL_CONTENTS
        }
    }

    private fun stateDoubleExponent() {
        mTokenRange.match()
        val c = mTokenRange.codePoint
        if (c == '+'.toInt() || c == '-'.toInt()) {
            mTokenRange.match()
        }
        mType = XQueryTokenType.PARTIAL_DOUBLE_LITERAL_EXPONENT
        popState()
    }

    private fun stateXQueryComment() {
        var c = mTokenRange.codePoint
        if (c == CodePointRange.END_OF_BUFFER) {
            mType = null
            return
        } else if (c == ':'.toInt()) {
            mTokenRange.save()
            mTokenRange.match()
            if (mTokenRange.codePoint == ')'.toInt()) {
                mTokenRange.match()
                mType = XQueryTokenType.COMMENT_END_TAG
                popState()
                return
            } else {
                mTokenRange.restore()
            }
        }

        var depth = 1
        while (true) {
            if (c == CodePointRange.END_OF_BUFFER) {
                mTokenRange.match()
                mType = XQueryTokenType.COMMENT
                popState()
                pushState(STATE_UNEXPECTED_END_OF_BLOCK)
                return
            } else if (c == '('.toInt()) {
                mTokenRange.match()
                if (mTokenRange.codePoint == ':'.toInt()) {
                    mTokenRange.match()
                    ++depth
                }
            } else if (c == ':'.toInt()) {
                mTokenRange.save()
                mTokenRange.match()
                if (mTokenRange.codePoint == ')'.toInt()) {
                    mTokenRange.match()
                    if (--depth == 0) {
                        mTokenRange.restore()
                        mType = XQueryTokenType.COMMENT
                        return
                    }
                }
            } else {
                mTokenRange.match()
            }
            c = mTokenRange.codePoint
        }
    }

    private fun stateXmlComment() {
        var c = mTokenRange.codePoint
        if (c == CodePointRange.END_OF_BUFFER) {
            mType = null
            return
        } else if (c == '-'.toInt()) {
            mTokenRange.save()
            mTokenRange.match()
            if (mTokenRange.codePoint == '-'.toInt()) {
                mTokenRange.match()
                if (mTokenRange.codePoint == '>'.toInt()) {
                    mTokenRange.match()
                    mType = XQueryTokenType.XML_COMMENT_END_TAG
                    popState()
                    return
                } else {
                    mTokenRange.restore()
                }
            } else {
                mTokenRange.restore()
            }
        }

        while (true) {
            if (c == CodePointRange.END_OF_BUFFER) {
                mTokenRange.match()
                mType = XQueryTokenType.XML_COMMENT
                popState()
                pushState(STATE_UNEXPECTED_END_OF_BLOCK)
                return
            } else if (c == '-'.toInt()) {
                mTokenRange.save()
                mTokenRange.match()
                if (mTokenRange.codePoint == '-'.toInt()) {
                    mTokenRange.match()
                    if (mTokenRange.codePoint == '>'.toInt()) {
                        mTokenRange.restore()
                        mType = XQueryTokenType.XML_COMMENT
                        return
                    }
                }
            } else {
                mTokenRange.match()
            }
            c = mTokenRange.codePoint
        }
    }

    private fun stateUnexpectedEndOfBlock() {
        mType = XQueryTokenType.UNEXPECTED_END_OF_BLOCK
        popState()
    }

    private fun stateCDataSection() {
        var c = mTokenRange.codePoint
        if (c == CodePointRange.END_OF_BUFFER) {
            mType = null
            return
        } else if (c == ']'.toInt()) {
            mTokenRange.save()
            mTokenRange.match()
            if (mTokenRange.codePoint == ']'.toInt()) {
                mTokenRange.match()
                if (mTokenRange.codePoint == '>'.toInt()) {
                    mTokenRange.match()
                    mType = XQueryTokenType.CDATA_SECTION_END_TAG
                    popState()
                    return
                } else {
                    mTokenRange.restore()
                }
            } else {
                mTokenRange.restore()
            }
        }

        while (true) {
            if (c == CodePointRange.END_OF_BUFFER) {
                mTokenRange.match()
                mType = XQueryTokenType.CDATA_SECTION
                popState()
                pushState(STATE_UNEXPECTED_END_OF_BLOCK)
                return
            } else if (c == ']'.toInt()) {
                mTokenRange.save()
                mTokenRange.match()
                if (mTokenRange.codePoint == ']'.toInt()) {
                    mTokenRange.match()
                    if (mTokenRange.codePoint == '>'.toInt()) {
                        mTokenRange.restore()
                        mType = XQueryTokenType.CDATA_SECTION
                        return
                    }
                }
            } else {
                mTokenRange.match()
            }
            c = mTokenRange.codePoint
        }
    }

    private fun statePragmaPreQName() {
        val c = mTokenRange.codePoint
        var cc = CharacterClass.getCharClass(c)
        when (cc) {
            CharacterClass.WHITESPACE -> {
                mTokenRange.match()
                while (CharacterClass.getCharClass(mTokenRange.codePoint) == CharacterClass.WHITESPACE)
                    mTokenRange.match()
                mType = XQueryTokenType.WHITE_SPACE
            }
            CharacterClass.COLON -> {
                mTokenRange.match()
                mType = XQueryTokenType.QNAME_SEPARATOR
                popState()
                pushState(STATE_PRAGMA_QNAME)
            }
            CharacterClass.NAME_START_CHAR -> {
                mTokenRange.match()
                cc = CharacterClass.getCharClass(mTokenRange.codePoint)
                if (c == 'Q'.toInt() && cc == CharacterClass.CURLY_BRACE_OPEN) {
                    mTokenRange.match()
                    mType = XQueryTokenType.BRACED_URI_LITERAL_START
                    popState()
                    pushState(STATE_PRAGMA_QNAME)
                    pushState(STATE_BRACED_URI_LITERAL_PRAGMA)
                } else {
                    while (cc == CharacterClass.NAME_START_CHAR ||
                            cc == CharacterClass.DIGIT ||
                            cc == CharacterClass.DOT ||
                            cc == CharacterClass.HYPHEN_MINUS ||
                            cc == CharacterClass.NAME_CHAR) {
                        mTokenRange.match()
                        cc = CharacterClass.getCharClass(mTokenRange.codePoint)
                    }
                    mType = XQueryTokenType.NCNAME
                    popState()
                    pushState(STATE_PRAGMA_QNAME)
                }
            }
            else -> {
                popState()
                pushState(STATE_PRAGMA_CONTENTS)
                statePragmaContents()
            }
        }
    }

    private fun statePragmaQName() {
        val c = mTokenRange.codePoint
        var cc = CharacterClass.getCharClass(c)
        when (cc) {
            CharacterClass.WHITESPACE -> {
                mTokenRange.match()
                while (CharacterClass.getCharClass(mTokenRange.codePoint) == CharacterClass.WHITESPACE)
                    mTokenRange.match()
                mType = XQueryTokenType.WHITE_SPACE
                popState()
                pushState(STATE_PRAGMA_CONTENTS)
            }
            CharacterClass.COLON -> {
                mTokenRange.match()
                mType = XQueryTokenType.QNAME_SEPARATOR
            }
            CharacterClass.NAME_START_CHAR -> {
                mTokenRange.match()
                cc = CharacterClass.getCharClass(mTokenRange.codePoint)
                while (cc == CharacterClass.NAME_START_CHAR ||
                        cc == CharacterClass.DIGIT ||
                        cc == CharacterClass.DOT ||
                        cc == CharacterClass.HYPHEN_MINUS ||
                        cc == CharacterClass.NAME_CHAR) {
                    mTokenRange.match()
                    cc = CharacterClass.getCharClass(mTokenRange.codePoint)
                }
                mType = XQueryTokenType.NCNAME
            }
            else -> {
                popState()
                pushState(STATE_PRAGMA_CONTENTS)
                statePragmaContents()
            }
        }
    }

    private fun statePragmaContents() {
        var c = mTokenRange.codePoint
        if (c == CodePointRange.END_OF_BUFFER) {
            mType = null
            return
        } else if (c == '#'.toInt()) {
            mTokenRange.save()
            mTokenRange.match()
            if (mTokenRange.codePoint == ')'.toInt()) {
                mTokenRange.match()
                mType = XQueryTokenType.PRAGMA_END
                popState()
                return
            } else {
                mTokenRange.restore()
            }
        }

        while (true) {
            if (c == CodePointRange.END_OF_BUFFER) {
                mTokenRange.match()
                mType = XQueryTokenType.PRAGMA_CONTENTS
                popState()
                pushState(STATE_UNEXPECTED_END_OF_BLOCK)
                return
            } else if (c == '#'.toInt()) {
                mTokenRange.save()
                mTokenRange.match()
                if (mTokenRange.codePoint == ')'.toInt()) {
                    mTokenRange.restore()
                    mType = XQueryTokenType.PRAGMA_CONTENTS
                    return
                }
            } else {
                mTokenRange.match()
            }
            c = mTokenRange.codePoint
        }
    }

    private fun stateDirElemConstructor(state: Int) {
        var cc = CharacterClass.getCharClass(mTokenRange.codePoint)
        val c: Int
        when (cc) {
            CharacterClass.WHITESPACE -> {
                mTokenRange.match()
                while (CharacterClass.getCharClass(mTokenRange.codePoint) == CharacterClass.WHITESPACE)
                    mTokenRange.match()
                mType = XQueryTokenType.XML_WHITE_SPACE
                if (state == STATE_DIR_ELEM_CONSTRUCTOR) {
                    popState()
                    pushState(STATE_DIR_ATTRIBUTE_LIST)
                }
            }
            CharacterClass.COLON -> {
                mTokenRange.match()
                mType = if (state == STATE_DIR_ATTRIBUTE_LIST) XQueryTokenType.XML_ATTRIBUTE_QNAME_SEPARATOR else XQueryTokenType.XML_TAG_QNAME_SEPARATOR
            }
            CharacterClass.NAME_START_CHAR -> {
                mTokenRange.match()
                cc = CharacterClass.getCharClass(mTokenRange.codePoint)
                while (cc == CharacterClass.NAME_START_CHAR ||
                        cc == CharacterClass.DIGIT ||
                        cc == CharacterClass.DOT ||
                        cc == CharacterClass.HYPHEN_MINUS ||
                        cc == CharacterClass.NAME_CHAR) {
                    mTokenRange.match()
                    cc = CharacterClass.getCharClass(mTokenRange.codePoint)
                }
                mType = if (state == STATE_DIR_ATTRIBUTE_LIST) XQueryTokenType.XML_ATTRIBUTE_NCNAME else XQueryTokenType.XML_TAG_NCNAME
            }
            CharacterClass.GREATER_THAN -> {
                mTokenRange.match()
                mType = XQueryTokenType.END_XML_TAG
                popState()
                if (state == STATE_DIR_ELEM_CONSTRUCTOR || state == STATE_DIR_ATTRIBUTE_LIST) {
                    pushState(STATE_DIR_ELEM_CONTENT)
                }
            }
            CharacterClass.FORWARD_SLASH -> {
                mTokenRange.match()
                c = mTokenRange.codePoint
                if (c == '>'.toInt()) {
                    mTokenRange.match()
                    mType = XQueryTokenType.SELF_CLOSING_XML_TAG
                    popState()
                } else {
                    mType = XQueryTokenType.INVALID
                }
            }
            CharacterClass.EQUAL -> {
                mTokenRange.match()
                mType = XQueryTokenType.XML_EQUAL
            }
            CharacterClass.QUOTE, CharacterClass.APOSTROPHE -> {
                mTokenRange.match()
                mType = XQueryTokenType.XML_ATTRIBUTE_VALUE_START
                pushState(if (cc == CharacterClass.QUOTE) STATE_DIR_ATTRIBUTE_VALUE_QUOTE else STATE_DIR_ATTRIBUTE_VALUE_APOSTROPHE)
            }
            CharacterClass.END_OF_BUFFER -> mType = null
            else -> {
                mTokenRange.match()
                mType = XQueryTokenType.BAD_CHARACTER
            }
        }
    }

    private fun stateDirAttributeValue(type: Char) {
        var c = mTokenRange.codePoint
        if (c == type.toInt()) {
            mTokenRange.match()
            if (mTokenRange.codePoint == type.toInt()) {
                mTokenRange.match()
                mType = XQueryTokenType.XML_ESCAPED_CHARACTER
            } else {
                mType = XQueryTokenType.XML_ATTRIBUTE_VALUE_END
                popState()
            }
        } else if (c == '{'.toInt()) {
            mTokenRange.match()
            if (mTokenRange.codePoint == '{'.toInt()) {
                mTokenRange.match()
                mType = XQueryTokenType.XML_ESCAPED_CHARACTER
            } else {
                mType = XQueryTokenType.BLOCK_OPEN
                pushState(if (type == '"') STATE_DEFAULT_ATTRIBUTE_QUOT else STATE_DEFAULT_ATTRIBUTE_APOSTROPHE)
            }
        } else if (c == '}'.toInt()) {
            mTokenRange.match()
            mType = if (mTokenRange.codePoint == '}'.toInt()) {
                mTokenRange.match()
                XQueryTokenType.XML_ESCAPED_CHARACTER
            } else {
                XQueryTokenType.BLOCK_CLOSE
            }
        } else if (c == '<'.toInt()) {
            mTokenRange.match()
            mType = XQueryTokenType.BAD_CHARACTER
        } else if (c == '&'.toInt()) {
            matchEntityReference(if (type == '"') STATE_DIR_ATTRIBUTE_VALUE_QUOTE else STATE_DIR_ATTRIBUTE_VALUE_APOSTROPHE)
        } else if (c == CodePointRange.END_OF_BUFFER) {
            mType = null
        } else {
            while (true) {
                when (c) {
                    CodePointRange.END_OF_BUFFER, '{'.toInt(), '}'.toInt(), '<'.toInt(), '&'.toInt() -> {
                        mType = XQueryTokenType.XML_ATTRIBUTE_VALUE_CONTENTS
                        return
                    }
                    else -> if (c == type.toInt()) {
                        mType = XQueryTokenType.XML_ATTRIBUTE_VALUE_CONTENTS
                        return
                    } else {
                        mTokenRange.match()
                        c = mTokenRange.codePoint
                    }
                }
            }
        }
    }

    private fun stateDirElemContent() {
        var c = mTokenRange.codePoint
        if (c == '{'.toInt()) {
            mTokenRange.match()
            if (mTokenRange.codePoint == '{'.toInt()) {
                mTokenRange.match()
                mType = XQueryTokenType.ESCAPED_CHARACTER
            } else {
                mType = XQueryTokenType.BLOCK_OPEN
                pushState(STATE_DEFAULT_ELEM_CONTENT)
            }
        } else if (c == '}'.toInt()) {
            mTokenRange.match()
            mType = if (mTokenRange.codePoint == '}'.toInt()) {
                mTokenRange.match()
                XQueryTokenType.ESCAPED_CHARACTER
            } else {
                XQueryTokenType.BLOCK_CLOSE
            }
        } else if (c == '<'.toInt()) {
            mTokenRange.match()
            c = mTokenRange.codePoint
            if (c == '/'.toInt()) {
                mTokenRange.match()
                mType = XQueryTokenType.CLOSE_XML_TAG
                popState()
                pushState(STATE_DIR_ELEM_CONSTRUCTOR_CLOSING)
            } else if (CharacterClass.getCharClass(mTokenRange.codePoint) == CharacterClass.NAME_START_CHAR) {
                mType = XQueryTokenType.OPEN_XML_TAG
                pushState(STATE_DIR_ELEM_CONSTRUCTOR)
            } else if (c == '?'.toInt()) {
                mTokenRange.match()
                mType = XQueryTokenType.PROCESSING_INSTRUCTION_BEGIN
                pushState(STATE_PROCESSING_INSTRUCTION_ELEM_CONTENT)
            } else if (c == '!'.toInt()) {
                mTokenRange.match()
                if (mTokenRange.codePoint == '-'.toInt()) {
                    mTokenRange.match()
                    if (mTokenRange.codePoint == '-'.toInt()) {
                        mTokenRange.match()
                        mType = XQueryTokenType.XML_COMMENT_START_TAG
                        pushState(STATE_XML_COMMENT_ELEM_CONTENT)
                    } else {
                        mType = XQueryTokenType.INVALID
                    }
                } else if (mTokenRange.codePoint == '['.toInt()) {
                    mTokenRange.match()
                    if (mTokenRange.codePoint == 'C'.toInt()) {
                        mTokenRange.match()
                        if (mTokenRange.codePoint == 'D'.toInt()) {
                            mTokenRange.match()
                            if (mTokenRange.codePoint == 'A'.toInt()) {
                                mTokenRange.match()
                                if (mTokenRange.codePoint == 'T'.toInt()) {
                                    mTokenRange.match()
                                    if (mTokenRange.codePoint == 'A'.toInt()) {
                                        mTokenRange.match()
                                        if (mTokenRange.codePoint == '['.toInt()) {
                                            mTokenRange.match()
                                            mType = XQueryTokenType.CDATA_SECTION_START_TAG
                                            pushState(STATE_CDATA_SECTION_ELEM_CONTENT)
                                        } else {
                                            mType = XQueryTokenType.INVALID
                                        }
                                    } else {
                                        mType = XQueryTokenType.INVALID
                                    }
                                } else {
                                    mType = XQueryTokenType.INVALID
                                }
                            } else {
                                mType = XQueryTokenType.INVALID
                            }
                        } else {
                            mType = XQueryTokenType.INVALID
                        }
                    } else {
                        mType = XQueryTokenType.INVALID
                    }
                } else {
                    mType = XQueryTokenType.INVALID
                }
            } else {
                mType = XQueryTokenType.BAD_CHARACTER
            }
        } else if (c == '&'.toInt()) {
            matchEntityReference(STATE_DIR_ELEM_CONTENT)
        } else if (c == CodePointRange.END_OF_BUFFER) {
            mType = null
        } else {
            while (true) {
                when (c) {
                    CodePointRange.END_OF_BUFFER, '{'.toInt(), '}'.toInt(), '<'.toInt(), '&'.toInt() -> {
                        mType = XQueryTokenType.XML_ELEMENT_CONTENTS
                        return
                    }
                    else -> {
                        mTokenRange.match()
                        c = mTokenRange.codePoint
                    }
                }
            }
        }
    }

    private fun stateProcessingInstruction(state: Int) {
        var cc = CharacterClass.getCharClass(mTokenRange.codePoint)
        when (cc) {
            CharacterClass.WHITESPACE -> {
                mTokenRange.match()
                while (CharacterClass.getCharClass(mTokenRange.codePoint) == CharacterClass.WHITESPACE)
                    mTokenRange.match()
                mType = XQueryTokenType.WHITE_SPACE
                popState()
                pushState(if (state == STATE_PROCESSING_INSTRUCTION) STATE_PROCESSING_INSTRUCTION_CONTENTS else STATE_PROCESSING_INSTRUCTION_CONTENTS_ELEM_CONTENT)
            }
            CharacterClass.NAME_START_CHAR -> {
                mTokenRange.match()
                cc = CharacterClass.getCharClass(mTokenRange.codePoint)
                while (cc == CharacterClass.NAME_START_CHAR ||
                        cc == CharacterClass.DIGIT ||
                        cc == CharacterClass.DOT ||
                        cc == CharacterClass.HYPHEN_MINUS ||
                        cc == CharacterClass.NAME_CHAR) {
                    mTokenRange.match()
                    cc = CharacterClass.getCharClass(mTokenRange.codePoint)
                }
                mType = XQueryTokenType.NCNAME
            }
            CharacterClass.QUESTION_MARK -> {
                mTokenRange.match()
                if (mTokenRange.codePoint == '>'.toInt()) {
                    mTokenRange.match()
                    mType = XQueryTokenType.PROCESSING_INSTRUCTION_END
                    popState()
                } else {
                    mType = XQueryTokenType.INVALID
                }
            }
            CharacterClass.END_OF_BUFFER -> mType = null
            else -> {
                mTokenRange.match()
                mType = XQueryTokenType.BAD_CHARACTER
            }
        }
    }

    private fun stateProcessingInstructionContents() {
        var c = mTokenRange.codePoint
        if (c == CodePointRange.END_OF_BUFFER) {
            mType = null
            return
        } else if (c == '?'.toInt()) {
            mTokenRange.save()
            mTokenRange.match()
            if (mTokenRange.codePoint == '>'.toInt()) {
                mTokenRange.match()
                mType = XQueryTokenType.PROCESSING_INSTRUCTION_END
                popState()
                return
            } else {
                mTokenRange.restore()
            }
        }

        while (true) {
            if (c == CodePointRange.END_OF_BUFFER) {
                mTokenRange.match()
                mType = XQueryTokenType.PROCESSING_INSTRUCTION_CONTENTS
                popState()
                pushState(STATE_UNEXPECTED_END_OF_BLOCK)
                return
            } else if (c == '?'.toInt()) {
                mTokenRange.save()
                mTokenRange.match()
                if (mTokenRange.codePoint == '>'.toInt()) {
                    mTokenRange.restore()
                    mType = XQueryTokenType.PROCESSING_INSTRUCTION_CONTENTS
                    return
                }
            } else {
                mTokenRange.match()
            }
            c = mTokenRange.codePoint
        }
    }

    private fun stateStringConstructorContents() {
        var c = mTokenRange.codePoint
        if (c == '`'.toInt()) {
            mTokenRange.save()
            mTokenRange.match()
            if (mTokenRange.codePoint == '{'.toInt()) {
                mTokenRange.match()
                pushState(STATE_DEFAULT_STRING_INTERPOLATION)
                mType = XQueryTokenType.STRING_INTERPOLATION_OPEN
                return
            } else {
                mTokenRange.restore()
            }
        }
        while (c != CodePointRange.END_OF_BUFFER) {
            if (c == ']'.toInt()) {
                mTokenRange.save()
                mTokenRange.match()
                if (mTokenRange.codePoint == '`'.toInt()) {
                    mTokenRange.match()
                    if (mTokenRange.codePoint == '`'.toInt()) {
                        mTokenRange.restore()
                        popState()
                        mType = XQueryTokenType.STRING_CONSTRUCTOR_CONTENTS
                        return
                    }
                }
            } else if (c == '`'.toInt()) {
                mTokenRange.save()
                mTokenRange.match()
                if (mTokenRange.codePoint == '{'.toInt()) {
                    mTokenRange.restore()
                    mType = XQueryTokenType.STRING_CONSTRUCTOR_CONTENTS
                    return
                } else {
                    mTokenRange.restore()
                }
            }
            mTokenRange.match()
            c = mTokenRange.codePoint
        }
        popState()
        pushState(STATE_UNEXPECTED_END_OF_BLOCK)
        mType = XQueryTokenType.STRING_CONSTRUCTOR_CONTENTS
    }

    private fun stateStartDirElemConstructor() {
        when (CharacterClass.getCharClass(mTokenRange.codePoint)) {
            CharacterClass.LESS_THAN -> {
                mTokenRange.match()
                mType = XQueryTokenType.OPEN_XML_TAG
                if (CharacterClass.getCharClass(mTokenRange.codePoint) != CharacterClass.WHITESPACE) {
                    popState()
                    pushState(STATE_DIR_ELEM_CONSTRUCTOR)
                }
            }
            CharacterClass.WHITESPACE -> {
                mType = XQueryTokenType.XML_WHITE_SPACE
                matchWhiteSpace()
                popState()
                pushState(STATE_DIR_ELEM_CONSTRUCTOR)
            }
        }
    }

    // endregion
    // region Helper Functions

    private fun matchNCName(): Boolean {
        var cc = CharacterClass.getCharClass(mTokenRange.codePoint)
        if (cc != CharacterClass.NAME_START_CHAR)
            return false

        while (cc == CharacterClass.NAME_START_CHAR ||
                cc == CharacterClass.DIGIT ||
                cc == CharacterClass.DOT ||
                cc == CharacterClass.HYPHEN_MINUS ||
                cc == CharacterClass.NAME_CHAR) {
            mTokenRange.match()
            cc = CharacterClass.getCharClass(mTokenRange.codePoint)
        }
        return true
    }

    private fun matchQName(): Boolean {
        if (!matchNCName())
            return false

        if (mTokenRange.codePoint == ':'.toInt()) {
            mTokenRange.match()
            matchNCName()
        }
        return true
    }

    private fun matchWhiteSpace() {
        var cc = CharacterClass.getCharClass(mTokenRange.codePoint)
        while (cc == CharacterClass.WHITESPACE) {
            mTokenRange.match()
            cc = CharacterClass.getCharClass(mTokenRange.codePoint)
        }
    }

    private fun matchOpenXmlTag() {
        // Whitespace between the '<' and the NCName/QName is invalid. The lexer
        // allows this to provide better error reporting in the parser.
        mTokenRange.save()
        matchWhiteSpace()

        if (!matchQName()) {
            mTokenRange.restore()
            mType = XQueryTokenType.LESS_THAN
            return
        }

        mType = XQueryTokenType.DIRELEM_OPEN_XML_TAG
        matchWhiteSpace()

        when (CharacterClass.getCharClass(mTokenRange.codePoint)) {
            CharacterClass.FORWARD_SLASH -> {
                mTokenRange.save()
                mTokenRange.match()
                if (mTokenRange.codePoint == '>'.toInt()) {
                    mTokenRange.match()
                    return
                }
                mType = XQueryTokenType.DIRELEM_MAYBE_OPEN_XML_TAG
                mTokenRange.restore()
            }
            CharacterClass.GREATER_THAN -> {
                mTokenRange.match()
                pushState(STATE_DIR_ELEM_CONTENT)
            }
            CharacterClass.NAME_START_CHAR -> pushState(STATE_DIR_ATTRIBUTE_LIST)
            else -> mType = XQueryTokenType.DIRELEM_MAYBE_OPEN_XML_TAG
        }
    }

    private fun matchEntityReference(state: Int) {
        val isAttributeValue = state == STATE_DIR_ATTRIBUTE_VALUE_QUOTE || state == STATE_DIR_ATTRIBUTE_VALUE_APOSTROPHE
        mTokenRange.match()
        var cc = CharacterClass.getCharClass(mTokenRange.codePoint)
        if (cc == CharacterClass.NAME_START_CHAR) {
            mTokenRange.match()
            cc = CharacterClass.getCharClass(mTokenRange.codePoint)
            while (cc == CharacterClass.NAME_START_CHAR || cc == CharacterClass.DIGIT) {
                mTokenRange.match()
                cc = CharacterClass.getCharClass(mTokenRange.codePoint)
            }
            mType = if (cc == CharacterClass.SEMICOLON) {
                mTokenRange.match()
                if (isAttributeValue) XQueryTokenType.XML_PREDEFINED_ENTITY_REFERENCE else XQueryTokenType.PREDEFINED_ENTITY_REFERENCE
            } else {
                if (isAttributeValue) XQueryTokenType.XML_PARTIAL_ENTITY_REFERENCE else XQueryTokenType.PARTIAL_ENTITY_REFERENCE
            }
        } else if (cc == CharacterClass.HASH) {
            mTokenRange.match()
            var c = mTokenRange.codePoint
            if (c == 'x'.toInt()) {
                mTokenRange.match()
                c = mTokenRange.codePoint
                if (c >= '0'.toInt() && c <= '9'.toInt() || c >= 'a'.toInt() && c <= 'f'.toInt() || c >= 'A'.toInt() && c <= 'F'.toInt()) {
                    while (c >= '0'.toInt() && c <= '9'.toInt() || c >= 'a'.toInt() && c <= 'f'.toInt() || c >= 'A'.toInt() && c <= 'F'.toInt()) {
                        mTokenRange.match()
                        c = mTokenRange.codePoint
                    }
                    mType = if (c == ';'.toInt()) {
                        mTokenRange.match()
                        if (isAttributeValue) XQueryTokenType.XML_CHARACTER_REFERENCE else XQueryTokenType.CHARACTER_REFERENCE
                    } else {
                        if (isAttributeValue) XQueryTokenType.XML_PARTIAL_ENTITY_REFERENCE else XQueryTokenType.PARTIAL_ENTITY_REFERENCE
                    }
                } else if (c == ';'.toInt()) {
                    mTokenRange.match()
                    mType = if (isAttributeValue) XQueryTokenType.XML_EMPTY_ENTITY_REFERENCE else XQueryTokenType.EMPTY_ENTITY_REFERENCE
                } else {
                    mType = if (isAttributeValue) XQueryTokenType.XML_PARTIAL_ENTITY_REFERENCE else XQueryTokenType.PARTIAL_ENTITY_REFERENCE
                }
            } else if (c >= '0'.toInt() && c <= '9'.toInt()) {
                mTokenRange.match()
                while (c >= '0'.toInt() && c <= '9'.toInt()) {
                    mTokenRange.match()
                    c = mTokenRange.codePoint
                }
                mType = if (c == ';'.toInt()) {
                    mTokenRange.match()
                    if (isAttributeValue) XQueryTokenType.XML_CHARACTER_REFERENCE else XQueryTokenType.CHARACTER_REFERENCE
                } else {
                    if (isAttributeValue) XQueryTokenType.XML_PARTIAL_ENTITY_REFERENCE else XQueryTokenType.PARTIAL_ENTITY_REFERENCE
                }
            } else if (c == ';'.toInt()) {
                mTokenRange.match()
                mType = if (isAttributeValue) XQueryTokenType.XML_EMPTY_ENTITY_REFERENCE else XQueryTokenType.EMPTY_ENTITY_REFERENCE
            } else {
                mType = if (isAttributeValue) XQueryTokenType.XML_PARTIAL_ENTITY_REFERENCE else XQueryTokenType.PARTIAL_ENTITY_REFERENCE
            }
        } else if (cc == CharacterClass.SEMICOLON) {
            mTokenRange.match()
            mType = if (isAttributeValue) XQueryTokenType.XML_EMPTY_ENTITY_REFERENCE else XQueryTokenType.EMPTY_ENTITY_REFERENCE
        } else {
            mType = if (isAttributeValue) XQueryTokenType.XML_PARTIAL_ENTITY_REFERENCE else XQueryTokenType.PARTIAL_ENTITY_REFERENCE
        }
    }

    // endregion
    // region Lexer

    override fun advance() {
        when (nextState()) {
            STATE_DEFAULT, STATE_DEFAULT_ATTRIBUTE_QUOT, STATE_DEFAULT_ATTRIBUTE_APOSTROPHE, STATE_DEFAULT_ELEM_CONTENT, STATE_DEFAULT_STRING_INTERPOLATION, STATE_MAYBE_DIR_ELEM_CONSTRUCTOR -> stateDefault(state)
            STATE_STRING_LITERAL_QUOTE -> stateStringLiteral('"')
            STATE_STRING_LITERAL_APOSTROPHE -> stateStringLiteral('\'')
            STATE_DOUBLE_EXPONENT -> stateDoubleExponent()
            STATE_XQUERY_COMMENT -> stateXQueryComment()
            STATE_XML_COMMENT, STATE_XML_COMMENT_ELEM_CONTENT -> stateXmlComment()
            STATE_UNEXPECTED_END_OF_BLOCK -> stateUnexpectedEndOfBlock()
            STATE_CDATA_SECTION, STATE_CDATA_SECTION_ELEM_CONTENT -> stateCDataSection()
            STATE_PRAGMA_PRE_QNAME -> statePragmaPreQName()
            STATE_PRAGMA_QNAME -> statePragmaQName()
            STATE_PRAGMA_CONTENTS -> statePragmaContents()
            STATE_DIR_ELEM_CONSTRUCTOR, STATE_DIR_ELEM_CONSTRUCTOR_CLOSING, STATE_DIR_ATTRIBUTE_LIST -> stateDirElemConstructor(state)
            STATE_DIR_ATTRIBUTE_VALUE_QUOTE -> stateDirAttributeValue('"')
            STATE_DIR_ATTRIBUTE_VALUE_APOSTROPHE -> stateDirAttributeValue('\'')
            STATE_DIR_ELEM_CONTENT -> stateDirElemContent()
            STATE_PROCESSING_INSTRUCTION, STATE_PROCESSING_INSTRUCTION_ELEM_CONTENT -> stateProcessingInstruction(state)
            STATE_PROCESSING_INSTRUCTION_CONTENTS, STATE_PROCESSING_INSTRUCTION_CONTENTS_ELEM_CONTENT -> stateProcessingInstructionContents()
            STATE_BRACED_URI_LITERAL, STATE_BRACED_URI_LITERAL_PRAGMA -> stateStringLiteral('}')
            STATE_STRING_CONSTRUCTOR_CONTENTS -> stateStringConstructorContents()
            STATE_START_DIR_ELEM_CONSTRUCTOR -> stateStartDirElemConstructor()
            else -> throw AssertionError("Invalid state: $state")
        }
    }

    // endregion
}
