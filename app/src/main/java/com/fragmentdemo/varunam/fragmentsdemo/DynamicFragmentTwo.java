package com.fragmentdemo.varunam.fragmentsdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DynamicFragmentTwo extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_dynamic_fragment_two, container, false);

        TextView textView = view.findViewById(R.id.textView);

        if (getArguments() != null)
            if (getArguments().getString("message") != null)
                textView.setText(getArguments().getString("message"));

        return view;
    }
}
