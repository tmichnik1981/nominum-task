package com.nomi.service;

import com.nomi.dto.CredentialsDto;
import com.nomi.exception.CredentialsException;
import com.nomi.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final CredentialsRepository credentialsRepository;

    public void authenticate(CredentialsDto credentialsDto) {

       boolean credentialsCorrect = credentialsRepository.exists(credentialsDto.getUserName(), credentialsDto.getPassword());

        if(!credentialsCorrect){
            throw new CredentialsException("Wrong user or password");
        }

    }

    @Autowired
    public AuthenticationService(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }
}
