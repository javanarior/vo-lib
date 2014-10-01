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

/**
 * Wrapper for Boolean values.
 *
 * @param <V>
 *            the value type
 */
public abstract class BooleanWrapper<V extends Value<V, Boolean>> extends AbstractValue<V, Boolean> {

    private final boolean value;

    /**
     * Create Boolean Type with boolean value.
     *
     * @param value
     *            - value for the object
     */
    public BooleanWrapper(boolean value) {
        super();
        this.value = value;
    }

    @Override
    public Boolean getValue() {
        return asBoolean();
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + (value ? 1231 : 1237);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        BooleanWrapper<?> other = (BooleanWrapper<?>)obj;
        if (value != other.value) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean asBoolean() {
        return Boolean.valueOf(value);
    }

    @Override
    public boolean asPrimitiveBoolean() {
        return value;
    }

}
