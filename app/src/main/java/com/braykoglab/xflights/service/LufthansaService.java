package com.braykoglab.xflights.service;

import android.os.Binder;
import android.widget.Toast;

import com.braykoglab.xflights.authorization.lufthansa.LufthansaAuthorizationService;
import com.braykoglab.xflights.authorization.lufthansa.LufthansaAuthorizationToken;
import com.braykoglab.xflights.model.Request;
import com.braykoglab.xflights.model.Response;

public class LufthansaService extends BaseService {

    private LufthansaAuthorizationService lufthansaAuthorizationService;

    public class LufthansaServiceBinder extends Binder {
        public LufthansaService getService() {
            return LufthansaService.this;
        }
    }

    public LufthansaService() {
        this.lufthansaAuthorizationService = new LufthansaAuthorizationService();
    }

    @Override
    public Response findCheapestFlights(Request request) {
        Toast.makeText(LufthansaService.this, "Calling Lufthansa Api...", Toast.LENGTH_SHORT).show();

        LufthansaAuthorizationToken lufthansaAuthorizationToken = lufthansaAuthorizationService.getAuthorizationToken();

        ///TODO: use authentication data and call simple endpoinr from lufthansa

        return new Response();
    }
}
