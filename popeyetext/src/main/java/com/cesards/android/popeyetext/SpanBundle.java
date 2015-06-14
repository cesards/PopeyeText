package com.cesards.android.popeyetext;

import com.cesards.android.popeyetext.span.Span;

/**
 * Created by cesards on 12/06/15.
 */
public class SpanBundle {

    private final Span span;
    private boolean repeatSearch = false;
    private String pattern;
    private String spannedText;

    public SpanBundle(Span span) {
        this.span = span;
    }

    public Span getSpan() {
        return span;
    }

    public boolean isRepeatSearch() {
        return repeatSearch;
    }

    public void setRepeatSearch(boolean repeatSearch) {
        this.repeatSearch = repeatSearch;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getSpannedText() {
        return spannedText;
    }

    public void setSpannedText(String spannedText) {
        this.spannedText = spannedText;
    }
}
