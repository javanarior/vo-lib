/*
 * Copyright (C) 2014 Sven von Pluto - javanarior (a) gmail dot com
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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import de.javanarior.vo.types.helper.BigDecimalValueImpl;
import de.javanarior.vo.types.helper.BigIntegerValueImpl;
import de.javanarior.vo.types.helper.BooleanValueImpl;
import de.javanarior.vo.types.helper.ByteValueImpl;
import de.javanarior.vo.types.helper.CharValueImpl;
import de.javanarior.vo.types.helper.DoubleValueImpl;
import de.javanarior.vo.types.helper.IntValueImpl;
import de.javanarior.vo.types.helper.LongValueImpl;
import de.javanarior.vo.types.helper.ShortValueImpl;
import de.javanarior.vo.types.helper.StringValueImpl;

@Test
public class WrapperTest {

    @DataProvider(name = "getValue")
    public Object[][] getWrapper() {
//        @formatter:off
        return new Object[][] {
            {new BigDecimalValueImpl(BigDecimal.valueOf(1.1)), new BigDecimalValueImpl(BigDecimal.valueOf(1.1)),
             new BigDecimalValueImpl(BigDecimal.valueOf(2.2))}
          , {new BigIntegerValueImpl(BigInteger.valueOf(1)), new BigIntegerValueImpl(BigInteger.valueOf(1)),
             new BigIntegerValueImpl(BigInteger.valueOf(2))}
          , {new BooleanValueImpl(true), new BooleanValueImpl(true), new BooleanValueImpl(false)}
          , {new ByteValueImpl((byte)1), new ByteValueImpl((byte)1), new ByteValueImpl((byte)2)}
          , {new CharValueImpl('1'), new CharValueImpl('1'), new CharValueImpl('2')}
          , {new DoubleValueImpl(1.1), new DoubleValueImpl(1.1), new DoubleValueImpl(2.2)}
          , {new IntValueImpl(1), new IntValueImpl(1), new IntValueImpl(2)}
          , {new LongValueImpl(1L), new LongValueImpl(1L), new LongValueImpl(2L)}
          , {new ShortValueImpl((short)1), new ShortValueImpl((short)1), new ShortValueImpl((short)2)}
          , {new StringValueImpl("one"), new StringValueImpl("one"), new StringValueImpl("two")}
        };
//        @formatter:on
    }

    @Test(dataProvider = "getValue")
    public void testHashCodeNotEqualForDifferentValues(Value<?> one, Value<?> anotherOne, Value<?> two) {
        assertNotEquals(one.hashCode(), two.hashCode());
        assertNotEquals(anotherOne.hashCode(), two.hashCode());
    }

    @Test(dataProvider = "getValue")
    public void testHashCodeEqualForEqualValues(Value<?> one, Value<?> anotherOne, Value<?> two) {
        assertNotSame(one, anotherOne);
        assertEquals(one.hashCode(), anotherOne.hashCode());
        assertEquals(one.hashCode(), one.hashCode());
    }

    @Test(dataProvider = "getValue")
    public void testEqualsForDifferentValues(Value<?> one, Value<?> anotherOne, Value<?> two) {
        assertFalse(one.equals(two));
        assertFalse(two.equals(one));
    }

    @Test(dataProvider = "getValue")
    public void testEqualsForEqualValues(Value<?> one, Value<?> anotherOne, Value<?> two) {
        assertNotSame(one, anotherOne);
        assertTrue(one.equals(anotherOne));
        assertTrue(anotherOne.equals(one));
        assertTrue(one.equals(one));
    }

    @Test(dataProvider = "getValue")
    public void testEqualsForNull(Value<?> one, Value<?> anotherOne, Value<?> two) {
        assertFalse(one.equals(null));
    }

}
