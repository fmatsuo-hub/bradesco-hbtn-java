import java.util.Random;

public class Produtor extends Thread {
    private Fila fila;
    private Random random = new Random();

    public Produtor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int numero = random.nextInt(100) + 1; // 1 a 100
                fila.adicionar(numero);
                Thread.sleep(1000); // produz a cada 1 segundo
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
