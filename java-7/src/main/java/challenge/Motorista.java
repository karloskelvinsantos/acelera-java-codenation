package challenge;


import java.util.Objects;

public class Motorista {

    private final String nome;

    private final int idade;

    private final int pontos;

    private final String habilitacao;

    private Motorista(String nome, int idade, int pontos, String habilitacao) {
        this.nome = nome;
        this.idade = idade;
        this.pontos = pontos;
        this.habilitacao = habilitacao;

        this.validate();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    private void validate() {
        if (nome.isEmpty()) {
            throw new NullPointerException();
        }
        if (this.habilitacao.isEmpty()) {
            throw new NullPointerException();
        }
        if (this.pontos > 21) {
            throw new EstacionamentoException("Motorista com pontuação extrapolada ou invalida.");
        }
        if (this.idade < 18) {
            throw new EstacionamentoException("Motorista menor de idade não é aceito.");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return Objects.equals(habilitacao, motorista.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(habilitacao);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontos=" + pontos +
                ", habilitacao='" + habilitacao + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }


    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;

        private MotoristaBuilder() {
        }

        public MotoristaBuilder withNome(String nome) {

            this.nome = nome;
            return this;
        }

        public MotoristaBuilder withIdade(int idade) {
            if (idade < 0) throw new IllegalArgumentException();

            this.idade = idade;
            return this;
        }

        public MotoristaBuilder withPontos(int pontos) {
            if (pontos < 0) throw new IllegalArgumentException();

            this.pontos = pontos;
            return this;
        }

        public MotoristaBuilder withHabilitacao(String habilitacao) {

            this.habilitacao = habilitacao;
            return this;
        }

        public Motorista build() {
           return new Motorista(nome, idade, pontos, habilitacao);
        }
    }
}
