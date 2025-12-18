package org.dio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class CadastrarPessoaTest {
    /*
    Outra maneira de utilizar o Mockito, mais trabalhosa, nao utilizamos o @ExtendWith e nem o @Mock
    @BeforeAll
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    */

    @Mock
    private ApiDosCorreios apiDosCorreios;
    /*
    Outra maneira de utilizar o Mockito, mais trabalhosa, nao utilizamos o @ExtendWith e nem o @Mock
    private ApiDosCorreios apiDosCorreios = Mockito.mock(ApiDosCorreios.class);
    */

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro() {
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("SP", "Ourinhos", "Rua Duque de Caxias", "Apto", "Centro");
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("555555555")).thenReturn(dadosLocalizacao);
        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Evandro", "123456789", LocalDate.now(), "555555555");

        assertEquals("Evandro", pessoa.getNome());
        assertEquals("123456789", pessoa.getDocumento());
        assertEquals("SP", pessoa.getEndereco().getUf());
        assertEquals("Apto", pessoa.getEndereco().getComplemento());
    }

    @Test
    void lancarExceptionQuandoChamarApiDosCorreios() {
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("SP", "Ourinhos", "Rua Duque de Caxias", "Apto", "Centro");

        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenThrow(IllegalArgumentException.class);

        /*
        //Outra maneira de lançar a Exception:

        Mockito.doThrow(IllegalArgumentException.class)
                .when(apiDosCorreios)
                .buscaDadosComBaseNoCep(anyString());
        */

        assertThrows(IllegalArgumentException.class, () -> cadastrarPessoa.cadastrarPessoa("Evandro", "123456789", LocalDate.now(), "555555555"));

    }

}
