public class PessoasArray {
    private String[] nomes;

    public PessoasArray() {
        nomes = new String[]{"Amanda", "Beatriz", "Carlos", "Daniela", "Eduardo",
                "Fabio", "Gustavo", "Hingrid", "Isabela", "Joao", "Leise", "Maria",
                "Norberto", "Otavio", "Paulo", "Quirino", "Renata", "Sabata",
                "Tais", "Umberto", "Vanessa", "Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    public void buscaLinear(String nome) {
        System.out.println("Procurando pelo nome: \"" + nome + "\"");
        boolean encontrado = false;
    
        for (int i = 0; i < nomes.length; i++) {
            System.out.println("Passando pelo indice:" + i);
    
            if (nomes[i].equals(nome) && !encontrado) {
                System.out.println("Nome pesquisado \u00E9 " + nomes[i] + " que est\u00E1 na posi\u00E7\u00E3o " + i);
                encontrado = true;
            }
        }
        if (!encontrado) {
            throw new IllegalArgumentException("O nome " + nome + " não se encontra no array de nomes");
        }
    }
    
}
