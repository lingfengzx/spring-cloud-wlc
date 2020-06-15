package org.spring.cloud.WLC.base.oauth2.jwt.controller;

import org.spring.cloud.WLC.base.oauth2.jwt.util.JwtUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/jwt")
public class JwtController {
	
	@RequestMapping("/parse")
	public Claims jwtParse(String jsonWebToken) {
		return JwtUtil.parseJWT(jsonWebToken);
	}
}
