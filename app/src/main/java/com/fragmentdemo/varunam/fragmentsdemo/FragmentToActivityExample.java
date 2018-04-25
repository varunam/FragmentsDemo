package com.fragmentdemo.varunam.fragmentsdemo;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FragmentToActivityExample extends AppCompatActivity implements FragmentOne.onMessageReadListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_to_example);

        if(findViewById(R.id.fta_fragment_container_id)!=null)
        {
            if(savedInstanceState!=null)
                return;

            FragmentManager fragmentManager = getFragmentManager();
            FragmentOne fragmentOne = new FragmentOne();

            fragmentManager.beginTransaction()
                    .add(R.id.fta_fragment_container_id, fragmentOne, null)
                    .commit();


        }
    }

    @Override
    public void onMessageRead(String message) {
        TextView textView = findViewById(R.id.fta_textView_id);
        textView.setText(message);
    }
}
