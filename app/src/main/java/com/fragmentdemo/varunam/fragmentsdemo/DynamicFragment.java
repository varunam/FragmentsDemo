package com.fragmentdemo.varunam.fragmentsdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class DynamicFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_dynamic_fragment, container, false);
        Button loadAnother = view.findViewById(R.id.loadAnotherFragmentID);

        loadAnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DynamicFragmentExample.fragmentManager.beginTransaction().replace(R.id.dynamic_fragment_container_id, new DynamicFragmentTwo(), null).addToBackStack(null).commit();
            }
        });

        return view;
    }
}
