# XQuery and XPath Data Model

This provides an implementation of the
[XQuery and XPath Data Model (XDM)](#xdm) for use in the IntelliJ XQuery
plugin. It is designed to facilitate implementing IntelliJ features such
as resolving references, and implementing static analysis.

__NOTE:__ While this is an accurate implementation of the XDM specifications,
it does not provide the facilities to perform dynamic analysis or evaluating
queries at runtime.

The [XMLSchema](#xmlschema) data types are modelled here as part of the XDM
type hierarchy. These builtin data types implement the casting rules as defined
in the [XPath and XQuery Functions and Operators](#functions-and-operators)
specification.

__NOTE:__ This implementation does not support any dynamic XMLSchema facets,
nor does it support querying custom data in XMLSchema definition (`xsd`) files.
That functionality can be built on top of this, if needed.

This only provides the core data model and the associated API to build and
manipulate that data model. The higher-level APIs for modelling XPath and
XQuery constructs (such as variable bindings) is handled in the XPath/XQuery
implementation.

## References
### Functions and Operators
1. [XQuery 1.0 and XPath 2.0 Functions and Operators](https://www.w3.org/TR/2007/REC-xpath-functions-20070123/). W3C Recommendation, 23 January 2007. W3C.
1. [XQuery 1.0 and XPath 2.0 Functions and Operators (Second Edition)](http://www.w3.org/TR/2010/REC-xpath-functions-20101214/). W3C Recommendation, 14 December 2010. W3C.
1. [XPath and XQuery Functions and Operators 3.0](https://www.w3.org/TR/2014/REC-xpath-functions-30-20140408/). W3C Recommendation, 08 April 2014. W3C.
1. [XPath and XQuery Functions and Operators 3.1](https://www.w3.org/TR/2017/REC-xpath-functions-31-20170321/). W3C Recommendation, 21 March 2017. W3C.
### XDM
1. [XQuery 1.0 and XPath 2.0 Data Model (XDM)](https://www.w3.org/TR/2007/REC-xpath-datamodel-20070123/). W3C Recommendation, 23 January 2007. W3C.
1. [XQuery 1.0 and XPath 2.0 Data Model (XDM) (Second Edition)](https://www.w3.org/TR/2010/REC-xpath-datamodel-20101214/). W3C Recommendation 14, December 2010. W3C.
1. [XQuery and XPath Data Model 3.0](http://www.w3.org/TR/2014/REC-xpath-datamodel-30-20140408/). W3C Recommendation, 08 April 2014. W3C.
1. [XQuery and XPath Data Model 3.1](https://www.w3.org/TR/2017/REC-xpath-datamodel-31-20170321/). W3C Recommendation, 21 March 2017. W3C.
### XMLSchema
1. [XML Schema Part 2: Datatypes](https://www.w3.org/TR/2001/REC-xmlschema-2-20010502/). W3C Recommendation, 02 May 2001. W3C.
1. [XML Schema Part 2: Datatypes Second Edition](http://www.w3.org/TR/2004/REC-xmlschema-2-20041028/). W3C Recommendation, 28 October 2004. W3C.
1. [W3C XML Schema Definition Language (XSD) 1.1 Part 2: Datatypes](http://www.w3.org/TR/2012/REC-xmlschema11-2-20120405/). W3C Recommendation, 5 April 2012. W3C.
