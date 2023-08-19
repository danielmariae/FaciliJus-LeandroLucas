package br.unitins.tp1.faciliJus.resource;
import br.unitins.tp1.faciliJus.model.Advogado;
import br.unitins.tp1.faciliJus.repository.AdvogadoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;



@Path("/advogados/JoaoDaSilva")
public class AdvogadoResource {

    @Inject
    AdvogadoRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Advogado> findAll() {
        return repository.listAll();
    }


}