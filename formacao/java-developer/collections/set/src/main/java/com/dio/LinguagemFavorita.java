package com.dio;

import java.util.Objects;

public class LinguagemFavorita implements Comparable<LinguagemFavorita> {
    private String nome;
    private Integer anoDeCriacao;
    private String ide;

    public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return Objects.equals(nome, that.nome) && Objects.equals(anoDeCriacao, that.anoDeCriacao) && Objects.equals(ide, that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriacao, ide);
    }

    @Override
    public String toString() {
        return "{" +
                nome + " - " +
                anoDeCriacao + " - " +
                ide +
                "}";
    }

    @Override
    public int compareTo(LinguagemFavorita o) {
        int nome = this.getNome().compareToIgnoreCase(o.getNome());
        if (nome != 0) return nome;

        int anoDeCriacao = this.getAnoDeCriacao().compareTo(o.getAnoDeCriacao());
        if (anoDeCriacao != 0) return anoDeCriacao;

        return this.getIde().compareTo(o.getIde());
    }
}
