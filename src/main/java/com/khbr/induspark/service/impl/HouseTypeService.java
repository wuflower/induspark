package com.khbr.induspark.service.impl;

import com.khbr.induspark.dao.HouseTypeRepository;
import com.khbr.induspark.entity.HouseType;
import com.khbr.induspark.service.IHouseTypeService;
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
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/9/27 0027.
 */
@Service
public class HouseTypeService implements IHouseTypeService {

    @Autowired
    private HouseTypeRepository houseTypeRepository;

    @Override
    public Page<HouseType> queryAll(Integer pageNum, Integer pageSize, HouseType houseType) {
        Pageable param = new PageRequest(pageNum, pageSize);
        Page<HouseType> page = houseTypeRepository.findAll(new Specification<HouseType>() {
            @Override
            public Predicate toPredicate(Root<HouseType> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<Predicate>();
                if(houseType.getId()!=null && !"".equals(houseType.getId())){
                    predicates.add(criteriaBuilder.like(root.get("id").as(String.class),"%"+houseType.getId()+"%"));
                }
                if(houseType.getImgUrl()!=null && !"".equals(houseType.getImgUrl())){
                    predicates.add(criteriaBuilder.like(root.get("imgUrl").as(String.class),"%"+houseType.getImgUrl()+"%"));
                }
                if(houseType.getTypeName()!=null && !"".equals(houseType.getImgUrl())){
                    predicates.add(criteriaBuilder.like(root.get("typeName").as(String.class),"%"+houseType.getTypeName()+"%"));
                }
                if(houseType.getSysStatus()!=null && !"".equals(houseType.getSysStatus())){
                    predicates.add(criteriaBuilder.like(root.get("sysStatus").as(String.class),"%"+houseType.getSysStatus()+"%"));
                }

                Predicate[] pre = new Predicate[predicates.size()];
                criteriaQuery.where(predicates.toArray(pre));
                return criteriaBuilder.and(predicates.toArray(pre));
            }
        },param);


        return page;
    }

    @Override
    public HouseType queryOne(String id) {
        HouseType houseType = houseTypeRepository.findOne(id);
        return houseType;
    }

    @Override
    public HouseType addOne(HouseType houseType) {
        HouseType resultHouseType = houseTypeRepository.save(houseType);
        return resultHouseType;
    }
}
