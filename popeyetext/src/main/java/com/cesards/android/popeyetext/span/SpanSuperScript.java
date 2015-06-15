package com.cesards.android.popeyetext.span;

import android.text.style.SuperscriptSpan;

/**
 * Created by cesards on 15/06/15.
 */
public class SpanSuperScript extends Span {
    @Override
    public Object getSpanType() {
        return new SuperscriptSpan();
    }
}
