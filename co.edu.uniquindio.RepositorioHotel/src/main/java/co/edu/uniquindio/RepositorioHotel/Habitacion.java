package co.edu.uniquindio.RepositorioHotel;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Habitacion {
    private final String numero;
    private final TipoHabitacion tipo;
    private final double precio;
    private Estado estado;
    private Cliente cliente;
    private final Collection <Servicio> servicios;

    public Habitacion(String numero, TipoHabitacion tipo, double precio){
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = Estado.LIBRE;
        this.cliente = null;
        this.servicios = new LinkedList<>();

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

    public void addServicio(Servicio servicio){
        servicios.add(servicio);
    }
    public Estado getEstado(){
        return estado;
    }
    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public Collection <Servicio> getServicios(){
        return Collections.unmodifiableCollection(servicios);
    }

}

