package co.edu.uniquindio.RepositorioHotel;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
/*Creacion de la clase reserva */
public class Reserva {
    private final Habitacion habitacion;
    private Cliente cliente;
    private final LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;


    public Reserva(Habitacion habitacion, Cliente cliente, LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }
/*Metodo el cual nos permite calcular el tiempo en dias, que estuvo el cleinte en la habitacion*/
    public int calcularTiempo(LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
        Duration tiempo = Duration.between(fechaEntrada, fechaSalida);
        long dias = tiempo.toDays();
        return (int) dias;
    }
/*Metodo el cual nos permite clacular el precio total tomando los dias reservados * el precio de la habitacio*/
    public double calcularPrecio(){
        int diasReservados = calcularTiempo(fechaEntrada, fechaSalida);
        double precioHabitacion = habitacion.getPrecio();
        return diasReservados * precioHabitacion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }
    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

}
