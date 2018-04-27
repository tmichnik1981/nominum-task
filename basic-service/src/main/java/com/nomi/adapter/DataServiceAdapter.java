package com.nomi.adapter;

import com.nomi.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataServiceAdapter {


    @Value("${protocol}")
    private String protocol;

    @Value("${data.host}")
    private String dataServiceHost;

    private final RestTemplate dataServiceClient;

    public ResponseEntity<StudentDto> getStudent(String userIdentifier) {

        String url = protocol+ "://"+dataServiceHost + "/data/{user-id}";

        ResponseEntity<StudentDto> response = dataServiceClient.getForEntity(url, StudentDto.class, userIdentifier );

        System.out.println(response);

        return response;



        /*restTemplate.exchange(
            "http://localhost:8080/spring-security-rest-template/api/foos/1",
            HttpMethod.GET, null, Foo.class);*/

    }

    @Autowired
    public DataServiceAdapter( @Qualifier("dataServiceClient") RestTemplate dataServiceClient) {
        this.dataServiceClient = dataServiceClient;
    }

}
