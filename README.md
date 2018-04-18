# IntelliJ XQuery Plugin

[![Build Status](https://travis-ci.org/rhdunn/xquery-intellij-plugin.svg)](https://travis-ci.org/rhdunn/xquery-intellij-plugin)
[![codecov.io](https://codecov.io/github/rhdunn/xquery-intellij-plugin/coverage.svg)](https://codecov.io/github/rhdunn/xquery-intellij-plugin)

- [Features](#features)
  - [Language Support](#language-support)
  - [Warnings and Errors](#warnings-and-errors)
  - [IntelliJ Integration](#intellij-integration)
- [License Information](#license-information)

----------

This project provides XQuery support for the IntelliJ IDE.

_Supported IntelliJ Platforms:_ IntelliJ IDEA Community, IntelliJ IDEA Ultimate,
PhpStorm, WebStorm, PyCharm, RubyMine, AppCode, CLion, Rider, Android Studio

_Supported IntelliJ Versions:_ 2017.1 - 2018.1

_Supported XQuery Implementations:_ BaseX, MarkLogic, Saxonica Saxon, W3C Specifications

## Features

### Language Support

A robust, standard conforming XQuery syntax highlighter and parser with file encoding
detection and error recovery. It supports the following W3C specifications:

*  XQuery 1.0, 3.0 and 3.1 core language;
*  XQuery and XPath Full Text 1.0 and 3.0 for XQuery;
*  XQuery Update Facility 1.0 and 3.0;
*  XQuery Scripting Extension 1.0.

The [XPath and XQuery Extensions](docs/XPath%20and%20XQuery%20Extensions.md) document
describes the syntax of the vendor extensions supported in this plugin, and
other changes to the XPath and XQuery grammar.

![Syntax Highlighting](images/syntax-highlighting.png)

It supports the following XQuery syntax extensions:

*  BaseX 7.8 and 8.5 `update` syntax, and Full Text `fuzzy` option;
*  Saxon 9.4 `map`, and Saxon 9.8 `tuple`, `union`, and `declare type` vendor
   extensions;
*  MarkLogic 6.0, 7.0 (schema types) and 8.0 (json types) vendor extensions.

It has support for xqDoc documentation comments.

The plugin provides control over how XQuery dialects are interpreted.

![XQuery Settings](images/xquery-settings.png)

### Warnings and Errors

Helpful error messages for invalid XQuery constructs.

![Error Messages](images/error-messages.png)

Warnings for XQuery constructs that are valid in a different version or extension
to the one configured in the project.

![Require Different Version](images/require-different-version.png)

### IntelliJ Integration

Resolve URI string literals to the files they reference.

![Resolve URI Literals](images/resolve-uriliteral.png)

Resolve namespaces, functions and variables to their corresponding declarations.

Code folding is supported for the following elements:

*  Comment;
*  DirElemConstructor;
*  EnclosedExpr (including function bodies).

Other supported IntelliJ features:

1.  Find usages.
2.  Paired brace matching.
3.  Commenting code support.

## License Information

Copyright (C) 2016-2017 Reece H. Dunn

The IntelliJ XQuery Plugin is licensed under the [Apache 2.0](LICENSE)
license.
