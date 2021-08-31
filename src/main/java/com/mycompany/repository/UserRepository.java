package com.mycompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{


    User findByUserId(Long userId);

}
