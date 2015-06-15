package com.cesards.android.popeyetext;

import android.content.Context;
import android.support.annotation.StringRes;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.TextView;
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

    public static class SpanBuilder {

        private final Builder builder;

        public SpanBuilder(Builder builder) {
            this.builder = builder;
        }

        private ArrayList<SpanBundle> spanBundles = new ArrayList<>();

        public Builder span(Span span) {
            final SpanBundle spanBundle = new SpanBundle(span);
            spanBundle.setTextIndex(builder.texts.size() - 1);
            spanBundles.add(spanBundle);
            return builder;
        }
    }

    public static class Builder {

        private TextView textView;
        private Context context;
        private ArrayList<String> texts = new ArrayList<>();
        private SpanBuilder spanBuilder;

        public Builder(TextView textView) {
            this.textView = textView;
            context = textView.getContext();
            spanBuilder = new SpanBuilder(this);
        }

        public Builder(Context context) {
            this.context = context;
            spanBuilder = new SpanBuilder(this);
        }

        public Builder intro() {
            texts.add("\n");
            return this;
        }

        public Builder text(@StringRes int textRes) {
            final String text = context.getString(textRes);
            return text(text);
        }

        public Builder text(@StringRes int textRes, int textId) {
            final String text = context.getString(textRes);
            return text(text);
        }

        public Builder text(String text) {
            texts.add(text);
            return this;
        }

        public Builder text(String text, int textId) {
            texts.add(text);
            return this;
        }

        public SpanBuilder spanText(@StringRes int res) {
            final String text = context.getString(res);
            texts.add(text);
            return spanBuilder;
        }

        public SpanBuilder spanText(String text) {
            texts.add(text);
            return spanBuilder;
        }




        public SpanBuilder spanPattern(String pattern) {
            return spanBuilder;
        }

        public SpanBuilder spanPattern(String pattern, boolean firstMatch) {
            return spanBuilder;
        }






        public TextComposer compose() {
            final StringBuilder stringBuilder = new StringBuilder();

            for (String text : texts) {
                stringBuilder.append(text);
            }


            final SpannableString spannableString = new SpannableString(stringBuilder);
            //            final SpannableString spannableString = new SpannableString(stringBuilder.toString());

            for (int i = spanBuilder.spanBundles.size() - 1; i >= 0; i--) {
                final SpanBundle spanBundle = spanBuilder.spanBundles.get(i);

                final String s = stringBuilder.toString();
                final String spannedText = texts.get(spanBundle.getTextIndex());
                final int i1 = s.indexOf(spannedText);

//                spannableString.setSpan(spanBundle.getSpan().getSpanType(), i1, i1 + spannedText.length(), Span.DEFAULT_RENDER_APPLY_MODE);
                spannableString.setSpan(spanBundle.getSpan().getSpanType(), i1, i1 + spannedText.length(), 0);
            }

            if (textView != null) {
                textView.setText(spannableString, TextView.BufferType.SPANNABLE);
            }

            return new TextComposer(spannableString);
        }
    }
}


