package com.khbr.induspark.dao;

import com.khbr.induspark.entity.Company;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/9/27 0027.
 */
public interface CompanyDao extends JpaRepository<Company,String>, JpaSpecificationExecutor<Company> {

}
