package br.unitins.tp1.faciliJus.resource;

import java.util.List;

import br.unitins.tp1.faciliJus.model.Advogado;
import br.unitins.tp1.faciliJus.repository.AdvogadoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/advogados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdvogadoResource {

    @Inject
    AdvogadoRepository repository;

    @GET
    public List<Advogado> findAllAdvogados() {
        return repository.listAll();
    }

    @GET
    @Path("/search/nome/{nome}")
    public List<Advogado> findByNome(@PathParam("nome") String nome){
        return repository.findByNome(nome);
    }

    @GET
    @Path("/{id}")
    public Advogado findById(@PathParam("id") Long id){
        return repository.findById(id);
    }
}