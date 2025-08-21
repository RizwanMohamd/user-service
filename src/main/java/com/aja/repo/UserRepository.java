package com.aja.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aja.entity.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {

}
