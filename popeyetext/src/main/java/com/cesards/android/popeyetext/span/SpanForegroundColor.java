package com.cesards.android.popeyetext.span;

import android.text.style.ForegroundColorSpan;

/**
 * Created by cesards on 15/06/15.
 */
public class SpanForegroundColor extends Span {

    private final int color;

    public SpanForegroundColor(int color) {
        this.color = color;
    }

    @Override
    public Object getSpanType() {
        return new ForegroundColorSpan(color);
    }
}
