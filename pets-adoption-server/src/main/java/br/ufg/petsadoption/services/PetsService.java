package br.ufg.petsadoption.services;

import br.ufg.petsadoption.models.PetDto;

public interface PetsService {

    void create(PetDto pet);

    void update(Long id, PetDto pet);

    PetDto find(Long id);
}
