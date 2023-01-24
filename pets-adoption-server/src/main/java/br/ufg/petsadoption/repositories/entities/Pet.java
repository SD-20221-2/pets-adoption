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

    @Column(name = "age_month_year")
    private LocalDate ageMonthYear;

    @Column(name = "description")
    private String description;

    @Column(name = "characteristics")
    private String characteristics;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getAgeMonthYear() {
        return ageMonthYear;
    }

    public void setAgeMonthYear(LocalDate ageMonthYear) {
        this.ageMonthYear = ageMonthYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }
}
