package com.lumi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lumi.bean.UserInfo;
import com.lumi.domain.UserInfoRepository;

@Controller
@RequestMapping(value = "/registry")
public class UserInfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);
	
	@Autowired
	private UserInfoRepository userRepository;
	
	
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody UserInfo findUser(@RequestParam(value = "userId", required = false) String userId) {
    	logger.debug("Finding user: : {}", userId);
    	UserInfo userInfo = userRepository.findByUpn(userId);
    	logger.debug("Found user: {}", userInfo);
    	return userInfo;
    }    
}
