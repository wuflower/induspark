package com.khbr.induspark.dao;

import com.khbr.induspark.entity.RentHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2018/9/28 0028.
 */
public interface RentHouseRepository extends JpaRepository<RentHouse,String>,JpaSpecificationExecutor<RentHouse> {
}
