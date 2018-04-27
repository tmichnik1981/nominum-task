package com.nomi.adapter;

import com.nomi.dto.StudentDto;
import com.nomi.exception.ServiceUnAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class DataServiceAdapter {

    private static final String DATA_SERVICE_REQ_MAPPING = "/data/{user-id}";

    @Value("${protocol}")
    private String protocol;

    @Value("${data.host}")
    private String dataServiceHost;

    private final RestTemplate dataServiceClient;

    public ResponseEntity<StudentDto> getStudent(String userIdentifier) {

        String url = buildURL();

        ResponseEntity<StudentDto> response = null;
        try {

            response = dataServiceClient.exchange(
                url,
                HttpMethod.GET, null, StudentDto.class, userIdentifier);

        } catch (ResourceAccessException exception) {
            //server is down
            throw new ServiceUnAvailableException("Data-Service is down", exception);
        } catch (RestClientException exception) {
            throw exception;
        }
        return response;

    }

    private String buildURL() {
        return protocol + "://" + dataServiceHost + DATA_SERVICE_REQ_MAPPING;
    }


    @Autowired
    public DataServiceAdapter(@Qualifier("dataServiceClient") RestTemplate dataServiceClient) {
        this.dataServiceClient = dataServiceClient;
    }

}
