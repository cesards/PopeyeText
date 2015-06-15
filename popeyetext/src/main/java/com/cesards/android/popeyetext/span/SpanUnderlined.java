package com.cesards.android.popeyetext.span;

import android.text.style.UnderlineSpan;

/**
 * Created by cesards on 15/06/15.
 */
public class SpanUnderlined extends Span {
    @Override
    public Object getSpanType() {
        return new UnderlineSpan();
    }
}
