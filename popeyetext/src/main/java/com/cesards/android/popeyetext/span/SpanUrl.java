package com.cesards.android.popeyetext.span;

import android.text.style.URLSpan;

/**
 * Created by cesards on 15/06/15.
 */
public class SpanUrl extends Span {

    private final String url;

    public SpanUrl(String url) {
        this.url = url;
    }

    @Override
    public Object getSpanType() {
        return new URLSpan(url);
    }
}
