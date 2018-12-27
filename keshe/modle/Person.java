package com.example.administrator.keshe.modle;

import org.greenrobot.greendao.annotation.Entity;

import cn.bmob.v3.BmobUser;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Nikcn on 2016/5/10.
 * 表设置内容：
 * String Name
 * String address
 */
@Entity
public class Person extends BmobUser {
    private String name;
    private String number;
    private String oil;
    private String sex;
    private String vehclenumber1;
    private String vehcleclass1;
    private String oilclass1;
    private String vehclenumber2;
    private String vehcleclass2;
    private String oilclass2;
    private String vehclenumber3;
    private String vehcleclass3;
    private String oilclass3;
    private Integer vehcles2;

    @Generated(hash = 1636455650)
    public Person(String name, String number, String oil, String sex,
            String vehclenumber1, String vehcleclass1, String oilclass1,
            String vehclenumber2, String vehcleclass2, String oilclass2,
            String vehclenumber3, String vehcleclass3, String oilclass3,
            Integer vehcles2) {
        this.name = name;
        this.number = number;
        this.oil = oil;
        this.sex = sex;
        this.vehclenumber1 = vehclenumber1;
        this.vehcleclass1 = vehcleclass1;
        this.oilclass1 = oilclass1;
        this.vehclenumber2 = vehclenumber2;
        this.vehcleclass2 = vehcleclass2;
        this.oilclass2 = oilclass2;
        this.vehclenumber3 = vehclenumber3;
        this.vehcleclass3 = vehcleclass3;
        this.oilclass3 = oilclass3;
        this.vehcles2 = vehcles2;
    }

    @Generated(hash = 1024547259)
    public Person() {
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


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getOil() {
        return oil;
    }

    public void setOil(String oil) {
        this.oil = oil;
    }


    public void setVehcleNumber1(String vehclenumber) {
        this.vehclenumber1 = vehclenumber;
    }

    public void setVehcleclass1(String vehcleclass) {
        this.vehcleclass1 = vehcleclass;
    }

    public void setOilclass1(String oilclass) {
        this.oilclass1 = oilclass;
    }

    public void setVehcleNumber2(String vehclenumber) {
        this.vehclenumber2 = vehclenumber;
    }

    public void setVehcleclass2(String vehcleclass) {
        this.vehcleclass2 = vehcleclass;
    }

    public void setOilclass2(String oilclass) {
        this.oilclass2 = oilclass;
    }

    public void setVehcleNumber3(String vehclenumber) {
        this.vehclenumber3 = vehclenumber;
    }

    public void setVehcleclass3(String vehcleclass) {
        this.vehcleclass3 = vehcleclass;
    }

    public void setOilclass3(String oilclass) {
        this.oilclass3 = oilclass;
    }

    public Integer getVehcles2() {
        return this.vehcles2;
    }

    public void setVehcles2(Integer vehcles2) {
        this.vehcles2 = vehcles2;
    }

    public String getOilclass3() {
        return this.oilclass3;
    }

    public String getVehcleclass3() {
        return this.vehcleclass3;
    }

    public String getVehclenumber3() {
        return this.vehclenumber3;
    }

    public void setVehclenumber3(String vehclenumber3) {
        this.vehclenumber3 = vehclenumber3;
    }

    public String getOilclass2() {
        return this.oilclass2;
    }

    public String getVehcleclass2() {
        return this.vehcleclass2;
    }

    public String getVehclenumber2() {
        return this.vehclenumber2;
    }

    public void setVehclenumber2(String vehclenumber2) {
        this.vehclenumber2 = vehclenumber2;
    }

    public String getOilclass1() {
        return this.oilclass1;
    }

    public String getVehcleclass1() {
        return this.vehcleclass1;
    }

    public String getVehclenumber1() {
        return this.vehclenumber1;
    }

    public void setVehclenumber1(String vehclenumber1) {
        this.vehclenumber1 = vehclenumber1;
    }
}