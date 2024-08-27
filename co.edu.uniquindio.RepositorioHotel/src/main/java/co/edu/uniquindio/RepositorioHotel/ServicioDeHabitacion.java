package co.edu.uniquindio.RepositorioHotel;
/*Creacion de la clase Servicio de habitacion la cual hereda de la clase Servicio e implementa dela interface Consumible*/
public class ServicioDeHabitacion extends Servicio implements Consumible{
    private Habitacion habitacion;

    @Override
    public double calcularPrecioServicio() {
        return 35000.0;
    }

    @Override
    public void consumir() {
        System.out.println("Consumiendo Servicio de Habitacion"+habitacion.getNumero());
    }
}
