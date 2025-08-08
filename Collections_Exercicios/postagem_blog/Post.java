public class Post implements Comparable<Post> {
    private Autor autor;
    private String titulo;
    private String corpo;
    private Categorias categoria;

    public Post(Autor autor, String titulo, String corpo, Categorias categoria) {
        this.autor = autor;
        this.titulo = titulo;
        this.corpo = corpo;
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return titulo;
    }

    @Override
    public int compareTo(Post outro) {
        return this.titulo.compareTo(outro.titulo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        // Mesmo autor e título = mesma postagem
        return autor.equals(post.autor) && titulo.equals(post.titulo);
    }

    @Override
    public int hashCode() {
        return autor.hashCode() * 31 + titulo.hashCode();
    }
}
