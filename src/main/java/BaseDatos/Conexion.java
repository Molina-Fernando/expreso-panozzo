package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:sqlite:expreso_panozzo.db";
    private static Connection conectar = null;

    /**
     * Establece la conexión a la base de datos SQLite.
     *
     * @return Un objeto Connection activo o null si falla.
     */
    public static Connection conectar() {
        if (conectar != null) {
            return conectar;
        }

        try {
            conectar = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }

        return conectar;
    }
}

