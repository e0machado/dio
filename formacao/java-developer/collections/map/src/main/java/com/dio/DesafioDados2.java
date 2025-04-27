package com.dio;

import java.util.*;

public class DesafioDados2 {
    public static void main(String[] args) {
        // Lista para armazenar os lancamentos de dados
        List<Integer> lancamentos = new ArrayList<>();

        // Mapa para contar quantas vezes cada valor foi inserido
        Map<Integer, Integer> contagem = new HashMap<>();
        for (int i = 1; i <= 6; i++) contagem.put(i, 0);

        Random random = new Random();
        for (int i = 1; i <= 100; i++) {
            int valor = random.nextInt(6) + 1;
            lancamentos.add(valor); // Armazena o lançamento
            contagem.put(valor, contagem.get(valor) + 1); // Atualiza a contagem
        }

        // Exibe todos os lançamentos
        System.out.println("Sequência de lançamentos:");
        for (int i = 0; i < lancamentos.size(); i++) {
            System.out.print(lancamentos.get(i));
            if ((i + 1) % 20 == 0) { // Quebra linha a cada 20 valores
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }

        // Exibe a contagem detalhada
        System.out.println("\n\nContagem de resultados:");
        for (Map.Entry<Integer, Integer> entry : contagem.entrySet()) {
            System.out.printf("Valor %d: %d vezes (%.1f%%)%n",
                    entry.getKey(),
                    entry.getValue(),
                    (entry.getValue() / 100.0) * 100);
        }
    }
}
