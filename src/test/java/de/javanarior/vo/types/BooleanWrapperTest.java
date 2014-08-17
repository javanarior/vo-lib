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

import de.javanarior.vo.types.helper.BooleanValue;
import de.javanarior.vo.types.helper.BooleanValueImpl;
import de.javanarior.vo.types.helper.OtherBooleanValue;
import de.javanarior.vo.types.helper.OtherBooleanValueImpl;

@Test
public class BooleanWrapperTest {

    private static final BooleanValue ONE = new BooleanValueImpl(true);
    private static final BooleanValue TWO = new BooleanValueImpl(false);
    private static final BooleanValue ANOTHER_ONE = new BooleanValueImpl(true);
    private static final OtherBooleanValue OTHER_TYPE_ONE = new OtherBooleanValueImpl(true);

    public void testEqualsForDifferentTypes() {
        Assert.assertFalse(ONE.equals(OTHER_TYPE_ONE));
        Assert.assertFalse(OTHER_TYPE_ONE.equals(ONE));
    }

    public void testPrimitiveBoolean() {
        Assert.assertEquals(ONE.asPrimitiveBoolean(), true);
        Assert.assertEquals(true, ONE.asPrimitiveBoolean());
    }

    public void testAsBoolean() {
        Assert.assertEquals(ONE.asBoolean(), Boolean.valueOf(true));
        Assert.assertEquals(Boolean.valueOf(true), ONE.asBoolean());
    }

    public void testCompareTo() {
        Assert.assertEquals(ONE.compareTo(ANOTHER_ONE), 0);
        Assert.assertTrue(ONE.compareTo(TWO) > 0);
        Assert.assertTrue(TWO.compareTo(ONE) < 0);
    }

}
