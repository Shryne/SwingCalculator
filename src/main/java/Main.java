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

import ui.CalculatorWindow;
import ui.mutables.MutString;
import ui.wrapper.Button;
import ui.wrapper.TextField;

/**
 * The start of the application.
 * @since 0.1.0
 */
public class Main {
    private Main() {} // Because instantiating this class doesn't make sense

    public static void main(String[] args) {
        final var text = new MutString("First");
        new CalculatorWindow(
            200, 150,
            new TextField(text, 0, 0, 200, 50),
            new Button("Hallo", 0, 50, 100, 100),
            new Button("Hey", 100, 50, 100, 100)
        ).show();
        text.value("Second");
    }
}
