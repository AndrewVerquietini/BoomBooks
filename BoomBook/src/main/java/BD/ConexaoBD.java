package BD;

import TelaLogin.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConexaoBD {

    private static final String URL = "jdbc:mysql://localhost/BoomBooksBD";
    private static final String USUARIO = "root";
    private static final String SENHA = "123456789";

    public static Connection obterConexao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Carrega o driver do MySQL

            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            return conexao;
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL não encontrado", e);
        }
    }

    public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean validarLoginComum(String email, String senha) {
        try {
            Connection conexao = obterConexao();

            // Execute a consulta SQL para verificar as credenciais de usuário comum
            String query = "SELECT * FROM usuario WHERE email = ? AND senha = ? AND id_cliente NOT LIKE '1'";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Se houver uma linha correspondente, o login é válido.
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Em caso de erro, retorne falso.
        }
    }

    public boolean validarLoginAdmin(String email, String senha) {
        try {
            Connection conexao = obterConexao();

            // Execute a consulta SQL para verificar as credenciais de administrador
            String query = "SELECT * FROM usuario WHERE email = ? AND senha = ? AND tipo = 'admin'";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Se houver uma linha correspondente, o login é válido.
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Em caso de erro, retorne falso.
        }
    }

    public void inserirLivro(Livro livro) throws SQLException {
        Connection conexao = obterConexao();
        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO livros (titulo, autor, comentario, nota) VALUES (?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getComentario());
            stmt.setInt(4, livro.getAvaliacoes().isEmpty() ? 0 : livro.getAvaliacoes().get(0).getNota());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void inserirUsuario(Usuario usuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = obterConexao();
            String sql = "INSERT INTO usuario (nome, email, senha, genero, idade) VALUES (?, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getGenero());
            stmt.setInt(5, usuario.getIdade());

            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null) {
                fecharConexao(conexao);
            }
        }
    }

    public List<Livro> obterLivros() throws SQLException {
        List<Livro> livros = new ArrayList<>();

        try (Connection conexao = obterConexao(); Statement statement = conexao.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM livros")) {

            while (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");
                String comentario = resultSet.getString("comentario");
                int nota = resultSet.getInt("nota");

                Livro livro = new Livro(titulo, autor, comentario, nota);
                livros.add(livro);
            }
        }

        return livros;
    }

    public void desconectar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Livro> listarLivros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
