package br.unitins.tp1.facilijus.resource;
import java.util.List;

import br.unitins.tp1.facilijus.dto.ClienteDTO;
import br.unitins.tp1.facilijus.dto.ClienteResponseDTO;
import br.unitins.tp1.facilijus.model.Cliente;
import br.unitins.tp1.facilijus.repository.ClienteRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;



@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    ClienteRepository repository;

    @POST
    @Transactional
    public ClienteResponseDTO insert(ClienteDTO dto) {
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(dto.getNome());
        novoCliente.setCpf(dto.getCpf());

        repository.persist(novoCliente);

        return ClienteResponseDTO.valueOf(novoCliente);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public ClienteResponseDTO update(ClienteDTO dto, @PathParam("id") Long id) { 
        Cliente cliente = repository.findById(id);
        if(cliente != null){
            cliente.setNome(dto.getNome());
            cliente.setCpf(dto.getCpf());
        }else{
            throw new NotFoundException();
        }

        return ClienteResponseDTO.valueOf(cliente);
    }
    
    @DELETE
    @Transactional
    @Path("/id")
    public void delete(ClienteResponseDTO dto, @PathParam("id") Long id){
        if(!repository.deleteById(id)){
            throw new NotFoundException();
        }
    }

    @GET
    @Path("/listarTodos")
    public List<ClienteResponseDTO> findAll() {
        return repository.listAll().stream().map(c -> ClienteResponseDTO.valueOf(c)).toList();
    }

    @GET
    @Path("/{id}")
    public Cliente findById(@PathParam("id") Long id) {
        return repository.findById(id);
    }

    @GET
    @Path("/search/nome/{nome}")
    public List<Cliente> findByNome(@PathParam("nome") String nome) {
        return repository.findByNome(nome);
    }

}