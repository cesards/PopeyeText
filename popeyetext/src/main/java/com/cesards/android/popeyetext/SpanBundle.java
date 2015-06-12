package com.cesards.android.popeyetext;

import com.cesards.android.popeyetext.span.Span;

/**
 * Created by cesards on 12/06/15.
 */
public class SpanBundle {

    private int start = 0;
    private int end = 0;
    private int flags;
    private Span span;

    public SpanBundle(int start, int end, int flags, Span span) {
        this.start = start;
        this.end = end;
        this.flags = flags;
        this.span = span;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getFlags() {
        return flags;
    }

    public Span getSpan() {
        return span;
    }
}
