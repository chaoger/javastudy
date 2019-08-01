/**
 * @(#)KafkaConsumer.java, 2019/7/31.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.chaoge.comsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @author 雷玉超(leiyuchao @ corp.netease.com)
 * @data 2019/07/31
 */
@Component
public class KafkaConsumer {


    @KafkaListener(topics = "mytopic")
    public void listen(ConsumerRecord<?,String> record) {
        String value = record.value();
        System.out.println("I consumer this message = "+value);
        System.out.println(record);
    }

}
