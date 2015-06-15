package com.cesards.android.popeyetext.span;

import android.content.Context;
import android.text.style.TextAppearanceSpan;

/**
 * Created by cesards on 15/06/15.
 */
public class SpanTextAppearance extends Span {

    private final Context context;
    private final int appearance;

    public SpanTextAppearance(Context context, int appearance) {
        this.context = context;
        this.appearance = appearance;
    }

    @Override
    public Object getSpanType() {
        return new TextAppearanceSpan(context, appearance);
    }

    //
    //    text.setSpan(new TextAppearanceSpan(getContext(), R.style.myStyle), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    //    text.setSpan(new TextAppearanceSpan(getContext(), R.style.myNextStyle), 6, 10, Spannable
    // .SPAN_EXCLUSIVE_EXCLUSIVE);
}
