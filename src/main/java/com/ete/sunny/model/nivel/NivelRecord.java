package com.ete.sunny.model.nivel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NivelRecord(
        Long numero,
        @NotNull
        @NotBlank
        @Size(max = 100)
    String nome,
    int numtentativas,
        @NotNull
        @NotBlank
        @Size(max = 100)

    String dicas,

    boolean resposta,
        @NotNull
        Tema tema

) {
    public Nivel toNivel(NivelRecord nivelRecord){
        return new Nivel(numero(), nome(),numtentativas(), dicas(), resposta(), tema());

    }

    public NivelRecord(Nivel nivel) {
        this(nivel.getNumero(), nivel.getNome(),nivel.getNumtentativas(),nivel.getDicas(), nivel.isResposta(), nivel.getTema());
    }
}
