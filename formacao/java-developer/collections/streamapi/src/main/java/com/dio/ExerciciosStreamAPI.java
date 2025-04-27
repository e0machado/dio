package com.dio;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {

        List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9","6", "5");

        System.out.println("Imprima todos os elementos dessa lista de String: ");
//        numerosAleatorios.stream().forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });
//        numerosAleatorios.stream().forEach(s -> System.out.println(s));
        numerosAleatorios.forEach(System.out::println);

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set: ");
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("Transforme essa lista de String em uma lista de números inteiros: ");
        List<Integer> listNumerosInteiros = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(listNumerosInteiros);

        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista: ");
        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> (i % 2 == 0 && i > 2))
                .toList();
        System.out.println(listParesMaioresQue2);

        System.out.println("Mostre a média dos números: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Remova os valores impares: ");
        List<Integer> listPares = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        listPares.removeIf(i -> (i % 2 != 0));
        System.out.println(listPares);

//        Para você:

        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante: ");
        numerosAleatorios.stream()
                .skip(3)
                .forEach(System.out::println);

        int size = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet())
                .size();
        System.out.println("Retirando os números repetidos da lista, quantos números ficam? " + size);
/*
        Resposta da professora:
        long countNumerosUnicos = numerosAleatorios.stream()
                .distinct()
                .count();
*/

//        Optional<Integer> min = listNumerosInteiros.stream().min(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
        Optional<Integer> min = listNumerosInteiros.stream()
                .min(Integer::compareTo);
        System.out.println("Mostre o menor valor da lista: " + min);

/*      Resposta da professora:
        listNumerosInteiros.stream()
                .mapToInt(Integer::intValue)
                .min()
                .ifPresent(System.out::println);
*/
        Optional<Integer> max = listNumerosInteiros.stream()
                .max(Integer::compareTo);
        System.out.println("Mostre o maior valor da lista: " + max);

        System.out.println("Pegue apenas os números ímpares e some: ");
        List<Integer> listImpares = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        listImpares.removeIf(i -> (i % 2 == 0));
        int sumImpares = listImpares.stream()
                .mapToInt(Integer::intValue)
                .sum();
//        System.out.println(listImpares);
        System.out.println(sumImpares);
/*
        Resposta da professora:
        int sumImpares1 = listNumerosInteiros.stream()
                .filter(i -> (i % 2 != 0))
                .mapToInt(Integer::intValue)
                .sum();
*/
        System.out.println("Mostre a lista na ordem númerica: ");
        listNumerosInteiros.sort(Integer::compareTo);
        System.out.println(listNumerosInteiros);

/*      Resposta da professora:
        List<Integer> collectOrdemNatural = listNumerosInteiros.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(collectOrdemNatural);
*/
        System.out.println("Agrupe os valores ímpares múltiplos de 3 e de 5: ");
//        Map<Boolean, List<Integer>> grupoMultiplos3E5 = listNumerosInteiros.stream()
//                .collect(Collectors.groupingBy(new Function<Integer, Boolean>() {
//                    @Override
//                    public Boolean apply(Integer i) {
//                        if (i % 3 == 0 || i % 5 == 0) return true;
//                        return false;
//                    }
//                }));
        Map<Boolean, List<Integer>> grupoMultiplos3E5 = listNumerosInteiros.stream()
                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
        System.out.println(grupoMultiplos3E5);

        System.out.println("By Evandro >>> Agrupe todos os valores entre 2 e 6: ");
        Map<Boolean, List<Integer>> collectEntre2E6 = listNumerosInteiros.stream()
                .collect(Collectors.groupingBy(i -> (i >= 2 && i <= 6)));
        System.out.println(collectEntre2E6);

    }
}
