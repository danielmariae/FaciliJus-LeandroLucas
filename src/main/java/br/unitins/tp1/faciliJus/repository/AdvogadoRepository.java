package br.unitins.tp1.faciliJus.repository;

import java.util.List;

import br.unitins.tp1.faciliJus.model.Advogado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AdvogadoRepository implements PanacheRepository<Advogado>{
    public List<Advogado> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1)", "%"+nome+"%").list();
    }
    
}
