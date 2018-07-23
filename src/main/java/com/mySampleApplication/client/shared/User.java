package com.mySampleApplication.client.shared;

import java.io.Serializable;

/**
 * Created by dik81 on 23.01.18.
 */
public class User implements Serializable {
    private String name;
    private Integer age;
    private Integer id;
    private Integer departmentId;


    public User(String name, Integer age, Integer departmentId) {
        this.name = name;
        this.age = age;
        this.departmentId = departmentId;

    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentId() {return departmentId; }

    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }

}
