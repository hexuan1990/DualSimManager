package com.example.administrator.dualsimmanager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import DualSimUtils.SimManagerWrapper;

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        SimManagerWrapper wrapper = SimManagerWrapper.getInstance(getApplicationContext());
        wrapper.getMainIMSI();
        wrapper.getSecondIMSI();
        SimManagerWrapper.checkIsMultiSim(getApplicationContext());
    }
}
