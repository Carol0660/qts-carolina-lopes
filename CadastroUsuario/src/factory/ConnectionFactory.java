package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Fabrica de conexoes com o banco de dados.
 * Altere usuario/senha/porta de acordo com a sua instalacao do MySQL.
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/projetojava?useTimezone=true&serverTimezone=UTC",
                "root",          // <-- troque pelo seu usuario do MySQL, se necessario
                "carol0612" // <-- troque pela sua senha do MySQL
            );
        } catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}
