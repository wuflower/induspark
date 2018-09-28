package com.khbr.induspark.service.impl;

import com.khbr.induspark.dao.RentHouseRepository;
import com.khbr.induspark.entity.RentHouse;
import com.khbr.induspark.service.IRentHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/9/28 0028.
 */
@Service
public class RentHouseService implements IRentHouseService {

    @Autowired
    private RentHouseRepository rentHouseRepository;


    public Page<RentHouse> queryAll(Integer pageNum,Integer pageSize){
        Pageable pageable = new PageRequest(pageNum,pageSize);
        Page<RentHouse> rentHouses = rentHouseRepository.findAll(pageable);
        return rentHouses;
    }


    public RentHouse addOne(RentHouse rentHouse){
        RentHouse addRentHouse = rentHouseRepository.save(rentHouse);
        return addRentHouse;
    }

    public RentHouse queryOne(String id){
        RentHouse rentHouse = rentHouseRepository.findOne(id);
        return rentHouse;
    }
}
