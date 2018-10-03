package com.example.evgen.domain.entity;


public class DriverEntity {

    private String number, car, objectId;

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
}
