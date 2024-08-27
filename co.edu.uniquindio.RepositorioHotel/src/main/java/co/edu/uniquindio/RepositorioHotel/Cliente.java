package co.edu.uniquindio.RepositorioHotel;

import java.util.Collection;
import java.util.LinkedList;

public class Cliente {
    private final String nombre;
    private final String dni;
    private final Collection<Reserva> reservas;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.reservas = new LinkedList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public String getDni() {
        return dni;
    }
    public Collection<Reserva> getReservas() {
        return reservas;
    }
}
