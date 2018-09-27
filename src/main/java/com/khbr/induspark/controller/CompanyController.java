package com.khbr.induspark.controller;

import com.khbr.induspark.entity.Company;
import com.khbr.induspark.service.ICompanyService;
import com.khbr.induspark.util.MyBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



/**
 * Created by Administrator on 2018/9/27 0027.
 */
@Controller
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @PostMapping("addCompany")
    @ResponseBody
    public Company addCompany(@RequestBody Company company){
        Company addCompany = companyService.addCompany(company);
        return addCompany;
    }

    @GetMapping("queryAllCompany")
    @ResponseBody
    public Page<Company> queryAllCompany(){
        Pageable pageParam = new PageRequest(0,3);
        Page<Company> allCompany = companyService.queryAllCompany(pageParam);
        return allCompany;
    }

    @PutMapping("modifyCompany")
    @ResponseBody
    public Company modifyCompany(@RequestBody Company company){
        Company resultCompany = companyService.queryOneCompany(company.getId());
        BeanUtils.copyProperties(company,resultCompany, MyBeanUtils.getNullProperties(company));
        Company addCompany = companyService.addCompany(resultCompany);
        return addCompany;
    }


    @PutMapping("queryByCondition")
    @ResponseBody
    public Page<Company> queryByCondition(Integer pageNum,Integer pageSize,@RequestBody Company params) {
        pageNum=0;
        pageSize=3;
        Page<Company> companies = companyService.dynamicQueryCompany(pageNum,pageSize,params);
        return companies;

    }

}
