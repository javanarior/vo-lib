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

import de.javanarior.vo.types.helper.IntValue;
import de.javanarior.vo.types.helper.IntValueImpl;
import de.javanarior.vo.types.helper.OtherIntValue;
import de.javanarior.vo.types.helper.OtherIntValueImpl;

@Test
public class IntWrapperTest {

    private static final IntValue ONE = new IntValueImpl(1);
    private static final IntValue TWO = new IntValueImpl(2);
    private static final IntValue ANOTHER_ONE = new IntValueImpl(1);
    private static final OtherIntValue OTHER_TYPE_ONE = new OtherIntValueImpl(1);

    public void testEqualsForDifferentTypes() {
        Assert.assertFalse(ONE.equals(OTHER_TYPE_ONE));
        Assert.assertFalse(OTHER_TYPE_ONE.equals(ONE));
    }

    public void testAsInt() {
        Assert.assertEquals(ONE.asInt(), 1);
        Assert.assertEquals(1, ONE.asInt());
    }

    public void testAsInteger() {
        Assert.assertEquals(ONE.asInteger(), Integer.valueOf(1));
        Assert.assertEquals(Integer.valueOf(1), ONE.asInteger());
    }

    public void testCompareTo() {
        Assert.assertEquals(ONE.compareTo(ANOTHER_ONE), 0);
        Assert.assertTrue(ONE.compareTo(TWO) < 0);
        Assert.assertTrue(TWO.compareTo(ONE) > 0);
    }

}
