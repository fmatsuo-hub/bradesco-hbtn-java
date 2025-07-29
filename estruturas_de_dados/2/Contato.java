import java.util.*;

public class Contato {
    private List<String> telefones;
    private Set<String> emails;

    public Contato() {
        telefones = new ArrayList<>();
        emails = new HashSet<>();
    }

    public void adicionarTelefone(String telefone) {
        telefones.add(telefone);
    }

    public boolean adicionarEmail(String email) {
        if (!emails.contains(email)) {
            emails.add(email);
            return true;
        }
        return false;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public Set<String> getEmails() {
        return emails;
    }
}