package com.baomidou.samples.statictx.service.impl;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.samples.statictx.entity.User;
import com.baomidou.samples.statictx.mapper.UserMapper;
import com.baomidou.samples.statictx.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectUsersFromMaster() {
        return userMapper.selectUsers();
    }

    @DS("slave")
    @Override
    public List<User> selectUsersFromSlave() {
        return userMapper.selectUsers();
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user.getName(), user.getAge());
    }

    @Override
    public void deleteUserById(Long id) {
        userMapper.deleteUserById(id);
    }
}
