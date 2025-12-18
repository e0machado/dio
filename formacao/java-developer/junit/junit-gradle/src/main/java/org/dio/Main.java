package org.dio;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Evandro", LocalDate.of(1988,9,23));

        System.out.println(pessoa1);
        System.out.println(pessoa1.getIdade());
    }

}
