package com.braykoglab.xflights.apis;


import com.braykoglab.xflights.model.LufthansaAuthorizationToken;
import com.braykoglab.xflights.model.lufthansa.AirportResource;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface LufthansaApi {

    String CLIENT_ID = "client_id";
    String CLIENT_SECRET = "client_secret";
    String GRANT_TYPE = "grant_type";

    @FormUrlEncoded
    @POST("/v1/oauth/token/")
    Observable<LufthansaAuthorizationToken> getAuthenticationToken(@Field(CLIENT_ID) String clientId,
                                                                   @Field(CLIENT_SECRET) String clientSecret,
                                                                   @Field(GRANT_TYPE) String grantType);

    @Headers({
            "Accept: application/json"
    })
    @GET("/v1/references/airports/")
    Observable<AirportResource> getAirports();
}
