package com.fiap.grupo.dois.mongoDb;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.grupo.dois.dto.ProfessorDTO;
import com.fiap.grupo.dois.error.ProfessorNotFoundException;
import com.fiap.grupo.dois.model.Professor;
import com.fiap.grupo.dois.repository.ProfessorRepository;
import com.fiap.grupo.dois.service.ProfessorService;

@Service
public final class MongoDBProfessorService implements ProfessorService{
	
	private final ProfessorRepository repository;
	 
    @Autowired
    MongoDBProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }
 
    @Override
    public ProfessorDTO create(ProfessorDTO professor) {
        Professor persisted = Professor.getBuilder()
                .nome(professor.getNome())
                .email(professor.getEmail())
                .telefone(professor.getTelefone())
                .build();
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }
 
    @Override
    public ProfessorDTO delete(String id) {
        Professor deleted = findAlunoById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }
 
    @Override
    public List<ProfessorDTO> findAll() {
        List<Professor> professorEntries = repository.findAll();
        return convertToDTOs(professorEntries);
    }
 
    private List<ProfessorDTO> convertToDTOs(List<Professor> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }
 
    @Override
    public ProfessorDTO findById(String id) {
        Professor found = findAlunoById(id);
        return convertToDTO(found);
    }
 
    @Override
    public ProfessorDTO update(ProfessorDTO professor) {
        Professor updated = findAlunoById(professor.getId());
        updated.update(professor.getNome(), professor.getEmail(), professor.getTelefone());
        updated = repository.save(updated);
        return convertToDTO(updated);
    }
 
    private Professor findAlunoById(String id) {
        Optional<Professor> result = repository.findById(id);
        return result.orElseThrow(() -> new ProfessorNotFoundException(id));
 
    }
 
    private ProfessorDTO convertToDTO(Professor model) {
        ProfessorDTO dto = new ProfessorDTO();
 
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setEmail(model.getEmail());
        dto.setTelefone(model.getTelefone());
 
        return dto;
    }
}
