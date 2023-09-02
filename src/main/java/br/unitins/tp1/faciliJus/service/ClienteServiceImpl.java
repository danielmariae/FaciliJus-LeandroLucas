package br.unitins.tp1.facilijus.service;

import java.util.List;

import br.unitins.tp1.facilijus.dto.ClienteDTO;
import br.unitins.tp1.facilijus.dto.ClienteResponseDTO;
import br.unitins.tp1.facilijus.model.Cliente;
import br.unitins.tp1.facilijus.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

    @Inject 
    ClienteRepository repository;
    
    @Override
    @Transactional
    public ClienteResponseDTO insert(ClienteDTO dto) {
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(dto.getNome());
        novoCliente.setCpf(dto.getCpf());

        repository.persist(novoCliente);

        return ClienteResponseDTO.valueOf(novoCliente);
    }

    @Override
    @Transactional
    public ClienteResponseDTO update(ClienteDTO dto, Long id) {
        Cliente cliente = repository.findById(id);
        if(cliente != null){
            cliente.setNome(dto.getNome());
            cliente.setCpf(dto.getCpf());
        }else{
            throw new NotFoundException();
        }

        return ClienteResponseDTO.valueOf(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if(!repository.deleteById(id)){
            throw new NotFoundException();
        }
    }

    @Override
    public List<ClienteResponseDTO> findAll() {
        return repository.listAll().stream().map(c -> ClienteResponseDTO.valueOf(c)).toList();
    }

    @Override
    public ClienteResponseDTO findById(Long id) {
        return ClienteResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<ClienteResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome);
    }    
}
