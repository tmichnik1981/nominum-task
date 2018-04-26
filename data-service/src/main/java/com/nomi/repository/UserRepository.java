package com.nomi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nomi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
