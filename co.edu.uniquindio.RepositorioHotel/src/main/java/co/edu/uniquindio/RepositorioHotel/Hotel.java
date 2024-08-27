package co.edu.uniquindio.RepositorioHotel;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Hotel {
    private final Collection<Habitacion> habitaciones;
    private final Collection <Cliente> clientes;
    private final Collection <Reserva> reservas;

    public Hotel() {
        this.habitaciones = new LinkedList<>();
        this.clientes = new LinkedList<>();
        this.reservas = new LinkedList<>();
    }

    public void addHabitacion(Habitacion habitacion) {
        if(verificarHabitacionExiste(habitacion.getNumero())) {
            System.out.println("Error: la habitación con número: " + habitacion.getNumero() + "ya existe");
            return;  //evita que la habitación se agregue si ya existe.
        }
        habitaciones.add(habitacion);
        System.out.println("Habitación número: '" + habitacion.getNumero() + "', de tipo: '" + habitacion.getTipo() + "', y Precio: '" + habitacion.getPrecio() + "' creada correctamente");
    }

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

    private boolean verificarHabitacionExiste(String numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero().equals(numero)) {
                return true;
            }
        }
        return false;
    }


    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Collection<Cliente> getClientes() {
        return Collections.unmodifiableCollection(clientes);
    }

    public Collection<Reserva> getReservas() {
        return Collections
                .unmodifiableCollection(reservas);
    }
    public Collection<Habitacion> getHabitaciones() {
        return Collections.unmodifiableCollection(habitaciones);
    }


}
