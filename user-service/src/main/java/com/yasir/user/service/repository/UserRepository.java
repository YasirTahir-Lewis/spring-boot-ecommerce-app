package com.yasir.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yasir.user.service.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
