package com.lumi.sv;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.lumi.domain.UserInfoLog;
import com.lumi.domain.UserInfoLogRepository;

@Service
public class LoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	@Value("${user.registry.url}")
	private String userRegistryUrl;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserInfoLogRepository userLogRepository;
	
	public UserInfoLog logUserInfo() {
		
		String userId = userId();
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(userRegistryUrl).queryParam("userId", userId);
		URI userInfoUri = builder.buildAndExpand().toUri();
		UserInfoLog userInfoLog = new UserInfoLog();
		
		try {
			UserInfoLog userInfo = restTemplate.getForObject(userInfoUri, UserInfoLog.class);
			logger.debug("Fetched userInfo : {}", userInfo);
			
			userInfoLog.name = userInfo.name;
			userInfoLog.upn = userInfo.upn;
			userInfoLog.country = userInfo.country;
			userInfoLog.visitorNumber = userLogRepository.count();
			
			userLogRepository.saveAndFlush(userInfoLog);
		} catch (Exception e) {
			logger.error("Error retrieving user info", e);
		}
		
		return userInfoLog;
	}
	
	public String userId() {
		SecurityContext ctx = SecurityContextHolder.getContext();
		Authentication auth1 = ctx.getAuthentication();
		DefaultOidcUser ud = (DefaultOidcUser) auth1.getPrincipal();
		String upn = (String) ud.getAttributes().get("upn");
		return upn;
	}

}
