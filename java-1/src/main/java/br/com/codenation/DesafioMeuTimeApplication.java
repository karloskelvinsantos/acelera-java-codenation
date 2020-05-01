package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

import br.com.codenation.dao.JogadorDAO;
import br.com.codenation.dao.TimeDAO;
import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.model.Jogador;
import br.com.codenation.model.Time;
import br.com.codenation.util.ComparatorIdadeJogador;
import br.com.codenation.util.ComparatorNivelHabilidadeJogador;
import br.com.codenation.util.ComparatorSalarioJogador;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	TimeDAO timeDAO = new TimeDAO();
	JogadorDAO jogadorDAO = new JogadorDAO();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if (timeDAO.findById(id).isPresent()) {
			throw new IdentificadorUtilizadoException();
		}
		Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		timeDAO.save(time);
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		timeDAO.findById(idTime).orElseThrow(TimeNaoEncontradoException::new);
		if (jogadorDAO.findById(id).isPresent()) {
			throw new IdentificadorUtilizadoException();
		}
		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		jogadorDAO.save(jogador);
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		Jogador novoCapitao = jogadorDAO.findById(idJogador)
						.orElseThrow(JogadorNaoEncontradoException::new);

		Optional<Jogador> capitaoAnterior = jogadorDAO
						.findAllByTime(novoCapitao.getIdTime())
						.filter(jogador -> jogador.getCapitao().equals(Boolean.TRUE))
						.findFirst();

		if (capitaoAnterior.isPresent()) {
			capitaoAnterior.get().setCapitao(Boolean.FALSE);
			jogadorDAO.update(capitaoAnterior.get());
		}

		novoCapitao.setCapitao(Boolean.TRUE);
		jogadorDAO.update(novoCapitao);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		timeDAO.findById(idTime).orElseThrow(TimeNaoEncontradoException::new);

		return jogadorDAO
						.findAllByTime(idTime)
						.filter(jogador -> jogador.getCapitao().equals(Boolean.TRUE))
						.findFirst()
						.orElseThrow(CapitaoNaoInformadoException::new)
						.getId();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		return jogadorDAO.
						findById(idJogador)
						.orElseThrow(JogadorNaoEncontradoException::new)
						.getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		return timeDAO.findById(idTime)
						.orElseThrow(TimeNaoEncontradoException::new)
						.getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		timeDAO.findById(idTime).orElseThrow(TimeNaoEncontradoException::new);

		return jogadorDAO
						.findAllByTime(idTime)
						.map(Jogador::getId)
						.sorted()
						.collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		timeDAO.findById(idTime).orElseThrow(TimeNaoEncontradoException::new);

		return jogadorDAO
						.findAllByTime(idTime)
						.max(new ComparatorNivelHabilidadeJogador())
						.orElseThrow(JogadorNaoEncontradoException::new)
						.getId();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		timeDAO.findById(idTime).orElseThrow(TimeNaoEncontradoException::new);

		return jogadorDAO
						.findAllByTime(idTime)
						.min(new ComparatorIdadeJogador()
										.thenComparing(Jogador::getId))
						.orElseThrow(JogadorNaoEncontradoException::new)
						.getId();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return timeDAO
						.findAll()
						.map(Time::getId)
						.sorted()
						.collect(Collectors.toList());
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		timeDAO.findById(idTime).orElseThrow(TimeNaoEncontradoException::new);
		return jogadorDAO
						.findAllByTime(idTime)
						.min(new ComparatorSalarioJogador()
										.reversed()
										.thenComparing(Jogador::getId))
						.orElseThrow(JogadorNaoEncontradoException::new)
						.getId();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		return jogadorDAO
						.findById(idJogador)
						.orElseThrow(JogadorNaoEncontradoException::new)
						.getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		return jogadorDAO.findAll()
						.sorted(Comparator
										.comparingLong(Jogador::getNivelHabilidade)
										.reversed()
										.thenComparing(Jogador::getId))
						.map(Jogador::getId)
						.limit(top)
						.collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		Time timeMandante = timeDAO.findById(timeDaCasa).orElseThrow(TimeNaoEncontradoException::new);
		Time timeVisitante = timeDAO.findById(timeDeFora).orElseThrow(TimeNaoEncontradoException::new);

		if (timeMandante.getCorUniformePrincipal().equalsIgnoreCase(timeVisitante.getCorUniformePrincipal())) {
			return timeVisitante.getCorUniformeSecundario();
		} else {
			return timeVisitante.getCorUniformePrincipal();
		}
	}
}
