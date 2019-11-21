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

package ui;

import org.javatuples.Pair;
import ui.mutables.MutString;
import ui.wrapper.ButtonRow;
import ui.wrapper.TextField;
import ui.wrapper.WrappedComponent;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * A window for the calculator.
 * @since 0.1.0
 */
public class CalculatorWindow implements Showable {
    /**
     * The number of cells inside of a row that contains buttons.
     * Example: First row: 1, 2, 3, =, C -> 5 cells.
     * All button rows need to have the same number of cells.
     */
    private static final int ROW_CELLS = 5;

    /**
     * The number of cells in a column. Only the button rows are counted.
     * Example: First column: 1, 4, 7 -> 3 cells.
     * All columns need to have the same number of cells.
     */
    private static final int COLUMN_CELLS = 3;

    private final JFrame frame;

    /**
     * Ctor.
     * @param textFieldH The height of the TextField containing representing
     *                   the calculation.
     * @param buttonSize The size of the buttons.
     */
    public CalculatorWindow(int textFieldH, int buttonSize) {
        this(new MutString("0"), textFieldH, buttonSize);
    }

    /**
     * Ctor. This constructor is necessary because the MutString is needed in
     * multiple objects. Because it's impossible to create a variable inside of
     * a constructor before the this call, a second constructor does the job.
     * @param text The text of the TextField.
     * @param textFieldH The height of the TextField containing representing
     *                   the calculation.
     * @param buttonSize The size of the buttons.
     */
    private CalculatorWindow(MutString text, int textFieldH, int buttonSize) {
        this(
            buttonSize * ROW_CELLS, textFieldH + COLUMN_CELLS * buttonSize,
            new TextField(text, buttonSize * ROW_CELLS, textFieldH),
            new ButtonRow(
                0,
                textFieldH,
                buttonSize,
                Pair.with("1", t -> text.value(text.value() + t)),
                Pair.with("2", t -> text.value(text.value() + t)),
                Pair.with("3", t -> text.value(text.value() + t)),
                Pair.with("=", t -> System.out.println("=")),
                Pair.with("C", t -> text.value("0"))
            ),
            new ButtonRow(
                0,
                textFieldH + buttonSize,
                buttonSize,
                Pair.with("4", t -> text.value(text.value() + t)),
                Pair.with("5", t -> text.value(text.value() + t)),
                Pair.with("6", t -> text.value(text.value() + t)),
                Pair.with("+", t -> System.out.println("=")),
                Pair.with("-", t -> text.value("0"))
            ),
            new ButtonRow(
                0,
                textFieldH + buttonSize * 2,
                buttonSize,
                Pair.with("7", t -> text.value(text.value() + t)),
                Pair.with("8", t -> text.value(text.value() + t)),
                Pair.with("9", t -> text.value(text.value() + t)),
                Pair.with("*", t -> System.out.println("=")),
                Pair.with("/", t -> text.value("0"))
            )
        );
    }

    private CalculatorWindow(int w, int h, WrappedComponent... components) {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        for (WrappedComponent c : components) {
            c.addOn(frame);
        }
        frame.getContentPane().setPreferredSize(new Dimension(w, h));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    @Override
    public final void show() {
        this.frame.setVisible(true);
    }
}
