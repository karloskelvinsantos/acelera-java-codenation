package br.com.codenation.util;
/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 23/04/20
 Time: 10:52
 To change this template use File | Settings | File Templates.
*/

import br.com.codenation.model.Jogador;

import java.util.Comparator;

public class ComparatorSalarioJogador implements Comparator<Jogador> {
  @Override
  public int compare(Jogador o1, Jogador o2) {
    return o1.getSalario().compareTo(o2.getSalario());
  }
}
