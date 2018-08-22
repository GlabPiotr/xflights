package com.braykoglab.xflights.interceptors;

import com.braykoglab.xflights.apis.LufthansaApi;
import com.braykoglab.xflights.model.LufthansaAuthorizationToken;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.springframework.http.HttpStatus;

import java.io.IOException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static com.braykoglab.xflights.configuration.Configuration.LUFTHANSA_BASE_URL;
import static com.braykoglab.xflights.configuration.Configuration.LUFTHANSA_CLIEND_ID;
import static com.braykoglab.xflights.configuration.Configuration.LUFTHANSA_CLIENT_SECRET;
import static com.braykoglab.xflights.configuration.Configuration.LUFTHANSA_GRANT_TYPE;

public class LufthansaResponseInterceptor implements Interceptor {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);

        if (response.code() != HttpStatus.OK.value()) {
            refreshToken(chain, request);
        }

        return response;
    }

    private Response sendRequestWithNewToken(Chain chain, Request request, LufthansaAuthorizationToken token) throws IOException {
        Request newRequest = request.newBuilder()
                .header("Authorization", "Bearer " + token.getAccessToken())
                .header("Accept", "application/json")
                .build();

        return chain.proceed(newRequest);
    }

    private void refreshToken(Chain chain, Request request) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LUFTHANSA_BASE_URL)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        compositeDisposable.add(retrofit.create(LufthansaApi.class)
                .getAuthenticationToken(LUFTHANSA_CLIEND_ID, LUFTHANSA_CLIENT_SECRET, LUFTHANSA_GRANT_TYPE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(token -> sendRequestWithNewToken(chain, request, token),
                        throwable -> System.out.println(throwable.getMessage())));
    }
}
