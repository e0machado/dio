package org.dio.lab_padroes_projeto_spring.service.impl;

import org.dio.lab_padroes_projeto_spring.dto.ClienteDTO;
import org.dio.lab_padroes_projeto_spring.model.Cliente;
import org.dio.lab_padroes_projeto_spring.model.Endereco;
import org.dio.lab_padroes_projeto_spring.model.mapper.ClienteMapper;
import org.dio.lab_padroes_projeto_spring.repository.ClienteRepository;
import org.dio.lab_padroes_projeto_spring.repository.EnderecoRepository;
import org.dio.lab_padroes_projeto_spring.service.ClienteService;
import org.dio.lab_padroes_projeto_spring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 *
 * @author falvojr
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Autowired
    private ClienteMapper clienteMapper;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public List<ClienteDTO.Response> buscarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toResponse)
                .toList();
    }

    @Override
    public ClienteDTO.Response buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado. ID = " + id));
        return clienteMapper.toResponse(cliente);
    }

    @Override
    public ClienteDTO.Response inserir(ClienteDTO.Request dto) {
        Endereco endereco = salvarEnderecoViaCep(dto);
        Cliente cliente = clienteMapper.toEntity(dto);
        cliente.setEndereco(endereco);

        return clienteMapper.toResponse(clienteRepository.save(cliente));
    }

    @Override
    public ClienteDTO.Response atualizar(Long id, ClienteDTO.Request dto) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado. ID = " + id));
        Endereco endereco = salvarEnderecoViaCep(dto);
        clienteMapper.updateEntity(clienteExistente, dto, endereco);

        return clienteMapper.toResponse(clienteRepository.save(clienteExistente));
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private Endereco salvarEnderecoViaCep(ClienteDTO.Request dto) {
        String cep = dto.getEnderecoRef().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        return endereco;
    }

}
