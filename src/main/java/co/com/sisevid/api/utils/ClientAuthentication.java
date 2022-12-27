package co.com.sisevid.api.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

import static co.com.sisevid.api.utils.constants.Constants.AUDIENCE_SERVICE;

@UtilityClass
public final class ClientAuthentication {

    private static final String secret = "poli_jic_2022";

    public static String generateToken() {
        Instant now = Instant.now();
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setAudience(AUDIENCE_SERVICE)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(5L, ChronoUnit.MINUTES)))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
