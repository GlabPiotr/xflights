package com.braykoglab.xflights.authorization;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

public interface AuthorizationService {

    HttpHeaders getHeaders();

    MultiValueMap<String, String> getParams();


}
