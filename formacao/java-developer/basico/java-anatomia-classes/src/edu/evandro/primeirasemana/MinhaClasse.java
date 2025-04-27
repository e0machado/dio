package edu.evandro.primeirasemana;

public class MinhaClasse {

    public static void main(String[] args) {

        int anoFabricacao = 2022;

        boolean verdadeira = false;

        anoFabricacao = 2018;

        String primeiroNome = "Evandro";
        String segundoNome = "Machado";

        String nomeCompleto = nomeCompleto(primeiroNome, segundoNome);

        System.out.println(nomeCompleto);

    }

    public static String nomeCompleto(String primeiroNome, String segundoNome) {
        return "Resultado do método " + primeiroNome.concat(" ").concat(segundoNome);

    }
}
