package org.spring.cloud.WLC.user.provider.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.cloud.wlc.base.domain.user.User;


@Mapper
public interface UserMapper {
    
    public List<User> findAll();
    public User findUserById(String id);

}