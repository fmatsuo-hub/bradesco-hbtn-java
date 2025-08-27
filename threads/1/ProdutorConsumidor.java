public class ProdutorConsumidor {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        // Criar produtor e consumidor
        Produtor produtor = new Produtor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        // Iniciar as threads
        produtor.start();
        consumidor.start();
    }
}
