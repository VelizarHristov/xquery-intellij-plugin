/*
 * Copyright (C) 2017 Reece H. Dunn
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
package uk.co.reecedunn.intellij.plugin.xdm.tests

import junit.framework.TestCase
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import uk.co.reecedunn.intellij.plugin.xdm.*
import uk.co.reecedunn.intellij.plugin.xdm.model.XdmSequenceType
import uk.co.reecedunn.intellij.plugin.xdm.model.XmlSchemaType

class AtomicTypes : TestCase() {
    fun testXsUntypedAtomic() {
        assertThat(XsUntypedAtomic.typeName?.prefix, `is`(nullValue()))
        assertThat(XsUntypedAtomic.typeName?.declaration, `is`(nullValue()))

        assertThat(XsUntypedAtomic.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsUntypedAtomic.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsUntypedAtomic.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsUntypedAtomic.typeName?.localName?.lexicalRepresentation, `is`("untypedAtomic"))

        assertThat(XsUntypedAtomic.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsUntypedAtomic.isPrimitive, `is`(true)) // XDM casting rules

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "untypedAtomic").toXmlSchemaType(),
                `is`(XsUntypedAtomic as XdmSequenceType))
    }

    fun testXsDateTime() {
        assertThat(XsDateTime.typeName?.prefix, `is`(nullValue()))
        assertThat(XsDateTime.typeName?.declaration, `is`(nullValue()))

        assertThat(XsDateTime.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsDateTime.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsDateTime.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsDateTime.typeName?.localName?.lexicalRepresentation, `is`("dateTime"))

        assertThat(XsDateTime.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsDateTime.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "dateTime").toXmlSchemaType(),
                `is`(XsDateTime as XdmSequenceType))
    }

    fun testXsDateTimeStamp() {
        assertThat(XsDateTimeStamp.typeName?.prefix, `is`(nullValue()))
        assertThat(XsDateTimeStamp.typeName?.declaration, `is`(nullValue()))

        assertThat(XsDateTimeStamp.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsDateTimeStamp.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsDateTimeStamp.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsDateTimeStamp.typeName?.localName?.lexicalRepresentation, `is`("dateTimeStamp"))

        assertThat(XsDateTimeStamp.baseType, `is`(XsDateTime as XmlSchemaType))
        assertThat(XsDateTimeStamp.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "dateTimeStamp").toXmlSchemaType(),
                `is`(XsDateTimeStamp as XdmSequenceType))
    }

    fun testXsDate() {
        assertThat(XsDate.typeName?.prefix, `is`(nullValue()))
        assertThat(XsDate.typeName?.declaration, `is`(nullValue()))

        assertThat(XsDate.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsDate.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsDate.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsDate.typeName?.localName?.lexicalRepresentation, `is`("date"))

        assertThat(XsDate.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsDate.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "date").toXmlSchemaType(),
                `is`(XsDate as XdmSequenceType))
    }

    fun testXsTime() {
        assertThat(XsTime.typeName?.prefix, `is`(nullValue()))
        assertThat(XsTime.typeName?.declaration, `is`(nullValue()))

        assertThat(XsTime.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsTime.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsTime.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsTime.typeName?.localName?.lexicalRepresentation, `is`("time"))

        assertThat(XsTime.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsTime.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "time").toXmlSchemaType(),
                `is`(XsTime as XdmSequenceType))
    }

    fun testXsDuration() {
        assertThat(XsDuration.typeName?.prefix, `is`(nullValue()))
        assertThat(XsDuration.typeName?.declaration, `is`(nullValue()))

        assertThat(XsDuration.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsDuration.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsDuration.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsDuration.typeName?.localName?.lexicalRepresentation, `is`("duration"))

        assertThat(XsDuration.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsDuration.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "duration").toXmlSchemaType(),
                `is`(XsDuration as XdmSequenceType))
    }

    fun testXsYearMonthDuration() {
        assertThat(XsYearMonthDuration.typeName?.prefix, `is`(nullValue()))
        assertThat(XsYearMonthDuration.typeName?.declaration, `is`(nullValue()))

        assertThat(XsYearMonthDuration.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsYearMonthDuration.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsYearMonthDuration.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsYearMonthDuration.typeName?.localName?.lexicalRepresentation, `is`("yearMonthDuration"))

        assertThat(XsYearMonthDuration.baseType, `is`(XsDuration as XmlSchemaType))
        assertThat(XsYearMonthDuration.isPrimitive, `is`(true)) // XDM casting rules

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "yearMonthDuration").toXmlSchemaType(),
                `is`(XsYearMonthDuration as XdmSequenceType))
    }

    fun testXsDayTimeDuration() {
        assertThat(XsDayTimeDuration.typeName?.prefix, `is`(nullValue()))
        assertThat(XsDayTimeDuration.typeName?.declaration, `is`(nullValue()))

        assertThat(XsDayTimeDuration.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsDayTimeDuration.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsDayTimeDuration.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsDayTimeDuration.typeName?.localName?.lexicalRepresentation, `is`("dayTimeDuration"))

        assertThat(XsDayTimeDuration.baseType, `is`(XsDuration as XmlSchemaType))
        assertThat(XsDayTimeDuration.isPrimitive, `is`(true)) // XDM casting rules

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "dayTimeDuration").toXmlSchemaType(),
                `is`(XsDayTimeDuration as XdmSequenceType))
    }

    fun testXsFloat() {
        assertThat(XsFloat.typeName?.prefix, `is`(nullValue()))
        assertThat(XsFloat.typeName?.declaration, `is`(nullValue()))

        assertThat(XsFloat.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsFloat.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsFloat.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsFloat.typeName?.localName?.lexicalRepresentation, `is`("float"))

        assertThat(XsFloat.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsFloat.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "float").toXmlSchemaType(),
                `is`(XsFloat as XdmSequenceType))
    }

    fun testXsDouble() {
        assertThat(XsDouble.typeName?.prefix, `is`(nullValue()))
        assertThat(XsDouble.typeName?.declaration, `is`(nullValue()))

        assertThat(XsDouble.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsDouble.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsDouble.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsDouble.typeName?.localName?.lexicalRepresentation, `is`("double"))

        assertThat(XsDouble.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsDouble.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "double").toXmlSchemaType(),
                `is`(XsDouble as XdmSequenceType))
    }

    fun testXsDecimal() {
        assertThat(XsDecimal.typeName?.prefix, `is`(nullValue()))
        assertThat(XsDecimal.typeName?.declaration, `is`(nullValue()))

        assertThat(XsDecimal.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsDecimal.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsDecimal.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsDecimal.typeName?.localName?.lexicalRepresentation, `is`("decimal"))

        assertThat(XsDecimal.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsDecimal.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "decimal").toXmlSchemaType(),
                `is`(XsDecimal as XdmSequenceType))
    }

    fun testXsInteger() {
        assertThat(XsInteger.typeName?.prefix, `is`(nullValue()))
        assertThat(XsInteger.typeName?.declaration, `is`(nullValue()))

        assertThat(XsInteger.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsInteger.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsInteger.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsInteger.typeName?.localName?.lexicalRepresentation, `is`("integer"))

        assertThat(XsInteger.baseType, `is`(XsDecimal as XmlSchemaType))
        assertThat(XsInteger.isPrimitive, `is`(true)) // XDM casting rules

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "integer").toXmlSchemaType(),
                `is`(XsInteger as XdmSequenceType))
    }

    fun testXsNonPositiveInteger() {
        assertThat(XsNonPositiveInteger.typeName?.prefix, `is`(nullValue()))
        assertThat(XsNonPositiveInteger.typeName?.declaration, `is`(nullValue()))

        assertThat(XsNonPositiveInteger.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsNonPositiveInteger.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsNonPositiveInteger.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsNonPositiveInteger.typeName?.localName?.lexicalRepresentation, `is`("nonPositiveInteger"))

        assertThat(XsNonPositiveInteger.baseType, `is`(XsInteger as XmlSchemaType))
        assertThat(XsNonPositiveInteger.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "nonPositiveInteger").toXmlSchemaType(),
                `is`(XsNonPositiveInteger as XdmSequenceType))
    }

    fun testXsNegativeInteger() {
        assertThat(XsNegativeInteger.typeName?.prefix, `is`(nullValue()))
        assertThat(XsNegativeInteger.typeName?.declaration, `is`(nullValue()))

        assertThat(XsNegativeInteger.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsNegativeInteger.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsNegativeInteger.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsNegativeInteger.typeName?.localName?.lexicalRepresentation, `is`("negativeInteger"))

        assertThat(XsNegativeInteger.baseType, `is`(XsNonPositiveInteger as XmlSchemaType))
        assertThat(XsNegativeInteger.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "negativeInteger").toXmlSchemaType(),
                `is`(XsNegativeInteger as XdmSequenceType))
    }

    fun testXsLong() {
        assertThat(XsLong.typeName?.prefix, `is`(nullValue()))
        assertThat(XsLong.typeName?.declaration, `is`(nullValue()))

        assertThat(XsLong.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsLong.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsLong.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsLong.typeName?.localName?.lexicalRepresentation, `is`("long"))

        assertThat(XsLong.baseType, `is`(XsInteger as XmlSchemaType))
        assertThat(XsLong.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "long").toXmlSchemaType(),
                `is`(XsLong as XdmSequenceType))
    }

    fun testXsInt() {
        assertThat(XsInt.typeName?.prefix, `is`(nullValue()))
        assertThat(XsInt.typeName?.declaration, `is`(nullValue()))

        assertThat(XsInt.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsInt.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsInt.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsInt.typeName?.localName?.lexicalRepresentation, `is`("int"))

        assertThat(XsInt.baseType, `is`(XsLong as XmlSchemaType))
        assertThat(XsInt.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "int").toXmlSchemaType(),
                `is`(XsInt as XdmSequenceType))
    }

    fun testXsShort() {
        assertThat(XsShort.typeName?.prefix, `is`(nullValue()))
        assertThat(XsShort.typeName?.declaration, `is`(nullValue()))

        assertThat(XsShort.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsShort.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsShort.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsShort.typeName?.localName?.lexicalRepresentation, `is`("short"))

        assertThat(XsShort.baseType, `is`(XsInt as XmlSchemaType))
        assertThat(XsShort.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "short").toXmlSchemaType(),
                `is`(XsShort as XdmSequenceType))
    }

    fun testXsByte() {
        assertThat(XsByte.typeName?.prefix, `is`(nullValue()))
        assertThat(XsByte.typeName?.declaration, `is`(nullValue()))

        assertThat(XsByte.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsByte.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsByte.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsByte.typeName?.localName?.lexicalRepresentation, `is`("byte"))

        assertThat(XsByte.baseType, `is`(XsShort as XmlSchemaType))
        assertThat(XsByte.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "byte").toXmlSchemaType(),
                `is`(XsByte as XdmSequenceType))
    }

    fun testXsNonNegativeInteger() {
        assertThat(XsNonNegativeInteger.typeName?.prefix, `is`(nullValue()))
        assertThat(XsNonNegativeInteger.typeName?.declaration, `is`(nullValue()))

        assertThat(XsNonNegativeInteger.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsNonNegativeInteger.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsNonNegativeInteger.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsNonNegativeInteger.typeName?.localName?.lexicalRepresentation, `is`("nonNegativeInteger"))

        assertThat(XsNonNegativeInteger.baseType, `is`(XsInteger as XmlSchemaType))
        assertThat(XsNonNegativeInteger.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "nonNegativeInteger").toXmlSchemaType(),
                `is`(XsNonNegativeInteger as XdmSequenceType))
    }

    fun testXsUnsignedLong() {
        assertThat(XsUnsignedLong.typeName?.prefix, `is`(nullValue()))
        assertThat(XsUnsignedLong.typeName?.declaration, `is`(nullValue()))

        assertThat(XsUnsignedLong.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsUnsignedLong.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsUnsignedLong.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsUnsignedLong.typeName?.localName?.lexicalRepresentation, `is`("unsignedLong"))

        assertThat(XsUnsignedLong.baseType, `is`(XsNonNegativeInteger as XmlSchemaType))
        assertThat(XsUnsignedLong.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "unsignedLong").toXmlSchemaType(),
                `is`(XsUnsignedLong as XdmSequenceType))
    }

    fun testXsUnsignedInt() {
        assertThat(XsUnsignedInt.typeName?.prefix, `is`(nullValue()))
        assertThat(XsUnsignedInt.typeName?.declaration, `is`(nullValue()))

        assertThat(XsUnsignedInt.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsUnsignedInt.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsUnsignedInt.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsUnsignedInt.typeName?.localName?.lexicalRepresentation, `is`("unsignedInt"))

        assertThat(XsUnsignedInt.baseType, `is`(XsUnsignedLong as XmlSchemaType))
        assertThat(XsUnsignedInt.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "unsignedInt").toXmlSchemaType(),
                `is`(XsUnsignedInt as XdmSequenceType))
    }

    fun testXsUnsignedShort() {
        assertThat(XsUnsignedShort.typeName?.prefix, `is`(nullValue()))
        assertThat(XsUnsignedShort.typeName?.declaration, `is`(nullValue()))

        assertThat(XsUnsignedShort.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsUnsignedShort.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsUnsignedShort.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsUnsignedShort.typeName?.localName?.lexicalRepresentation, `is`("unsignedShort"))

        assertThat(XsUnsignedShort.baseType, `is`(XsUnsignedInt as XmlSchemaType))
        assertThat(XsUnsignedShort.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "unsignedShort").toXmlSchemaType(),
                `is`(XsUnsignedShort as XdmSequenceType))
    }

    fun testXsUnsignedByte() {
        assertThat(XsUnsignedByte.typeName?.prefix, `is`(nullValue()))
        assertThat(XsUnsignedByte.typeName?.declaration, `is`(nullValue()))

        assertThat(XsUnsignedByte.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsUnsignedByte.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsUnsignedByte.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsUnsignedByte.typeName?.localName?.lexicalRepresentation, `is`("unsignedByte"))

        assertThat(XsUnsignedByte.baseType, `is`(XsUnsignedShort as XmlSchemaType))
        assertThat(XsUnsignedByte.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "unsignedByte").toXmlSchemaType(),
                `is`(XsUnsignedByte as XdmSequenceType))
    }

    fun testXsPositiveInteger() {
        assertThat(XsPositiveInteger.typeName?.prefix, `is`(nullValue()))
        assertThat(XsPositiveInteger.typeName?.declaration, `is`(nullValue()))

        assertThat(XsPositiveInteger.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsPositiveInteger.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsPositiveInteger.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsPositiveInteger.typeName?.localName?.lexicalRepresentation, `is`("positiveInteger"))

        assertThat(XsPositiveInteger.baseType, `is`(XsNonNegativeInteger as XmlSchemaType))
        assertThat(XsPositiveInteger.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "positiveInteger").toXmlSchemaType(),
                `is`(XsPositiveInteger as XdmSequenceType))
    }

    fun testXsGYearMonth() {
        assertThat(XsGYearMonth.typeName?.prefix, `is`(nullValue()))
        assertThat(XsGYearMonth.typeName?.declaration, `is`(nullValue()))

        assertThat(XsGYearMonth.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsGYearMonth.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsGYearMonth.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsGYearMonth.typeName?.localName?.lexicalRepresentation, `is`("gYearMonth"))

        assertThat(XsGYearMonth.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsGYearMonth.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "gYearMonth").toXmlSchemaType(),
                `is`(XsGYearMonth as XdmSequenceType))
    }

    fun testXsGYear() {
        assertThat(XsGYear.typeName?.prefix, `is`(nullValue()))
        assertThat(XsGYear.typeName?.declaration, `is`(nullValue()))

        assertThat(XsGYear.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsGYear.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsGYear.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsGYear.typeName?.localName?.lexicalRepresentation, `is`("gYear"))

        assertThat(XsGYear.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsGYear.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "gYear").toXmlSchemaType(),
                `is`(XsGYear as XdmSequenceType))
    }

    fun testXsGMonthDay() {
        assertThat(XsGMonthDay.typeName?.prefix, `is`(nullValue()))
        assertThat(XsGMonthDay.typeName?.declaration, `is`(nullValue()))

        assertThat(XsGMonthDay.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsGMonthDay.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsGMonthDay.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsGMonthDay.typeName?.localName?.lexicalRepresentation, `is`("gMonthDay"))

        assertThat(XsGMonthDay.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsGMonthDay.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "gMonthDay").toXmlSchemaType(),
                `is`(XsGMonthDay as XdmSequenceType))
    }

    fun testXsGDay() {
        assertThat(XsGDay.typeName?.prefix, `is`(nullValue()))
        assertThat(XsGDay.typeName?.declaration, `is`(nullValue()))

        assertThat(XsGDay.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsGDay.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsGDay.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsGDay.typeName?.localName?.lexicalRepresentation, `is`("gDay"))

        assertThat(XsGDay.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsGDay.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "gDay").toXmlSchemaType(),
                `is`(XsGDay as XdmSequenceType))
    }

    fun testXsGMonth() {
        assertThat(XsGMonth.typeName?.prefix, `is`(nullValue()))
        assertThat(XsGMonth.typeName?.declaration, `is`(nullValue()))

        assertThat(XsGMonth.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsGMonth.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsGMonth.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsGMonth.typeName?.localName?.lexicalRepresentation, `is`("gMonth"))

        assertThat(XsGMonth.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsGMonth.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "gMonth").toXmlSchemaType(),
                `is`(XsGMonth as XdmSequenceType))
    }

    fun testXsString() {
        assertThat(XsString.typeName?.prefix, `is`(nullValue()))
        assertThat(XsString.typeName?.declaration, `is`(nullValue()))

        assertThat(XsString.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsString.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsString.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsString.typeName?.localName?.lexicalRepresentation, `is`("string"))

        assertThat(XsString.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsString.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "string").toXmlSchemaType(),
                `is`(XsString as XdmSequenceType))
    }

    fun testXsNormalizedString() {
        assertThat(XsNormalizedString.typeName?.prefix, `is`(nullValue()))
        assertThat(XsNormalizedString.typeName?.declaration, `is`(nullValue()))

        assertThat(XsNormalizedString.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsNormalizedString.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsNormalizedString.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsNormalizedString.typeName?.localName?.lexicalRepresentation, `is`("normalizedString"))

        assertThat(XsNormalizedString.baseType, `is`(XsString as XmlSchemaType))
        assertThat(XsNormalizedString.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "normalizedString").toXmlSchemaType(),
                `is`(XsNormalizedString as XdmSequenceType))
    }

    fun testXsToken() {
        assertThat(XsToken.typeName?.prefix, `is`(nullValue()))
        assertThat(XsToken.typeName?.declaration, `is`(nullValue()))

        assertThat(XsToken.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsToken.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsToken.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsToken.typeName?.localName?.lexicalRepresentation, `is`("token"))

        assertThat(XsToken.baseType, `is`(XsNormalizedString as XmlSchemaType))
        assertThat(XsToken.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "token").toXmlSchemaType(),
                `is`(XsToken as XdmSequenceType))
    }

    fun testXsLanguage() {
        assertThat(XsLanguage.typeName?.prefix, `is`(nullValue()))
        assertThat(XsLanguage.typeName?.declaration, `is`(nullValue()))

        assertThat(XsLanguage.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsLanguage.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsLanguage.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsLanguage.typeName?.localName?.lexicalRepresentation, `is`("language"))

        assertThat(XsLanguage.baseType, `is`(XsToken as XmlSchemaType))
        assertThat(XsLanguage.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "language").toXmlSchemaType(),
                `is`(XsLanguage as XdmSequenceType))
    }

    fun testXsNMTOKEN() {
        assertThat(XsNMTOKEN.typeName?.prefix, `is`(nullValue()))
        assertThat(XsNMTOKEN.typeName?.declaration, `is`(nullValue()))

        assertThat(XsNMTOKEN.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsNMTOKEN.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsNMTOKEN.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsNMTOKEN.typeName?.localName?.lexicalRepresentation, `is`("NMTOKEN"))

        assertThat(XsNMTOKEN.baseType, `is`(XsToken as XmlSchemaType))
        assertThat(XsNMTOKEN.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "NMTOKEN").toXmlSchemaType(),
                `is`(XsNMTOKEN as XdmSequenceType))
    }

    fun testXsName() {
        assertThat(XsName.typeName?.prefix, `is`(nullValue()))
        assertThat(XsName.typeName?.declaration, `is`(nullValue()))

        assertThat(XsName.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsName.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsName.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsName.typeName?.localName?.lexicalRepresentation, `is`("Name"))

        assertThat(XsName.baseType, `is`(XsToken as XmlSchemaType))
        assertThat(XsName.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "Name").toXmlSchemaType(),
                `is`(XsName as XdmSequenceType))
    }

    fun testXsNCName() {
        assertThat(XsNCName.typeName?.prefix, `is`(nullValue()))
        assertThat(XsNCName.typeName?.declaration, `is`(nullValue()))

        assertThat(XsNCName.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsNCName.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsNCName.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsNCName.typeName?.localName?.lexicalRepresentation, `is`("NCName"))

        assertThat(XsNCName.baseType, `is`(XsName as XmlSchemaType))
        assertThat(XsNCName.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "NCName").toXmlSchemaType(),
                `is`(XsNCName as XdmSequenceType))
    }

    fun testXsID() {
        assertThat(XsID.typeName?.prefix, `is`(nullValue()))
        assertThat(XsID.typeName?.declaration, `is`(nullValue()))

        assertThat(XsID.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsID.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsID.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsID.typeName?.localName?.lexicalRepresentation, `is`("ID"))

        assertThat(XsID.baseType, `is`(XsNCName as XmlSchemaType))
        assertThat(XsID.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "ID").toXmlSchemaType(),
                `is`(XsID as XdmSequenceType))
    }

    fun testXsIDREF() {
        assertThat(XsIDREF.typeName?.prefix, `is`(nullValue()))
        assertThat(XsIDREF.typeName?.declaration, `is`(nullValue()))

        assertThat(XsIDREF.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsIDREF.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsIDREF.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsIDREF.typeName?.localName?.lexicalRepresentation, `is`("IDREF"))

        assertThat(XsIDREF.baseType, `is`(XsNCName as XmlSchemaType))
        assertThat(XsIDREF.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "IDREF").toXmlSchemaType(),
                `is`(XsIDREF as XdmSequenceType))
    }

    fun testXsENTITY() {
        assertThat(XsENTITY.typeName?.prefix, `is`(nullValue()))
        assertThat(XsENTITY.typeName?.declaration, `is`(nullValue()))

        assertThat(XsENTITY.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsENTITY.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsENTITY.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsENTITY.typeName?.localName?.lexicalRepresentation, `is`("ENTITY"))

        assertThat(XsENTITY.baseType, `is`(XsNCName as XmlSchemaType))
        assertThat(XsENTITY.isPrimitive, `is`(false))

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "ENTITY").toXmlSchemaType(),
                `is`(XsENTITY as XdmSequenceType))
    }

    fun testXsBoolean() {
        assertThat(XsBoolean.typeName?.prefix, `is`(nullValue()))
        assertThat(XsBoolean.typeName?.declaration, `is`(nullValue()))

        assertThat(XsBoolean.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsBoolean.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsBoolean.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsBoolean.typeName?.localName?.lexicalRepresentation, `is`("boolean"))

        assertThat(XsBoolean.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsBoolean.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "boolean").toXmlSchemaType(),
                `is`(XsBoolean as XdmSequenceType))
    }

    fun testXsBase64Binary() {
        assertThat(XsBase64Binary.typeName?.prefix, `is`(nullValue()))
        assertThat(XsBase64Binary.typeName?.declaration, `is`(nullValue()))

        assertThat(XsBase64Binary.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsBase64Binary.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsBase64Binary.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsBase64Binary.typeName?.localName?.lexicalRepresentation, `is`("base64Binary"))

        assertThat(XsBase64Binary.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsBase64Binary.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "base64Binary").toXmlSchemaType(),
                `is`(XsBase64Binary as XdmSequenceType))
    }

    fun testXsHexBinary() {
        assertThat(XsHexBinary.typeName?.prefix, `is`(nullValue()))
        assertThat(XsHexBinary.typeName?.declaration, `is`(nullValue()))

        assertThat(XsHexBinary.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsHexBinary.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsHexBinary.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsHexBinary.typeName?.localName?.lexicalRepresentation, `is`("hexBinary"))

        assertThat(XsHexBinary.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsHexBinary.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "hexBinary").toXmlSchemaType(),
                `is`(XsHexBinary as XdmSequenceType))
    }

    fun testXsAnyURI() {
        assertThat(XsAnyURI.typeName?.prefix, `is`(nullValue()))
        assertThat(XsAnyURI.typeName?.declaration, `is`(nullValue()))

        assertThat(XsAnyURI.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsAnyURI.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsAnyURI.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsAnyURI.typeName?.localName?.lexicalRepresentation, `is`("anyURI"))

        assertThat(XsAnyURI.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsAnyURI.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "anyURI").toXmlSchemaType(),
                `is`(XsAnyURI as XdmSequenceType))
    }

    fun testXsQName() {
        assertThat(XsQName.typeName?.prefix, `is`(nullValue()))
        assertThat(XsQName.typeName?.declaration, `is`(nullValue()))

        assertThat(XsQName.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsQName.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsQName.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsQName.typeName?.localName?.lexicalRepresentation, `is`("QName"))

        assertThat(XsQName.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsQName.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "QName").toXmlSchemaType(),
                `is`(XsQName as XdmSequenceType))
    }

    fun testXsNOTATION() {
        assertThat(XsNOTATION.typeName?.prefix, `is`(nullValue()))
        assertThat(XsNOTATION.typeName?.declaration, `is`(nullValue()))

        assertThat(XsNOTATION.typeName?.namespace?.staticType, `is`(XsAnyURI as XdmSequenceType))
        assertThat(XsNOTATION.typeName?.namespace?.lexicalRepresentation, `is`("http://www.w3.org/2001/XMLSchema"))

        assertThat(XsNOTATION.typeName?.localName?.staticType, `is`(XsNCName as XdmSequenceType))
        assertThat(XsNOTATION.typeName?.localName?.lexicalRepresentation, `is`("NOTATION"))

        assertThat(XsNOTATION.baseType, `is`(XsAnyAtomicType as XmlSchemaType))
        assertThat(XsNOTATION.isPrimitive, `is`(true)) // XMLSchema definition

        assertThat(createQName("http://www.w3.org/2001/XMLSchema", "NOTATION").toXmlSchemaType(),
                `is`(XsNOTATION as XdmSequenceType))
    }
}
