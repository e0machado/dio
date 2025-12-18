package org.dio;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // --> Executa na ordem estabelecida no @Order()
// @TestMethodOrder(MethodOrderer.MethodName.class) --> Executa em ordem alfabética
// @TestMethodOrder(MethodOrderer.Random.class) --> Executa em ordem aleatória
// @TestMethodOrder(MethodOrderer.DisplayName.class) --> Executa na ordem estabelecida no @DisplayName() respeitando ordem alfabética
public class EscolhendoAOrdemTest {

    @Order(4)
    @Test
    void validaFluxoA() {
        Assertions.assertTrue(true);
    }

    @Order(3)
    @Test
    void validaFluxoB() {
        Assertions.assertTrue(true);
    }

    @Order(2)
    @Test
    void validaFluxoC() {
        Assertions.assertTrue(true);
    }

    @Order(1)
    @Test
    void validaFluxoD() {
        Assertions.assertTrue(true);
    }

}
