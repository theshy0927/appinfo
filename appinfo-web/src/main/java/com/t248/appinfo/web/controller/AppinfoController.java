package com.t248.appinfo.web.controller;

import com.t248.appinfo.dto.CategoryDTO;
import com.t248.appinfo.service.AppinfoService;
import com.t248.appinfo.web.config.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/appinfo")
public class AppinfoController {

    @Autowired
    private AppinfoService service;

    @Autowired
    private RedisUtils utils;



    @RequestMapping("/CategoryLevel2")
    public List<CategoryDTO> getCategoryLevel2(@RequestParam("pid") Long categoryLevelId){
        return utils.getCategoryLevel(categoryLevelId,"c2");
    }
    @RequestMapping("/CategoryLevel3")
    public List<CategoryDTO> getCategoryLevel3(@RequestParam("pid") Long categoryLevelId){

        return utils.getCategoryLevel(categoryLevelId,"c3");
    }


}
