package com.crud.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name="Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,length=100)
    private String name;

    @Column(nullable=false,length=100,unique=true)
    private String email;

    @Column(nullable=false)
    private Integer age;

    public Student() {}


    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getEmail() {
        return email;
    }
    public void  setEmail(String email){
        this.email=email;
    }
    public Integer getAge(){
        return age;
    }
    public void setAge(Integer age){
        this.age=age;

        }
}
