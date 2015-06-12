package com.cesards.android.popeyetext;

import android.content.Context;
import android.support.annotation.StringRes;
import android.text.Spannable;
import android.text.SpannableString;
import com.cesards.android.popeyetext.span.Span;
import java.util.ArrayList;

/**
 * Created by cesards on 12/06/15.
 */
public class TextComposer {

    private Spannable spannable;

    public TextComposer(Spannable spannable) {
        this.spannable = spannable;
    }

    public Spannable getSpannable() {
        return spannable;
    }

    public static class Builder {

        private Context context;
        private StringBuilder stringBuilder = new StringBuilder();
        private ArrayList<SpanBundle> spanBundles = new ArrayList<>();

        public Builder(Context context) {
            this.context = context;
        }

        public Builder intro() {
            stringBuilder.append("\n");
            return this;
        }

        public Builder text(@StringRes int res) {
            final String text = context.getString(res);
            return text(text);
        }

        public Builder text(String text) {
            stringBuilder.append(text);
            return this;
        }




        public Builder span(Span span, String text) {
            spanBundles.add(new SpanBundle(start, end, Span.DEFAULT_RENDER_APPLY_MODE, span));
            return this;
        }

        public Builderspan(Span span, String text, boolean repeat) {

        }

        public Builder span(Span span, String pattern) {
            return span(span, start, end, Span.DEFAULT_RENDER_APPLY_MODE);
        }

        public TextComposer build() {

            final String s = stringBuilder.toString();

            final SpannableString spannableString = new SpannableString(s);

            for (int i = spanBundles.size() - 1; i >= 0; i--) {
                final SpanBundle spanBundle = spanBundles.get(i);
                spannableString.setSpan(spanBundle.getSpan(), spanBundle.getStart(), spanBundle.getEnd(),
                        spanBundle.getFlags());
            }

            return new TextComposer(spannableString);
        }
    }
}
