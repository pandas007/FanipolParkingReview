package com.example.evgen.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Driver implements Serializable {

    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("car")
    @Expose
    private String car;
    @SerializedName("created")
    @Expose
    private Long created;
    @SerializedName("ownerId")
    @Expose
    private String ownerId;
    @SerializedName("updated")
    @Expose
    private Long updated;
    @SerializedName("objectId")
    @Expose
    private String objectId;
    @SerializedName("payDate")
    @Expose
    private Long payDate;
    @SerializedName("___class")
    @Expose
    private String _class;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Long getPayDate() {
        return payDate;
    }

    public void setPayDate(Long payDate) {
        this.payDate = payDate;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }
}
