package br.com.codenation.dao;
/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 22/04/20
 Time: 16:06
 To change this template use File | Settings | File Templates.
*/

import br.com.codenation.model.Time;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TimeDAO {

  List<Time> times = new ArrayList<>();

  public Optional<Time> findById(Long id) {
    return times.stream().filter(t -> t.getId().equals(id)).findFirst();
  }

  public void save(Time time) {
    times.add(time);
  }

  public Stream<Time> findAll() {
    return times.stream();
  }



}
