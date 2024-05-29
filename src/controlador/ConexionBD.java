package controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConexionBD {
    Connection con;
    String bd = "myp";
    String url ="jdbc:mysql://localhost:3306/" + bd + "?useUnicode=true&use"
            + "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
            + "serverTimezone=UTC";
    String usuario = "root";
    String pwd = "";
    String driver= "com.mysql.cj.jdbc.Driver";    

    public ConexionBD() {
    }
    public Connection ConectarBaseDeDatos (){
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, usuario, pwd);
            System.out.println("Conexión exitosa a base de datos" + bd);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se pudo conectar a base de datos" + bd);
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return con;
    }
    
    public static void main(String[] args) {
    ConexionBD conexion = new ConexionBD();
    conexion.ConectarBaseDeDatos();
    }
}

    
 
