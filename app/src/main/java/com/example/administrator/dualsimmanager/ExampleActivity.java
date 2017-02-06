package com.example.administrator.dualsimmanager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import DualSimUtils.SimManagerWraper;

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        SimManagerWraper wrapper = SimManagerWraper.getInstance(getApplicationContext());
        wrapper.getMainIMSI();
        wrapper.getSecondIMSI();
        wrapper.getEntireIMSI();
    }
}
