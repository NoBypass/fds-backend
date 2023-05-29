package com.fds.v1.lib.security;


import org.springframework.beans.factory.annotation.Value;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class SecurityConstants {
    @Value("${jwt.secret}")
    public static final String SECRET = null;
    public static final String ALGORITHM = "HmacSHA256";
    public static final SecretKeySpec SECRET_KEY_SPEC = new SecretKeySpec(SECRET.getBytes(StandardCharsets.UTF_8), ALGORITHM);
    public static final long EXPIRATION_TIME = 2_592_000_000L; // 30 days
    public static final String AUTH_URLS = "/auth/*";
    public static final String AUTHORIZATION_HEADER_NAME = "Authorization";
}
