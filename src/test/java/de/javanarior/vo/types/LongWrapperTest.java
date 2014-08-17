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

import de.javanarior.vo.types.helper.LongValue;
import de.javanarior.vo.types.helper.LongValueImpl;
import de.javanarior.vo.types.helper.OtherLongValue;
import de.javanarior.vo.types.helper.OtherLongValueImpl;

@Test
public class LongWrapperTest {

    private static final LongValue ONE = new LongValueImpl(1L);
    private static final LongValue TWO = new LongValueImpl(2);
    private static final LongValue ANOTHER_ONE = new LongValueImpl(1);
    private static final OtherLongValue OTHER_TYPE_ONE = new OtherLongValueImpl(1L);

    public void testEqualsForDifferentTypes() {
        Assert.assertFalse(ONE.equals(OTHER_TYPE_ONE));
        Assert.assertFalse(OTHER_TYPE_ONE.equals(ONE));
    }

    public void testAsPrimitiveLong() {
        Assert.assertEquals(ONE.asPrimitiveLong(), 1);
        Assert.assertEquals(1, ONE.asPrimitiveLong());
    }

    public void testAsLong() {
        Assert.assertEquals(ONE.asLong(), Long.valueOf(1));
        Assert.assertEquals(Long.valueOf(1), ONE.asLong());
    }

    public void testCompareTo() {
        Assert.assertEquals(ONE.compareTo(ANOTHER_ONE), 0);
        Assert.assertTrue(ONE.compareTo(TWO) < 0);
        Assert.assertTrue(TWO.compareTo(ONE) > 0);
    }

}
