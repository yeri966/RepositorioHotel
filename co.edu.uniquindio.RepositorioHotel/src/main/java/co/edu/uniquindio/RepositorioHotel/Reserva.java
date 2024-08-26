package co.edu.uniquindio.RepositorioHotel;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public int calcularTiempo(LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
        Duration tiempo = Duration.between(fechaEntrada, fechaSalida);
        long dias = tiempo.toDays();
        return (int) dias;
    }

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
