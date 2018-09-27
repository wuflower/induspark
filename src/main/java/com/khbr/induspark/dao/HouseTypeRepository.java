package com.khbr.induspark.dao;


import com.khbr.induspark.entity.Company;
import com.khbr.induspark.entity.HouseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2018/9/27 0027.
 */

public interface HouseTypeRepository extends JpaRepository<HouseType,String>, JpaSpecificationExecutor<HouseType> {
}
