# XPath and XQuery Extensions

This plugin implements the XQuery 3.1 language specification, and associated
W3C and vendor extensions in a unified grammar. This file documents the changes
to the grammar from what is provided in the various specifications.

-----

- [XPath and XQuery](#xpath-and-xquery)
  - [Prolog](#prolog)
  - [Quantified Expressions](#quantified-expressions)
  - [Typeswitch Expressions](#typeswitch-expressions)
  - [Cast Expressions](#cast-expressions)
  - [Direct Element Construction](#direct-element-construction)
  - [Primary Expressions](#primary-expressions)
- [W3C Extensions](#w3c-extensions)
  - [XPath and XQuery Full Text](#xpath-and-xquery-full-text)
    - [Match Options](#match-options)
  - [XQuery Scripting Extension](#xquery-scripting-extension)
    - [Block Expressions](#block-expressions)
  - [XQuery Update Facility](#xquery-update-facility)
- [Vendor Extensions](#vendor-extensions)
  - [BaseX Vendor Extensions](#basex-vendor-extensions)
    - [Fuzzy Match Option](#fuzzy-match-options)
    - [Update Expressions](#update-expressions)
    - [Non-Deterministic Function Calls](#non-deterministic-function-calls)
  - [MarkLogic Vendor Extensions](#marklogic-vendor-extensions)
    - [Compatibility Annotation](#compatibility-annotation)
    - [Transactions](#transactions)
    - [Try/Catch Expressions](#try-catch-expressions)
  - [Saxon Vendor Extensions](#saxon-vendor-extensions)
    - [Maps](#maps)
    - [Tuple Types](#tuple-types)
    - [Type Declarations](#type-declarations)
    - [Union Types](#union-types)

## XPath and XQuery

The following XQuery specifications are supported:

1.  XQuery 1.0 Second Edition (W3C Recommendation 14 December 2010)
1.  XQuery 3.0 (W3C Recommendation 08 April 2014)
1.  XQuery 3.1 (W3C Recommendation 21 March 2017)

### Prolog

    Prolog   ::= ((DefaultNamespaceDecl | Setter | NamespaceDecl | Import) Separator)*
                 ((ContextItemDecl | AnnotatedDecl | OptionDecl | TypeDecl) Separator)*

This adds the [`TypeDecl`](#type-declarations) Saxon vendor extension.

### Quantified Expressions

    QuantifiedExpr        := ("some" | "every") QuantifiedExprBinding ("," QuantifiedExprBinding)* "satisfies" ExprSingle
    QuantifiedExprBinding := "$" VarName TypeDeclaration? "in" ExprSingle

The `QuantifiedExprBinding` production is not used in the XPath and XQuery
grammar. Instead, the production is inlined in the `QuantifiedExpr` production.
This is split out in the plugin to mirror the change made to the `ForClause`
and `LetClause` productions with the addition of the `ForBinding` and
`LetBinding` productions.

This change was made to make it easier to implement the variable binding
logic, as each `QuantifiedExprBinding` is a single variable binding.

### Typeswitch Expressions

    TypeswitchExpr    ::=  "typeswitch" "(" Expr ")" CaseClause+ DefaultCaseClause
    DefaultCaseClause ::=  "default" ("$" VarName)? "return" ExprSingle

The default case expression is factored out here into a separate grammar
production, similar to the `CaseClause` expression.

This change was made to make it easier to implement the variable binding
logic, as each `CaseClause` can expose a variable bound to the typeswitch
expression that is valid for the scope of the case's return expression.

### Cast Expressions

    CastExpr                 := ArrowTransformUpdateExpr ( "cast" "as" SingleType )?
    ArrowTransformUpdateExpr := ArrowExpr | TransformWithExpr | UpdateExpr

The XQuery 3.1 and Update Facility 3.0 specifications both define constructs for use
between `CastExpr` and `UnaryExpr`. This supports either construct, but does not allow
both constructs to be mixed in the same expression, unless parentheses are used. It
also supports the BaseX `UpdateExpr` constructs here, using the same logic.

This differs from the
[proposed official resolution](https://www.w3.org/Bugs/Public/show_bug.cgi?id=30015)
which has not been standardized. Instead, this change supports any expression
that is valid in the different specifications, but not expressions that mix them
in ways not convered by those expressions.

### Direct Element Construction

    DirAttributeList ::= (S DirAttribute?)*                /* ws: explicit */
    DirAttribute     ::= QName S? "=" S? DirAttributeValue /* ws: explicit */

This follows the grammar production pattern used in other constructs like
`ParamList`.

This change was made to make it easier to implement the namespace declaration
logic, as each `xmlns`-based `DirAttribute` can expose a namespace to the
direct element constructor expression that is valid for the scope of the
element.

### Primary Expressions

    PrimaryExpr ::= Literal
                  | VarRef
                  | ParenthesizedExpr
                  | ContextItemExpr
                  | FunctionCall
                  | NonDeterministicFunctionCall
                  | OrderedExpr
                  | UnorderedExpr
                  | NodeConstructor
                  | FunctionItemExpr
                  | MapConstructor
                  | ArrayConstructor
                  | StringConstructor
                  | UnaryLookup

This adds the [`NonDeterministicFunctionCall`](#non-deterministic-function-calls)
BaseX vendor extension.

## W3C Extensions

### XPath and XQuery Full Text

The following Full Text extension specifications are supported:

1.  Full Text 1.0 (W3C Recommendation 17 March 2011)
1.  Full Text 3.0 (W3C Recommendation 24 November 2015)

#### Match Options

    FTMatchOption ::= FTLanguageOption
                    | FTWildCardOption
                    | FTThesaurusOption
                    | FTStemOption
                    | FTCaseOption
                    | FTDiacriticsOption
                    | FTStopWordOption
                    | FTExtensionOption
                    | FTFuzzyOption

This adds the [`FTFuzzyOption`](#fuzzy-match-option) BaseX vendor extension.

### XQuery Update Facility

The following Update Facility extension specifications are supported:

1.  Update Facility 1.0 (W3C Recommendation 17 March 2011)
1.  Update Facility 3.0 (W3C Working Group Note 24 January 2017)

### XQuery Scripting Extension

The following Scripting extension specifications are supported:

1.  Scripting Extension 1.0 (W3C Working Group Note 18 September 2014)

#### Block Expressions

    BlockVarDecl      ::= "declare" BlockVarDeclEntry ("," BlockVarDeclEntry)*
    BlockVarDeclEntry ::= "$" VarName TypeDeclaration? (":=" ExprSingle)?

The `BlockVarDeclEntry` production is not used in the XQuery Scripting
Extension grammar. Instead, the production is inlined in the `BlockVarDecl`
production. This is split out in the plugin to mirror the change made to the
`ForClause` and `LetClause` productions with the addition of the `ForBinding`
and `LetBinding` productions.

This change was made to make it easier to implement the variable declaration
logic, as each `BlockVarDeclEntry` is a single variable declaration.

## Vendor Extensions

### BaseX Vendor Extensions

#### Fuzzy Match Option

    FTFuzzyOption ::= "fuzzy"

BaseX 6.1 defines a [fuzzy match option](http://docs.basex.org/wiki/Full-Text#Fuzzy_Querying)
for full text queries.

#### Update Expressions

    UpdateExpr := InlineUpdateExpr | BlockUpdateExpr
    InlineUpdateExpr := "update" Expr
    BlockUpdateExpr := ( "update" EnclosedUpdateExpr )*
    EnclosedUpdateExpr := "{" Expr "}"

BaseX defines an [update expression](http://docs.basex.org/wiki/Updates#update)
to simplify `CopyModifyExpr` constructs. BaseX 7.8 supports inline update
expressions, and BaseX 8.5 supports block update expressions that can be
chained.

#### Non-Deterministic Function Calls

    NonDeterministicFunctionCalls := "non-deterministic" "$" VarDecl ArgumentList

BaseX 8.4 defines a
[non-deterministic function call](http://docs.basex.org/wiki/XQuery_Extensions#Non-determinism)
for calling `NamedFunctionRef` variables.

### MarkLogic Vendor Extensions

1. [MarkLogic Server Enhanced XQuery Language](https://docs.marklogic.com/guide/xquery/enhanced)

#### Compatibility Annotation

    AnnotatedDecl ::= "declare" (MarkLogicCompatibilityAnnotation | CompatibilityAnnotation | Annotation)* (VarDecl | FunctionDecl)
    MarkLogicCompatibilityAnnotation ::= "private"

MarkLogic supports using the `private` keyword in place of XQuery 3.0 annotations, in addition to
the `%private` annotation.

#### Transactions

    Module := VersionDecl? (LibraryModule | MainModule) ( TransactionSeparator VersionDecl? (LibraryModule | MainModule) )*
    TransactionSeparator := ";"
    ApplyExpr ::= ConcatExpr ( ( TransactionSeparator ConcatExpr )+ TransactionSeparator? )?

MarkLogic supports using ";" to separate transactions. Within this grammar, MarkLogic transactions
that provide a `VersionDecl` or `Prolog` are parsed in `Module` nodes, while those that don't are
parsed in `ApplyExpr` nodes. This is to be compatible with Scripting extensions.

The `ApplyExpr` grammar has been modified to make the final transaction separator optional. The
final transaction separator is required in Scripting extensions, and is invalid for MarkLogic.

#### Try/Catch Expressions

    TryCatchExpr ::= TryClause ( MarkLogicCatchExpr | CatchClause+ )
    MarkLogicCatchExpr ::= "catch" "(" "$" VarName ")" EnclosedExpr

MarkLogic supports a different syntax to the XQuery 3.0 try/catch expressions.
The variable passed to the `MarkLogicCatchExpr` is the MarkLogic `error:error`
object.

### Saxon Vendor Extensions

#### Maps

    MapConstructorEntry ::= MapKeyExpr (":" | ":=") MapValueExpr

Saxon 9.4 to 9.6 support using `:=` to separate map keys and values. In
Saxon 9.7 and later, only the XQuery 3.1 map syntax is supported.

#### Tuple Types

    TupleType  ::= "tuple" "(" TupleField ("," TupleField)* ")"
    TupleField ::= NCName ":" SequenceType

A tuple type is a Saxon 9.8 vendor extension described in the
[Saxonica documentation](http://www.saxonica.com/documentation/index.html#!extensions/syntax-extensions/tuple-types)
for defining custom typed maps in XQuery.

#### Type Declarations

    TypeDecl ::= "declare" "type" QName "=" ItemType

A type declaration is a Saxon 9.8 vendor extension described in the
[Saxonica documentation](http://www.saxonica.com/documentation/index.html#!extensions/syntax-extensions/type-aliases)
for defining custom type aliases in XQuery.

#### Union Types

    UnionType ::= "union" "(" QName ("," QName)* ")"

A union type is a Saxon 9.8 vendor extension described in the
[Saxonica documentation](http://www.saxonica.com/documentation/index.html#!extensions/syntax-extensions/union-types)
for defining custom XDM union types in XQuery.
