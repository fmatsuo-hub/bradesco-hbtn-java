public class PersonagemGame {
    private int saudeAtual;
    private String nome;

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void tomarDano(int quantidadeDeDano) {
        if (saudeAtual - quantidadeDeDano < 0) {
            saudeAtual = 0;
        } else {
            saudeAtual -= quantidadeDeDano;
        }
    }

    public void receberCura(int quantidadeDeCura) {
        if (saudeAtual + quantidadeDeCura > 100) {
            saudeAtual = 100;
        } else {
            saudeAtual += quantidadeDeCura;
        }
    }
}
