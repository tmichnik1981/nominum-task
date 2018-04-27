package com.nomi.repository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Repository
public class CredentialsRepository {

    @Value("${users.file}")
    private String usersFilePath;

    private final Properties credentialsDatasource = new Properties();


    public boolean exists(String userName, String password) {
        String  retrievedPassword =  credentialsDatasource.getProperty(userName);

        return (StringUtils.isNotBlank(retrievedPassword) && retrievedPassword.equals(password) ? true : false );
    }

    @PostConstruct
    public void setUpRepository() throws Exception {
        Resource usersResource = new ClassPathResource(usersFilePath);

        credentialsDatasource.load(usersResource.getInputStream());

    }



}