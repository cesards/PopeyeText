package com.cesards.android.popeyetext;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.Spannable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by cesards on 12/06/15.
 */
public class PopeyeTextView extends TextView {

    public PopeyeTextView(Context context) {
        super(context);
    }

    public PopeyeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PopeyeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PopeyeTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setSpannable(Spannable spannable) {
        setText(spannable, BufferType.SPANNABLE);
    }

    public void setText(@NonNull TextComposer textComposer) {
        setSpannable(textComposer.getSpannable());
    }

}
