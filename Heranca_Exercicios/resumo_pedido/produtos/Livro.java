public class Livro extends Produto {

    public Livro(String titulo, double preco) {
        super(titulo, preco);
    }

    @Override
    public String getTipo() {
        return "Livro";
    }
}
