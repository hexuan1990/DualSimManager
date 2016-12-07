package com.example.administrator.androiddualsimmanager;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Button;

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        Button button;
        TelephonyManager manager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        manager.getSubscriberId();
    }
}
