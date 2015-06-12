package com.cesards.android.popeyetext.span;

import android.text.style.RelativeSizeSpan;

/**
 * Created by cesards on 12/06/15.
 */
public class SpanSize extends Span {

    // WE CAN ONLY WORK WITH RELATIVES, WE SHOULD HAVE A REFERENCE OR SOMETHING, and pass a dp of normal and desired
    // size instead of double, half and so on

    // span.setSpan(new RelativeSizeSpan(2.0f), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

    @Override
    public Object getSpanType(Object object) {
        return new RelativeSizeSpan();
    }
}
