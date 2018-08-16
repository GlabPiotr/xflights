package com.braykoglab.xflights;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.braykoglab.xflights.service.RyanairApiService;

public class MainActivity extends AppCompatActivity implements ServiceConnection {

    private RyanairApiService ryanairApiService;

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.callRyanairApiService:
                Intent service = new Intent(getApplicationContext(), RyanairApiService.class);
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
    protected void onResume() {
        super.onResume();
        Intent intent= new Intent(this, RyanairApiService.class);
        bindService(intent, this, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(this);
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        RyanairApiService.RyanairApiServiceBinder binder = (RyanairApiService.RyanairApiServiceBinder) iBinder;
        ryanairApiService = binder.getService();
        Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        ryanairApiService = null;
    }
}
