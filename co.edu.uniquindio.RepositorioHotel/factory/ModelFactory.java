package co.edu.uniquindio.factory;
import co.edu.uniquindio.model.*;
import co.edu.uniquindio.servicio.ICrudCliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ModelFactory implements ICrudCliente {
    private static ModelFactory instance;
    private static Hotel hotel;

    private ModelFactory(){
        inicializarDatos();
    }

    public static ModelFactory getInstance(){
        if(instance == null){
            instance = new ModelFactory();
        }
        return instance;
    }
    public Hotel getHotel(){
        return hotel;
    }
    public Habitacion crearHabitacion(String numero, TipoHabitacion tipo, double precio){
        return new Habitacion(numero, tipo, precio);
    }
    public Cliente crearCliente(String nombre, String dni){
        return new Cliente(nombre, dni);
    }
    public Reserva crearReserva(Cliente cliente, Habitacion habitacion, LocalDateTime FechaEntrada, LocalDateTime FechaSalida) {
        return new Reserva (habitacion, cliente, FechaEntrada, FechaSalida);
    }
    public Servicio crearServicio(String nombre, double costo){
        return new Servicio (nombre, precio);
    }
    public ServicioDeHabitacion crearServicioDeHabitacion(String nombre, double precio){
        return new ServicioDeHabitacion(nombre, precio);
    }

/**
 * Inicializa los datos del hotel
 *
 * return instancia del hotel con datos predefinidos
 */

private void inicializarDatos(){
    hotel = new Hotel("Hotel Mocawa Plaza");

    //Crear habitaciones
    Habitacion habitacionSimple = crearHabitacion("111", TipoHabitacion.SIMPLE, 150000);
    Habitacion habitacionDoble = crearHabitacion("112", TipoHabitacion.DOBLE, 200000);
    Habitacion habitacionSuite = crearHabitacion("113", TipoHabitacion.SUITE, 500000);

    //Crear clientes
    Cliente cliente1 = crearCliente("Paula Niño","12345678");
    Cliente cliente2 = crearCliente("Luis Bustamante","87654321");
    Cliente cliente3 = crearCliente("Gabriela Bustamante","24681357");

    //Crear reservas
    Reserva reserva1 = crearReserva(cliente1, habitacionSimple, LocalDateTime.now(), LocalDateTime.now().plusDays(4));
    Reserva reserva2 = crearReserva(cliente2, habitacionDoble, LocalDateTime.now().plusWeeks(1), LocalDateTime.now().plusWeeks(3));
    Reserva reserva3 = crearReserva(cliente3, habitacionSuite, LocalDateTime.now().plusWeeks(3), LocalDateTime.now().plusWeeks(6));

    //agregar elementos al hotel
    hotel.addHabitacion(habitacionSimple);
    hotel.addHabitacion(habitacionDoble);
    hotel.addHabitacion(habitacionSuite);
    hotel.addCliente(cliente1);
    hotel.addCliente(cliente2);
    hotel.addCliente(cliente3);
    hotel.addReserva(reserva1);
    hotel.addReserva(reserva2);
    hotel.addReserva(reserva3);

    //Servicios
    ServicioDeHabitacion servicioDeHabitacion =  crearServicioDeHabitacion("Limpiar habitacion", 5000);
    Servicio spa = crearServicio("Spa", 10000);
    Servicio restaurante = crearServicio ("Restaurante", 8000);

    hotel.addServicio(servicioDeHabitacion);
    hotel.addServicio(spa);
    hotel.addServicio(restaurante);
    }
}