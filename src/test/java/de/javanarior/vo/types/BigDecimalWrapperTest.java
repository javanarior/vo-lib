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

import java.math.BigDecimal;

import org.testng.Assert;
import org.testng.annotations.Test;

import de.javanarior.vo.types.helper.BigDecimalValue;
import de.javanarior.vo.types.helper.BigDecimalValueImpl;
import de.javanarior.vo.types.helper.OtherBigDecimalValue;
import de.javanarior.vo.types.helper.OtherBigDecimalValueImpl;

@Test
public class BigDecimalWrapperTest extends AbstractValueTest {

    private static final BigDecimalValue ONE = new BigDecimalValueImpl(BigDecimal.valueOf(1.1));
    private static final BigDecimalValue TWO = new BigDecimalValueImpl(BigDecimal.valueOf(2.2));
    private static final BigDecimalValue ANOTHER_ONE = new BigDecimalValueImpl(BigDecimal.valueOf(1.1));
    private static final OtherBigDecimalValue OTHER_TYPE_ONE = new OtherBigDecimalValueImpl(BigDecimal.valueOf(1.1));

    public void testEqualsForDifferentTypes() {
        Assert.assertFalse(ONE.equals(OTHER_TYPE_ONE));
        Assert.assertFalse(OTHER_TYPE_ONE.equals(ONE));
    }

    public void testAsBigDecimal() {
        Assert.assertEquals(ONE.asBigDecimal(), BigDecimal.valueOf(1.1));
        Assert.assertEquals(BigDecimal.valueOf(1.1), ONE.asBigDecimal());
    }

    public void testCompareTo() {
        Assert.assertEquals(ONE.compareTo(ANOTHER_ONE), 0);
        Assert.assertTrue(ONE.compareTo(TWO) < 0);
        Assert.assertTrue(TWO.compareTo(ONE) > 0);
    }

}
