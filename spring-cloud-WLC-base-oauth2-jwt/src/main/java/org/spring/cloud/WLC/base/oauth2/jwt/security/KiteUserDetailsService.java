package org.spring.cloud.WLC.base.oauth2.jwt.security;

import java.util.ArrayList;
import java.util.List;

import org.spring.cloud.WLC.base.oauth2.jwt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.spring.cloud.wlc.base.domain.user.WlcUser;

@Component(value = "kiteUserDetailsService")
public class KiteUserDetailsService implements UserDetailsService {


    @Autowired
    private UserMapper userMapper;

    /**
     * 正式环境中，这里应该是从数据库或者其他地方根据用户名将加密后的密码及所属角色查出来的。
     * 账号 admin ，密码 123456，稍后在换取 token 的时候会用到。
     * 并且给这个用户设置 "ROLE_ADMIN" 角色。
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	WlcUser user=userMapper.findByName(username);
    	// 查询数据库操作
        if(user==null){
            throw new UsernameNotFoundException("the user is not found");
        }else{
            // 用户角色也应在数据库中获取
        	List<String> roles=userMapper.queryRoleNames(username);
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(JSON.toJSONString(roles)));
            // 线上环境应该通过用户名查询数据库获取加密后的密码
            String password = user.getUserPassword();
            return new org.springframework.security.core.userdetails.User(username,password, authorities);
        }
    }
}