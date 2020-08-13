package com.cognizant.bloodbank.controller;

import java.util.Base64;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbank.BloodbankApplication;

import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;

@RestController
public class AuthenticationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BloodbankApplication.class);

	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		// System.err.println("hi hello");
		LOGGER.info("Start of authenticate");
		LOGGER.info("The auth Header is" + authHeader);
		Map<String, String> authmap = new HashMap<String, String>();
		// put token in map
		String token = generateJwt(getUser(authHeader));
		// System.err.println("token-----"+token);
		authmap.put("token", token);
		String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
		// put role into map
		authmap.put("role", role);
		// gets the username
		authmap.put("username", getUser(authHeader));
		LOGGER.info("END OF authenticate");
		return authmap;
	}

	private String getUser(String authHeader) {
		String user = new String(Base64.getDecoder().decode(authHeader.substring(6)));
		user = user.substring(0, user.indexOf(":"));
		LOGGER.info("The retrieved user is " + user);
		return user;
	}

	private String generateJwt(String user) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);

		// Set the token issue time as current time
		builder.setIssuedAt(new Date());

		// Set the token expiry as 20 minutes from now
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");

		String token = builder.compact();
		LOGGER.info(token);
		return token;
	}
}
