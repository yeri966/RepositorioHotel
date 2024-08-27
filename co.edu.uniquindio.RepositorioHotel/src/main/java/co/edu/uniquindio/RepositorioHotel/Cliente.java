package co.edu.uniquindio.RepositorioHotel;

package co.edu.uniquindio.RepositorioHotel;

import java.util.Collection;
import java.util.LinkedList;
/* creacion de clase cliente con los atributos privados nombre y dni, y una coleccion de reservas */
public class Cliente {
    private final String nombre;
    private final String dni;
    private final Collection<Reserva> reservas;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.reservas = new LinkedList<>();
    }
/*Metodos get de la clase*/
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

