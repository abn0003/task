package com.lumi.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoLogRepository extends JpaRepository<UserInfoLog, Long>{
}