package com.example.jwtlogin.utils;

import com.google.common.io.BaseEncoding;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Devil
 * @create 2022-04-03 17:21
 */
public class JwtUtil {
    private static final String jwtSecret = "aPbOBbnH4gnZBzIYEY7mxWNu49kYljNPMeva9Fjrwwqzw0bFlO0kPXZTCGaVcw0j";
    private static final long tokenExpiredTime = 60*1000*60;
    //创建jwt
    public static String createToken(Map<String,Object> map){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Date now = new Date(System.currentTimeMillis());
        SecretKey secretKey = generalKey();

        long nowMillis = System.currentTimeMillis();
        JwtBuilder builder = Jwts.builder()
                .setClaims(map)
                //设置签发日期
                .setIssuedAt(now)
                .signWith(signatureAlgorithm,secretKey);
        if(tokenExpiredTime>0){
            long expMillis = nowMillis+tokenExpiredTime;
            Date date = new Date(expMillis);
            builder.setExpiration(date);
        }
        return builder.compact();
    }

    //验证token
    public static Claims verifyJwt(String token){
        SecretKey secretKey = generalKey();
        Claims claims;
        claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return claims;
    }
    //生成加密key
    public static SecretKey generalKey(){
        byte[] decode = BaseEncoding.base64().decode(jwtSecret);
        return new SecretKeySpec(decode, 0, decode.length, "HmacSHA256");
    }
    //根据userId生成token
    public static String generateToken(Integer id){
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        return createToken(map);
    }
}
