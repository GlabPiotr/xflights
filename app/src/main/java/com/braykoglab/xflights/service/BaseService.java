package com.braykoglab.xflights.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.braykoglab.xflights.model.Request;
import com.braykoglab.xflights.model.Response;

import java.io.IOException;

public abstract class BaseService extends Service {

    protected IBinder binder;

    public abstract void findCheapestFlights(final Request request);

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        findCheapestFlights(Request.builder().build());
        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
