package br.ufg.petsadoption.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pet-sequence-generator"
    )
    @SequenceGenerator(
            name = "pet-sequence-generator",
            sequenceName = "pet_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "breed")
    private String breed;

    @Column(name = "type")
    private String type;

    @Column(name = "characteristics")
    private String characteristics;

    @Column(name = "age_month_year")
    private LocalDate ageMonthYear;

    public Pet() {
    }

    public Pet(Long id, String name, String breed, String characteristics, LocalDate ageMonthYear) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.characteristics = characteristics;
        this.ageMonthYear = ageMonthYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
