package org.dio;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

public class ConsultarDadosDePessoaTest {

    @BeforeAll
    static void configuraConexao() {
        BancoDeDados.iniciarConexao();
        //System.out.println("Rodou iniciarConexao()");
    }

    @BeforeEach
    void insereDadosParaTeste() {
        BancoDeDados.inserirDados(new Pessoa("João", LocalDate.of(2000, 1, 1)));
    }

    @AfterEach
    void removeDadosParaTeste() {
        BancoDeDados.removerDados(new Pessoa("João", LocalDate.of(2000, 1, 1)));
    }

    @Test
    void validarDadosDeRetorno() {
        Assertions.assertTrue(true);
    }

    @Test
    void validarDadosDeRetorno2() {
        Assertions.assertNull(null);
    }

    @AfterAll
    static void finalizaConexao() {
        BancoDeDados.finalizarConexao();
        //System.out.println("Rodou finalizarConexao()");
    }

}
