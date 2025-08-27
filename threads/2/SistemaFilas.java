public class SistemaFilas {
    public static void main(String[] args) {
        Fila fila = new Fila(10); // capacidade 10

        // Criar 2 produtores e 2 consumidores
        Produtor p1 = new Produtor(fila);
        Produtor p2 = new Produtor(fila);
        Consumidor c1 = new Consumidor(fila);
        Consumidor c2 = new Consumidor(fila);

        // Iniciar threads
        p1.start();
        p2.start();
        c1.start();
        c2.start();

        // Executa por 20 segundos e encerra
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Encerrando sistema...");
        System.exit(0);
    }
}
