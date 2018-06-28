package com.fiap.grupo.dois.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.fiap.grupo.dois.model.Professor;

public interface ProfessorRepository extends Repository<Professor, String> {
	 
    void delete(Professor deleted);
    
    List<Professor> findAll();
 
    Optional<Professor> findById(String id);
 
    Professor save(Professor saved);
}
