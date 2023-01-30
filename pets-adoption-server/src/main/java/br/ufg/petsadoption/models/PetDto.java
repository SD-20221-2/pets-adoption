package br.ufg.petsadoption.models;

import br.ufg.petsadoption.repositories.entities.Pet;
import org.modelmapper.ModelMapper;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class PetDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -3628283567854362449L;

    private static final ModelMapper mapper = new ModelMapper();

    static {
        mapper.getConfiguration().setPropertyCondition(context -> context.getSource() != null);
    }

    private String name;
    private String breed;
    private String characteristics;
    private LocalDate ageMonthYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public LocalDate getAgeMonthYear() {
        return ageMonthYear;
    }

    public void setAgeMonthYear(LocalDate ageMonthYear) {
        this.ageMonthYear = ageMonthYear;
    }

    public static PetDto fromEntity(Pet entity) {
        var dto = new PetDto();
        mapper.map(entity, dto);
        return dto;
    }

    public Pet toEntity() {
        return toEntity(new Pet());
    }

    public Pet toEntity(Pet entity) {
        mapper.map(this, entity);
        return entity;
    }

}
