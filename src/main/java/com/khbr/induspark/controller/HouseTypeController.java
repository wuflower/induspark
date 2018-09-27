package com.khbr.induspark.controller;

import com.khbr.induspark.entity.HouseType;
import com.khbr.induspark.service.IHouseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/9/27 0027.
 */
@Controller
@RequestMapping("houseType")
public class HouseTypeController {

    @Autowired
    private IHouseTypeService houseTypeService;

    @PutMapping("queryAll")
    @ResponseBody
    public Page<HouseType> queryAll(Integer pageNum,Integer pageSize,@RequestBody HouseType houseType){

    }


}


