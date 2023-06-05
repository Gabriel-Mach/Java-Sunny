package com.ete.sunny.repository;


import com.ete.sunny.model.professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepositry extends JpaRepository<Professor, Long> {

}
