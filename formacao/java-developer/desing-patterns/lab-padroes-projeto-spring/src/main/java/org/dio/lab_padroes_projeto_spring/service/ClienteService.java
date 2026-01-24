package org.dio.lab_padroes_projeto_spring.service;

import org.dio.lab_padroes_projeto_spring.dto.ClienteDTO;

import java.util.List;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 *
 * @author falvojr
 */
public interface ClienteService {

    List<ClienteDTO.Response> buscarTodos();

    ClienteDTO.Response buscarPorId(Long id);

    ClienteDTO.Response inserir(ClienteDTO.Request dto);

    ClienteDTO.Response atualizar(Long id, ClienteDTO.Request dto);

    void deletar(Long id);

}
