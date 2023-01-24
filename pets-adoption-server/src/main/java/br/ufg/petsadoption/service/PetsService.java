package br.ufg.petsadoption.service;

import br.ufg.petsadoption.repository.PetsRepository;
import org.springframework.stereotype.Service;

@Service
public class PetsService {

    private final PetsRepository petsRepository;

    public PetsService(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }
}
