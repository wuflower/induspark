package com.khbr.induspark.service.impl;

import com.khbr.induspark.dao.HouseRepository;
import com.khbr.induspark.entity.HouseDetail;
import com.khbr.induspark.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/27 0027.
 */
@Service
public class HouseService implements IHouseService{

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public Page<HouseDetail> queryAll(Integer pageNum,Integer pageSize) {
        Pageable pageable = new PageRequest(pageNum,pageSize);
        Page<HouseDetail> allHouse = houseRepository.findAll(pageable);
        return allHouse;

    }

    @Override
    public HouseDetail addOne(HouseDetail house) {
        HouseDetail houseDetail = houseRepository.save(house);

        return houseDetail;
    }

    @Override
    public HouseDetail queryOne(String id) {
        HouseDetail houseDetail = houseRepository.findOne(id);
        return houseDetail;
    }
}
