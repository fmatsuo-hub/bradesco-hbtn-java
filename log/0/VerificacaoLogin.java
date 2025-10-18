import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerificacaoLogin {

    private static final Logger logger = LoggerFactory.getLogger(VerificacaoLogin.class);

    public static void main(String[] args) {
        String usuarioCorreto = "admin";
        String senhaCorreta = "12345";

        realizarLogin("admin", "12345", usuarioCorreto, senhaCorreta); // Login correto
        realizarLogin("admin", "senhaErrada", usuarioCorreto, senhaCorreta); // Senha incorreta
        realizarLogin("usuarioDesconhecido", "12345", usuarioCorreto, senhaCorreta); // Usuário desconhecido
    }

    public static void realizarLogin(String usuario, String senha, String usuarioCorreto, String senhaCorreta) {
        logger.info("Tentativa de login com o usuário: {}", usuario);
        
        if (!usuario.equals(usuarioCorreto)) {
            logger.warn("Usuário {} não encontrado!", usuario);
        } else if (!senha.equals(senhaCorreta)) {
            logger.error("Senha incorreta para o usuário: {}", usuario);
        } else {
            logger.info("Login bem-sucedido para o usuário: {}", usuario);
        }
    }
}