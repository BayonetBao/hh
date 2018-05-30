package com.gem.shop.dao;

import com.gem.shop.entity.Message;
import com.gem.shop.entity.User;

public interface UserMapper {
    public User selectUserByName(String uname);
}
