package org.spring.cloud.WLC.user.provider.service;

import java.util.List;

import org.spring.cloud.WLC.user.provider.domain.User;

public interface UserService {
	/**
     * 根据接口查询所用的用户
     */
    public List<User> findAllUser();
    
    /**
     * 根据接口查询所用的用户
     */
    public User findUserById(String id);
}
