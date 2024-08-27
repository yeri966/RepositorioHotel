package co.edu.uniquindio.RepositorioHotel;

import java.time.Duration;
import java.time.LocalDateTime;

public class Reserva {
    private final Habitacion habitacion;
    private Cliente cliente;
    private final LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;


    public Reserva (Habitacion habitacion, Cliente cliente, LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

        public Habitacion getHabitacion() {
        return habitacion; }

        public Cliente getCliente() {
        return cliente; }
        public void setCliente(Cliente cliente) { this.cliente = cliente; }
    
        public LocalDateTime getFechaEntrada() {
        return fechaEntrada; }
    
        public LocalDateTime getFechaSalida() {
        return fechaSalida; }
        public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida; }


    public int calcularTiempo() {
        Duration tiempo = Duration.between(this.fechaEntrada, this.fechaSalida);
        long dias = tiempo.toDays();
        return (int) dias;
    }

        public double calcularPrecio(){
            int diasReservados = calcularTiempo();
            double precioHabitacion = habitacion.getPrecio();
            double precioTotal = diasReservados * precioHabitacion;
            for(Servicio servicio : habitacion.getServicios()){
                precioTotal += servicio.calcularPrecioServicio();
            }

            return precioTotal;

        }

}
