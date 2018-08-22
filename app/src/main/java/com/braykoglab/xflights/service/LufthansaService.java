package com.braykoglab.xflights.service;

import android.os.Binder;
import android.widget.Toast;

import com.braykoglab.xflights.apis.LufthansaApi;
import com.braykoglab.xflights.interceptors.LufthansaResponseInterceptor;
import com.braykoglab.xflights.model.Request;
import com.braykoglab.xflights.model.lufthansa.AirportResource;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static com.braykoglab.xflights.configuration.Configuration.LUFTHANSA_BASE_URL;

public class LufthansaService extends BaseService {

    CompositeDisposable compositeDisposable = new CompositeDisposable();
    AirportResource airportResource;

    public class LufthansaServiceBinder extends Binder {
        public LufthansaService getService() {
            return LufthansaService.this;
        }
    }

    ///TODO: prepare test of intercetptor
    public void getAirports(Request request) {
        Toast.makeText(LufthansaService.this, "Calling Lufthansa Api...", Toast.LENGTH_SHORT).show();

        OkHttpClient client = new OkHttpClient().newBuilder()
                .addInterceptor(new LufthansaResponseInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LUFTHANSA_BASE_URL)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        compositeDisposable.add(retrofit.create(LufthansaApi.class)
                .getAirports()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(airports -> airportResource = airports));
    }

    @Override
    public void findCheapestFlights(Request request) {
        getAirports(request);
    }


}
