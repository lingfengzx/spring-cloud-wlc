package org.spring.cloud.WLC.base.oauth2.jwt.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

/*增强 JWT
如果我想在 JWT 中加入额外的字段(比方说用户的其他信息)怎么办呢，当然可以。spring security oauth2 提供了 TokenEnhancer 增强器。其实不光 JWT ，RedisToken 的方式同样可以。
声明一个增强器*/
/**
 * 通过 oAuth2Authentication 可以拿到用户名等信息，通过这些我们可以在这里查询数据库或者缓存获取更多的信息，而这些信息都可以作为 JWT 扩展信息加入其中。
 * @author zxk
 *
 */
@Component
public class JwtTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String, Object> info = new HashMap<>();
        User user=(User) oAuth2Authentication.getPrincipal();
        info.put("jwt-ext", user.getAuthorities().toString());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);
        return oAuth2AccessToken;
    }
}