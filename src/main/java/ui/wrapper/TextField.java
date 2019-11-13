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

import ui.mutables.MutString;

import javax.swing.*;
import java.awt.*;

/**
 * A wrapper for {@link javax.swing.JTextField}.
 * @since 0.3.0
 */
public class TextField implements WrappedComponent {
    private final JTextField wrapped;
    private final MutString text;

    public TextField(String text, int x, int y, int w, int h) {
        this(new MutString(text), x, y, w, h);
    }

    public TextField(MutString text, int x, int y, int w, int h) {
        wrapped = new JTextField(text.value());
        text.register(this);
        this.text = text;
        wrapped.setBounds(x, y, w, h);
        wrapped.setHorizontalAlignment(JTextField.RIGHT);
        wrapped.setEditable(false);
    }

    @Override
    public final void addOn(Container container) {
        container.add(wrapped);
    }

    @Override
    public void update() {
        wrapped.setText(text.value());
    }
}
