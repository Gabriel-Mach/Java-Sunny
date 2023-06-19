package com.ete.sunny.model.responsavel;
import com.ete.sunny.model.aluno.Aluno;
import com.ete.sunny.model.responsavel.Responsavel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record DadosResponsavelRecord(
        @NotNull
        @Size(min = 11, max = 11)
        String cpf,

        @NotNull
        @Size(max = 100)
        String nome,

        @NotNull
        @Email
        @Size(max = 100)
        String email,

        @NotNull
        @Size(min = 8, max = 100)
        String password,

        @NotNull
        @Size(max = 11)
        String telefoneResp
        /*
        Perguntar como resolver essa Lista pra o professor
        @NotNull
        @Size(min = 1)
        List<Aluno> aluno*/

) {
    public Responsavel toResp(DadosResponsavelRecord responsavelRecord){
            return new Responsavel(null, this.cpf(), this.nome(),this.email(),this.password(),this.telefoneResp());
    }



}
