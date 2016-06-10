package com.pelletier.controller;

import com.pelletier.valuelist.PagingInfo;
import com.pelletier.valuelist.ValueListService;
import com.pelletier.valuelist.Values;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ryan Pelletier on 6/10/2016.
 */
@RestController
public class HelloController {

    @Autowired
    ValueListService valueListService;

    @RequestMapping(value = "/valueslistservice/values", method = RequestMethod.GET)
    public Values<? extends Object> getValueList(HttpServletRequest request){
        Map<String,Object> params = new HashMap<String, Object>();

        for(Object key : request.getParameterMap().keySet()){
            String paramValue = ((String[])request.getParameterMap().get(key))[0];
//            params.put((String)key,parameterConversionService.convertIfNeeded((String) key, paramValue));
            params.put((String)key,paramValue);

        }
        PagingInfo pagingInfo = null;

        if(params.get("page") != null && params.get("numberPerPage") != null){
            pagingInfo = new PagingInfo();
            pagingInfo.setPage(Integer.parseInt((String)params.get("page")));
            pagingInfo.setNumberPerPage(Integer.parseInt((String)params.get("numberPerPage")));
        }

        //the valuesInfo I am returned should never be null
        return valueListService.getValuesList((String) params.get("valueListQuery"), params, pagingInfo);
    }
}
