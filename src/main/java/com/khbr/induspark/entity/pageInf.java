package com.khbr.induspark.entity;

/**
 * Created by Administrator on 2018/9/29 0029.
 */
public class PageInf {
    private Integer pageNum;
    private Integer pageSize;
    private Company company;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    @Override
    public String toString() {
        return "PageInf{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", company=" + company +
                '}';
    }
}
