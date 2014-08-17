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

import de.javanarior.vo.types.helper.ByteValue;
import de.javanarior.vo.types.helper.ByteValueImpl;
import de.javanarior.vo.types.helper.OtherByteValue;
import de.javanarior.vo.types.helper.OtherByteValueImpl;

@Test
public class ByteWrapperTest {

    private static final ByteValue ONE = new ByteValueImpl((byte)1);
    private static final ByteValue TWO = new ByteValueImpl((byte)2);
    private static final ByteValue ANOTHER_ONE = new ByteValueImpl((byte)1);
    private static final OtherByteValue OTHER_TYPE_ONE = new OtherByteValueImpl((byte)1);

    public void testEqualsForDifferentTypes() {
        Assert.assertFalse(ONE.equals(OTHER_TYPE_ONE));
        Assert.assertFalse(OTHER_TYPE_ONE.equals(ONE));
    }

    public void testAsPrimitiveByte() {
        Assert.assertEquals(ONE.asPrimitiveByte(), (byte)1);
        Assert.assertEquals((byte)1, ONE.asPrimitiveByte());
    }

    public void testAsByte() {
        Assert.assertEquals(ONE.asByte(), Byte.valueOf("1"));
        Assert.assertEquals(Byte.valueOf("1"), ONE.asByte());
    }

    public void testCompareTo() {
        Assert.assertEquals(ONE.compareTo(ANOTHER_ONE), 0);
        Assert.assertTrue(ONE.compareTo(TWO) < 0);
        Assert.assertTrue(TWO.compareTo(ONE) > 0);
    }

}
