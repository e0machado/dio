package com.dio;

import java.util.*;

public class ExercicioProposto1 {
    public static void main(String[] args) {

        System.out.println("Crie um conjunto contendo as cores do arco-íris e:");
        TreeSet<String> coresArcoIris = new TreeSet<>() {{
            add("Vermelho");
            add("Laranja");
            add("Amarelo");
            add("Verde");
            add("Azul");
            add("Anil");
            add("Violeta");
        }};

        System.out.println("A. Exiba todas as cores uma abaixo da outra: ");
        for (String cores : coresArcoIris) System.out.println(cores);

        System.out.println("B. A quantidade de cores que o arco-íris tem: " + coresArcoIris.size());

        System.out.println("C. Exiba as cores em ordem alfabética: ");
        System.out.println(coresArcoIris);

        System.out.println("D. Exiba as cores na ordem inversa da que foi informada: ");
        List<String> coresArcoIrisInvertida = new ArrayList<>(coresArcoIris);
        Collections.reverse(coresArcoIrisInvertida);
        System.out.println(coresArcoIrisInvertida);

        System.out.println("E. Exiba todas as cores que começam com a letra V: ");
        Set<String> letraV = new TreeSet<>(coresArcoIris.subSet("V", "X"));
        System.out.println(letraV);

        System.out.println("F. Remova todas as cores que não começam com a letra V: ");
        Iterator<String> iterator = coresArcoIris.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (!letraV.contains(next)) iterator.remove();
        }
        System.out.println(coresArcoIris);

        System.out.println("G. Limpe o conjunto: ");
        coresArcoIris.clear();
        System.out.println(coresArcoIris);

        System.out.println("H. Confira se o conjunto está vazio: " + coresArcoIris.isEmpty());

    }
}
