package br.ufg.petsadoption.repository;

import br.ufg.petsadoption.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetsRepository extends JpaRepository<Pet, Long> {
}
