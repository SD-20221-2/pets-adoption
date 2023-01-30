package br.ufg.petsadoption.services;

import br.ufg.petsadoption.models.PetDto;

import java.util.List;

public interface PetsService {

    void create(PetDto pet);

    void update(Long id, PetDto pet);

    PetDto find(Long id);

    List<PetDto> findAll();

    void delete(Long id);
}
