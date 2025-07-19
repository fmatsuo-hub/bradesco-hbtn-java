public class Dvd extends Produto {

    public Dvd(String titulo, double preco) {
        super(titulo, preco);
    }

    @Override
    public String getTipo() {
        return "Dvd";
    }
}
