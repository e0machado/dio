package org.dio.lab_padroes_projeto_spring.model.mapper;

import org.dio.lab_padroes_projeto_spring.dto.ClienteDTO;
import org.dio.lab_padroes_projeto_spring.model.Cliente;
import org.dio.lab_padroes_projeto_spring.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteDTO.Request dto) {
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();

        cliente.setNome(dto.getNome());
        endereco.setCep(dto.getEnderecoRef().getCep());
        cliente.setEndereco(endereco);

        return cliente;
    }

    public ClienteDTO.Response toResponse(Cliente cliente) {
        ClienteDTO.Response response = new ClienteDTO.Response();

        response.setId(cliente.getId());
        response.setNome(cliente.getNome());
        response.setEndereco(cliente.getEndereco());

        return response;
    }

    public void updateEntity(Cliente clienteExistente, ClienteDTO.Request dto, Endereco endereco) {
        clienteExistente.setNome(dto.getNome());
        if (endereco != null) {
            clienteExistente.setEndereco(endereco);
        }
    }

}
