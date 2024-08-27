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

    public void crearHabitaciones(String numero, TipoHabitacion tipo, double precio) {
        if(verificarHabitacionExiste(numero)) {
            System.out.println("Error: la habitación con número: " + numero + "ya existe");
            return;
        }
        Habitacion habitacionNueva = new Habitacion(numero, tipo, precio);
        habitaciones.add(habitacionNueva);
        System.out.println("Habitación número: '" + numero + "', de tipo: '" + tipo + "', y Precio: '" + precio + "' creada correctamente");
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

    public void removeClienteHabitacion(Cliente cliente, Habitacion habitacion, LocalDateTime fechaSalida) {
        var obtenerCliente = habitacion.getCliente();
        if (obtenerCliente != null && obtenerCliente.equals(cliente)) {
            for (Reserva reserva : reservas) {
                if (reserva.getCliente().equals(obtenerCliente) && reserva.getHabitacion().equals(habitacion)) {
                    reserva.setFechaSalida(fechaSalida);
                }
            }
            habitacion.setCliente(null); //Cambia el estado a LIBRE
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
