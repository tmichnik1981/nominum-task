package com.nomi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nomi.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

     Optional<User> findByIndentifier(String indentifier);

}
