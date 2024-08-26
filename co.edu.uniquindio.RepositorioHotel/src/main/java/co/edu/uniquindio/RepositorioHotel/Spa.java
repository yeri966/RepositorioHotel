package co.edu.uniquindio.RepositorioHotel;

public class Spa extends Servicio implements Consumible{
    @Override
    public double calcularPrecioServicio() {
        return 30000.0;
    }

    @Override
    public void consumir() {
        System.out.println("Consumiendo servicio de Spa");
    }
}
