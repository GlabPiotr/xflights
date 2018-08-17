package com.braykoglab.xflights.connections;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

import com.braykoglab.xflights.service.BaseService;

public abstract class BaseServiceConnection implements ServiceConnection {

    BaseService baseService;
    Context context;

    BaseServiceConnection(Context context) {
        this.context = context;
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        baseService = null;
    }
}
