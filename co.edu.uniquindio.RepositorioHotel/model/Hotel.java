package co.edu.uniquindio.model;

import co.edu.uniquindio.RepositorioHotel.services.ICrudCliente;
import co.edu.uniquindio.servicio.IServicio;
import com.sun.glass.ui.Clipboard;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/*Clase hotel con colecciones de habitaciones, clientes y reservas*/
public class Hotel implements ICrudCliente {
    private String nombre;

    private final Collection<Habitacion> habitaciones = new LinkedList<>();
    private final Collection <Cliente> clientes = new LinkedList<>();
    private final Collection <Reserva> reservas  = new LinkedList<>();
    private final servicio;

    public Hotel(String hotelMocawaPlaza) {
    }

    @Override
    public boolean crearCliente(String nombre, String dni) {
        Cliente cliente = new Cliente();

        Cliente clienteExistente = verificarCliente(dni);

        if (clienteExistente == null) {
            cliente.setNombre(nombre);
            cliente.setDni(dni);
            clientes.add(cliente);

            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarCliente(String dni) {
        Cliente cliente = verificarCliente(dni);
        if (cliente != null) {
            clientes.remove(cliente);
            return true;
        }

        return false;
    }

    @Override
    public boolean modificarCliente(String nombre, String dni) {

        return false;
    }

    @Override
    public Cliente getCliente(String id) {

        return null;
    }

    private Cliente verificarCliente(String dni) {
        Cliente clienteExistente = null;

        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                clienteExistente = cliente;
                break;
            }
        }
        return clienteExistente;
    }

    /**
     * Método el cual nos permite crear habitaciones, si el numero de la habitacion ya existe no se puede crear la habitacion
     */
    public void addHabitacion(Habitacion habitacion) {
        if(verificarHabitacionExiste(habitacion.getNumero())) {
            System.out.println("Error: la habitación con número: " + habitacion.getNumero() + "ya existe");
            return;  //evita que la habitación se agregue si ya existe.
        }
        habitaciones.add(habitacion);
        System.out.println("Habitación número: '" + habitacion.getNumero() + "', de tipo: '" + habitacion.getTipoHabitacion() + "', y Precio: '" + habitacion.getPrecio() + "' creada correctamente");
    }
    /**
     * Método el cual nos permite agregar un cliente a una habitacion, solo si esta tiene estado de libre
     * y crea la reserva con el numero de la habitacion, el nombre del cliente, la fecha de entrada y salida
     */
    public void addClienteHabitacion(Cliente cliente, Habitacion habitacion, int dias) {
        if(habitacion.getEstado() == Estado.LIBRE){
            LocalDateTime fechaEntrada = LocalDateTime.now();
            LocalDateTime fechaSalida = LocalDateTime.now().plusDays(dias);
            Reserva nuevaReserva = new Reserva(habitacion, cliente, fechaEntrada, fechaSalida);
            reservas.add(nuevaReserva);
            habitacion.setCliente(cliente); //Cambia el estado a OCUPADO
            cliente.getReservas().add(nuevaReserva);
            addCliente(cliente);
        } else {
            System.out.println("La habitación está ocupada");
        }

    }
    /**
     * Este método permite verificar si el numero de la habitacion ya existe
     */
    public boolean verificarHabitacionExiste(String numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero().equals(numero)) {
                return true;
            }
        }
        return false;
    }

    public Habitacion getHabitacion(String numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero().equals(numero)) {
                return habitacion;
            }
        }
        return null;
    }

    public int calcularTotalClientes() {
        int totalClientes = 0;

        for (Habitacion habitacion : habitaciones) {
            if(habitacion.getCliente() != null){
                totalClientes++;
            }
        }
        return totalClientes;
    }

    /**
     * Agrega un cliente
     */
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public String toString() {
        return "Hotel{ \n" +
                "nombre='" + nombre + '\'' +
                ", \nClientes = " + getClientes().toString() +
                ", \nHabitaciones = " + getHabitaciones().toString() +
                ", \nReservas = " + getReservas().toString() +
                '}';
    }

    /*Crea una lista o colección de los clientes*/
    public Collection<Cliente> getClientes() {
        return Collections.unmodifiableCollection(clientes);
    }

    /*Crea una lista o colección de as reservas realizadas*/
    public Collection<Reserva> getReservas() {
        return Collections
                .unmodifiableCollection(reservas);
    }
    /*Crea una lista de las habitaciones */
    public Collection<Habitacion> getHabitaciones() {
        return Collections.unmodifiableCollection(habitaciones);
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void addReserva(Reserva reserva){
        this.reservas.add(reserva);
    }
    public void addServicio(Servicio servicio){
        this.servicio.add(servicio);
}