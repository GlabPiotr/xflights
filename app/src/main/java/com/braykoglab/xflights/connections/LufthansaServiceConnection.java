package com.braykoglab.xflights.connections;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import android.widget.Toast;

import com.braykoglab.xflights.service.LufthansaService;

public class LufthansaServiceConnection extends BaseServiceConnection {
    public LufthansaServiceConnection(Context context) {
        super(context);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder iBinder) {
        LufthansaService.LufthansaServiceBinder binder = (LufthansaService.LufthansaServiceBinder) iBinder;
        baseService = binder.getService();

        Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
    }
}
