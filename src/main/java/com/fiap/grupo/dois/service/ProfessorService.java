package com.fiap.grupo.dois.service;

import java.util.List;

import com.fiap.grupo.dois.dto.ProfessorDTO;

public interface ProfessorService {
	
	ProfessorDTO create(ProfessorDTO aluno);
	 
	ProfessorDTO delete(String id);
 
    List<ProfessorDTO> findAll();
 
    ProfessorDTO findById(String id);
 
    ProfessorDTO update(ProfessorDTO aluno);
}
