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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import de.javanarior.vo.types.helper.CharValue;
import de.javanarior.vo.types.helper.CharValueImpl;
import de.javanarior.vo.types.helper.OtherCharValue;
import de.javanarior.vo.types.helper.OtherCharValueImpl;

@Test
public class CharWrapperTest {

    private static final CharValue ONE = new CharValueImpl('1');
    private static final CharValue TWO = new CharValueImpl('2');
    private static final CharValue ANOTHER_ONE = new CharValueImpl('1');
    private static final OtherCharValue OTHER_TYPE_ONE = new OtherCharValueImpl('1');

    public void testEqualsForDifferentTypes() {
        assertFalse(ONE.equals(OTHER_TYPE_ONE));
        assertFalse(OTHER_TYPE_ONE.equals(ONE));
    }

    public void testAsChar() {
        assertEquals(ONE.asChar(), '1');
        assertEquals('1', ONE.asChar());
    }

    public void testAsCharacter() {
        assertEquals(ONE.asCharacter(), Character.valueOf('1'));
        assertEquals(Character.valueOf('1'), ONE.asCharacter());
    }

    public void testCompareTo() {
        assertEquals(ONE.compareTo(ANOTHER_ONE), 0);
        assertTrue(ONE.compareTo(TWO) < 0);
        assertTrue(TWO.compareTo(ONE) > 0);
    }

}
