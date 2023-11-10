package TelaLogin;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String genero;
    private int idade;

    public Usuario(String nome, String email, String senha, String genero, int idade) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.genero = genero;
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getGenero() {
        return genero;
    }

    public int getIdade() {
        return idade;
    }
}