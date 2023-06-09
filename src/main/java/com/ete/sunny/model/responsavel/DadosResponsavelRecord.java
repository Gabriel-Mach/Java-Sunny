package com.ete.sunny.model.responsavel;
import com.ete.sunny.model.responsavel.Responsavel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosResponsavelRecord(
        @NotNull
        @NotBlank
        @Size(min = 11, max = 11)
        String cpf,

        @NotNull
        @NotBlank
        @Size(max = 100)
        String nome,

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
        @Size(max = 11)
        String telefoneResp
) {
    public Responsavel toResp(DadosResponsavelRecord responsavelRecord){
            //QUAL O PROBLEMA QUE ESTÁ DANDO AQUI???
            return new Responsavel(null, cpf(), nome(),email(),telefoneResp());
    }



}
