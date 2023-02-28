package br.ufg.petsadoption.repositories;

import br.ufg.petsadoption.entities.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetsRepository extends CrudRepository<Pet, Long> {
}
