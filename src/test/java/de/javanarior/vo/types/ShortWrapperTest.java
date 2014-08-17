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

import de.javanarior.vo.types.helper.OtherShortValue;
import de.javanarior.vo.types.helper.OtherShortValueImpl;
import de.javanarior.vo.types.helper.ShortValue;
import de.javanarior.vo.types.helper.ShortValueImpl;

@Test
public class ShortWrapperTest {

    private static final ShortValue ONE = new ShortValueImpl((short)1);
    private static final ShortValue TWO = new ShortValueImpl((short)2);
    private static final ShortValue ANOTHER_ONE = new ShortValueImpl((short)1);
    private static final OtherShortValue OTHER_TYPE_ONE = new OtherShortValueImpl((short)1);

    public void testEqualsForDifferentTypes() {
        Assert.assertFalse(ONE.equals(OTHER_TYPE_ONE));
        Assert.assertFalse(OTHER_TYPE_ONE.equals(ONE));
    }

    public void testAsPrimitiveShort() {
        Assert.assertEquals(ONE.asPrimitiveShort(), (short)1);
        Assert.assertEquals((short)1, ONE.asPrimitiveShort());
    }

    public void testAsShort() {
        Assert.assertEquals(ONE.asShort(), Short.valueOf("1"));
        Assert.assertEquals(Short.valueOf("1"), ONE.asShort());
    }

    public void testCompareTo() {
        Assert.assertEquals(ONE.compareTo(ANOTHER_ONE), 0);
        Assert.assertTrue(ONE.compareTo(TWO) < 0);
        Assert.assertTrue(TWO.compareTo(ONE) > 0);
    }

}
