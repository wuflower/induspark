package com.khbr.induspark.controller;

import com.khbr.induspark.entity.Company;
import com.khbr.induspark.service.ICompanyService;
import com.khbr.induspark.util.MyBeanUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * Created by Administrator on 2018/9/27 0027.
 */
@Controller
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @PostMapping("add")
    public String addCompany(@RequestParam("file") List<MultipartFile> origFiles,Company company){
        Company addCompany = companyService.addCompany(company);

        if (addCompany!=null){

        }
        String result="";
        if (origFiles.isEmpty()) {
            //redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            result+="Please select a file to upload";
        }
        try {
            for (MultipartFile origFile : origFiles) {
                String contentType = origFile.getContentType();
                String fileName = origFile.getOriginalFilename();
                byte[] bytes = origFile.getBytes();
                System.out.println("上传文件名为-->" + fileName);
                System.out.println("上传文件类型为-->" + contentType);
                System.out.println("上传文件大小为-->"+bytes.length);

                //String filePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/myres/";
                String filePath = "D:/Onedrive/picture/proImg/indus";
                //String filePath = request.getSession().getServletContext().getRealPath("imgupload");
                System.out.println("上传目的地为-->"+filePath);
                try {
                    File destFile = new File(filePath,fileName);//上传目的地
                    FileUtils.writeByteArrayToFile(destFile,origFile.getBytes());
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }


            // Get the file and save it somewhere

	     /*   Path path = Paths.get(UPLOADED_FOLDER + origFile.getOriginalFilename());
	        Files.write(path, bytes);

	        redirectAttributes.addFlashAttribute("message",
	                "You successfully uploaded '" + origFile.getOriginalFilename() + "'");*/
            String fileName="";
            for (MultipartFile list:
                    origFiles) {

                fileName=fileName+list.getOriginalFilename()+";";

            }

            result+="You successfully uploaded";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "companyInf";
    }

    /*@GetMapping("queryAll")
    @ResponseBody
    public Page<Company> queryAllCompany(@RequestParam(value = "pageNum" ,defaultValue = "0") Integer pageNum, @RequestParam(value = "pageSize" ,defaultValue = "3")Integer pageSize){
        Page<Company> page = companyService.queryAllCompany(pageNum,pageSize);
        return page;
    }*/

    @PutMapping("modifyCompany")
    @ResponseBody
    public Company modifyCompany(@RequestBody Company company){
        Company resultCompany = companyService.queryOneCompany(company.getId());
        BeanUtils.copyProperties(company,resultCompany, MyBeanUtils.getNullProperties(company));
        Company addCompany = companyService.addCompany(resultCompany);
        return addCompany;
    }


    /*@PostMapping("query")
    @ResponseBody
    public Page<Company> queryByCondition(@RequestBody PageInf pageInf) {
        //Page<Company> companies = companyService.dynamicQueryCompany(Integer.valueOf(pageNum),Integer.valueOf(pageSize),params);
        Integer pageNum = pageInf.getPageNum();
        Integer pageSize = pageInf.getPageSize();
        Company params = pageInf.getCompany();
        System.out.println("============");
        Page<Company> companies = companyService.dynamicQueryCompany(pageNum,pageSize,params);
        return companies;

    }*/

    @GetMapping("query")
    @ResponseBody
    public Page<Company> queryByCondition(Integer pageNum,Integer pageSize, Company params) {
        //Page<Company> companies = companyService.dynamicQueryCompany(Integer.valueOf(pageNum),Integer.valueOf(pageSize),params);
        System.out.println("============");
        Page<Company> companies = companyService.dynamicQueryCompany(pageNum,pageSize,params);
        return companies;

    }



    @RequestMapping("index")
    public String index(){
        return "companyInf";
    }

}
