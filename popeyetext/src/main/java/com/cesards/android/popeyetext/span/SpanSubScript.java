package com.cesards.android.popeyetext.span;

import android.text.style.SubscriptSpan;

/**
 * Created by cesards on 15/06/15.
 */
public class SpanSubScript extends Span {
    @Override
    public Object getSpanType() {
        return new SubscriptSpan();
    }
}
