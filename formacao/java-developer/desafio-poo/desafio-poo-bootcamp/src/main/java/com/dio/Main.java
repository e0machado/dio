package com.dio;

import com.dio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descricao curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descricao curso js");
        curso2.setCargaHoraria(8);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("mentoria de java");
        mentoria1.setDescricao("descricao mentoria java");
        mentoria1.setData(LocalDate.now());

//        System.out.println(curso1);
//        System.out.println(curso2);
//        System.out.println(mentoria1);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("bootcamp java developer");
        bootcamp.setDescricao("descricao bootcamp java developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria1);

        Dev devEvandro = new Dev();
        devEvandro.setNome("Evandro");
        devEvandro.inscreverBootcamp(bootcamp);
        System.out.println("conteudos inscritos: " + devEvandro.getNome() + devEvandro.getConteudosInscritos());
        devEvandro.progredir();
        System.out.println("-");
        System.out.println("conteudos inscritos: " + devEvandro.getNome() + devEvandro.getConteudosInscritos());
        System.out.println("conteudos concluidos: " + devEvandro.getNome() + devEvandro.getConteudosConcluidos());
        System.out.println("XP Evandro: " + devEvandro.calcularXp());

        System.out.println("----------");

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("conteudos inscritos: " + devCamila.getNome() + devCamila.getConteudosInscritos());
        devCamila.progredir();
        devCamila.progredir();
        devCamila.progredir();
//        devCamila.progredir();
        System.out.println("-");
        System.out.println("conteudos inscritos: " + devCamila.getNome() + devCamila.getConteudosInscritos());
        System.out.println("conteudos concluidos: " + devCamila.getNome() + devCamila.getConteudosConcluidos());
        System.out.println("XP Camila: " + devCamila.calcularXp());

    }
}
