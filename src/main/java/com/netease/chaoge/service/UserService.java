/**
 * @(#)UserService.java, 2019/7/31.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.chaoge.service;

import java.util.List;

import com.netease.chaoge.po.User;

/**
 * @author 雷玉超(leiyuchao @ corp.netease.com)
 * @data 2019/07/31
 */
public interface UserService {
    List<User> selectAllUser();

    Integer insertUser(User user);

}
