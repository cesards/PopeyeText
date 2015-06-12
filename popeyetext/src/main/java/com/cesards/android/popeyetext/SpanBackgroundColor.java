package com.cesards.android.popeyetext;

import android.support.annotation.ColorRes;
import android.text.style.BackgroundColorSpan;
import com.cesards.android.popeyetext.span.Span;

/**
 * Created by cesards on 12/06/15.
 */
public class SpanBackgroundColor<T extends Integer> extends Span<T> {

    @Override
    public Object getSpanType(@ColorRes Integer color) {
        return new BackgroundColorSpan(color);
    }
}
