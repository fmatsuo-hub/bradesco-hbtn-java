import java.util.function.Supplier;
import java.util.function.Consumer;

public class Produto {
    private String nome;
    private Double preco;
    private Double percentualMarkup = 10d;

    public Produto(Double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    // Supplier (retorna o preço com markup)
    public Supplier<Double> precoComMarkup = () -> preco + preco * percentualMarkup / 100;

    // Consumer (atauliza o percentual de markup)
    public Consumer<Double> atualizarMarkup = (novoMarkup) -> this.percentualMarkup = novoMarkup;
}
