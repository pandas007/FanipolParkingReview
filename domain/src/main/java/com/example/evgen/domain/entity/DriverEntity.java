package com.example.evgen.domain.entity;


public class DriverEntity {

    private String number, car, objectId, phone;
    private Long createdTime, payDayTime;

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getPayDayTime() {
        return payDayTime;
    }

    public void setPayDayTime(Long payDayTime) {
        this.payDayTime = payDayTime;
    }

    public DriverEntity(String number, String car, String phone, Long payDayTime) {
        this.number = number;
        this.car = car;
        this.phone = phone;
        this.payDayTime = payDayTime;
    }
}
