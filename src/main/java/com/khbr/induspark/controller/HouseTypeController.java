package com.khbr.induspark.controller;

import com.khbr.induspark.entity.HouseType;
import com.khbr.induspark.service.IHouseTypeService;
import com.khbr.induspark.util.MyBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        Page<HouseType> houseTypes = houseTypeService.queryAll(pageNum, pageSize, houseType);
        return houseTypes;
    }

    @PutMapping("modify")
    @ResponseBody
    public HouseType modify(@RequestBody HouseType houseType){
        HouseType resultHouseType = houseTypeService.queryOne(houseType.getId());
        BeanUtils.copyProperties(houseType,resultHouseType, MyBeanUtils.getNullProperties(houseType));
        HouseType addHouseType = houseTypeService.addOne(resultHouseType);
        return addHouseType;
    }

    @PostMapping("addOne")
    @ResponseBody
    public HouseType addOne(@RequestBody HouseType houseType){
        HouseType addHouseType = houseTypeService.addOne(houseType);
        return addHouseType;
    }


}


