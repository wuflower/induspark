package com.khbr.induspark.controller;

import com.khbr.induspark.entity.Company;
import com.khbr.induspark.entity.HouseDetail;
import com.khbr.induspark.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/9/27 0027.
 */
@Controller
@RequestMapping("house")
public class HouseController {

    @Autowired
    private IHouseService houseService;


    public Page<HouseDetail> queryAllHouse(Integer pageNum,Integer pageSize,@RequestBody Company params){

        return null;
    }

}
