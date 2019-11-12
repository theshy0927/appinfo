package com.t248.appinfo.web.controller.dev;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.t248.appinfo.dto.AppVersionDTO;
import com.t248.appinfo.dto.AppinfoDTO;
import com.t248.appinfo.dto.CategoryDTO;
import com.t248.appinfo.model.AppInfo;
import com.t248.appinfo.model.AppVersion;
import com.t248.appinfo.model.DataDictionary;
import com.t248.appinfo.model.DevUser;
import com.t248.appinfo.service.AppVersionService;
import com.t248.appinfo.service.AppinfoService;
import com.t248.appinfo.utils.AppinfoCode;
import com.t248.appinfo.utils.QueryParam;
import com.t248.appinfo.utils.Result;
import com.t248.appinfo.vo.AppinfoVO;
import com.t248.appinfo.web.config.RedisUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/dev")
@Controller
public class DevUserController {



    @Autowired
    private AppinfoService service;

    @Autowired
    private AppVersionService versionService;

    @Autowired
    private RedisUtils utils;

     private void allCategory(){
         List<CategoryDTO> categorylevel1 = service.getAllCategory(null,1);
         List<CategoryDTO> categorylevel2 = new ArrayList<>();
         List<CategoryDTO> categorylevel3 = new ArrayList<>();

         for (CategoryDTO c1 : categorylevel1){
             c1.setNextLevel("c1");
             List<CategoryDTO> templevel2 = service.getAllCategory(c1.getId(),2);
             c1.setChildCategory(templevel2.stream().map(CategoryDTO::getId).collect(Collectors.toList()));
             for (CategoryDTO c2 : templevel2){
                 categorylevel2.add(c2);
                 c1.setNextLevel("c2");
                 List<CategoryDTO> templevel3 = service.getAllCategory(c2.getId(),3);
                 c2.setChildCategory(templevel3.stream().map(CategoryDTO::getId).collect(Collectors.toList()));
                 for (CategoryDTO c3 : templevel3){
                     c3.setNextLevel(null);
                     categorylevel3.add(c3);
                 }
             }
         }
         utils.set("allc1", categorylevel1);
         utils.set("allc2", categorylevel2);
         utils.set("allc3", categorylevel3);
    }
    private void getAllCategory(){
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




    private void allDataDictionary(){
        List<DataDictionary> flaform = service.getFlaform(null);
        utils.set("dataDictionary", flaform);
    }

    @RequestMapping("/main.html")
    public String main(){
        return "/dev/main";
    }


    @RequestMapping("list.html")
    public String findAllApp(HttpServletRequest request,Model model, QueryParam queryParam, @RequestParam(name = "curNo",required = false,defaultValue = "1") Integer curNo){


         if(!utils.hasKey("c1")){
             allCategory();
             getAllCategory();
         }
         if (!utils.hasKey("dataDictionary")){
             allDataDictionary();
         }
        DevUser devUser = (DevUser) request.getSession().getAttribute("devUser");

            queryParam.setCreatedBy(devUser.getId());
            if(queryParam.getQueryCategoryLevel1()!=null){
                model.addAttribute("clist2",utils.getCategoryLevel(queryParam.getQueryCategoryLevel1(),"c2"));
            }
            if(queryParam.getQueryCategoryLevel2()!=null){
                model.addAttribute("clist3",utils.getCategoryLevel(queryParam.getQueryCategoryLevel2(),"c3"));
            }
        List<CategoryDTO> c1 = (List<CategoryDTO>)utils.get("c1");
        model.addAttribute("clist1",c1);
        List<DataDictionary> allDataDictionary = (List<DataDictionary>) utils.get("dataDictionary");
        model.addAttribute("appStatus",allDataDictionary.stream().filter(s->"APP_STATUS".equals(s.getTypeCode())).collect(Collectors.toList()));
        model.addAttribute("appFlatFrom",allDataDictionary.stream().filter(s->"APP_FLATFORM".equals(s.getTypeCode())).collect(Collectors.toList()));
        PageHelper.startPage(curNo, 2);
        Page<AppinfoDTO> page = service.findAppAll(queryParam);
        PageInfo pageInfo = new PageInfo(page,3);
        model.addAttribute("pageData",page.getResult());
        model.addAttribute("page",pageInfo);
        model.addAttribute("queryParam", queryParam);
        return "/dev/list";
    }

    @RequestMapping("/edit/{id}.html")
    public ModelAndView edit(@PathVariable("id") Long id){
        ModelAndView model = new ModelAndView("/dev/edit");
        AppInfo selectOneAPP = service.getSelectOneAPP(id);
        model.addObject("appinfo",selectOneAPP);
        System.out.println(selectOneAPP);
        return model;
    }

    @RequestMapping("/add.html")
    public String add(){
        if(!utils.hasKey("c1")){
            allCategory();
            getAllCategory();
        }
        if (!utils.hasKey("dataDictionary")){
            allDataDictionary();
        }
        return "/dev/add";
    }



@RequestMapping("/upload")
@ResponseBody
    public String upload(@RequestParam("a_logoPicPath") MultipartFile file,AppInfo info,HttpServletRequest request) throws IOException {
    File file1 = new File("D:\\fileupload\\"+System.currentTimeMillis()+file.getOriginalFilename());
    file.transferTo(file1);
    info.setLogoLocPath(file1.getName());
    info.setLogoPicPath(file1.getName());
    DevUser devUser = (DevUser)request.getSession().getAttribute("devUser");
    info.setCreatedBy(devUser.getId());
    info.setCreationDate(new Date());
    info.setDevId(devUser.getId());
    int result = service.addApp(info);
    if(result>0){
        utils.del("c1");
    }
    return "{\"status\":\"true\"}";
    }

    @RequestMapping(value= "modify",method = RequestMethod.POST)
    @ResponseBody
    public String modify(@RequestParam(name = "attach",required = false) MultipartFile file,AppInfo info,HttpServletRequest request) throws IOException {

         if(file!=null){
            File file1 = new File("D:\\fileupload\\"+System.currentTimeMillis()+file.getOriginalFilename());
            info.setLogoLocPath(file1.getName());
            info.setLogoPicPath(file1.getName());
            file.transferTo(file1);
        }
        DevUser devUser = (DevUser)request.getSession().getAttribute("devUser");
        info.setModifyBy(devUser.getId());
        info.setModifyDate(new Date());

        boolean bool = service.modify(info);

        return bool?"{\"status\":\"true\"}":"{\"status\":\"false\"}";
    }

    @RequestMapping("/view/{id}.html")
    public String view(@PathVariable Long id,Model model){
         if (!utils.hasKey("dataDictionary")){
             allDataDictionary();
         }
            QueryParam info = new QueryParam();
            info.setId(id);
        AppinfoVO one = service.findOne(info);
        model.addAttribute("appinfo", one);
        model.addAttribute("appVersionList", versionService.findByAPPId(id,null,(List<DataDictionary>) utils.get("dataDictionary")));

        return "/dev/view";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam("downloadLink")String downloadLink,HttpServletRequest request) throws IOException {
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


    @RequestMapping("/versionadd/{appid}.html")
    public ModelAndView versionAdd(@PathVariable Long appid){
         if(utils.hasKey("dataDictionary")){
             allDataDictionary();
         }
        ModelAndView modelAndView = new ModelAndView("/dev/versionadd");
        QueryParam queryParam = new QueryParam();
        queryParam.setId(appid);
        modelAndView.addObject("appinfo", service.findOne(queryParam));
        modelAndView.addObject("appVersionList",versionService.findByAPPId(appid,null,(List<DataDictionary>) utils.get("dataDictionary")));
        return modelAndView;
    }


    @RequestMapping("versionUpload")
    @ResponseBody
    public Result versionUpload(@RequestParam("a_downloadLink") MultipartFile file, AppVersion version,HttpServletRequest request) throws IOException {
        File uploadFile = new File("D:\\filedownload\\"+file.getOriginalFilename());
        file.transferTo(uploadFile);
        version.setDownloadLink(file.getOriginalFilename());
        version.setCreationDate(new Date());
        version.setApkFileName(file.getOriginalFilename());
        version.setApkLocPath(file.getOriginalFilename());
        DevUser devUser = (DevUser) request.getSession().getAttribute("devUser");
        version.setCreatedBy(devUser.getId());
        int versionId = versionService.addVersion(version);
        QueryParam param = new QueryParam();
        AppInfo one = service.getSelectOneAPP(version.getAppId());
        param.setId(one.getId());
        one.setVersionId(version.getId());
        service.modify(one);
        if(service.findOne(param)==null){
            Result.errorOf(AppinfoCode.app_not_find);
        }
         return Result.okOf(null);
    }

    /**
     * 版本 修改
     * @param appid app的id
     * @return
     */
    @RequestMapping("versionedit/{appid}.html")
    public ModelAndView versionEdit(@PathVariable("appid") Long appid,@RequestParam("id") Long id){
        if(utils.hasKey("dataDictionary")){
            allDataDictionary();
        }
        ModelAndView model = new ModelAndView("/dev/versionedit");
        AppVersion version = new AppVersion();
        List<AppVersionDTO> listVersion = versionService.findByAPPId(appid, null, (List<DataDictionary>) utils.get("dataDictionary"));
        model.addObject("appVersionList",  listVersion.stream().filter(l -> l.getAppId() != appid).collect(Collectors.toList()));
        model.addObject("appVersion", versionService.findById(id,(List<DataDictionary>) utils.get("dataDictionary")));
        return model;
    }


    @RequestMapping(value= "versionModify",method = RequestMethod.POST)
    @ResponseBody
    public Result versionModify(@RequestParam(name = "attach",required = false) MultipartFile file,AppVersion version,HttpServletRequest request) throws IOException {
        DevUser devUser = (DevUser) request.getSession().getAttribute("devUser");
        if(file!=null){
            File file1 = new File("D:\\download\\"+file.getOriginalFilename());
            version.setDownloadLink(file.getOriginalFilename());
            version.setApkFileName(file.getOriginalFilename());
            version.setApkLocPath(file.getOriginalFilename());
            file.transferTo(file1);
        }
        version.setModifyBy(devUser.getId());
        version.setModifyDate(new Date());
        AppVersionDTO dto = new AppVersionDTO();
        BeanUtils.copyProperties(version,dto);
        boolean bool = versionService.modify(dto);

        return Result.okOf(null);
    }

    @RequestMapping("delapp.json")
    @ResponseBody
    public Result delapp(@RequestParam("id")Long appid){
        boolean delete = service.delete(appid);
        if(delete){
            return Result.okOf(null);
        }
        return Result.errorOf(AppinfoCode.app_not_find);
    }

    /**
     * 上架下架
     */
    @RequestMapping("{appid}/sale.json")
    @ResponseBody
    public Result sale(@PathVariable("appid") Long appid,@RequestParam("status")Long status){
        AppInfo app = service.select(appid);
        app.setStatus(status);
        boolean modify = service.modify(app);
        if(!modify){
            return Result.errorOf(AppinfoCode.app_not_find);
        }
        return Result.okOf(null);
    }

}
