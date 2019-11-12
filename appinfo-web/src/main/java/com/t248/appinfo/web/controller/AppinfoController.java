package com.t248.appinfo.web.controller;

import com.t248.appinfo.dto.AppVersionDTO;
import com.t248.appinfo.dto.CategoryDTO;
import com.t248.appinfo.model.AppInfo;
import com.t248.appinfo.model.DataDictionary;
import com.t248.appinfo.service.AppVersionService;
import com.t248.appinfo.service.AppinfoService;
import com.t248.appinfo.web.config.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/appinfo/")
public class AppinfoController {

    @Autowired
    private AppinfoService service;

    @Autowired
    private RedisUtils utils;

    @Autowired
    private AppVersionService versionService;


    @RequestMapping("/CategoryLevel2")
    public List<CategoryDTO> getCategoryLevel2(@RequestParam("pid") Long categoryLevelId){
        return utils.getCategoryLevel(categoryLevelId,"c2");
    }
    @RequestMapping("/CategoryLevel3")
    public List<CategoryDTO> getCategoryLevel3(@RequestParam("pid") Long categoryLevelId){

        return utils.getCategoryLevel(categoryLevelId,"c3");
    }

    private void allDataDictionary(){
        List<DataDictionary> flaform = service.getFlaform(null);
        utils.set("dataDictionary", flaform);
    }

        @RequestMapping("datadictionarylist.json")
        public List<DataDictionary> getFlaFormList(String tcode){
        if(!utils.hasKey("dataDictionary")){
            allDataDictionary();
        }
            List<DataDictionary> dataDictionary = (List<DataDictionary>) utils.get("dataDictionary");
           return dataDictionary.stream().filter(s->tcode.equals(s.getTypeCode())).collect(Collectors.toList());
        }
    @RequestMapping("statusName.json")
    public DataDictionary getStatusName(Long valueId){
        if(!utils.hasKey("dataDictionary")){
            allDataDictionary();
        }
        List<DataDictionary> dataDictionary = (List<DataDictionary>) utils.get("dataDictionary");
        return dataDictionary.stream().filter(s->"APP_STATUS".equals(s.getTypeCode())).filter(s->s.getValueId()==valueId).collect(Collectors.toList()).get(0);
    }

        @RequestMapping("categorylevellist.json")
    public List<CategoryDTO> getCategorylevellist1(@RequestParam("pid") Long parentId,@RequestParam(name = "level",required = false
        ,defaultValue = "allc1") String level){
            List<CategoryDTO> allc1 = utils.getCateList(parentId, level);

            return  allc1;
        }

        @RequestMapping("apkexist.json")
        public String checkAPKNameExsits(@RequestParam(name = "APKName") String APKName){
            if(StringUtils.isBlank(APKName)){
                return "{\"APKName\":\"empty\"}";
            }
            AppInfo info = new AppInfo();
            info.setAPKName(APKName);

            boolean exits = service.checkAPKNameExsits(info);
            if(exits){
                return "{\"APKName\":\"exist\"}";
            }
            return "{\"APKName\":\"noexist\"}";
        }

        @RequestMapping("delfile.json")
        public String delfile(@RequestParam("id") Long id,@RequestParam(value = "flag",required = false)String flag){
            File file = null;
            boolean bool = false;
            if("apk".equals(flag)){
                if(utils.hasKey("dataDictionary")){
                    allDataDictionary();
                }
                AppVersionDTO appVersion = versionService.findById(id, (List<DataDictionary>) utils.get("dataDictionary"));
                file = new File("D:\\fileupload\\" + appVersion.getDownloadLink());
                if(file.exists()){
                    file.delete();
                }
                appVersion.setDownloadLink(null);
                appVersion.setApkLocPath(null);
                appVersion.setApkFileName(null);
                bool = versionService.modify(appVersion);

            }else {

                AppInfo app = service.getSelectOneAPP(id);
                file = new File("D:\\fileuploa\\" + app.getLogoLocPath());
                if (file.exists()) {
                    file.delete();
                }
                app.setLogoLocPath(null);
                app.setLogoPicPath(null);
                bool = service.modify(app);
            }
            return bool?"{\"result\":\"success\"}":"{\"result\":\"failed\"}";
        }


    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam("downloadLink")String downloadLink, HttpServletRequest request) throws IOException {
        File file = new File("D:\\filedownload\\"+downloadLink);
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }

}
