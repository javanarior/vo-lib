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

/**
 * Generic Null Object.
 *
 * @param <T>
 *            the value type
 */
public abstract class NullObject<T extends Value<T>> extends AbstractValue<T> {

    /**
     * Create a new NullObject instance.
     *
     * @param metaType
     *            - the value type
     */
    protected NullObject(Class<T> metaType) {
        super(metaType);
    }

    @Override
    public int hashCode() {
        return 15077 + getMetaType().getName().hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return true;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        NullObject<?> other = (NullObject<?>)object;
        if (!super.equals(other)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(T other) {
        throw new UnsupportedOperationException("Null Object are not comparable with other objects.");
    }

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public Object getValue() {
        return null;
    }

}
