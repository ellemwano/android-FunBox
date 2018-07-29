package com.mwano.lauren.androidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeDisplayActivityFragment extends Fragment{

    /**
     * A placeholder fragment containing a simple view.
     */

        public JokeDisplayActivityFragment() {
        }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_andlib_display, container, false);
        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(JokeDisplayActivity.JOKE);
        TextView jokeTextView = (TextView) root.findViewById(R.id.joke_tv);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }

        return root;
    }
}
