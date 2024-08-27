package co.edu.uniquindio.RepositorioHotel;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
/*Clase hotel con colecciones de habitaciones, cleintes y reservas*/
public class Hotel {
    private final Collection<Habitacion> habitaciones;
    private final Collection <Cliente> clientes;
    private final Collection <Reserva> reservas;

    public Hotel() {
        this.habitaciones = new LinkedList<>();
        this.clientes = new LinkedList<>();
        this.reservas = new LinkedList<>();
    }
    /*Metodo el cual nos permite crear habitaciones, si el numero de la habitacion ya existe no se puede crear la habitacion*/
    public void addHabitacion(Habitacion habitacion) {
        if(verificarHabitacionExiste(habitacion.getNumero())) {
            System.out.println("Error: la habitación con número: " + habitacion.getNumero() + "ya existe");
            return;  //evita que la habitación se agregue si ya existe.
        }
        habitaciones.add(habitacion);
        System.out.println("Habitación número: '" + habitacion.getNumero() + "', de tipo: '" + habitacion.getTipo() + "', y Precio: '" + habitacion.getPrecio() + "' creada correctamente");
    }
    /*  Metodo el cual nos permite agregar un cliente a una habitacion, solo si esta tiene estado de libre
      y crea la reserva con el numero de la habitacion, el nombre del cliente, la fecha de entrada y salida*/
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
    /*Este metodo permite verificar si el numero de la habitacion ya existe*/
    private boolean verificarHabitacionExiste(String numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero().equals(numero)) {
                return true;
            }
        }
        return false;
    }

/*Agrega un ciente*/
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }
/*Crea una lista o coleccion de los clientes*/
    public Collection<Cliente> getClientes() {
        return Collections.unmodifiableCollection(clientes);
    }
/*Crea una lista o coleccion de as resenrvas realizadas*/
    public Collection<Reserva> getReservas() {
        return Collections
                .unmodifiableCollection(reservas);
    }
/*Crea una lista de las habitaciones */
    public Collection<Habitacion> getHabitaciones() {
        return Collections.unmodifiableCollection(habitaciones);
    }


}
