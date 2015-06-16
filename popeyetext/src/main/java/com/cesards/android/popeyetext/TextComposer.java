package com.cesards.android.popeyetext;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.SparseArray;
import android.widget.TextView;
import com.cesards.android.popeyetext.span.Span;
import java.util.ArrayList;

/**
 * Created by cesards on 12/06/15.
 */
public class TextComposer {

    private Spanned spanned;

    public TextComposer(Spanned spanned) {
        this.spanned = spanned;
    }

    public Spanned getSpanned() {
        return spanned;
    }

    public static class Builder {

        private TextView textView;
        private Context context;
        private ArrayList<String> texts = new ArrayList<>();
        private ArrayList<String> patterns = new ArrayList<>();
        private SparseArray<String> ids = new SparseArray<>();
        private ArrayList<SpanBundle> spanBundles = new ArrayList<>();

        public Builder(@NonNull TextView textView) {
            this.context = textView.getContext();
        }

        public Builder(@NonNull Context context) {
            this.context = context;
        }

        public Builder intro() {
            texts.add("\n");
            return this;
        }

        public Builder space() {
            texts.add(" ");
            return this;
        }

        public Builder text(@StringRes int textRes) {
            final String text = context.getString(textRes);
            return text(text);
        }

        public Builder text(@StringRes int textRes, int textId) {
            final String text = context.getString(textRes);
            return text(text, textId);
        }

        public Builder text(String text) {
            texts.add(text);
            return this;
        }

        public Builder text(String text, int textId) {
            texts.add(text);
            ids.put(textId, text);
            return this;
        }

        public Builder span(Span span, int textId) {
            final SpanBundle spanBundle = new SpanBundle(span);
            spanBundle.setTextId(textId);
            spanBundles.add(spanBundle);
            return this;
        }

        public Builder span(Span span, String pattern) {
            final SpanBundle spanBundle = new SpanBundle(span);
            spanBundle.setPattern(pattern);
            spanBundles.add(spanBundle);
            return this;
        }

        public Builder span(Span span, String pattern, boolean firstMatch) {
            final SpanBundle spanBundle = new SpanBundle(span);
            spanBundle.setPattern(pattern);
            spanBundle.setRepeatSearch(!firstMatch);
            spanBundles.add(spanBundle);
            return this;
        }

        public TextComposer compose() {
            final StringBuilder stringBuilder = new StringBuilder();

            for (String text : texts) {
                stringBuilder.append(text);
            }

            final SpannableString spannableString = new SpannableString(stringBuilder);
            for (int i = spanBundles.size() - 1; i >= 0; i--) {
                final SpanBundle spanBundle = spanBundles.get(i);

                final String text = ids.get(spanBundle.getTextId());
                final int textIndex = stringBuilder.indexOf(text);
                if (textIndex >= 0) {
                    spannableString.setSpan(spanBundle.getSpan().getSpanType(), textIndex, textIndex + text.length(),
                            Span.DEFAULT_RENDER_APPLY_MODE);
                }
            }

            if (textView != null) {
                textView.setText(spannableString, TextView.BufferType.SPANNABLE);
            }

            return new TextComposer(spannableString);
        }
    }
}


