package com.lumi.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lumi.bean.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{
	
    @Query("SELECT u FROM UserInfo u where u.upn = :upn")
    UserInfo findByUpn(@Param("upn") String upn);
}