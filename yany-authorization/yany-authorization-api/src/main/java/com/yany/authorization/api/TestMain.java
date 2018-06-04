package com.yany.authorization.api;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by yanyong on 2018/5/8.
 */
public class TestMain {

    public static void main(String[] args) {
        Map<String,String> test = new HashMap<>();
        test.put("a","aaa");
        System.out.println(test.computeIfAbsent("a",key -> "c"));


    }
}
