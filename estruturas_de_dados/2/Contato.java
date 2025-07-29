import java.util.*;

class Contato {
    private List<String> telefones;
    private List<String> emails;

    public Contato() {
        telefones = new ArrayList<>();
        emails = new ArrayList<>();
    }

    public void adicionarTelefone(String telefone) {
        telefones.add(telefone);
    }

    public void adicionarEmail(String email) {
        emails.add(email);
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public List<String> getEmails() {
        return emails;
    }
}
