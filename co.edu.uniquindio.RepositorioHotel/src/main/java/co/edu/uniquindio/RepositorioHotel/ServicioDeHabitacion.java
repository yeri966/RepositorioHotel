package co.edu.uniquindio.RepositorioHotel;

public class ServicioDeHabitacion extends Servicio implements Consumible{
    private Habitacion habitacion;

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
