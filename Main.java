//Comprobar la conexión a la Base de Datos de Oracle 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String username = "alquilervehiculo"; // Cambia el username al suyo //
        String password = "1234567"; // Cambia el password al suyo //

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Conexión exitosa a la base de datos!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }
}
