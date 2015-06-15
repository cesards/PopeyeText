package com.cesards.android.popeyetext.span;

import android.text.style.BackgroundColorSpan;
import com.cesards.android.popeyetext.span.Span;

/**
 * Created by cesards on 12/06/15.
 */
public class SpanBackgroundColor extends Span {

    private final int color;

    public SpanBackgroundColor(int color) {
        this.color = color;
    }

    @Override
    public Object getSpanType() {
        return new BackgroundColorSpan(color);
    }
}
