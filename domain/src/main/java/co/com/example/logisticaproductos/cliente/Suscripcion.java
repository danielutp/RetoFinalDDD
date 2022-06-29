package co.com.example.logisticaproductos.cliente;

import co.com.example.logisticaproductos.cliente.values.Beneficio;
import co.com.example.logisticaproductos.cliente.values.TipoSuscripcion;
import co.com.sofka.domain.generic.Entity;
import co.com.example.logisticaproductos.cliente.values.SuscripcionId;

import java.util.HashSet;
import java.util.Set;

public class Suscripcion extends Entity<SuscripcionId> {

    private TipoSuscripcion tipoSuscripcion;
    private Set<Beneficio> beneficios;

    public Suscripcion(SuscripcionId id, TipoSuscripcion tipoSuscripcion) {
        super(id);
        this.tipoSuscripcion = tipoSuscripcion;
        this.beneficios = new HashSet<>();
    }

    public void cambiarTipoDeSuscripcion(Integer valor,Boolean suscrito){
        this.tipoSuscripcion = tipoSuscripcion.cambiarSuscripcion(valor,suscrito);
    }

    public void agregarBeneficio(Beneficio beneficio){
        this.beneficios.add(beneficio);
    }
}
