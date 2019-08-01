/**
 * @(#)KafkaController.java, 2019/7/31.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.chaoge.controller;

import com.alibaba.fastjson.JSONObject;
import com.netease.chaoge.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 雷玉超(leiyuchao @ corp.netease.com)
 * @data 2019/07/31
 */
@RestController
@RequestMapping("/redis")
public class RedisController {




    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping(value = "/insert")
    public String insertUserInfo(String key,String value) {


        redisTemplate.opsForValue().set(key,value);

        return redisTemplate.opsForValue().get(key).toString();
    }


    @RequestMapping(value = "/getOne")
    public String selectAllUserInfo(String key) {
        return redisTemplate.opsForValue().get(key).toString();

    }


}
