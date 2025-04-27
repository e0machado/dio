package com.dio;

import java.util.*;

public class DesafioDados {
    public static void main(String[] args) {

        Map<Integer, Integer> dadosLancamentos = new LinkedHashMap<>();
        Map<String, Integer> dadosContagem = new LinkedHashMap<>(){{
            put("valor1", 0);
            put("valor2", 0);
            put("valor3", 0);
            put("valor4", 0);
            put("valor5", 0);
            put("valor6", 0);
        }};

        Random random = new Random();
        for (int i = 1; i <= 100; i++) dadosLancamentos.put(i, random.nextInt(6) + 1);
        System.out.println(dadosLancamentos);

        Iterator<Integer> iterator = dadosLancamentos.values().iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            switch (next) {
                case 1:
                    dadosContagem.put("valor1", dadosContagem.get("valor1") + 1);
                    break;
                case 2:
                    dadosContagem.put("valor2", dadosContagem.get("valor2") + 1);
                    break;
                case 3:
                    dadosContagem.put("valor3", dadosContagem.get("valor3") + 1);
                    break;
                case 4:
                    dadosContagem.put("valor4", dadosContagem.get("valor4") + 1);
                    break;
                case 5:
                    dadosContagem.put("valor5", dadosContagem.get("valor5") + 1);
                    break;
                case 6:
                    dadosContagem.put("valor6", dadosContagem.get("valor6") + 1);
                    break;
            }
        }
        System.out.println(dadosContagem);
    }
}
