package com.dio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExercicioTempMeses {
    public static void main (String[] args) {

        List<Mes> primeiroSemestre = new ArrayList<>(){{
            add(new Mes("Janeiro"));
            add(new Mes("Fevereiro"));
            add(new Mes("Março"));
            add(new Mes("Abril"));
            add(new Mes("Maio"));
            add(new Mes("Junho"));
        }};

        System.out.println(primeiroSemestre);

        Double soma = 0d;
        for (int i = 0; i < primeiroSemestre.size(); i++) {
            Mes mesAux = primeiroSemestre.get(i);
            soma += mesAux.getTemperatura();
        }
        //System.out.printf("Soma da média das temperaturas do primeiro semestre: %.1f%n", soma);

        Double temperaturaMedia = (soma / primeiroSemestre.size());
        System.out.printf("Média semestral da temperatura: %.1f%n", temperaturaMedia);

        List<Mes> mesesAcimaMedia = new ArrayList<>();

        for (int i = 0; i < primeiroSemestre.size(); i++) {
            Mes mesAux = primeiroSemestre.get(i);
            if (mesAux.getTemperatura() > temperaturaMedia) {
                mesesAcimaMedia.add(mesAux);
            }
        }
        System.out.println(mesesAcimaMedia);

    }
}

class Mes {

    private String nomeMes;
    private Double temperatura;

    public Mes(String nomeMes) {
        this.nomeMes = nomeMes;

        Random random = new Random();
        double tempMedia = 30.0;
        double desvioPadrao = 3.0;

        this.temperatura = tempMedia + random.nextGaussian() * desvioPadrao;

    }

    public String getNomeMes() {
        return nomeMes;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    @Override
    public String toString() {
        return "{" +
                "nomeMes='" + nomeMes + '\'' +
                ", temperatura=" + String.format("%.1f", temperatura) +
                '}';
    }

}
