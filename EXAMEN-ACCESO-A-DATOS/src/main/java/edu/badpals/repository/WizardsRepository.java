package edu.badpals.repository;
import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.Optional;

import edu.badpals.dominio.Person;
import edu.badpals.dominio.Wizards;

public class WizardsRepository implements PanacheRepositoryBase<Wizards, String>{

    public Optional<Wizards> findByIdOptional(Person nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByIdOptional'");
    }
    
}
