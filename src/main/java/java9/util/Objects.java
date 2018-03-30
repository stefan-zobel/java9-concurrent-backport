/*
 * Copyright (c) 2009, 2016, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package java9.util;

import java.util.function.Supplier;

/**
 * This class consists of {@code static} utility methods for operating on
 * objects, or checking certain conditions before operation. These utilities
 * include {@code null}-safe or {@code null}-tolerant methods for computing the
 * hash code of an object, returning a string for an object, comparing two
 * objects, and checking if indexes or sub-range values are out-of-bounds.
 *
 * <p>
 * <b>API Note:</b><br>
 * Static methods such as {@link Objects#checkIndex},
 * {@link Objects#checkFromToIndex}, and {@link Objects#checkFromIndexSize} are
 * provided for the convenience of checking if values corresponding to indexes
 * and sub-ranges are out-of-bounds.
 *
 * @since 1.7
 */
public final class Objects {
    private Objects() {
    }

    /**
     * Returns the first argument if it is non-{@code null} and otherwise
     * returns the non-{@code null} second argument.
     *
     * @param obj
     *            an object
     * @param defaultObj
     *            a non-{@code null} object to return if the first argument is
     *            {@code null}
     * @param <T>
     *            the type of the reference
     * @return the first argument if it is non-{@code null} and otherwise the
     *         second argument if it is non-{@code null}
     * @throws NullPointerException
     *             if both {@code obj} is null and {@code defaultObj} is
     *             {@code null}
     * @since 9
     */
    public static <T> T requireNonNullElse(T obj, T defaultObj) {
        return (obj != null) ? obj : java.util.Objects.requireNonNull(defaultObj, "defaultObj");
    }

    /**
     * Returns the first argument if it is non-{@code null} and otherwise
     * returns the non-{@code null} value of {@code supplier.get()}.
     *
     * @param obj
     *            an object
     * @param supplier
     *            of a non-{@code null} object to return if the first argument
     *            is {@code null}
     * @param <T>
     *            the type of the first argument and return type
     * @return the first argument if it is non-{@code null} and otherwise the
     *         value from {@code supplier.get()} if it is non-{@code null}
     * @throws NullPointerException
     *             if both {@code obj} is null and either the {@code supplier}
     *             is {@code null} or the {@code supplier.get()} value is
     *             {@code null}
     * @since 9
     */
    public static <T> T requireNonNullElseGet(T obj, Supplier<? extends T> supplier) {
        return (obj != null) ? obj
                : java.util.Objects.requireNonNull(java.util.Objects.requireNonNull(supplier, "supplier").get(),
                        "supplier.get()");
    }

    /**
     * Checks if the {@code index} is within the bounds of the range from
     * {@code 0} (inclusive) to {@code length} (exclusive).
     *
     * <p>
     * The {@code index} is defined to be out-of-bounds if any of the following
     * inequalities is true:
     * <ul>
     * <li>{@code index < 0}</li>
     * <li>{@code index >= length}</li>
     * <li>{@code length < 0}, which is implied from the former
     * inequalities</li>
     * </ul>
     *
     * @param index
     *            the index
     * @param length
     *            the upper-bound (exclusive) of the range
     * @return {@code index} if it is within bounds of the range
     * @throws IndexOutOfBoundsException
     *             if the {@code index} is out-of-bounds
     * @since 9
     */
    public static int checkIndex(int index, int length) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException(String.format("Index %d out-of-bounds for length %d", index, length));
        }
        return index;
    }

    /**
     * Checks if the sub-range from {@code fromIndex} (inclusive) to
     * {@code toIndex} (exclusive) is within the bounds of range from {@code 0}
     * (inclusive) to {@code length} (exclusive).
     *
     * <p>
     * The sub-range is defined to be out-of-bounds if any of the following
     * inequalities is true:
     * <ul>
     * <li>{@code fromIndex < 0}</li>
     * <li>{@code fromIndex > toIndex}</li>
     * <li>{@code toIndex > length}</li>
     * <li>{@code length < 0}, which is implied from the former
     * inequalities</li>
     * </ul>
     *
     * @param fromIndex
     *            the lower-bound (inclusive) of the sub-range
     * @param toIndex
     *            the upper-bound (exclusive) of the sub-range
     * @param length
     *            the upper-bound (exclusive) the range
     * @return {@code fromIndex} if the sub-range is within bounds of the range
     * @throws IndexOutOfBoundsException
     *             if the sub-range is out-of-bounds
     * @since 9
     */
    public static int checkFromToIndex(int fromIndex, int toIndex, int length) {
        if (fromIndex < 0 || fromIndex > toIndex || toIndex > length) {
            throw new IndexOutOfBoundsException(
                    String.format("Range [%d, %d) out-of-bounds for length %d", fromIndex, toIndex, length));
        }
        return fromIndex;
    }

    /**
     * Checks if the sub-range from {@code fromIndex} (inclusive) to
     * {@code fromIndex + size} (exclusive) is within the bounds of range from
     * {@code 0} (inclusive) to {@code length} (exclusive).
     *
     * <p>
     * The sub-range is defined to be out-of-bounds if any of the following
     * inequalities is true:
     * <ul>
     * <li>{@code fromIndex < 0}</li>
     * <li>{@code size < 0}</li>
     * <li>{@code fromIndex + size > length}, taking into account integer
     * overflow</li>
     * <li>{@code length < 0}, which is implied from the former
     * inequalities</li>
     * </ul>
     *
     * @param fromIndex
     *            the lower-bound (inclusive) of the sub-interval
     * @param size
     *            the size of the sub-range
     * @param length
     *            the upper-bound (exclusive) of the range
     * @return {@code fromIndex} if the sub-range is within bounds of the range
     * @throws IndexOutOfBoundsException
     *             if the sub-range is out-of-bounds
     * @since 9
     */
    public static int checkFromIndexSize(int fromIndex, int size, int length) {
        if ((length | fromIndex | size) < 0 || size > length - fromIndex) {
            throw new IndexOutOfBoundsException(
                    String.format("Range [%d, %<d + %d) out-of-bounds for length %d", fromIndex, size, length));
        }
        return fromIndex;
    }
}
