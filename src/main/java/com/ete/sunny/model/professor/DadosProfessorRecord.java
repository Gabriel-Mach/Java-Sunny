package com.ete.sunny.model.professor;

import jakarta.validation.constraints.*;

//Para tratar os dados
public record DadosProfessorRecord (
        @NotNull
        @Size(max = 100)
        String nome,

        @NotNull
        @Size(min = 11, max = 11)
        String cpf,

        @NotNull
        @Email
        @Size(max = 100)
        String email,

        @NotNull
        @Size(min = 8, max = 100)
        String password,

        @NotNull
        @Size(min = 11, max = 11)
        String telefoneProf,

        @NotNull
        @Size(max = 100)
        String escola
) {
    public Professor toProfessor(DadosProfessorRecord professorRecord){
        return new Professor(null, cpf(), nome(),email(),password(),telefoneProf(),escola() );
    }

}
