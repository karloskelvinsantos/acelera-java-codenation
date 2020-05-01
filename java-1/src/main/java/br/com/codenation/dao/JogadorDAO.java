package br.com.codenation.dao;
/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 22/04/20
 Time: 16:06
 To change this template use File | Settings | File Templates.
*/

import br.com.codenation.model.Jogador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class JogadorDAO {

  List<Jogador> jogadores = new ArrayList<>();

  public Optional<Jogador> findById(Long id) {
    return jogadores.stream().filter(jogador -> jogador.getId().equals(id)).findFirst();
  }

  public void save(Jogador jogador) {
    jogadores.add(jogador);
  }

  public Stream<Jogador> findAll() {
    return jogadores.stream();
  }

  public Stream<Jogador> findAllByTime(Long idTime) {
    return jogadores.stream().filter(jogador -> jogador.getIdTime().equals(idTime));
  }

  public void update(Jogador jogador) {
    int indexJogador = jogadores.indexOf(jogador);
    jogadores.remove(jogador);
    jogadores.add(indexJogador, jogador);
  }




}
