package co.edu.uniquindio.RepositorioHotel;

public class Habitacion {
    private final String numero;
    private final TipoHabitacion tipo;
    private final double precio;
    private Estado estado;
    private Cliente cliente;


    public enum TipoHabitacion {
        SIMPLE, DOBLE, SUITE
    }

    public enum Estado {
        LIBRE, OCUPADO
    }    

    public Habitacion(String numero, TipoHabitacion tipo, double precio){
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = Estado.LIBRE;
        this.cliente = null;

    }
    public String getNumero() {
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
        if (cliente != null){
            this.estado = Estado.OCUPADO;
        }
        else {
            this.estado = Estado.LIBRE;
        }
    }
    public Estado getEstado(){
        return estado;
    }
    public void setEstado(Estado estado){
        this.estado = estado;
    }

}

