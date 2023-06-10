package com.ete.sunny.model.nivel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NivelRecord(
        @NotNull
        @NotBlank
        @Size(max = 100)
    String nome,
        @NotNull
        @NotBlank

    int numtentativas,
        @NotNull
        @NotBlank
        @Size(max = 100)

    String dicas,
        @NotNull
        @NotBlank

    boolean resposta,
        @NotNull
        @NotBlank

    Tema tema

) {
    public Nivel toNivel(NivelRecord nivelRecord){
        return new Nivel(null, nome(),numtentativas(), dicas(), resposta(), tema());

    }

    public NivelRecord(Nivel nivel) {
        this(nivel.getNome(),nivel.getNumtentativas(),nivel.getDicas(), nivel.isResposta(), nivel.getTema());
    }
}
