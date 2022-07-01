package co.com.example.logisticaproductos.cliente;
import co.com.example.logisticaproductos.cliente.values.ContratoId;
import co.com.example.logisticaproductos.cliente.values.Detalle;
import co.com.sofka.domain.generic.Entity;
public class Contrato extends Entity<ContratoId> {
    private Detalle detalle;

    public Contrato(ContratoId id,Detalle detalle) {
        super(id);
        this.detalle = detalle;
    }



}
