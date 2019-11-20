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


import org.javatuples.Pair;
import org.javatuples.Tuple;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * A group of buttons.
 */
public class ButtonRow implements WrappedComponent {
    private final List<Button> buttons;

    public ButtonRow(int x, int y, int size, String... texts) {
        this(x, y, size, size, texts);
    }

    public ButtonRow(
        int x, int y, int size, Pair<String, Action>... content
    ) {
        this(x, y, size, size, List.of(content));
    }

    public ButtonRow(int x, int y, int w, int h, String... texts) {
        this(
            x, y, w, h,
            Arrays.stream(texts).map(t -> Pair.with(t, Action.NO)).collect(
                Collectors.toUnmodifiableList()
            )
        );
    }

    public ButtonRow(
        int x, int y, int w, int h, List<Pair<String, Action>> content
    ) {
        buttons = new ArrayList<>(content.size());
        int i = 0;
        for (var e : content) {
            buttons.add(
                new Button(e.getValue0(), x + i * w, y, w, h, e.getValue1())
            );
            i++;
        }
    }

    @Override
    public final void addOn(Container container) {
        buttons.forEach(b -> b.addOn(container));
    }

    @Override
    public final void update() {
        buttons.forEach(Button::update);
    }
}