package com.t248.appinfo.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.t248.appinfo.dto.AppinfoDTO;
import com.t248.appinfo.dto.CategoryDTO;
import com.t248.appinfo.mapper.AppInfoMapper;
import com.t248.appinfo.mapper.AppVersionMapper;
import com.t248.appinfo.model.AppVersion;
import com.t248.appinfo.model.DataDictionary;
import com.t248.appinfo.service.AppinfoService;
import com.t248.appinfo.web.config.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@ComponentScan("com.t248.appinfo")
@SpringBootTest
public  class AppinfoWebApplicationTests {

    @Autowired
    private AppInfoMapper mapper;


    @Autowired
    private AppVersionMapper versionMapper;


    @Test
    public void findApp(){
        PageHelper.offsetPage(6, 2);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("status", 1);
        Page<AppinfoDTO> appInfos = mapper.findApp(null);
        PageInfo<AppinfoDTO> info = new PageInfo<>(appInfos.getResult(),3);
        System.out.println(info);
    }

    @Autowired
    private RedisUtils utils;

    @Test
    public void stringTOmap(){
        Map<Integer, CategoryDTO> map = new HashMap<>();
        CategoryDTO dto1 = new CategoryDTO();
        dto1.setCategoryName("软件");
        dto1.setChildCategory(Lists.newArrayList(2L,3L,4L));
        map.put(1, dto1);
        utils.set("c1", map);
        CategoryDTO dto2 = new CategoryDTO();
        dto2.setCategoryName("软件");
        dto2.setChildCategory(Lists.newArrayList(5L,6L,7L));


        Map<Integer, CategoryDTO> test = (Map<Integer, CategoryDTO>)utils.get("c1");
        System.out.println(test);
    }

    @Test
    public void getAllCategory(){
        List<CategoryDTO> categorylevel1 = mapper.getAppInfoCategory(1L, "categorylevel2");
        System.out.println(categorylevel1);
    }

    @Test
    public void getFlaform(){
        List<DataDictionary> list = mapper.getFlaform("APP_STATUS");
        System.out.println(list);
    }
@Autowired
  private   AppinfoService service;


    @Test
    public void allCategory(){
        List<CategoryDTO> categorylevel1 = service.getAppInfoCategory(null, "categorylevel1");
        List<CategoryDTO> categorylevel2 = new ArrayList<>();
        List<CategoryDTO> categorylevel3 = new ArrayList<>();
        utils.set("c1", categorylevel1);
        for (CategoryDTO c1 : categorylevel1){
            c1.setNextLevel("c1");
            List<CategoryDTO> templevel2 = service.getAppInfoCategory(c1.getId(), "categorylevel2");
            c1.setChildCategory(templevel2.stream().map(CategoryDTO::getId).collect(Collectors.toList()));
            for (CategoryDTO c2 : templevel2){
                categorylevel2.add(c2);
                c1.setNextLevel("c2");
                List<CategoryDTO> templevel3 = service.getAppInfoCategory(c2.getId(), "categorylevel3");
                c2.setChildCategory(templevel3.stream().map(CategoryDTO::getId).collect(Collectors.toList()));
                for (CategoryDTO c3 : templevel3){
                    c3.setNextLevel(null);
                    categorylevel3.add(c3);
                }
            }
        }
        utils.set("c1", categorylevel1);
        utils.set("c2", categorylevel2);
        utils.set("c3", categorylevel3);
    }



    @Test
    public void version(){
        AppVersion version = new AppVersion();
        version.setAppId(56L);
        List<AppVersion> select = versionMapper.select(version);
        System.out.println(select);
    }

    @Test
    public void a(){
        List<DataDictionary> dataDictionary = (List<DataDictionary>) utils.get("dataDictionary");

    }
}
