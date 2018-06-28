package com.fiap.grupo.dois.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.grupo.dois.dto.ProfessorDTO;
import com.fiap.grupo.dois.error.ProfessorNotFoundException;
import com.fiap.grupo.dois.service.ProfessorService;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {
	
	private final ProfessorService service;
	 
    @Autowired
    ProfessorController(ProfessorService service) {
        this.service = service;
    }
 
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    ProfessorDTO create(@RequestBody @Valid ProfessorDTO professorEntry) {
        return service.create(professorEntry);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    ProfessorDTO delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
 
    @RequestMapping(method = RequestMethod.GET)
    List<ProfessorDTO> findAll() {
        return service.findAll();
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    ProfessorDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    ProfessorDTO update(@RequestBody @Valid ProfessorDTO todoEntry) {
        return service.update(todoEntry);
    }
 
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(ProfessorNotFoundException ex) {
    }
}
