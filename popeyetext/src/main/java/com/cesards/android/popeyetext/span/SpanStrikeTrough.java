package com.cesards.android.popeyetext.span;

import android.text.style.StrikethroughSpan;

/**
 * Created by cesards on 15/06/15.
 */
public class SpanStrikeTrough extends Span {
    @Override
    public Object getSpanType() {
        return new StrikethroughSpan();
    }
}
