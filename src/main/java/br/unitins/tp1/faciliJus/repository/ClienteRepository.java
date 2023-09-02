package br.unitins.tp1.facilijus.repository;

import java.util.List;

import br.unitins.tp1.facilijus.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente>{
    public List<Cliente> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1)", "%"+nome+"%").list();
    }

    @Override
    public Cliente findById(Long id){
        return find("UPPER(id) LIKE UPPER(?1)", "%"+id+"%").singleResult();
    }    
}
