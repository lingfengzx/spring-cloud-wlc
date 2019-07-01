package org.spring.cloud.WLC.user.provider.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.spring.cloud.WLC.user.provider.domain.User;


@Mapper
public interface UserMapper {
    
    public List<User> findAll();
    public User findUserById(String id);

}