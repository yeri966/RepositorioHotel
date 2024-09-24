package co.edu.uniquindio.model;

/*Creación de la clase Servicio de habitacion la cual hereda de la clase Servicio e implementa dela interface Consumible*/
public class ServicioDeHabitacion extends Servicio implements Consumible {
    private Habitacion habitacion;

    public ServicioDeHabitacion(String nombre, double precio) {
        super();
    }

    @Override
    public double calcularPrecioServicio() {
        return 35000.0;
    }

    @Override
    public void consumir() {
        if(habitacion != null){
            System.out.println("Consumiendo Servicio de Habitacion"+habitacion.getNumero());
        }else{
            System.out.println("Habitacion no asignada");
        }

    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
}