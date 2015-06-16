package com.cesards.android.popeyetext.samples;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.cesards.android.popeyetext.PopeyeTextView;
import com.cesards.android.popeyetext.TextComposer;
import com.cesards.android.popeyetext.span.SpanBackgroundColor;
import com.cesards.android.popeyetext.span.SpanForegroundColor;
import com.cesards.android.popeyetext.span.SpanImage;
import com.cesards.android.popeyetext.span.SpanSize;
import com.cesards.android.popeyetext.span.SpanStrikeTrough;
import com.cesards.android.popeyetext.span.SpanStyle;
import com.cesards.android.popeyetext.span.SpanSubScript;
import com.cesards.android.popeyetext.span.SpanSuperScript;
import com.cesards.android.popeyetext.span.SpanUnderlined;
import com.cesards.android.popeyetext.span.SpanUrl;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {

    @InjectView(R.id.sample_text)
    PopeyeTextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final SpanImage spanImage = new SpanImage();
        spanImage.setD(getResources().getDrawable(R.drawable.imgres));

        text.post(new Runnable() {
            @Override
            public void run() {
                spanImage.setLineHeight(300);

                new TextComposer.Builder(text)
                        .text("hola holita vecinito")
                        .intro()
                        .text("la primera prueba")
                        .intro()
                        .text("Valar Morghulis", 10)
                        .intro()
                        .text("Valar Dohaeris", 20)
                        .intro()
                        .intro()
                        .text("Jon Snow fucked up", 60)
                        .span(new SpanBackgroundColor(Color.MAGENTA), 60)
                        .span(new SpanStyle(SpanStyle.Style.BOLD), 10)
                        .span(new SpanStrikeTrough(), 10)
                        .span(new SpanSize(2.0f), 20)
                        .span(new SpanUnderlined(), 20)
                        .span(new SpanStyle(SpanStyle.Style.BOLD_ITALIC), 20)
                        .intro()
                        .intro()
                        .text("You know nothing Jon Snow", 30)
                        .span(new SpanForegroundColor(Color.BLUE), 30)
                        .span(new SpanStyle(SpanStyle.Style.BOLD_ITALIC), 30)
                        .span(new SpanSize(1.3f), 30)
                        .text("Joking")
                        .intro()
                        .intro()
                        .text("Texto normal")
                        .space()
                        .text("Just one more text", 3)
                        .span(new SpanSuperScript(), 3)
                        .intro()
                        .intro()
                        .intro()
                        .text("Texto normal")
                        .space()
                        .text("Everybody <3 John Snow", 4)
                        .span(new SpanSubScript(), 4)
                        .span(new SpanUrl("http://johnsnowdies.com"), 4)
                        .intro()
                        .intro()
                        .intro()
                        .text("mcgyver", 33)
                        .span(spanImage, 33)
                        .compose();
            }
        });



            // clickable text
//             ClickableSpan clickableSpan = new ClickableSpan() {
//            styledString.setSpan(clickableSpan, 103, 112, 0);

            // this step is mandated for the url and clickable styles.
//            textView.setMovementMethod(LinkMovementMethod.getInstance());


//        Notes :
//        - Multiple spans can be applied to the same area in a String. This has been shown above in the superscript span, where the text was both reduced in size and made superscript.
//        - The URLSpan and ClickableSpan both require the movementMethod of the TextView to be set as LinkMovementMethod.
//        - SpannableStrings are immutable. If this is a concern, use a SpannableStringBuilder.
//        - If you're using a string resource as the content of the TextView, some of the above styles can be declared in the resource itself. See this to check how.
//        - You could also use the Html.fromHtml method to create Spanned Strings using html tags. For an unofficial list of supported tags see this.


//        SpannableStringBuilder to create String with multiple fonts/text sizes etc Example?
//        Spannable sb = new SpannableString( finalString );
//        sb.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), finalString.indexOf(normalBOLD), normalBOLD.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); //bold
//        sb.setSpan(new AbsoluteSizeSpan(intSize), finalString.indexOf(normalBOLD), normalBOLD.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);//resize size


//        Clickable spans
//
//        One of the spans you can set your text to is a ClickableSpan. You may have added this and wondered why anything didn't happen when you clicked on the link. Well, you need to have one extra step to let Android know that there is a clickable link and it needs to be navigated to. You need to set a MovementMethod to the TextView. You can investigate this further if you wish, or you can just see the sample code to make it work below (and it is also in the sample):
//
//
//        // Adapted from Linkify.addLinkMovementMethod(), to make links clickable.
//        //
//        MovementMethod m = textView.getMovementMethod();
//        if ((m == null) || !(m instanceof LinkMovementMethod))
//        {
//            textView.setMovementMethod(LinkMovementMethod.getInstance());
//        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
