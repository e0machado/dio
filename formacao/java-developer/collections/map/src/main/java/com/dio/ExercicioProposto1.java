package com.dio;

import java.util.*;

public class ExercicioProposto1 {
    public static void main(String[] args) {

        System.out.println("Crie um dicionário e relacione os estados e suas populações: ");
        Map<String, Integer> estadosNE = new HashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(estadosNE);

        System.out.println("Substitua a população do estado do RN por 3.534.165: ");
        estadosNE.put("RN", 3534165);
        System.out.println(estadosNE);

        System.out.println("Confira se o estado PB está no dicionário: " + estadosNE.containsKey("PB"));
        System.out.println("Caso não, adicione PB - 4.039.277: ");
        if (!estadosNE.containsKey("PB")) estadosNE.put("PB", 4039277);
        System.out.println(estadosNE);

        System.out.println("Exiba a população PE: " + estadosNE.get("PE"));

        System.out.println("Exiba todos os estados e suas populações na ordem que foi informado: ");
        Map<String, Integer> estadosNE1 = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(estadosNE1);

        System.out.println("Exiba os estados e suas populações em ordem alfabética: ");
        Map<String, Integer> estadosNE2 = new TreeMap<>(estadosNE1);
        System.out.println(estadosNE2);

        System.out.println("Exiba o estado com a menor população e sua quantidade: ");
        Integer menorPopulacao = Collections.min(estadosNE1.values());
        Set<Map.Entry<String, Integer>> entries = estadosNE1.entrySet();
        String estadoMenorPopulacao = "";
        for (Map.Entry<String, Integer> entry: entries) {
            if (entry.getValue().equals(menorPopulacao)) {
                estadoMenorPopulacao = entry.getKey();
                System.out.println(estadoMenorPopulacao + " - " + menorPopulacao);
            }
        }

        System.out.println("Exiba o estado com a maior população e sua quantidade: ");
        Integer maiorPopulacao = Collections.max(estadosNE1.values());
        String estadoMaiorPopulacao = "";
        for (Map.Entry<String, Integer> entry: entries) {
            if (entry.getValue().equals(maiorPopulacao)) {
                estadoMaiorPopulacao = entry.getKey();
                System.out.println(estadoMaiorPopulacao + " - " + maiorPopulacao);
            }
        }

        Iterator<Integer> iterator = estadosNE1.values().iterator();
        Integer soma = 0;
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("Exiba a soma da população desses estados: " + soma);

        System.out.println("Exiba a média da população deste dicionário de estados: " + (soma/estadosNE1.size()));

        System.out.println("Remova os estados com a população menor que 4.000.000: ");
        Iterator<Integer> iterator1 = estadosNE2.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next() < 4000000) iterator1.remove();
        }
        System.out.println(estadosNE2);

        System.out.println("Apague o dicionário de estados: ");
        estadosNE.clear();
        System.out.println(estadosNE);

        System.out.println("Confira se o dicionário está vazio: " + estadosNE.isEmpty());

    }
}
