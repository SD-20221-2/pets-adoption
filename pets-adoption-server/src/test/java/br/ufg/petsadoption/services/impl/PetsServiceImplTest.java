package br.ufg.petsadoption.services.impl;

import br.ufg.petsadoption.models.PetDto;
import br.ufg.petsadoption.repositories.PetsRepository;
import br.ufg.petsadoption.repositories.entities.Pet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Optional;

class PetsServiceImplTest {

    private final PetsRepository repositoryMock = Mockito.mock(PetsRepository.class);
    private PetsServiceImpl sut;

    @BeforeEach
    void setUp() {
        sut = new PetsServiceImpl(repositoryMock);
    }

    @Test
    void shouldMergeEntityProperties() {
        Mockito.when(
                repositoryMock.findById(Mockito.anyLong())
        ).thenReturn(
                Optional.of(new Pet(1L, "Beto", "lhasa apso", "pelo branco, pequeno porte", LocalDate.of(2017, 7, 1)))
        );

        var dto = new PetDto();
        dto.setCharacteristics("pelo branco, pequeno porte, vacinado");
        sut.update(1L, dto);

        ArgumentCaptor<Pet> petArgumentCaptor = ArgumentCaptor.forClass(Pet.class);
        Mockito.verify(repositoryMock).save(petArgumentCaptor.capture());

        var got = petArgumentCaptor.getValue();
        var want = new Pet(1L, "Beto", "lhasa apso", "pelo branco, pequeno porte, vacinado", LocalDate.of(2017, 7, 1));

        Assertions.assertThat(got).usingRecursiveComparison().isEqualTo(want);

    }
}