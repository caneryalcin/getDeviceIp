package com.example.getdeviceip;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import java.net.InetAddress;

import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        TextView ipinfo = findViewById(R.id.ipinfo_text);
        TextView hostName = findViewById(R.id.hostname_text);

        InetAddress inetAddress = null;

        try {
            //Returns the address of the local host.
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        //get host name
        hostName.setText(inetAddress.getHostName());

        //get host address
        ipinfo.setText(inetAddress.getHostAddress());

    }
}