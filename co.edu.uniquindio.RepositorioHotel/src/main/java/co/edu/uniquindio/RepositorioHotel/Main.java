package co.edu.uniquindio.RepositorioHotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while(true){
            System.out.println("Gestión del Hotel");
            System.out.println("1. Crear Habitacion");
            System.out.println("2. Crear Cliente");
            System.out.println("3. Realizar Reserva");
            System.out.println("4. Agregar servicio");
            System.out.println("5. Mostrar Reservas");
            System.out.println("6. salir");
            System.out.println("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1:
                    System.out.println("Ingrese el número de la habitación: ");
                    String numero = sc.nextLine();
                    System.out.print("Ingrese tipo de habitación (SIMPLE, DOBLE, SUITE): ");
                    TipoHabitacion tipo = TipoHabitacion.valueOf(sc.nextLine().toUpperCase());
                    System.out.print("Ingrese precio de la habitación: ");
                    double precio = sc.nextDouble();
                    sc.nextLine(); // Consumir la nueva línea
                    hotel.crearHabitaciones(numero, tipo, precio);
                    break;

                case 2:
                    System.out.print("Ingrese nombre del cliente: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese DNI del cliente: ");
                    String dni = sc.nextLine();
                    Cliente cliente = new Cliente(nombre, dni);
                    hotel.addCliente(cliente);
                    System.out.println("Cliente agregado: " + nombre + ", DNI: " + dni);
                    break;

                case 3:
                    System.out.print("Ingrese DNI del cliente: ");
                    dni = sc.nextLine();
                    cliente = hotel.getClientes().stream().filter(c -> c.getDni().equals(dni)).findFirst().orElse(null);
                    if (cliente == null) {
                        System.out.println("Cliente no encontrado.");
                        break;
                    }
                    System.out.print("Ingrese número de la habitación: ");
                    numero = sc.nextLine();
                    Habitacion habitacion = hotel.getHabitaciones().stream().filter(h -> h.getNumero().equals(numero)).findFirst().orElse(null);
                    if (habitacion == null) {
                        System.out.println("Habitación no encontrada.");
                        break;
                    }
                    System.out.print("Ingrese número de días: ");
                    int dias = sc.nextInt();
                    sc.nextLine(); // Consumir la nueva línea
                    hotel.addClienteHabitacion(cliente, habitacion, dias);
                    break;

                case 4:
                    System.out.print("Ingrese número de la habitación: ");
                    numero = sc.nextLine();
                    habitacion = hotel.getHabitaciones().stream().filter(h -> h.getNumero().equals(numero)).findFirst().orElse(null);
                    if (habitacion == null) {
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
                    habitacion.addServicio(servicio);
                    System.out.println("Servicio agregado a la habitación " + numero);
                    break;

                case 5:
                    for (Reserva reserva : hotel.getReservas()) {
                        System.out.println("Reserva para " + reserva.getCliente().getNombre() +
                                " en habitación " + reserva.getHabitacion().getNumero());
                        System.out.println("Fecha de entrada: " + reserva.getFechaEntrada());
                        System.out.println("Fecha de salida: " + reserva.getFechaSalida());
                        System.out.println("Servicios contratados:");
                        for (Servicio s : reserva.getHabitacion().getServicios()) {
                            System.out.println(" - " + s.getClass().getSimpleName() + " con un costo de " + s.calcularPrecioServicio());
                        }
                        System.out.println("Costo total de la reserva: " + reserva.calcularPrecio());
                        System.out.println();
                    }
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
}