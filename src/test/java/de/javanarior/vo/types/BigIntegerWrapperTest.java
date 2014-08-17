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

import java.math.BigInteger;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.types.helper.BigIntegerValue;
import de.javanarior.vo.types.helper.BigIntegerValueImpl;
import de.javanarior.vo.types.helper.OtherBigIntegerValue;
import de.javanarior.vo.types.helper.OtherBigIntegerValueImpl;

@Test
public class BigIntegerWrapperTest extends AbstractValueTest {

    private static final BigIntegerValue ONE = new BigIntegerValueImpl(BigInteger.valueOf(1L));
    private static final BigIntegerValue TWO = new BigIntegerValueImpl(BigInteger.valueOf(2L));
    private static final BigIntegerValue ANOTHER_ONE = new BigIntegerValueImpl(BigInteger.valueOf(1L));
    private static final OtherBigIntegerValue OTHER_TYPE_ONE = new OtherBigIntegerValueImpl(BigInteger.valueOf(1L));

    public void testEqualsForDifferentTypes() {
        Assert.assertFalse(ONE.equals(OTHER_TYPE_ONE));
        Assert.assertFalse(OTHER_TYPE_ONE.equals(ONE));
    }

    public void testAsBigInteger() {
        Assert.assertEquals(ONE.asBigInteger(), BigInteger.valueOf(1L));
        Assert.assertEquals(BigInteger.valueOf(1L), ONE.asBigInteger());
    }

    public void testCompareTo() {
        Assert.assertEquals(ONE.compareTo(ANOTHER_ONE), 0);
        Assert.assertTrue(ONE.compareTo(TWO) < 0);
        Assert.assertTrue(TWO.compareTo(ONE) > 0);
    }

}
