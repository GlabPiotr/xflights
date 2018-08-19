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

import static com.braykoglab.xflights.configuration.Configuration.LUFTHANSA_AUTH_SERVICE_URL;
import static com.braykoglab.xflights.configuration.Configuration.LUFTHANSA_CLIEND_ID;
import static com.braykoglab.xflights.configuration.Configuration.LUFTHANSA_CLIENT_SECRET;
import static com.braykoglab.xflights.configuration.Configuration.LUFTHANSA_GRANT_TYPE;

public class LufthansaAuthorizationService implements AuthorizationService {

    private static final String CLIENT_ID = "client_id";
    private static final String CLIENT_SECRET = "client_secret";
    private static final String GRANT_TYPE = "grant_type";

    public Observable<LufthansaAuthorizationToken> getAuthorizationToken() {
        return Observable.create(e -> {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(LUFTHANSA_AUTH_SERVICE_URL);
            HttpEntity<?> entity = new HttpEntity<>(getParams(), getHeaders());

            ResponseEntity<LufthansaAuthorizationToken> response = new RestTemplate().postForEntity(builder.toUriString(),
                    entity,
                    LufthansaAuthorizationToken.class);
            e.onNext(response.getBody());
        });
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
