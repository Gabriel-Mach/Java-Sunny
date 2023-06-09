package com.ete.sunny.model.aluno;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosAlunoRecord(
        @NotNull
        @NotBlank
        @Size(max = 100)
        String nome,

        @NotNull
        @NotBlank
        @Size(min = 11, max = 11)
        String cpf,

        @NotNull
        @NotBlank
        @Email
        @Size(max = 100)
        String email,

        @NotNull
        @NotBlank
        @Size(min = 8, max = 100)
        String password,

        @NotNull
        @NotBlank
        int pontuacao

) {
    public Aluno toAluno(DadosAlunoRecord alunoRecord){
        return new Aluno( null,nome(),cpf(),email(),password(),pontuacao() );
            //QUAL O PROBLEMA QUE ESTÁ DANDO AQUI???
    }




}
