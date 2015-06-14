package com.cesards.android.popeyetext;

import android.content.Context;
import android.support.annotation.StringRes;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;
import com.cesards.android.popeyetext.span.Span;
import java.util.ArrayList;
import org.w3c.dom.Text;

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

        private TextView textView;
        private StringBuilder stringBuilder = new StringBuilder();
        private ArrayList<SpanBundle> spanBundles = new ArrayList<>();

        public Builder(TextView textView) {
            this.textView = textView;
        }

        public Builder intro() {
            stringBuilder.append("\n");
            return this;
        }

        public Builder text(@StringRes int res) {
            final String text = textView.getContext().getString(res);
            return text(text);
        }

        public Builder text(String text) {
            stringBuilder.append(text);
            return this;
        }

        public Builder span(Span span, String textToSpan) {
            final SpanBundle spanBundle = new SpanBundle(span);
            spanBundle.setSpannedText(textToSpan);
            spanBundles.add(spanBundle);
            return this;
        }


        COMPOSITION OVER INHERITANCE








        public Builderspan(Span span, String textToSpan, boolean firstMatch) {

        }

        public Builder span(Span span, String pattern) {
            return span(span, start, end, );
        }

        public TextComposer build() {



            text.setSpan(new TextAppearanceSpan(getContext(), R.style.myStyle), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            text.setSpan(new TextAppearanceSpan(getContext(), R.style.myNextStyle), 6, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);



            final String s = stringBuilder.toString();

            final SpannableString spannableString = new SpannableString(s);

            for (int i = spanBundles.size() - 1; i >= 0; i--) {
                final SpanBundle spanBundle = spanBundles.get(i);
                spannableString.setSpan(spanBundle.getSpan(), spanBundle.getStart(), spanBundle.getEnd(),
                        Span.DEFAULT_RENDER_APPLY_MODE);
            }

            return new TextComposer(spannableString);
        }
    }
}
