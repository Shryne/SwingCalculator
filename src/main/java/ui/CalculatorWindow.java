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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
    private final JFrame frame;

    /**
     * Ctor.
     */
    public CalculatorWindow() {
        this.frame = new JFrame("Calculator");
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final JPanel panel = new JPanel(new GridBagLayout());
        final JTextField textField = new JTextField("");
        final GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 0.3;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 5;
        c.gridheight = 1;
        panel.add(textField, c);

        for (int i = 0; i < 9; i++) {
            final JButton button = new JButton(Integer.toString(i + 1));
            final GridBagConstraints cb = new GridBagConstraints();
            cb.gridx = i % 3;
            cb.gridy = i / 3 + 1;
            cb.gridwidth = 1;
            cb.gridheight = 1;
            cb.weightx = 1.0;
            cb.weighty = 0.3;
            cb.fill = GridBagConstraints.BOTH;
            panel.add(button, cb);
        }


        this.frame.add(panel);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
    }

    @Override
    public final void show() {
        this.frame.setVisible(true);
    }
}
