package org.spring.cloud.WLC.user.provider.service.impl;

import java.util.List;

import org.spring.cloud.WLC.user.provider.domain.User;
import org.spring.cloud.WLC.user.provider.mapper.UserMapper;
import org.spring.cloud.WLC.user.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserMapper userMapper;
	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		List<User> list = userMapper.findAll();
        return list;
	}

	@Override
	public User findUserById(String id) {
		// TODO Auto-generated method stub
		User user=userMapper.findUserById(id);
		return user;
	}

}
