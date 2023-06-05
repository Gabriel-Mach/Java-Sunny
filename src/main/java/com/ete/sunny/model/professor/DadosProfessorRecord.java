package com.ete.sunny.model.professor;
//Para tratar os dados
public record DadosProfessorRecord (
                                    String nome,
                                    String cpf,
                                    String email,
                                    String password,
                                    String telefoneProf,
                                    String escola)
{
    public Professor toProfessor(DadosProfessorRecord professorRecord){
        return new Professor(null, cpf(), nome(),email(),password(),telefoneProf(),escola() );


    }
}
