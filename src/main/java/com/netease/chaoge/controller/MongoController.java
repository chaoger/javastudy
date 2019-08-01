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
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 雷玉超(leiyuchao @ corp.netease.com)
 * @data 2019/07/31
 */
@RestController
@RequestMapping("/mongo")
public class MongoController {



    public static final String MONGO_COLLECTION_NAME = "user_info";

    @Autowired
    private MongoTemplate mongoTemplate;


    @RequestMapping(value = "/insertUserInfo")
    public String insertUserInfo(String name,String address) {
        try{
            User user = new User();
            user.setName(name);
            user.setAddress(address);
            mongoTemplate.save(JSONObject.toJSON(user), MONGO_COLLECTION_NAME);

            //一般查询
            Query query = new Query();
            Criteria criteria = Criteria.where("name").is(name);  //查询条件"id"指MongoDB里面的key
            criteria.and("address").is(address);  //and条件
            query.addCriteria(criteria);
            List<String> result = mongoTemplate.find(query,String.class,MONGO_COLLECTION_NAME);

            return JSONObject.toJSONString(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "400";
    }


    @RequestMapping(value = "/selectAllUserInfo")
    public String selectAllUserInfo() {
        try{
            List<String> result = mongoTemplate.findAll(String.class,MONGO_COLLECTION_NAME);
            return JSONObject.toJSONString(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "400";
    }

}
