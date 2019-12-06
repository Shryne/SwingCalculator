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

import logic.Calculator;
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
        this(new Calculator(), new MutString("0"), textFieldH, buttonSize);
    }

    /**
     * Ctor. This constructor is necessary because the MutString is needed in
     * multiple objects. Because it's impossible to create a variable inside of
     * a constructor before the this call, a second constructor does the job.
     * @param calc The calculator doing the calculations.
     * @param text The text of the TextField.
     * @param textFieldH The height of the TextField containing representing
     *                   the calculation.
     * @param buttonSize The size of the buttons.
     */
    private CalculatorWindow(
        Calculator calc, MutString text, int textFieldH, int buttonSize
    ) {
        this(
            buttonSize * ROW_CELLS, textFieldH + COLUMN_CELLS * buttonSize,
            new TextField(text, buttonSize * ROW_CELLS, textFieldH),
            new ButtonRow(
                0,
                textFieldH,
                buttonSize,
                Pair.with("1", t -> {
                    if (text.value().equals("0")) {
                        text.value(t);
                        // matches(^[+-/*]) would be more elegant
                        // but for some reason the ^ doesn't work
                    } else {
                        if (hasSign(text.value())) {
                            applyCalculation(text, calc);
                        } else {
                            text.value(text.value() + t);
                        }
                    }
                }),
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
                Pair.with("+", t -> text.value(t + text.value())),
                Pair.with("-", t -> text.value(t + text.value()))
            ),
            new ButtonRow(
                0,
                textFieldH + buttonSize * 2,
                buttonSize,
                Pair.with("7", t -> text.value(text.value() + t)),
                Pair.with("8", t -> text.value(text.value() + t)),
                Pair.with("9", t -> text.value(text.value() + t)),
                Pair.with("*", t -> text.value(t + text.value())),
                Pair.with("/", t -> text.value(t + text.value()))
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

    /**
     * TODO: The supported signs should be noted at only one place.
     * Checks whether the given sequence has a sign as the first character.
     * @param sequence The sequence to be checked.
     * @return True if the first character is a supported sign or otherwise
     *  false.
     */
    private static boolean hasSign(CharSequence sequence) {
        return sequence.charAt(0) == '+' || sequence.charAt(0) == '-'
            || sequence.charAt(0) == '*' || sequence.charAt(0) == '/';
    }

    /**
     * Applies the calculation based on the sing in the text argument.
     * @param text The text that must have a sign as a first character. Only
     *             +, -, * and / are supported.
     * @param calc The calculator where the sign is applied on.
     * @throws IllegalArgumentException When text doesn't have a supported sign
     *  as the first character.
     */
    private static void applyCalculation(MutString text, Calculator calc) {
        if (text.value().charAt(0) == '+') {
            calc.add(Integer.parseInt(text.value().substring(1)));
        } else if (text.value().charAt(0) == '-') {
            calc.minus(Integer.parseInt(text.value().substring(1)));
        } else if (text.value().charAt(0) == '*') {
            calc.mul(Integer.parseInt(text.value().substring(1)));
        } else if (text.value().charAt(0) == '/') {
            calc.div(Integer.parseInt(text.value().substring(1)));
        } else {
            throw new IllegalArgumentException(
                "The given text must have a sign at the beginning at this " +
                    "point but is: " + text.value()
            );
        }
        text.value(Integer.toString(1));
    }
}
