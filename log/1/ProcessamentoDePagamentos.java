import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class ProcessamentoDePagamentos {

    // Logger SLF4j
    private static final Logger logger = LoggerFactory.getLogger(ProcessamentoDePagamentos.class);

    public static void main(String[] args) {
        logger.info("Iniciando sistema de processamento de pagamentos");
        
        // Processar 5 pagamentos consecutivos
        for (int i = 1; i <= 5; i++) {
            processarPagamento(i);
        }
        
        logger.info("Processamento de pagamentos concluído.");
    }

    public static void processarPagamento(int numeroPagamento) {
        // Log do início do processamento
        logger.info("Iniciando o processamento do pagamento {}", numeroPagamento);
        
        try {
            // Simular tempo de processamento (1 segundo)
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.error("Interrupção durante o processamento do pagamento {}", numeroPagamento, e);
            return;
        }
        
        // Simular resultado aleatório do pagamento
        Random random = new Random();
        int resultado = random.nextInt(3); // 0 = sucesso, 1 = falha, 2 = pendente
        
        switch (resultado) {
            case 0: // Sucesso
                logger.info("Pagamento {} processado com sucesso.", numeroPagamento);
                break;
            case 1: // Falha
                logger.error("Erro ao processar o pagamento {}: Falha na transação.", numeroPagamento);
                break;
            case 2: // Pendente
                logger.warn("Pagamento {} está pendente. Aguardando confirmação.", numeroPagamento);
                break;
        }
    }
}