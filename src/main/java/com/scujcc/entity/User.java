package com.scujcc.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by David on 4/6/17.
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String sex;
    private Date birthday;
    private int height;
    private int weight;
    private String maritalStatus;
    private String country;
    private String politicalStatus;
    private String typeOfCertificate;
    private String numberOfCertificate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getTypeOfCertificate() {
        return typeOfCertificate;
    }

    public void setTypeOfCertificate(String typeOfCertificate) {
        this.typeOfCertificate = typeOfCertificate;
    }

    public String getNumberOfCertificate() {
        return numberOfCertificate;
    }

    public void setNumberOfCertificate(String numberOfCertificate) {
        this.numberOfCertificate = numberOfCertificate;
    }
}
