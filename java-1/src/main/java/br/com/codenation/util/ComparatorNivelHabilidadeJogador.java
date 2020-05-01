package br.com.codenation.util;
/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 22/04/20
 Time: 18:27
 To change this template use File | Settings | File Templates.
*/

import br.com.codenation.model.Jogador;

import java.util.Comparator;

public class ComparatorNivelHabilidadeJogador implements Comparator<Jogador> {
  @Override
  public int compare(Jogador o1, Jogador o2) {
    return o1.getNivelHabilidade().compareTo(o2.getNivelHabilidade());
  }

  @Override
  public Comparator<Jogador> reversed() {
    return null;
  }
}
