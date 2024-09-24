package co.edu.uniquindio.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel("Hotel Mocawa Plaza");
        /*Decision while la cual nos permite seleccionar un item */
        while(true){
            System.out.println("Selecciona una de las siguientes opciones: ");
            System.out.println("1. Crear una habitación: ");
            System.out.println("2. Crear un cliente: ");
            System.out.println("3. Realizar una reserva: ");
            System.out.println("4. Agregar un servicio: ");
            System.out.println("5. Mostrar reservas");
            System.out.println("6. salir");
            System.out.println("opción a seleccionar: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            /*Agregar una habitacion*/
            switch(opcion){
                case 1:
                    Habitacion habitacion = capturarDatosHabitacion();
                    hotel.addHabitacion(habitacion);
                    System.out.println("La habitación ha sido creada correctamente");
                    break;

                /*Agrega los datos de un cliente*/
                case 2:
                    Cliente cliente  = capturarDatosCliente();
                    hotel.addCliente(cliente);
                    System.out.println("El cliente con nombre: '" + cliente.getNombre() + "' y dni: '" + cliente.getDni() + "' ha sido creado correctamente");
                    break;

                /*Realiza la busqueda de un cliente, con el DNI*/
                case 3:
                    System.out.print("Ingrese DNI del cliente: ");
                    String dni = sc.nextLine();
                    Cliente clienteReserva = hotel.getClientes().stream().filter(c -> c.getDni().equals(dni)).findFirst().orElse(null);
                    if (clienteReserva == null) {
                        System.out.println("Cliente no encontrado.");
                        break;
                    }
                    /*Realiza la busqueda de una habitacion reservada, con el numero de la misma*/
                    System.out.print("Ingrese número de la habitación: ");
                    String numeroReserva = sc.nextLine();
                    Habitacion habitacionReserva = hotel.getHabitaciones().stream().filter(h -> h.getNumero().equals(numeroReserva)).findFirst().orElse(null);
                    if (habitacionReserva == null) {
                        System.out.println("Habitación no encontrada.");
                        break;
                    }
                    System.out.print("Ingrese número de días: ");
                    int dias = sc.nextInt();
                    sc.nextLine();
                    hotel.addClienteHabitacion(clienteReserva, habitacionReserva, dias);
                    System.out.println("La reserva ha sido creada correctamente");
                    break;
                /*Muestra el servicio que tiene la habitacion*/
                case 4:
                    System.out.print("Ingrese número de la habitación: ");
                    String numero = sc.nextLine();
                    Habitacion habitacionXservicio = hotel.getHabitaciones().stream().filter(h -> h.getNumero().equals(numero)).findFirst().orElse(null);
                    if (habitacionXservicio == null) {
                        System.out.println("Habitación no encontrada.");
                        break;
                    }
                    System.out.println("Seleccione un servicio a agregar: ");
                    System.out.println("1. Servicio de Habitación");
                    System.out.println("2. Spa");
                    System.out.println("3. Restaurante");
                    int servicioOpcion = sc.nextInt();
                    sc.nextLine(); // Consumir la nueva línea
                    Servicio servicio = null;
                    switch (servicioOpcion) {
                        case 1:
                            servicio = new ServicioDeHabitacion();
                            break;
                        case 2:
                            servicio = new Spa();
                            break;
                        case 3:
                            servicio = new Restaurante();
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            continue;
                    }
                    habitacionXservicio.addServicio(servicio);
                    System.out.println("Servicio de agregado a la habitación " + numero);
                    break;
                /*Mediante el DNI del cliente muestra las reservas realizadas*/
                case 5:
                    System.out.println("Ingrese el DNI del cliente para mostrar sus reservas ");
                    String dniReserva = sc.nextLine();
                    Cliente clienteMostrar = hotel.getClientes().stream().filter(c -> c.getDni().equals(dniReserva)).findFirst().orElse(null);
                    if(clienteMostrar == null){
                        System.out.println("Cliente no encontrado.");
                        break;
                    }
                    mostrarReservasCliente(clienteMostrar, hotel);
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    /*Captura los datos del cliente*/
    private static Cliente capturarDatosCliente(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese dni del cliente: ");
        String dni = sc.nextLine();

        return new Cliente(nombre, dni);
    }
    /*Captura los datos de la habitacion*/
    private static Habitacion capturarDatosHabitacion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de habitación: ");
        String numero = sc.nextLine();
        System.out.println("Ingrese el tipo de habitacion (SIMPLE, DOBLE, SUITE): ");
        TipoHabitacion tipo = TipoHabitacion.valueOf(sc.next().toUpperCase());
        System.out.println("Ingrese el precio de la habitación: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        return new Habitacion(numero, tipo, precio);
    }
    /*Muestra y agrega las reservas realizadas por el cliente*/
    private static void mostrarReservasCliente(Cliente cliente, Hotel hotel) {
        Collection<Reserva> reservasCliente = new LinkedList<>();
        for (Reserva reserva : hotel.getReservas()) {
            if (reserva.getCliente().equals(cliente)) {
                reservasCliente.add(reserva);
            }
        }
        if (reservasCliente.isEmpty()) {
            System.out.println("El cliente con DNI: '" + cliente.getDni()+ "' No tiene reservas activas");
        } else {
            for (Reserva reserva : reservasCliente) {
                System.out.println("Reserva para " + reserva.getCliente().getNombre() +
                        " en habitación " + reserva.getHabitacion().getNumero());
                System.out.println("Fecha de entrada: " + reserva.getFechaEntrada());
                System.out.println("Fecha de salida: " + reserva.getFechaSalida());
                System.out.println("Servicios contratados:");
                for (Servicio s : reserva.getHabitacion().getServicios()) {
                    System.out.println(" - " + s.getClass().getSimpleName() + " con un costo de " + s.calcularPrecioServicio());
                }
                System.out.println("Costo total de la reserva: " + reserva.calcularPrecio());/*Precio total a pagar*/
                System.out.println();
            }
        }
    }
}