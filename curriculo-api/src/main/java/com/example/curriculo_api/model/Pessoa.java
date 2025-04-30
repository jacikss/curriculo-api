package com.example.curriculo_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(name = "cargo_pretendido", nullable = false, length = 100)
    private String cargoPretendido;

    @Column(name = "resumo_profissional", length = 500)
    private String resumoProfissional;

    public Pessoa() {
    }

    public Pessoa(String nome, String email, String telefone, String cargoPretendido, String resumoProfissional) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cargoPretendido = cargoPretendido;
        this.resumoProfissional = resumoProfissional;
    }

    // Getters e Setters
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

    public String getCargoPretendido() {

        return cargoPretendido;
    }

    public void setCargoPretendido(String cargoPretendido) {

        this.cargoPretendido = cargoPretendido;
    }

    public String getResumoProfissional() {

        return resumoProfissional;
    }

    public void setResumoProfissional(String resumoProfissional) {

        this.resumoProfissional = resumoProfissional;
    }
}