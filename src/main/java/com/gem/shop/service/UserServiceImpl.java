package com.gem.shop.service;

import com.gem.shop.dao.UserMapper;
import com.gem.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserByName(String uname) {
        return userMapper.selectUserByName(uname);
    }
}
