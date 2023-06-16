package com.ete.sunny.model.aluno;

import com.ete.sunny.model.responsavel.Responsavel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosAlunoRecord(
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

        Responsavel responsavel

) {
    public Aluno toAluno(DadosAlunoRecord alunoRecord){
        return new Aluno( null,nome(),cpf(),email(),password(), responsavel());
            //QUAL O PROBLEMA QUE ESTÁ DANDO AQUI???
    }




}
