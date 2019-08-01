/**
 * @(#)UserServiceImpl.java, 2019/7/31.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.chaoge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.chaoge.mapper.UserMapper;
import com.netease.chaoge.po.User;
import com.netease.chaoge.po.UserExample;
import com.netease.chaoge.service.UserService;

/**
 * @author 雷玉超(leiyuchao @ corp.netease.com)
 * @data 2019/07/31
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired UserMapper userMapper;

    @Override
    public List<User> selectAllUser() {
        UserExample example = new UserExample();
        example.createCriteria().andIdGreaterThan(0);
        return userMapper.selectByExample(example);
    }

    @Override
    public Integer insertUser(User user) {
        return userMapper.insertSelective(user);
    }
}
