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
 *
 * @param <T>
 *            the value type
 */
public abstract class BigDecimalWrapper<T extends Value<T>> extends AbstractValue<T> {

    private final BigDecimal value;

    /**
     * Create BigDecimal Type from BigDecimal value.
     *
     * @param metaType
     *            - the value type
     * @param value
     *            - value for the object
     */
    protected BigDecimalWrapper(Class<T> metaType, BigDecimal value) {
        super(metaType);
        this.value = value;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BigDecimalWrapper<?> other = (BigDecimalWrapper<?>)obj;
        if (value == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!value.equals(other.value)) {
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

    @Override
    public int compareTo(T other) {
        return value.compareTo(other.asBigDecimal());
    }

}
