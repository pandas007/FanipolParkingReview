package com.example.evgen.domain.entity;


public class DriverEntity {

    private String number, car, objectId;
    private Double createdTime, updatedTime;

    public Double getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Double createdTime) {
        this.createdTime = createdTime;
    }

    public Double getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Double updatedTime) {
        this.updatedTime = updatedTime;
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

    public DriverEntity(String number, String car, String objectId) {
        this.number = number;
        this.car = car;
        this.objectId = objectId;
    }

    public DriverEntity(String number, String car, String objectId, Double createdTime, Double updatedTime) {
        this.number = number;
        this.car = car;
        this.objectId = objectId;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }
}
