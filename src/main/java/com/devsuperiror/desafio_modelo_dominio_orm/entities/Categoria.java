package com.devsuperiror.desafio_modelo_dominio_orm.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(columnDefinition = "TEXT")
  private String descricao;

  @OneToMany(mappedBy = "categoria")
  private Set<Atividade> atividades = new HashSet<>();

  public Categoria() {
  }

  public Categoria(Integer id, String descricao, Set<Atividade> atividade) {
    this.id = id;
    this.descricao = descricao;
    this.atividades = atividade;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Set<Atividade> getAtividades() {
    return atividades;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Categoria categoria = (Categoria) o;
    return Objects.equals(id, categoria.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}