package com.ete.sunny.model.professor;

public record DetalhesProfessorRecord( String nome, String email, String telefone, String escola ) {
    public DetalhesProfessorRecord(Professor professor){
        this(professor.getNome(),professor.getEmail(),professor.getTelefoneProf(), professor.getEscola());

    }
}
