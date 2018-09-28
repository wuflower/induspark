package com.khbr.induspark.controller;

import com.khbr.induspark.service.IRentHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/9/28 0028.
 */
@Controller
@RequestMapping("rentHouse")
public class RentHouseController {

    @Autowired
    private IRentHouseService rentHouseService;


}
