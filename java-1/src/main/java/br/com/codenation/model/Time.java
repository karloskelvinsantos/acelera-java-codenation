package br.com.codenation.model;
/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 21/04/20
 Time: 16:07
 To change this template use File | Settings | File Templates.
*/

import java.time.LocalDate;

public class Time {

  private Long id;
  private String nome;
  private LocalDate dataCriacao;
  private String corUniformePrincipal;
  private String corUniformeSecundario;

  public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
    this.id = id;
    this.nome = nome;
    this.dataCriacao = dataCriacao;
    this.corUniformePrincipal = corUniformePrincipal;
    this.corUniformeSecundario = corUniformeSecundario;

    validate();
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

  public LocalDate getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(LocalDate dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public String getCorUniformePrincipal() {
    return corUniformePrincipal;
  }

  public void setCorUniformePrincipal(String corUniformePrincipal) {
    this.corUniformePrincipal = corUniformePrincipal;
  }

  public String getCorUniformeSecundario() {
    return corUniformeSecundario;
  }

  public void setCorUniformeSecundario(String corUniformeSecundario) {
    this.corUniformeSecundario = corUniformeSecundario;
  }

  public void validate() {
    if (this.id == null || this.id <= 0) {
      throw new IllegalArgumentException();
    }
    if (this.nome == null || this.nome.isEmpty()) {
      throw new IllegalArgumentException();
    }
    if (this.dataCriacao == null) {
      throw new IllegalArgumentException();
    }
    if (this.corUniformePrincipal == null || this.corUniformePrincipal.isEmpty()) {
      throw new IllegalArgumentException();
    }
    if (this.corUniformeSecundario == null || this.corUniformeSecundario.isEmpty()) {
      throw new IllegalArgumentException();
    }
  }

}
