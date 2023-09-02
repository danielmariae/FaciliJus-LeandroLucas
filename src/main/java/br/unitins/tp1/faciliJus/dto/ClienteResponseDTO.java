package br.unitins.tp1.facilijus.dto;
import java.util.List;

import br.unitins.tp1.facilijus.model.Cliente;

public record ClienteResponseDTO(
    Long id,
    String nome,
    String cpf
){
    public static ClienteResponseDTO valueOf(Cliente cliente){
        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getCpf());       
    }

    public static ClienteResponseDTO valueOf(List<Cliente> clientes){
        return new ClienteResponseDTO(null, null, null).listAll();
    }
}