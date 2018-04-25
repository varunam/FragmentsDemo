package com.fragmentdemo.varunam.fragmentsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button staticFragment, dynamicFragment, fragmentToActivity, fragmentToFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        staticFragment = findViewById(R.id.static_fragment_id);
        dynamicFragment = findViewById(R.id.dynamic_fragment_id);
        fragmentToActivity = findViewById(R.id.fragment_to_activity_id);
        fragmentToFragment = findViewById(R.id.fragment_to_fragment_id);

        staticFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StaticFragmentExample.class));
            }
        });

        dynamicFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DynamicFragmentExample.class));
            }
        });

        fragmentToActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FragmentToActivityExample.class));
            }
        });

        fragmentToFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FragmentToFragmentExample.class));
            }
        });
    }
}
