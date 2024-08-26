package co.edu.uniquindio.RepositorioHotel;

public class Restaurante extends Servicio implements Consumible{
    @Override
    public double calcularPrecioServicio() {
        return 50000.0;
    }

    @Override
    public void consumir() {
        System.out.println("Consumiendo servicio de Restaurante");
    }
}
