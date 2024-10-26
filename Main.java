//Comprobar la conexión a la Base de Datos de Oracle 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe"; // Cambia el URL si es necesario
        String username = "alquilervehiculo";
        String password = "1234567";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Conexión exitosa a la base de datos!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }
}
