/*
 * Copyright 2018 Eugen Deutsch
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following conditions: The above
 * copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF
 * ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package logic;

/**
 * A calculator based on integer values.
 *
 * <p>This class is mutable and not thread-safe.</p>
 */
public class Calculator {
    private int value;

    /**
     * Initializes the value of the calculator with a zero.
     */
    public Calculator() {
        this.value = 0;
    }

    public final void add(int value) {
        this.value += value;
    }

    public final void minus(int value) {
        this.value -= value;
    }

    public final void div(int value) {
        this.value /= value;
    }

    public final void mul(int value) {
        this.value *= value;
    }

    public final int value() {
        return this.value;
    }

    public final void clear() {
        this.value = 0;
    }

    @Override
    public String toString() {
        return "Calculator: " + value;
    }
}
