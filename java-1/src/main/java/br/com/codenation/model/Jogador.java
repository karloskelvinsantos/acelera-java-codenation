package br.com.codenation.model;
/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 21/04/20
 Time: 16:11
 To change this template use File | Settings | File Templates.
*/

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {

  private Long id;
  private Long idTime;
  private String nome;
  private LocalDate dataNascimento;
  private Integer nivelHabilidade;
  private BigDecimal salario;
  private Boolean capitao;

  public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
    this.id = id;
    this.idTime = idTime;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.nivelHabilidade = nivelHabilidade;
    this.salario = salario;
    this.capitao = Boolean.FALSE;

    validate();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getIdTime() {
    return idTime;
  }

  public void setIdTime(Long idTime) {
    this.idTime = idTime;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public Integer getNivelHabilidade() {
    return nivelHabilidade;
  }

  public void setNivelHabilidade(Integer nivelHabilidade) {
   this.nivelHabilidade = nivelHabilidade;
  }

  public BigDecimal getSalario() {
    return salario;
  }

  public void setSalario(BigDecimal salario) {
    this.salario = salario;
  }

  public void setCapitao(Boolean capitao) {
    this.capitao = capitao;
  }

  public Boolean getCapitao() {
    return capitao;
  }

  public void validate() {
    if (this.id == null || this.id <= 0) {
      throw new IllegalArgumentException();
    }
    if (this.nome == null || this.nome.isEmpty()) {
      throw new IllegalArgumentException();
    }
    if (this.idTime == null || this.idTime <= 0 ) {
      throw new IllegalArgumentException();
    }
    if (this.dataNascimento == null) {
      throw new IllegalArgumentException();
    }
    if (this.nivelHabilidade == null || this.nivelHabilidade < 0 || this.nivelHabilidade > 100) {
      throw new IllegalArgumentException();
    }
    if (this.salario == null || this.salario.doubleValue() <= 0.0) {
      throw new IllegalArgumentException();
    }
  }
}
