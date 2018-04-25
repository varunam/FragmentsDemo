package com.fragmentdemo.varunam.fragmentsdemo;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentToFragmentExample extends AppCompatActivity implements FragmentOne.onMessageReadListener{

    //will make use of already existing fragments here
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_to_fragment_example);

        if(findViewById(R.id.ftf_fragment_container_id)!=null)
        {
            if(savedInstanceState!=null)
                return;

            FragmentOne fragmentOne = new FragmentOne();
            fragmentManager = getFragmentManager();

            fragmentManager.beginTransaction().add(R.id.ftf_fragment_container_id, fragmentOne, null)
                    .commit();
        }
    }

    @Override
    public void onMessageRead(String message) {
        DynamicFragmentTwo dynamicFragmentTwo = new DynamicFragmentTwo();
        Bundle bundle = new Bundle();
        bundle.putString("message",message);
        dynamicFragmentTwo.setArguments(bundle);
        fragmentManager.beginTransaction().replace(R.id.ftf_fragment_container_id, dynamicFragmentTwo).addToBackStack(null).commit();
    }
}
