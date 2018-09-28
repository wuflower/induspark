package com.khbr.induspark.service;

import com.khbr.induspark.entity.HouseDetail;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2018/9/27 0027.
 */
public interface IHouseService {

    Page<HouseDetail> queryAll(Integer pageNum,Integer pageSize);

    HouseDetail addOne(HouseDetail house);

    HouseDetail queryOne(String id);
}
