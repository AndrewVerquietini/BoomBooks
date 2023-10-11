package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBD {
    public static void main (String [] args) throws SQLException {
         Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/BoomBooksBD", "root", "123456789");

        try{
                Class.forName("com.mysql.jdbc.Driver");
                ResultSet rsCliente = conexao.createStatement().executeQuery("SELECT * FROM usuario_comum where nome = 'Alexandre'");
                while (rsCliente.next()){
                            System.out.println("Nome " + rsCliente.getString("nome"));
                }
        }catch (ClassNotFoundException ex){
                System.out.println("Driver do banco de dados não localizado.");
        }catch (SQLException ex){
                System.out.println("Falha ao acessar o banco:" + ex.getMessage());
        }finally {
                if (conexao != null){
                    conexao.close();
                }
        }
    }
}
