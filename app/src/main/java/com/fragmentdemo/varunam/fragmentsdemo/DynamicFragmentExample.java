package com.fragmentdemo.varunam.fragmentsdemo;


import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DynamicFragmentExample extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment_example);

        final Bundle instanceState = savedInstanceState;
        Button button = (Button) findViewById(R.id.loadFragmentButtonID);
        fragmentManager = getFragmentManager();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (findViewById(R.id.dynamic_fragment_container_id) != null) {
                    if (instanceState != null)
                        return;

                    DynamicFragment dynamicFragment = new DynamicFragment();
                    fragmentManager.beginTransaction().add(R.id.dynamic_fragment_container_id, dynamicFragment, null).addToBackStack(null).commit();
                }
            }
        });
    }
}
