package br.ufg.petsadoption.services.impl;

import br.ufg.petsadoption.exceptions.NotFoundException;
import br.ufg.petsadoption.dtos.PetDto;
import br.ufg.petsadoption.repositories.PetsRepository;
import br.ufg.petsadoption.services.PetsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
        pet.mergeEntity(entity);
        petsRepository.save(entity);
    }

    @Override
    public PetDto find(Long id) {
        var entity = petsRepository.findById(id).orElseThrow(() -> new NotFoundException("Pet not found"));
        return PetDto.fromEntity(entity);
    }

    @Override
    public List<PetDto> findAll() {
        var all = petsRepository.findAll().spliterator();
        return StreamSupport.stream(all, false).map(PetDto::fromEntity).toList();
    }

    @Override
    public void delete(Long id) {
        petsRepository.deleteById(id);
    }

}
