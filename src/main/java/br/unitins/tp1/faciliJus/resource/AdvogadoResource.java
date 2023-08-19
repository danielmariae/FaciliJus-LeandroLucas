package br.unitins.tp1.faciliJus.resource;
import br.unitins.tp1.faciliJus.model.Advogado;
import br.unitins.tp1.faciliJus.repository.AdvogadoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;



@Path("/advogados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdvogadoResource {

    @Inject
    AdvogadoRepository repository;

    @POST
    @Transactional
    public Advogado insert(Advogado advogado) {
        Advogado novoAdvogado = new Advogado();
        novoAdvogado.setNome(advogado.getNome());
        novoAdvogado.setCpf(advogado.getCpf());
        novoAdvogado.setDataNascimento(advogado.getDataNascimento());
        novoAdvogado.setOab(advogado.getOab());

        repository.persist(novoAdvogado);

        return novoAdvogado;
    }

    @GET
    public List<Advogado> findAll() {
        return repository.listAll();
    }

    @GET
    @Path("/{id}")
    public Advogado findById(@PathParam("id") Long id) {
        return repository.findById(id);
    }

    @GET
    @Path("/search/nome/{nome}")
    public List<Advogado> findByNome(@PathParam("nome") String nome) {
        return repository.findByNome(nome);
    }

}