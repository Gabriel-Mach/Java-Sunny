package com.ete.sunny.model;

public record DetalhesReponsavelRecord(String nome, String email, String telefone) {
    public DetalhesReponsavelRecord(UserResponsavel user){
        this(user.getNome(), user.getEmail(), user.getTelefone());
    }
}
