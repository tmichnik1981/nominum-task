package com.nomi.rest.client;

import org.apache.http.HttpHost;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientsConfiguration {


    @Bean("dataServiceClient")
    public RestTemplate dataServiceClient(@Value("${data.host}") String hostPort, @Value("${protocol}") String httpProtocol, @Value("${data.login}") String user, @Value("${data.password}") String password) {


        String[] hostTab = hostPort.split(":");

        HttpHost host = new HttpHost(hostTab[0], Integer.parseInt(hostTab[1]), httpProtocol);
        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactoryBasicAuth(host));

        template.getInterceptors().add(
            new BasicAuthorizationInterceptor(user, password));
        return template;
    }

    @Bean("authServiceClient")
    public RestTemplate authServiceClient(@Value("${auth.host}") String hostPort, @Value("${protocol}") String httpProtocol, @Value("${auth.login}") String user, @Value("${auth.password}") String password) {

        String[] hostTab = hostPort.split(":");
        HttpHost host = new HttpHost(hostTab[0], Integer.parseInt(hostTab[1]), httpProtocol);

        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactoryBasicAuth(host));

        template.getInterceptors().add(
            new BasicAuthorizationInterceptor(user, password));
        return template;
    }
}
