package com.khbr.induspark.service;

import com.khbr.induspark.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/27 0027.
 */
public interface ICompanyService {

    Company addCompany(Company company);

    Page<Company> queryAllCompany(Integer pageNum,Integer pageSize);

    Company queryOneCompany(String id);

    Page<Company> dynamicQueryCompany(Integer pageNum,Integer pageSize,Company company);
}
