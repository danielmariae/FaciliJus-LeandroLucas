package br.unitins.tp1.facilijus.service;

import java.util.List;
import br.unitins.tp1.facilijus.dto.ClienteDTO;
import br.unitins.tp1.facilijus.dto.ClienteResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ClienteService {
    public ClienteResponseDTO insert(ClienteDTO dto);
    public ClienteResponseDTO update(ClienteDTO dto, Long id);
    public void delete(Long id);
    public ClienteResponseDTO findById(Long id);
    public List<ClienteResponseDTO> findByNome(String nome);
    public List<ClienteResponseDTO> findAll();
}
