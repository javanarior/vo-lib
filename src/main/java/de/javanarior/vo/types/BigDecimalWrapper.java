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

import java.math.BigDecimal;

/**
 * Wrapper for BigDecimal values.
 * <p>
 * Please note that the {@linkplain BigDecimalWrapper#equals(Object)}
 * implementation of this class differs from the #equals(Object) implementation
 * of BigDecimal.
 *
 * @param <V>
 *            the value type
 */
public abstract class BigDecimalWrapper<V extends Value<V, BigDecimal>> extends AbstractValue<V, BigDecimal> {

    private static final int EQUALS = 0;
    private final BigDecimal value;

    /**
     * Create BigDecimal Type from BigDecimal value.
     *
     * @param value
     *            - value for the object
     */
    public BigDecimalWrapper(BigDecimal value) {
        super();
        this.value = assertNotNull(value);
    }

    @Override
    public BigDecimal getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + value.hashCode();
    }

    /**
     * To compare the value, this implementation uses
     * {@linkplain BigDecimal#compareTo(BigDecimal)} instead of equals. This
     * means two values of BigDecimalWrapper are equals even if they have a
     * different scale.
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        BigDecimalWrapper<?> other = (BigDecimalWrapper<?>)obj;
        if (value.compareTo(other.value) != EQUALS) {
            return false;
        }
        return true;
    }

    @Override
    public BigDecimal asBigDecimal() {
        return value;
    }

    @Override
    public String asString() {
        return value.toPlainString();
    }

}
