package br.unitins.tp1.faciliJus.resource;
import br.unitins.tp1.faciliJus.model.Advogado;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.time.LocalDate;

@Path("/advogados/JoaoDaSilva")
public class AdvogadoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Advogado getAdvogado() {

        Advogado advogado = new Advogado();
        advogado.setId(90123912);
        advogado.setNome("João da Silva");
        advogado.setCpf("123.456.789-00");
        advogado.setDataNascimento(LocalDate.of(1990, 01, 01));
        advogado.setOab(1234567890);

        return advogado;
    }


}