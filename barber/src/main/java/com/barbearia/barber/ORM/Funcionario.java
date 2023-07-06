package com.barbearia.barber.ORM;

import jakarta.persistence.*;


@Entity
@Table(name ="Funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private Double salario;

    public Funcionario() {

    }

    public Funcionario(String nome, String sobrenome,Double salario,Long id) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.salario = salario;
        this.id = id;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        salario = salario;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
