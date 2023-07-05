package com.example.demofragmentlab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class DemoDynamicFragment extends AppCompatActivity {
    Button btn_frag1, btn_frag2;
    FrameLayout frame_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_dynamic_fragment);
        addControl();
        addEvent();
    }
    public  void addControl()
    {
        btn_frag1=(Button) findViewById(R.id.btn_frag1);
        btn_frag2=(Button) findViewById(R.id.btn_frag2);
        frame_fragment = (FrameLayout) findViewById(R.id.frame_fragment);
    }
    public  void addEvent()
    {
        btn_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Dynamic_Frag1());
            }
        });
        btn_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Dynamic_Frag2());
            }
        });


    }
    public void loadFragment(Fragment fragment)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_fragment,fragment);
        ft.commit();
    }
}