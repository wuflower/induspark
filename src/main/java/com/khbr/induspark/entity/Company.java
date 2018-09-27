package com.khbr.induspark.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2018/9/27 0027.
 */
@Entity
public class Company{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    @Column(length = 32)
    private String id;
    private String companyName;
    private String legalPerson;
    private String scCode;
    private String registrationId;
    private String address;
    private String phoneNumber;
    private String email;
    private String businessLicense;
    private String permitsAccounts;
    private Byte sysStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getScCode() {
        return scCode;
    }

    public void setScCode(String scCode) {
        this.scCode = scCode;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getPermitsAccounts() {
        return permitsAccounts;
    }

    public void setPermitsAccounts(String permitsAccounts) {
        this.permitsAccounts = permitsAccounts;
    }

    public Byte getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(Byte sysStatus) {
        this.sysStatus = sysStatus;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", companyName='" + companyName + '\'' +
                ", legalPerson='" + legalPerson + '\'' +
                ", scCode='" + scCode + '\'' +
                ", registrationId='" + registrationId + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", businessLicense='" + businessLicense + '\'' +
                ", permitsAccounts='" + permitsAccounts + '\'' +
                ", sysStatus=" + sysStatus +
                '}';
    }
}
