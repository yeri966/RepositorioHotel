package co.edu.uniquindio.RepositorioHotel;

public class Limpieza extends Servicio implements Consumible{
    @Override
    public double calcularPrecioServicio() {
        return 20000.0;
    }

    @Override
    public void consumir() {
        System.out.println("Consumiendo servicio de Limpieza");
    }
}
