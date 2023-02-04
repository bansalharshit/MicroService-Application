package com.masai.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.user.service.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
// if you want to implement custom method or query
}
