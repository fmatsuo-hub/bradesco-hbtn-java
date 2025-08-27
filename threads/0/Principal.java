public class Principal {
    public static void main(String[] args) {
        // Instancia o contador
        Contador contador = new Contador();

        // Cria duas threads que vão usar o mesmo contador
        ThreadContador t1 = new ThreadContador(contador);
        ThreadContador t2 = new ThreadContador(contador);

        // Inicia as threads
        t1.start();
        t2.start();

        try {
            // Aguarda as duas terminarem
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprime o valor final esperado: 2000
        System.out.println("Valor final do contador: " + contador.getContagem());
    }
}
