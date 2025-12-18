package org.dio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class PessoaTest {

    @Test
    void deveCalcularIdadeCorretamente() {
        Pessoa jessica = new Pessoa("Jessica", LocalDate.of(2000, 1, 1));
        Assertions.assertEquals(25, jessica.getIdade());

    }

    @Test
    void deveRetornarSeEMaiorDeIdade() {
        Pessoa jessica = new Pessoa("Jessica", LocalDate.of(2000, 1, 1));
        Assertions.assertTrue(jessica.eMaiorDeIdade());

        Pessoa joao = new Pessoa("Joao", LocalDate.now());
        Assertions.assertFalse(joao.eMaiorDeIdade());

    }

}
