package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Chen Changjiang
 * @date : 2020/01/03
 * @description :
 */

@RestController
@RequestMapping("/sample")
public class Sample {

    @RequestMapping("/show")
    public Object show() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("show", "success");
        return jsonObject;
    }

}
