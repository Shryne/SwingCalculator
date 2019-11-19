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

package ui.wrapper;

import javax.swing.*;
import java.awt.*;

/**
 * A wrapper for {@link javax.swing.JButton}.
 * @since 0.3.0
 */
public class Button implements WrappedComponent {
    private final JButton wrapped;

    public Button(String text, int x, int y, int size) {
        this(text, x, y, size, size);
    }

    public Button(String text, int x, int y, int size, Action action) {
        this(text, x, y, size, size, action);
    }

    public Button(String text, int x, int y, int w, int h) {
        this(text, new Rectangle(x, y, w, h));
    }

    public Button(String text, int x, int y, int w, int h, Action action) {
        this(text, new Rectangle(x, y, w, h), action);
    }

    public Button(String text, Rectangle rect) {
        this(text, rect, () -> {});
    }

    public Button(String text, Rectangle rect, Action action) {
        wrapped = new JButton(text);
        wrapped.setBounds(rect);
    }

    @Override
    public void addOn(final Container container) {
        // Doesn't prevent multiple additions
        container.add(this.wrapped);
    }

    @Override
    public void update() {

    }
}
