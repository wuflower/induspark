package com.khbr.induspark.service.impl;

import com.khbr.induspark.dao.CompanyDao;
import com.khbr.induspark.entity.Company;
import com.khbr.induspark.service.ICompanyService;
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
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public Company addCompany(Company company) {
        Company saveCompany = companyDao.save(company);
        return saveCompany;
    }

    @Override
    public Page<Company> queryAllCompany(Integer pageNum, Integer pageSize) {
        Pageable pageParam = new PageRequest(pageNum, pageSize);
        Page<Company> companyPage = companyDao.findAll(pageParam);

        return companyPage;
    }

    @Override
    public Company queryOneCompany(String id) {
        Company company = companyDao.findOne(id);
        return company;
    }

    @Override
    public Page<Company> dynamicQueryCompany(Integer pageNum, Integer pageSize, Company company) {
        Pageable pageable = new PageRequest(pageNum, pageSize);
        if (company != null) {
            Page<Company> page = companyDao.findAll(new Specification<Company>() {
                @Override
                public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                    List<Predicate> predicates = new ArrayList<>();
                    if (company.getId() != null && !company.getId().equals("")) {
                        predicates.add(cb.like(root.get("id").as(String.class), "%" + company.getId() + "%"));
                    }
                    if (company.getCompanyName() != null && !company.getCompanyName().equals("")) {
                        predicates.add(cb.like(root.get("companyName").as(String.class), "%" + company.getCompanyName() + "%"));
                    }
                    if (company.getLegalPerson() != null && !"".equals(company.getLegalPerson())) {
                        predicates.add(cb.like(root.get("legalPerson").as(String.class), "%" + company.getLegalPerson() + "%"));
                    }
                    if (company.getScCode() != null && !"".equals(company.getScCode())) {
                        predicates.add(cb.like(root.get("scCode").as(String.class), "%" + company.getScCode() + "%"));
                    }
                    if (company.getAddress() != null && !"".equals(company.getAddress())) {
                        predicates.add(cb.like(root.get("address").as(String.class), "%" + company.getAddress() + "%"));
                    }
                    if (company.getRegistrationId() != null && !"".equals(company.getRegistrationId())) {
                        predicates.add(cb.like(root.get("registrationId").as(String.class), "%" + company.getRegistrationId() + "%"));
                    }
                    if (company.getPhoneNumber() != null && !"".equals(company.getPhoneNumber())) {
                        predicates.add(cb.like(root.get("phoneNumber").as(String.class), "%" + company.getPhoneNumber() + "%"));
                    }
                    if (company.getEmail() != null && !"".equals(company.getEmail())) {
                        predicates.add(cb.like(root.get("email").as(String.class), "%" + company.getEmail() + "%"));
                    }
                    if (company.getBusinessLicense() != null && !"".equals(company.getBusinessLicense())) {
                        predicates.add(cb.like(root.get("businessLicense").as(String.class), "%" + company.getBusinessLicense() + "%"));
                    }
                    if (company.getPermitsAccounts() != null && !"".equals(company.getPermitsAccounts())) {
                        predicates.add(cb.like(root.get("permitsAccounts").as(String.class), "%" + company.getPermitsAccounts() + "%"));
                    }
                    if (company.getSysStatus() != null && !"".equals(company.getSysStatus())) {
                        predicates.add(cb.like(root.get("sysStatus").as(String.class), "%" + "1" + "%"));
                    }

                    Predicate[] pre = new Predicate[predicates.size()];
                    criteriaQuery.where(predicates.toArray(pre));
                    return cb.and(predicates.toArray(pre));
                }
            }, pageable);
            return page;
        }
        else {
            Page<Company> page = companyDao.findAll(pageable);
            return page;
        }


    }
}
