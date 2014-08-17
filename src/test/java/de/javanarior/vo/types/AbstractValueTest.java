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

import org.testng.annotations.Test;

@Test
public class AbstractValueTest {

    public void testIntegerCasting() {
        // Street string = TypeString.create(Street.class, 12);
        // Assert.assertEquals(string.asInt(), 12);
        // Assert.assertEquals(string.asInteger(), Integer.valueOf(12));
    }

    public void testStringCasting() {
        // StreetNumber integer = TypeInteger.create(StreetNumber.class, 12);
        // StringValue integer = TypeInteger.create(StringValue.class, 12);
        // StringValue integerAsString = TypeInteger.create(StringValue.class,
        // "12");
        // Street integer = TypeInteger.create(Street.class, "12");
        // Assert.assertEquals(integer.asString(), "12");
    }

}
