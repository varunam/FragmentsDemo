package com.fragmentdemo.varunam.fragmentsdemo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.location.OnNmeaMessageListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentOne extends Fragment {

    public static onMessageReadListener onMessageReadListener;

    public interface onMessageReadListener{

        public void onMessageRead(String message);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_fragment_one, container, false);
        final EditText editText = view.findViewById(R.id.fo_editText);
        Button button = view.findViewById(R.id.fo_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMessageReadListener.onMessageRead(editText.getText().toString().trim());
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;

        try{
            onMessageReadListener = (onMessageReadListener) activity;
        }catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString() + " must override onMessageRead() method...");
        }
    }
}
