package com.braykoglab.xflights.service;

import android.os.Binder;
import android.widget.Toast;

import com.braykoglab.xflights.model.Request;
import com.braykoglab.xflights.model.Response;

public class LufthansaService extends BaseService {

    public class LufthansaServiceBinder extends Binder {
        public LufthansaService getService() {
            return LufthansaService.this;
        }
    }

    @Override
    public Response findCheapestFlights(Request request) {
        Response response = new Response();
        Toast.makeText(LufthansaService.this, "Calling Lufthansa Api...", Toast.LENGTH_SHORT).show();
        // todo: call Lufthansa api and build Response
        return response;
    }
}
