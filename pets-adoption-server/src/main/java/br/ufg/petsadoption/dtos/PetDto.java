package br.ufg.petsadoption.dtos;

import br.ufg.petsadoption.entities.Pet;
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

    private String nome;
    private String raca;
    private String tipoAnimal;
    private String descricao;
    private String historia;
    private String coloracaoPelo;
    private Integer altura;
    private LocalDate dataNascimento;
    private Boolean vacinado;
    private Boolean castrado;

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

    public void setVacinado(Boolean vacinado) {
        this.vacinado = vacinado;
    }

    public Boolean getCastrado() {
        return castrado;
    }

    public void setCastrado(Boolean castrado) {
        this.castrado = castrado;
    }

    public static PetDto fromEntity(Pet entity) {
        var dto = new PetDto();
        mapper.map(entity, dto);
        return dto;
    }

    public Pet toEntity() {
        return mergeEntity(new Pet());
    }

    public Pet mergeEntity(Pet entity) {
        mapper.map(this, entity);
        return entity;
    }

}
