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
package uk.co.reecedunn.intellij.plugin.xquery.lang;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uk.co.reecedunn.intellij.plugin.xquery.XQueryBundle;

public enum XQuerySpecification {
    // XQuery: An XML Query Language

    XQUERY_1_0_20030502("xquery-20030502",
        XQueryBundle.message("xquery.specification.name.xquery-20030502"),
        XQueryBundle.message("xquery.specification.description.xquery-20030502"),
        "https://www.w3.org/TR/2003/WD-xquery-20030502/"),
    XQUERY_1_0("xquery",
        XQueryBundle.message("xquery.specification.name.xquery-20070123"),
        XQueryBundle.message("xquery.specification.description.xquery-20070123"),
        "https://www.w3.org/TR/2007/REC-xquery-20070123/"),
    XQUERY_1_0_20101214("xquery-20101214",
        XQueryBundle.message("xquery.specification.name.xquery-20101214"),
        XQueryBundle.message("xquery.specification.description.xquery-20101214"),
        "https://www.w3.org/TR/2010/REC-xquery-20101214/"),
    XQUERY_3_0("xquery-30",
        XQueryBundle.message("xquery.specification.name.xquery-30-20140408"),
        XQueryBundle.message("xquery.specification.description.xquery-30-20140408"),
        "https://www.w3.org/TR/2014/REC-xquery-30-20140408/"),
    XQUERY_3_1("xquery-31",
        XQueryBundle.message("xquery.specification.name.xquery-31-20151217"),
        XQueryBundle.message("xquery.specification.description.xquery-31-20151217"),
        "https://www.w3.org/TR/2015/CR-xquery-31-20151217/"),

    // XQuery and XPath Formal Semantics

    SEMANTICS_1_0("xquery-semantics",
        XQueryBundle.message("xquery.specification.name.xquery-semantics-20070123"),
        XQueryBundle.message("xquery.specification.description.xquery-semantics-20070123"),
        "https://www.w3.org/TR/2007/REC-xquery-semantics-20070123/"),
    SEMANTICS_1_0_20101214("xquery-semantics-20101214",
        XQueryBundle.message("xquery.specification.name.xquery-semantics-20101214"),
        XQueryBundle.message("xquery.specification.description.xquery-semantics-20101214"),
        "https://www.w3.org/TR/2010/REC-xquery-semantics-20101214/"),

    // XQuery and XPath Full Text

    FULL_TEXT_1_0("xpath-full-text-10",
            XQueryBundle.message("xquery.specification.name.xpath-full-text-10-20110317"),
            XQueryBundle.message("xquery.specification.description.xpath-full-text-10-20110317"),
            "https://www.w3.org/TR/2011/REC-xpath-full-text-10-20110317/"),
    FULL_TEXT_3_0("xpath-full-text-30",
            XQueryBundle.message("xquery.specification.name.xpath-full-text-30-20151124"),
            XQueryBundle.message("xquery.specification.description.xpath-full-text-30-20151124"),
            "https://www.w3.org/TR/2015/REC-xpath-full-text-30-20151124/"),

    // XQuery Update Facility

    UPDATE_1_0("xquery-update-10",
        XQueryBundle.message("xquery.specification.name.xquery-update-10-20110317"),
        XQueryBundle.message("xquery.specification.description.xquery-update-10-20110317"),
        "https://www.w3.org/TR/2011/REC-xquery-update-10-20110317/"),
    UPDATE_3_0("xquery-update-30",
        XQueryBundle.message("xquery.specification.name.xquery-update-30-20150219"),
        XQueryBundle.message("xquery.specification.description.xquery-update-30-20150219"),
        "https://www.w3.org/TR/2015/WD-xquery-update-30-20150219/");

    private final String mID;
    private final String mName;
    private final String mDescription;
    private final String mReference;

    XQuerySpecification(@NotNull String id, @NotNull String name, @Nullable String description, @NotNull String reference) {
        mID = id;
        mName = name;
        mDescription = description;
        mReference = reference;
    }

    @NotNull
    public String getName() {
        return mName;
    }

    @Nullable
    public String getDescription() {
        return mDescription;
    }

    @NotNull
    public String getReference() {
        return mReference;
    }

    @Nullable
    public static XQuerySpecification parse(@Nullable String value) {
        if ("xquery-20030502".equals(value)) return XQUERY_1_0_20030502;
        if ("xquery".equals(value)) return XQUERY_1_0;
        if ("xquery-20101214".equals(value)) return XQUERY_1_0_20101214;
        if ("xquery-30".equals(value)) return XQUERY_3_0;
        if ("xquery-31".equals(value)) return XQUERY_3_1;
        if ("xquery-semantics".equals(value)) return SEMANTICS_1_0;
        if ("xquery-semantics-20101214".equals(value)) return SEMANTICS_1_0_20101214;
        if ("xpath-full-text-10".equals(value)) return FULL_TEXT_1_0;
        if ("xpath-full-text-30".equals(value)) return FULL_TEXT_3_0;
        if ("xquery-update-10".equals(value)) return UPDATE_1_0;
        if ("xquery-update-30".equals(value)) return UPDATE_3_0;
        return null;
    }

    @NotNull
    @Override
    public String toString() {
        return mID;
    }
}
