/**
 * @(#)UserController.java, 2019/7/31.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.chaoge.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.netease.chaoge.po.User;
import com.netease.chaoge.service.UserService;

/**
 * @author 雷玉超(leiyuchao @ corp.netease.com)
 * @data 2019/07/31
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    //增加用户
    @ResponseBody
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public Integer insertUser(@RequestBody User user){
        System.out.println(JSONObject.toJSONString(user));
        return userService.insertUser(user);
    }

    //查询所有的用户
    @ResponseBody
    @RequestMapping("/selectAllUser")
    public String getAllUser(){
        List<User> list = userService.selectAllUser();

        return JSONObject.toJSONString(list);
    }
}
