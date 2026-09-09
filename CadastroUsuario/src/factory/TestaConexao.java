package factory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Classe simples para testar se a conexao com o MySQL esta funcionando.
 * Execute esta classe (Shift+F6 no NetBeans) antes de rodar a interface grafica.
 */
public class TestaConexao {
    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexao aberta com sucesso!");
        connection.close();
    }
}
