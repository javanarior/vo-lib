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

import de.javanarior.vo.types.helper.DoubleValue;
import de.javanarior.vo.types.helper.DoubleValueImpl;
import de.javanarior.vo.types.helper.OtherDoubleValue;
import de.javanarior.vo.types.helper.OtherDoubleValueImpl;

@Test
public class DoubleWrapperTest {

    private static final DoubleValue ONE = new DoubleValueImpl(1.1);
    private static final DoubleValue TWO = new DoubleValueImpl(2.2);
    private static final DoubleValue ANOTHER_ONE = new DoubleValueImpl(1.1);
    private static final OtherDoubleValue OTHER_TYPE_ONE = new OtherDoubleValueImpl(1.1);

    public void testEqualsForDifferentTypes() {
        Assert.assertFalse(ONE.equals(OTHER_TYPE_ONE));
        Assert.assertFalse(OTHER_TYPE_ONE.equals(ONE));
    }

    public void testAsPrimitiveDouble() {
        Assert.assertEquals(ONE.asPrimitiveDouble(), 1.1);
        Assert.assertEquals(1.1, ONE.asPrimitiveDouble());
    }

    public void testAsDouble() {
        Assert.assertEquals(ONE.asDouble(), Double.valueOf(1.1));
        Assert.assertEquals(Double.valueOf(1.1), ONE.asDouble());
    }

    public void testCompareTo() {
        Assert.assertEquals(ONE.compareTo(ANOTHER_ONE), 0);
        Assert.assertTrue(ONE.compareTo(TWO) < 0);
        Assert.assertTrue(TWO.compareTo(ONE) > 0);
    }

}
