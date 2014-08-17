/*
 * Copyright (C) 2014 Sven von Pluto - javanarior@gmail.com
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
package de.javanarior.vo.types;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.types.helper.OtherStringValue;
import de.javanarior.vo.types.helper.OtherStringValueImpl;
import de.javanarior.vo.types.helper.StringValue;
import de.javanarior.vo.types.helper.StringValueImpl;

@Test
public class StringWrapperTest extends AbstractValueTest {

    private static final StringValue ONE = new StringValueImpl("one");
    private static final StringValue TWO = new StringValueImpl("2");
    private static final StringValue ANOTHER_ONE = new StringValueImpl("one");
    private static final OtherStringValue OTHER_TYPE_ONE = new OtherStringValueImpl("one");

    public void testEqualsForDifferentTypes() {
        Assert.assertFalse(ONE.equals(OTHER_TYPE_ONE));
        Assert.assertFalse(OTHER_TYPE_ONE.equals(ONE));
    }

    public void testAsString() {
        Assert.assertEquals(ONE.asString(), "one");
        Assert.assertEquals("one", ONE.asString());
    }

    public void testCompareTo() {
        Assert.assertEquals(ONE.compareTo(ANOTHER_ONE), 0);
        Assert.assertTrue(ONE.compareTo(TWO) > 0);
        Assert.assertTrue(TWO.compareTo(ONE) < 0);
    }

}
