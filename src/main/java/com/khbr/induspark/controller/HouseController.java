package com.khbr.induspark.controller;

import com.khbr.induspark.entity.Company;
import com.khbr.induspark.entity.HouseDetail;
import com.khbr.induspark.service.IHouseService;
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
@RequestMapping("house")
public class HouseController {

    @Autowired
    private IHouseService houseService;

    @GetMapping("queryAll")
    @ResponseBody
    public Page<HouseDetail> queryAllHouse(Integer pageNum,Integer pageSize){
        Page<HouseDetail> houseDetails = houseService.queryAll(pageNum, pageSize);
        return houseDetails;
    }


    @PutMapping("modify")
    @ResponseBody
    public HouseDetail modify(@RequestBody HouseDetail house){
        HouseDetail resultHouse = houseService.queryOne(house.getId());
        BeanUtils.copyProperties(house,resultHouse, MyBeanUtils.getNullProperties(house));
        HouseDetail houseDetail = houseService.addOne(resultHouse);
        return houseDetail;
    }

    @PostMapping("addOne")
    @ResponseBody
    public HouseDetail addOne(@RequestBody HouseDetail house){
        HouseDetail houseDetail = houseService.addOne(house);
        return houseDetail;
    }

}
