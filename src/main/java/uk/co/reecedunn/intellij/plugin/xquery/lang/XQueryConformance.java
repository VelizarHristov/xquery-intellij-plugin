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

public enum XQueryConformance {
    MINIMAL_CONFORMANCE("xquery"),
    UPDATE_FACILITY("update-facility"),
    FULL_TEXT("full-text"),
    SCRIPTING("scripting"),
    MARKLOGIC("marklogic");

    private final String mID;

    XQueryConformance(@NotNull String id) {
        mID = id;
    }

    @Override
    public String toString() {
        return mID;
    }
}