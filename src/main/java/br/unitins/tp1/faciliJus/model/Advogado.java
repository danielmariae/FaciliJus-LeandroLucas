package br.unitins.tp1.faciliJus.model;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.time.LocalDate;

public class Advogado extends PanacheEntity {
    private Integer id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Integer oab;

    public Advogado() {

    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public Integer getOab() {
        return oab;
    }
    public void setOab(Integer oab) {
        this.oab = oab;
    }
}
