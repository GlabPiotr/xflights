package com.braykoglab.xflights;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.braykoglab.xflights.connections.BaseServiceConnection;
import com.braykoglab.xflights.connections.LufthansaServiceConnection;
import com.braykoglab.xflights.connections.RyanairServiceConnection;
import com.braykoglab.xflights.service.LufthansaService;
import com.braykoglab.xflights.service.RyanairService;
import com.google.common.collect.ImmutableMap;

public class MainActivity extends AppCompatActivity {

    private final ImmutableMap<BaseServiceConnection, Class> serviceConnections = ImmutableMap.<BaseServiceConnection, Class>builder()
            .put(new RyanairServiceConnection(this), RyanairService.class)
            .put(new LufthansaServiceConnection(this), LufthansaService.class)
            .build();

    public void onClick(View view) {
        Intent service;

        switch (view.getId()) {
            case R.id.callRyanairApiService:
                service = new Intent(getApplicationContext(), RyanairService.class);
                getApplicationContext().startService(service);
                break;
            case R.id.callLufthansaService:
                service = new Intent(getApplicationContext(), LufthansaService.class);
                getApplicationContext().startService(service);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        serviceConnections.forEach((key, value) -> {
            Intent intent = new Intent(this, value);
            bindService(intent, key, Context.BIND_AUTO_CREATE);
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        serviceConnections.forEach((key, value) -> {
            unbindService(key);
        });
    }
}
