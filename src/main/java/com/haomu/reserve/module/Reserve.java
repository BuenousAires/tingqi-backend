package com.haomu.reserve.module;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("ts_reserve")
public class Reserve {
    @TableId(value = "id", type= IdType.AUTO)
    private Integer id;

    private String name;

    private String phone;

    private Integer peopleNumber;

    private String startTime;

    private String endTime;

    private Integer step;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", peopleNumber=" + peopleNumber +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", step=" + step +
                '}';
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("name", name);
        json.put("phone", phone);
        json.put("peopleNumber", peopleNumber);
        json.put("startTime", startTime);
        json.put("endTime", endTime);
        json.put("step", step);
        return json;
    }
}
