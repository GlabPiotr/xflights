package com.braykoglab.xflights.service;

import android.os.Binder;
import android.widget.Toast;

import com.braykoglab.xflights.authorization.lufthansa.LufthansaAuthorizationService;
import com.braykoglab.xflights.authorization.lufthansa.LufthansaAuthorizationToken;
import com.braykoglab.xflights.model.Request;
import com.braykoglab.xflights.model.Response;

import io.reactivex.schedulers.Schedulers;

public class LufthansaService extends BaseService {

    private LufthansaAuthorizationService lufthansaAuthorizationService;
    LufthansaAuthorizationToken authorizationToken;

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

        lufthansaAuthorizationService.getAuthorizationToken().subscribeOn(Schedulers.io()).subscribe(token -> authorizationToken = token);

        ///TODO: use authentication data and call simple endpoinr from lufthansa

        return new Response();
    }
}
