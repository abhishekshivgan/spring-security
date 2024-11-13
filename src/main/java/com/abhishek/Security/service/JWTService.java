package com.abhishek.Security.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	
	private String secretKey = "jwtSecretForAuthenticationTokenFromTheServer";

	public String generateToken(String username) {
		// TODO Auto-generated method stub
		Map<String, Object> claims = new HashMap<String, Object>();
		
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 1000*60*60*24))
				.and()
				.signWith(getKey())
				.compact();
		
	}

	private Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	
}
