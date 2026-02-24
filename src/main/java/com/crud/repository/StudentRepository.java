package com.crud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Boolean existsByEmail(String email);

}
