package com.ilocky.foregroundexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ilocky.ILocky;
import com.ilocky.ILockyActivity;
import com.ilocky.ILockyPassport;
import com.ilocky.ILockyService;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ILockyPassport.initialize(this);
        Log.d("iLocky",ILockyPassport.getDeviceUuid());
        String passport="{\n" +
                "  \"passport_id\": 2,\n" +
                "  \"passport\":\"eyJpbG9ja3lfaWQiOiJjNGI5ZmQ0MyIsInV1aWQiOiJjOGVjYzUwNC1hNmJiLTRjMWYtOTlhMi01ZGE3NDFiYmEwMWUiLCJzdGFydF90aW1lIjoiMjAxNS0xMS0wN1QwMDowMDowMCswODAwIiwic3RvcF90aW1lIjoiMjAyMC0xMS0yMFQwMDowMDowMCswODAwIiwidXNlX2xpbWl0IjowLCJyZmlkX2R1cmF0aW9uIjoxMDAwLCJhY3Rpb24iOiJvcGVuIGRvb3IiLCJyZXZva2VfbGVnYWN5Ijp0cnVlfQ==\"\n" +
                "}";
        try {
            ILockyPassport.importPassport(passport);
        } catch (ILockyPassport.ImportPassportException e) {
            e.printStackTrace();
        }
//        ILocky.setLocale(Locale.SIMPLIFIED_CHINESE);
//        ILocky.setLocale(Locale.TRADITIONAL_CHINESE);
//        ILocky.setLocale(Locale.ENGLISH);
        findViewById(R.id.ivKey).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, ILockyActivity.class), 0);
            }
        });


    }
}
