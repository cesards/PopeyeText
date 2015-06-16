package com.cesards.android.popeyetext.span;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.text.style.ImageSpan;

/**
 * Created by cesards on 15/06/15.
 */
public class SpanImage extends Span {

    private Context context;
    private Bitmap b;
    private int verticalAlignment;
    private Drawable d;
    private Uri uri;
    private int lineHeight;

    @DrawableRes
    private int resourceId;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getLineHeight() {
        return lineHeight;
    }

    public void setLineHeight(int lineHeight) {
        this.lineHeight = lineHeight;
    }

    public Bitmap getB() {
        return b;
    }

    public void setB(Bitmap b) {
        this.b = b;
    }

    public int getVerticalAlignment() {
        return verticalAlignment;
    }

    public void setVerticalAlignment(int verticalAlignment) {
        this.verticalAlignment = verticalAlignment;
    }

    public Drawable getD() {
        return d;
    }

    public void setD(Drawable d) {
        this.d = d;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public Object getSpanType() {
        // SQUARE IMAGE
        d.setBounds(0, 0, lineHeight, lineHeight);
        return new ImageSpan(d);
    }
}
