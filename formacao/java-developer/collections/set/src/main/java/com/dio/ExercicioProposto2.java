package com.dio;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExercicioProposto2 {
    public static void main(String[] args) {

        System.out.println(
                "Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e ide.\n" +
                "Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:"
        );
        Set<LinguagemFavorita> minhasLinguagensFavoritas = new LinkedHashSet<>(){{
            add(new LinguagemFavorita("Java", 1990, "IntelliJ IDEA"));
            add(new LinguagemFavorita("Ruby", 1990, "VS Code"));
            add(new LinguagemFavorita("Python", 2000, "VS Code"));
        }};
        System.out.println("A. Ordem de inserção: ");
        System.out.println(minhasLinguagensFavoritas);

        System.out.println("B. Ordem natural (nome): ");
        Set<LinguagemFavorita> minhasLinguagensFavoritas1 = new TreeSet<>(minhasLinguagensFavoritas);
        System.out.println(minhasLinguagensFavoritas1);

        System.out.println("C. IDE: ");
        Set<LinguagemFavorita> minhasLinguagensFavoritas2 = new TreeSet<>(new ComparatorIDE());
        minhasLinguagensFavoritas2.addAll(minhasLinguagensFavoritas1);
        System.out.println(minhasLinguagensFavoritas2);

        System.out.println("D. Ano de crição e nome: ");
        Set<LinguagemFavorita> minhasLinguagensFavoritas3 = new TreeSet<>(new ComparatorAnoDeCriacaoNome());
        minhasLinguagensFavoritas3.addAll(minhasLinguagensFavoritas1);
        System.out.println(minhasLinguagensFavoritas3);

        System.out.println("E. Nome, ano de criação e IDE: ");
        System.out.println(minhasLinguagensFavoritas1);

        System.out.println("Exiba as lingugens no console, uma abaixo da outra: ");
        for (LinguagemFavorita linguagemAux: minhasLinguagensFavoritas1) System.out.println(linguagemAux);

    }

    static class ComparatorIDE implements Comparator<LinguagemFavorita> {
        @Override
        public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
            int ide = o1.getIde().compareTo(o2.getIde());
            if (ide != 0) return ide;

            int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
            if (nome != 0) return nome;

            return o1.getAnoDeCriacao().compareTo(o2.getAnoDeCriacao());
        }
    }

    static class ComparatorAnoDeCriacaoNome implements Comparator<LinguagemFavorita> {

        @Override
        public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
            int anoDeCriacao = o1.getAnoDeCriacao().compareTo(o2.getAnoDeCriacao());
            if (anoDeCriacao != 0) return anoDeCriacao;

            int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
            if (nome != 0) return nome;

            return o1.getIde().compareTo(o2.getIde());
        }
    }

}
