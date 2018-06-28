package com.fiap.grupo.dois.error;

@SuppressWarnings("serial")
public class ProfessorNotFoundException extends RuntimeException {

    public ProfessorNotFoundException(String id) {
        super(String.format("Nenhum aluno encontrado pelo id: <%s>", id));
    }
}
