package com.khbr.induspark.dao;

import com.khbr.induspark.entity.HouseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2018/9/27 0027.
 */
public interface HouseRepository extends JpaRepository<HouseDetail,String>,JpaSpecificationExecutor<HouseDetail> {
}
