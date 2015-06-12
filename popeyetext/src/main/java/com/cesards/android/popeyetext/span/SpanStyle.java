package com.cesards.android.popeyetext.span;

import android.graphics.Typeface;
import android.text.style.StyleSpan;

/**
 * Created by cesards on 12/06/15.
 */
public class SpanStyle<T extends SpanStyle.Style> extends Span<T> {

    public static final int ITALIC = Typeface.ITALIC;
    public static final int BOLD = Typeface.BOLD;
    public static final int BOLD_ITALIC = Typeface.BOLD_ITALIC;
    public static final int NORMAL = Typeface.NORMAL;

    enum Style {
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
    public Object getSpanType(Style style) {
        return new StyleSpan(style.type);
    }
}
