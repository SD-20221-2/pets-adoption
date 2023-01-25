package br.ufg.petsadoption.services.impl;

import br.ufg.petsadoption.exceptions.NotFoundException;
import br.ufg.petsadoption.models.PetDto;
import br.ufg.petsadoption.repositories.PetsRepository;
import br.ufg.petsadoption.services.PetsService;
import org.springframework.stereotype.Service;

@Service
public class PetsServiceImpl implements PetsService {

    private final PetsRepository petsRepository;

    public PetsServiceImpl(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    @Override
    public void create(PetDto pet) {
        petsRepository.save(pet.toEntity());
    }

    @Override
    public void update(Long id, PetDto pet) {
        var entity = petsRepository.findById(id).orElseThrow(() -> new NotFoundException("Pet not found"));
        pet.toEntity(entity);
        petsRepository.save(entity);
    }

    @Override
    public PetDto find(Long id) {
        var entity = petsRepository.findById(id).orElseThrow(() -> new NotFoundException("Pet not found"));
        return PetDto.fromEntity(entity);
    }

}
