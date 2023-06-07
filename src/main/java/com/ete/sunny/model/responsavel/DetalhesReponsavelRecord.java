package com.ete.sunny.model.responsavel;

public record DetalhesReponsavelRecord(String nome, String email, String telefone) {
    public DetalhesReponsavelRecord(Responsavel user){

        this(user.getNome(), user.getEmail(), user.getTelefoneResp());
    }
}
