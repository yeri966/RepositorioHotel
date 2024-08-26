package co.edu.uniquindio.RepositorioHotel;

public class Habitacion {
    private final int numero;
    private final TipoHabitacion tipo;
    private final double precio;
    private Estado estado;
    private Cliente cliente;

    public Habitacion(int numero, TipoHabitacion tipo, double precio){
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = Estado.LIBRE;
    }
    public int getNumero() {
        return numero;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }
    public double getPrecio() {
        return precio;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        if(cliente == null){
            estado = Estado.LIBRE;
        }
        else {
            estado = Estado.OCUPADO;
        }
    }
    public Estado getEstado(){
        return estado;
    }
    public void setEstado(Estado estado){
        this.estado = estado;
    }

}

