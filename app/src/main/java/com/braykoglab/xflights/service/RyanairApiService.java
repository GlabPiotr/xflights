package com.braykoglab.xflights.service;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import com.braykoglab.xflights.model.ApiRequest;
import com.braykoglab.xflights.model.ApiResponse;

public class RyanairApiService extends Service {

    private final IBinder mBinder = new RyanairApiServiceBinder();

    public class RyanairApiServiceBinder extends Binder {
        public RyanairApiService getService() {
            return RyanairApiService.this;
        }
    }

    public ApiResponse findCheapestFlights(final ApiRequest request) {
        ApiResponse response = new ApiResponse();
        Toast.makeText(RyanairApiService.this, "Calling Ryanair Api...", Toast.LENGTH_SHORT).show();
        // todo: call Ryanair api and build ApiResponse
        return response;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        findCheapestFlights(new ApiRequest.ApiRequestBuilder().build());
        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
