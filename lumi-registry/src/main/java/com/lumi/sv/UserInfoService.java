package com.lumi.sv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lumi.bean.UserInfo;
import com.lumi.domain.UserInfoRepository;

@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoRepository userRepository;
	
	public UserInfo userInfoByUpn(String upn) {
		return userRepository.findByUpn(upn);
	}

}
