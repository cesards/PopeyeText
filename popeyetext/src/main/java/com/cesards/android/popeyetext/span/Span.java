package com.cesards.android.popeyetext.span;

import android.text.Spannable;

/**
 * Created by cesards on 12/06/15.
 */
public abstract class Span<T> {

    public final static int DEFAULT_RENDER_APPLY_MODE = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE;

    public abstract Object getSpanType(T object);
}
