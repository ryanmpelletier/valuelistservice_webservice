package com.pelletier.controller;

import com.pelletier.valuelist.ValueListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 578993 on 6/10/2016.
 */
@RestController
public class HelloController {

    @Autowired
    ValueListService valueListService;

    @RequestMapping(value = "/valueslistservice/values", method = RequestMethod.GET)
    public String hello(){
        return "Hello";
    }
}
