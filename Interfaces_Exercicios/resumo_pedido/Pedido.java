public class Pedido {
    private int codigo;
    private double peso;
    private double total;
    private provedores.Frete frete;

    public Pedido(int codigo, double peso, double total) {
        this.codigo = codigo;
        this.peso = peso;
        this.total = total;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPeso() {
        return peso;
    }

    public double getTotal() {
        return total;
    }

    public provedores.Frete getFrete() {
        return frete;
    }

    public void setFrete(provedores.Frete frete) {
        this.frete = frete;
    }
}
