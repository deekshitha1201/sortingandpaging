package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.student;

public interface StudentRepository extends JpaRepository<student, Integer> {

}
