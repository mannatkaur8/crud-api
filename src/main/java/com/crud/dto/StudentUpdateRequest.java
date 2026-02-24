package com.crud.dto;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

public class StudentUpdateRequest {

    @Size(max=100)
    private String name;

    @Email
    private String email;

    private Integer age;

    public StudentUpdateRequest() {}
    public StudentUpdateRequest(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public void setName
            (String name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void  setEmail(String email){
        this.email=email;
    }
    public Integer getAge(){
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}