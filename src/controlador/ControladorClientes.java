package controlador;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.Interfaz;


public class ControladorClientes implements ActionListener {

    Cliente cliente = new Cliente();
    ClienteDAO clienteDAO = new ClienteDAO();
    Interfaz vista = new Interfaz();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    private String nombre;
    private String direccion;
    private int telefono;
    private String servicio;
    private String estado;
    private int id;
    
    public ControladorClientes (Interfaz _vista){
        this.vista = _vista;
        vista.setVisible(true);

      AgregarEventos();
      listarTabla();  
    }
     private void AgregarEventos(){
    vista.getBtnAgregar().addActionListener(this);
    vista.getBtnActualizar().addActionListener(this);
    vista.getBtnBorrar().addActionListener(this);
    vista.getTblTablaClientes().addMouseListener(new MouseAdapter(){
    
    public void mauseClicked(MouseEvent e){
             llenarCampos(e);
        }
    });
     
     }
     private void listarTabla(){
     String[] titulos = new String[]{"id", "nombre", "direccion", "telefono", "servicio", "estado"};
     modeloTabla = new DefaultTableModel(titulos, 0);
     List<Cliente> listaClientes = clienteDAO.listar();
     listaClientes.forEach(cliente -> {
         modeloTabla.addRow(new Object[]{
             cliente.getId(),
             cliente.getNombre(),
             cliente.getDireccion(),
             cliente.getTelefono(),
             cliente.getServicio(),
             cliente.getEstado()
         });
        });
         vista.getTblTablaClientes().setModel(modeloTabla);
         vista.getTblTablaClientes().setPreferredSize(new Dimension(350, modeloTabla.getRowCount() * 16));
   }
      private void llenarCampos(MouseEvent e){
      JTable target = (JTable) e.getSource(); 
        vista.getTxtNombre().setText(vista.getTblTablaClientes().getModel().getValueAt(target.getSelectedRow(), 1).toString());
        vista.getTxtDireccion().setText(vista.getTblTablaClientes().getModel().getValueAt(target.getSelectedRow(), 2).toString());
        vista.getTxtTelefono().setText(vista.getTblTablaClientes().getModel().getValueAt(target.getSelectedRow(), 3).toString());
        vista.getTxtServicio().setText(vista.getTblTablaClientes().getModel().getValueAt(target.getSelectedRow(), 4).toString());
        vista.getTxtEstado().setText(vista.getTblTablaClientes().getModel().getValueAt(target.getSelectedRow(), 5).toString());
    }
      
      private boolean validarDatos(){
          if("".equals(vista.getTxtNombre().getText())
                  || "".equals(vista.getTxtDireccion().getText())
                  || "".equals(vista.getTxtTelefono().getText())
                  || "".equals(vista.getTxtServicio().getText())
                  || "".equals(vista.getTxtEstado().getText())) {
                JOptionPane.showMessageDialog(null,"Los campos no pueden ser vacios",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return false;
          }
          return true;
      }
      
      private boolean cargarDatos(){
      
          try{
          nombre = vista.getTxtNombre().getText();
          direccion = vista.getTxtDireccion().getText();
          telefono = Integer.parseInt(vista.getTxtTelefono().getText());
          servicio = vista.getTxtServicio().getText();
          estado = vista.getTxtEstado().getText(); 
          return true;
          
                  
          
          }catch (NumberFormatException e){
          JOptionPane.showMessageDialog(null, "Los campos de telefono deben ser númericos",
                  "Error", JOptionPane.ERROR);
                  System.out.println("Error al cargar los datos " + e);
                  return false;
          
          }
      }
      
      public void limpiarCampos(){
      vista.getTxtNombre().getText();
      vista.getTxtDireccion().getText();
      vista.getTxtTelefono().getText();
      vista.getTxtServicio().getText();
      vista.getTxtEstado().getText();
      id = 0;
      nombre = "";
      direccion = "";
      telefono = 0;
      servicio = "";
      estado = "";
      }
      
      private void agregarCliente(){
      try{
          if(validarDatos()){
              if(cargarDatos()){
              Cliente cliente = new Cliente(nombre, direccion, telefono, servicio, estado);
              JOptionPane.showMessageDialog(null, "Registro agregado con exito");
              limpiarCampos();
              }
          }
          
      }catch(HeadlessException e){
      System.err.println("Error al agregar (C)");
      
      }finally{
            listarTabla();
      }
      
      }
      
      
      
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
