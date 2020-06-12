package org.spring.cloud.WLC.base.oauth2.jwt.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

/**
 * * @describe:JWT * 使用场景:一种情况是webapi,另一种情况是多web服务器下实现无状态分布式身份验证。 JWT是JSON Web
 * Token的缩写，即JSON Web令牌。JSON Web令牌（JWT）是一种紧凑的、URL安全的方式，
 * 用来表示要在双方之间传递的“声明”。JWT中的声明被编码为JSON对象，用作JSON Web签名（JWS）结构的有效内容或JSON
 * Web加密（JWE）结构的明文，使得声明能够被：数字签名、 或利用消息认证码（MAC）保护完整性、加密。 * @Date: 2018/3/26 16:49
 */
public class JwtUtil {
	private static String base64Security=TextCodec.BASE64.encode("dev");
	/** * 解密 * @param jsonWebToken * @param base64Security * @return */
	public static Claims parseJWT(String jsonWebToken) {
		try {
			Claims claims = Jwts.parser().setSigningKey(base64Security.getBytes()).parseClaimsJws(jsonWebToken)
					.getBody();
			return claims;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
