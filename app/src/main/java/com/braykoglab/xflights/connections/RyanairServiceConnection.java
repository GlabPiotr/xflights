package com.braykoglab.xflights.connections;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import android.widget.Toast;

import com.braykoglab.xflights.service.RyanairService;

public class RyanairServiceConnection extends BaseServiceConnection {

    public RyanairServiceConnection(Context context) {
        super(context);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder iBinder) {
        RyanairService.RyanairServiceBinder binder = (RyanairService.RyanairServiceBinder) iBinder;
        baseService = binder.getService();

        Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
    }
}
