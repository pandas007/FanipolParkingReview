package com.example.evgen.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Driver implements Serializable {

    @SerializedName("Number")
    @Expose
    private String number;
    @SerializedName("Car")
    @Expose
    private String car;
    @SerializedName("created")
    @Expose
    private Double created;
    @SerializedName("ownerId")
    @Expose
    private Integer ownerId;
    @SerializedName("updated")
    @Expose
    private Double updated;
    @SerializedName("objectId")
    @Expose
    private String objectId;
    @SerializedName("___class")
    @Expose
    private String _class;

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

    public Double getCreated() {
        return created;
    }

    public void setCreated(Double created) {
        this.created = created;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Double getUpdated() {
        return updated;
    }

    public void setUpdated(Double updated) {
        this.updated = updated;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }
}
