package com.dio;

import java.util.*;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t--");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that's 70 show", "comedia", 25));
        }};
        for (Serie serie: minhasSeries) {
            //System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
            System.out.println(serie.toString());
        }

        System.out.println("--\tOrdem inserção\t--");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that's 70 show", "comedia", 25));
        }};
        for (Serie serie: minhasSeries1) System.out.println(serie.toString());

        System.out.println("--\tOrdem natural (tempoEpisodio)\t--");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        for (Serie serie: minhasSeries2) System.out.println(serie);

        System.out.println("--\tOrdem Nome/Gênero/TempoEpisódio\t--");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSeries3.addAll(minhasSeries);
        for (Serie serie: minhasSeries3) System.out.println(serie);

    }

    static class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie> {
        @Override
        public int compare(Serie s1, Serie s2) {
            int nome = s1.getNome().compareToIgnoreCase(s2.getNome());
            if (nome != 0) return nome;

            int genero = s1.getGenero().compareToIgnoreCase(s2.getGenero());
            if (genero != 0) return genero;

            return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
        }
    }

}
