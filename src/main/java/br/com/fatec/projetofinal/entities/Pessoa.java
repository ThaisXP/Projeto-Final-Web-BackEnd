package br.com.fatec.projetofinal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TBL_PESSOA")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    @NotBlank(message = "O nome da pessoa não pode ser branco")
    private String nome;

    @Column(nullable = false)
    @NotBlank(message = "O e-mail da pessoa não pode ser branco")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "O telefone da pessoa não pode ser branco")
    private String telefone;

    @Column(nullable = false)
    @NotBlank(message = "O endereço da pessoa não pode ser branco")
    private String endereco;

    @Column(nullable = false)
    @NotBlank(message = "A cidade da pessoa não pode ser branco")
    private String cidade;

    @Column(nullable = false)
    @NotBlank(message = "O CEP da pessoa não pode ser branco")
    private String cep;

    @Column(nullable = false)
    @NotBlank(message = "O estado da pessoa não pode ser branco")
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}