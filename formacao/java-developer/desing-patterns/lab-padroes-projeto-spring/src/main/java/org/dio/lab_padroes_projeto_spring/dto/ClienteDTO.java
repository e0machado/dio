package org.dio.lab_padroes_projeto_spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.dio.lab_padroes_projeto_spring.model.Endereco;

public class ClienteDTO {

    @Data
    public static class EnderecoRef {

        @NotBlank
        private String cep;
    }

    @Data
    public static class Request {

        @NotBlank
        private String nome;

        @NotNull
        private ClienteDTO.EnderecoRef enderecoRef;

    }

    @Data
    public static class Response {

        private Long id;
        private String nome;
        private Endereco endereco;
    }
}
