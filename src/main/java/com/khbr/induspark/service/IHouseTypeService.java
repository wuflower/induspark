package com.khbr.induspark.service;

import com.khbr.induspark.entity.HouseType;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2018/9/27 0027.
 */
public interface IHouseTypeService {

    Page<HouseType> queryAll(Integer pageNum,Integer pageSize,HouseType houseType);

    HouseType queryOne(String id);

    HouseType addOne(HouseType houseType);
}
