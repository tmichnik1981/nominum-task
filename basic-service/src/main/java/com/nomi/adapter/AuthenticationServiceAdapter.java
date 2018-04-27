package com.nomi.adapter;

import com.nomi.dto.CredentialsDto;
import com.nomi.exception.ServiceUnAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationServiceAdapter {


    private static final String AUTH_SERVICE_REQ_MAPPING = "/auth";

    @Value("${protocol}")
    private String protocol;

    @Value("${auth.host}")
    private String authServiceHost;

    private final RestTemplate authServiceClient;


    public void authenticate(CredentialsDto credentialsDto) {

        String url = buildURL();

        HttpEntity<CredentialsDto> credentialsHttpEntity = new HttpEntity(credentialsDto);

        try {
            ResponseEntity<Void> response = authServiceClient.exchange(
                url,
                HttpMethod.POST, credentialsHttpEntity, Void.class);

        } catch (ResourceAccessException exception) {
            throw new ServiceUnAvailableException("Authorization-Service is down", exception);
        } catch (RestClientException exception) {
            throw exception;
        }
    }

    private String buildURL() {
        return protocol + "://" + authServiceHost + AUTH_SERVICE_REQ_MAPPING;
    }

    @Autowired
    public AuthenticationServiceAdapter(@Qualifier("authServiceClient") RestTemplate authServiceClient) {
        this.authServiceClient = authServiceClient;
    }

}
