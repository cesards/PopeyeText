package com.cesards.android.popeyetext.samples;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.cesards.android.popeyetext.PopeyeTextView;
import com.cesards.android.popeyetext.R;
import com.cesards.android.popeyetext.span.SpanStyle;
import com.cesards.android.popeyetext.TextComposer;

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

        final TextComposer textComposer = new TextComposer.Builder(getActivity().getApplicationContext())
                .span(new SpanStyle(), 10, 23)
                .intro()
                .intro()
                .build();

        text.setText(textComposer);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
