package com.ete.sunny.model.aluno;

public record DetalhesAlunoRecord(String nome, String email, int pontuacao) {
    public DetalhesAlunoRecord(Aluno aluno){
        this(aluno.getNome(),
                aluno.getEmail(),
                aluno.getPontuacao());
    }


}
