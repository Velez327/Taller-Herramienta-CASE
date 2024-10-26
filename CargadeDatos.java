//Código para Ejecutar el Script en VS Code Usando la Conexión JDBC 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.sql.SQLException;

public class CargadeDatos {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String username = "alquilervehiculo"; // Cambia el username al suyo //
        String password = "1234567"; // Cambia el password al suyo //
        String scriptPath = "C:\\Users\\ASUS TUF F15\\Documents\\insertPelicula.sql"; // Ruta al archivo .sql //

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
                Statement stmt = conn.createStatement()) {

            // Leer el archivo SQL y dividirlo en sentencias individuales //
            String sqlScript = new String(Files.readAllBytes(Paths.get(scriptPath)));
            String[] sqlStatements = sqlScript.split(";"); // Divide por el carácter ";" //

            for (String statement : sqlStatements) {
                if (!statement.trim().isEmpty()) {
                    stmt.execute(statement.trim()); // Ejecuta cada declaración individualmente //
                }
            }
            System.out.println("Datos de prueba insertados correctamente en la base de datos.");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo SQL: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error en la ejecución del script SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
