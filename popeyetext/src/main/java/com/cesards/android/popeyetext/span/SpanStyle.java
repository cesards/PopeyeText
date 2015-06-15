package com.cesards.android.popeyetext.span;

import android.graphics.Typeface;
import android.text.style.StyleSpan;

/**
 * Created by cesards on 12/06/15.
 */
public class SpanStyle extends Span {

    private final Style style;

    public SpanStyle(Style style) {
        this.style = style;
    }

    public enum Style {
        ITALIC(Typeface.ITALIC),
        BOLD(Typeface.BOLD),
        BOLD_ITALIC(Typeface.BOLD_ITALIC),
        NORMAL(Typeface.NORMAL),;

        private int type;

        Style(int type) {
            this.type = type;
        }
    }

    @Override
    public Object getSpanType() {
        return new StyleSpan(this.style.type);
    }
}
