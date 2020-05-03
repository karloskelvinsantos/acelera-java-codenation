package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

  private final List<Carro> carros = new ArrayList<>(10);

  public void estacionar(Carro carro) {
    if (carros.size() >= 10) {
      if (verificaSeTodosMotoristasMaior55()) throw new EstacionamentoException("Estacionamento Lotado!");

      if (carros.get(0).getMotorista().getIdade() > 55) {
        if (carros.stream().anyMatch(c -> c.getMotorista().getIdade() < 55)) {
          carros.remove(
                  carros
                          .stream().filter(c -> c.getMotorista().getIdade() < 55)
                          .findFirst()
                          .get()
          );
        }
      } else {
        carros.remove(0);
      }
    }

    carros.add(carro);

  }

  public int carrosEstacionados() {
    return carros.size();
  }

  public boolean carroEstacionado(Carro carro) {
    return carros.contains(carro);
  }

  public boolean verificaSeTodosMotoristasMaior55() {
    return carros.stream().allMatch(c -> c.getMotorista().getIdade() > 55);
  }
}
