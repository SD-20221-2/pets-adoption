package br.ufg.petsadoption.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "pets")
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

    @Column(name = "nome")
    private String nome;

    @Column(name = "raca")
    private String raca;

    @Column(name = "tipo_animal")
    private String tipoAnimal;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "historia")
    private String historia;

    @Column(name = "coloracao_pelo")
    private String coloracaoPelo;

    @Column(name = "altura")
    private Integer altura;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "vacinado")
    private Boolean vacinado;

    @Column(name = "castrado")
    private Boolean castrado;

    public Pet() {
    }

    public Pet(Long id, String nome, String raca, String descricao, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.descricao = descricao;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getColoracaoPelo() {
        return coloracaoPelo;
    }

    public void setColoracaoPelo(String coloracaoPelo) {
        this.coloracaoPelo = coloracaoPelo;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getVacinado() {
        return vacinado;
    }

    public void setVacinado(Boolean vaciado) {
        this.vacinado = vaciado;
    }

    public Boolean getCastrado() {
        return castrado;
    }

    public void setCastrado(Boolean castrado) {
        this.castrado = castrado;
    }
}
