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

import org.javatuples.Pair;
import ui.CalculatorWindow;
import ui.mutables.MutString;
import ui.wrapper.Button;
import ui.wrapper.ButtonRow;
import ui.wrapper.TextField;

import java.util.Map;

/**
 * The start of the application.
 * @since 0.1.0
 */
public class Main {
    private Main() {} // Because instantiating this class doesn't make sense

    public static void main(String[] args) {
        final var text = new MutString("First");
        final int buttonSize = 100;
        final int textHeight = 50;
        final int rowCells = 5;
        final int columnCells = 3;
        new CalculatorWindow(
                buttonSize * rowCells, textHeight + columnCells * buttonSize,
            new TextField(text, buttonSize * rowCells, textHeight),
            new ButtonRow(
                0,
                textHeight,
                buttonSize,
                Pair.with("1", () -> System.out.println("1")),
                Pair.with("2", () -> System.out.println("2")),
                Pair.with("3", () -> System.out.println("3")),
                Pair.with("=", () -> System.out.println("=")),
                Pair.with("C", () -> System.out.println("C"))
            ),
            new ButtonRow(
                0, textHeight + buttonSize, buttonSize, "4", "5", "6", "+", "-"
            ),
            new ButtonRow(
                0, textHeight + buttonSize * 2, buttonSize, "7", "8", "9", "*", "/"
            )
        ).show();
        text.value("Second");
    }
}
