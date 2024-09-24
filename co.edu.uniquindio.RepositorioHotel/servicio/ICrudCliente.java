package co.edu.uniquindio.servicio;

import co.edu.uniquindio.model.Cliente;
import java.util.ArrayList;

public interface ICrudCliente {

    public boolean crearCliente(String nombre, int edad);
    public boolean eliminarCliente(String nombre);
    public boolean modificarCliente(String nombre, int edad);
    public Cliente getCliente(String nombre);
    public ArrayList<Cliente> getClientes();

}