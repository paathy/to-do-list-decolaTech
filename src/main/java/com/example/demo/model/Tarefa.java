package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="tarefas")
public class Tarefa {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;
    private String descricao;
    private Boolean status;

    public Tarefa(){}

    public Tarefa(String nome, String descricao){
      this.nome = nome;
      this.descricao = descricao;
      this.status = false;
    }

    public Long getId(){
      return id;
    }

    public String  getNome(){
      return nome;
    }

    public void setNome(String nome){
      this.nome = nome;
    }

    public String getDescricao(){
      return descricao;
    }

    public void setDescricao(String descricao){
      this.descricao = descricao;
    }

    public Boolean getStatus(){
      return status;
    }

    public void setStatus(Boolean status){
      this.status = status;
    }


}
