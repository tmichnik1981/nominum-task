package com.nomi.adapter;

import com.nomi.dto.CredentialsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Service
public class AuthenticationServiceAdapter {


 /*   auth.login=auth-admin
    auth.password=admin1
    auth.host=localhost:8081*/

    @Value("${auth.login}")
    private String authServiceUser;
    @Value("${auth.password}")
    private String authServicePass;
    @Value("${auth.host}")
    private String authServiceHost;

    private final RestTemplate authServiceClient;


    public void authenticate(CredentialsDto credentialsDto) {

        RestTemplate template = new RestTemplate();

        ResponseEntity<Void> response = template.postForEntity("http://localhost:8081/auth",credentialsDto,  Void.class);


        System.out.println(response);
    }

    @Autowired
    public AuthenticationServiceAdapter( @Qualifier("authServiceClient") RestTemplate authServiceClient) {
        this.authServiceClient = authServiceClient;
    }

}
