package modelo;
import java.sql.Connection;
import controlador.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


public class ClienteDAO {
    ConexionBD conexion = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        String sql="select * from clientes";
        List<Cliente> lista = new ArrayList<>();
        
        try{
            con = conexion.ConectarBaseDeDatos();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
            
                Cliente clientes = new Cliente();
                clientes.setId(rs.getInt(1));
                clientes.setNombre(rs.getString(2));
                clientes.setDireccion(rs.getString(3));
                clientes.setTelefono(rs.getInt(4));
                clientes.setServicio(rs.getString(5));
                clientes.setEstado(rs.getString(6));
                lista.add(clientes);
            }
            
        }catch(SQLException e){
        System.err.println("Error al listar" + e);
        
        }
        
        return lista;
    }//fin metodo
    
    public void Agregar(Cliente cliente){
    String sql = "INSERT INTO clientes (nombre,direccion,telefono,servicio,estado) VALUES (?,?,?,?,?)";
    try{
    
        con =conexion.ConectarBaseDeDatos();
        ps = con.prepareStatement(sql);
        ps = setString(1, cliente.getNombre());
        ps = setString(2, cliente.getDireccion());
        ps = setInt(3,cliente.getTelefono());
        ps = setString(4, cliente.getServicio());
        ps = setString(5, cliente.getEstado());
        ps = executeUpdate();
        
    }catch(SQLException e){}
    System.err.println("Error en el método Agregar clase ClienteDAO ");
    
    }

    private PreparedStatement setString(int i, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private PreparedStatement setInt(int i, int telefono) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }//fin del metodo Agregar

    private PreparedStatement executeUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}// fin de la clase DAO
