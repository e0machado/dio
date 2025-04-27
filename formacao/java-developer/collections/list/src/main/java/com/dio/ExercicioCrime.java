package com.dio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExercicioCrime {
    public static void main(String[] args) {

        List<PerguntaInterrogatorio> interrogatorio = new ArrayList<>();

        interrogatorio.add(new PerguntaInterrogatorio("Telefonou para a vítima?"));
        interrogatorio.add(new PerguntaInterrogatorio("Esteve no local do crime?"));
        interrogatorio.add(new PerguntaInterrogatorio("Mora perto da vítima?"));
        interrogatorio.add(new PerguntaInterrogatorio("Devia para a vítima?"));
        interrogatorio.add(new PerguntaInterrogatorio("Já trabalhou com a vítima?"));

        System.out.println(interrogatorio);

        int respostaVerdadeira = 0;
        for (int i = 0; i < interrogatorio.size(); i++) {
            PerguntaInterrogatorio perguntaAux = interrogatorio.get(i);
            if (perguntaAux.getResposta()) respostaVerdadeira++;
        }

        if (respostaVerdadeira < 2) System.out.println("Inocente!");
        else if (respostaVerdadeira < 3) System.out.println("Suspeita!");
        else if (respostaVerdadeira < 5) System.out.println("Cúmplice!");
        else System.out.println("Assassina!");

    }
}

class PerguntaInterrogatorio {

    private String pergunta;
    private Boolean resposta;

    public PerguntaInterrogatorio(String pergunta) {
        this.pergunta = pergunta;

        Random random = new Random();
        this.resposta = random.nextBoolean();

    }

    public String getPergunta() {
        return pergunta;
    }

    public Boolean getResposta() {
        return resposta;
    }

    @Override
    public String toString() {
        return "{" +
                "pergunta='" + pergunta + '\'' +
                ", resposta=" + resposta +
                '}';
    }

}
