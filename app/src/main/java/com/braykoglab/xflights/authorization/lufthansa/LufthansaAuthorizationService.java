package com.braykoglab.xflights.authorization.lufthansa;

import com.braykoglab.xflights.authorization.AuthorizationService;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.braykoglab.xflights.configuration.Configuration.LUFTHANSA_AUTH_SERVICE_URL;
import static com.braykoglab.xflights.configuration.Configuration.LUFTHANSA_CLIEND_ID;
import static com.braykoglab.xflights.configuration.Configuration.LUFTHANSA_CLIENT_SECRET;
import static com.braykoglab.xflights.configuration.Configuration.LUFTHANSA_GRANT_TYPE;

public class LufthansaAuthorizationService implements AuthorizationService {

    private static final String CLIENT_ID = "client_id";
    private static final String CLIENT_SECRET = "client_secret";
    private static final String GRANT_TYPE = "grant_type";

    private LufthansaAuthorizationToken lufthansaAuthorizationToken;

    public LufthansaAuthorizationToken getAuthorizationToken() {
        CompositeDisposable compositeDisposable = new CompositeDisposable();

        Disposable disp = Observable.create((ObservableOnSubscribe<LufthansaAuthorizationToken>) e -> {
            try {
                UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(LUFTHANSA_AUTH_SERVICE_URL);
                HttpEntity<?> entity = new HttpEntity<>(getParams(), getHeaders());

                ResponseEntity<LufthansaAuthorizationToken> response = new RestTemplate()
                        .postForEntity(builder.toUriString(),
                                entity,
                                LufthansaAuthorizationToken.class);

                ///TODO: read more about subscribing
                lufthansaAuthorizationToken = response.getBody();
                e.onNext(lufthansaAuthorizationToken);
            } catch (Exception ex) {
                e.onError(ex);
            }
        })
                .subscribeOn(Schedulers.io())
                .subscribe(data -> lufthansaAuthorizationToken = data);

        compositeDisposable.add(disp);

        return lufthansaAuthorizationToken;
    }

    public MultiValueMap<String, String> getParams() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add(CLIENT_ID, LUFTHANSA_CLIEND_ID);
        params.add(CLIENT_SECRET, LUFTHANSA_CLIENT_SECRET);
        params.add(GRANT_TYPE, LUFTHANSA_GRANT_TYPE);
        return params;
    }

    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return headers;
    }
}
