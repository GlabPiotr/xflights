package com.braykoglab.xflights.service;


import android.os.Binder;
import android.widget.Toast;

import com.braykoglab.xflights.model.Request;
import com.braykoglab.xflights.model.Response;

public class RyanairService extends BaseService {

    public class RyanairServiceBinder extends Binder {
        public RyanairService getService() {
            return RyanairService.this;
        }
    }

    public void findCheapestFlights(final Request request) {
        Response response = new Response();
        Toast.makeText(RyanairService.this, "Calling Ryanair Api...", Toast.LENGTH_SHORT).show();
        // todo: call Ryanair api and build Response
    }
}
