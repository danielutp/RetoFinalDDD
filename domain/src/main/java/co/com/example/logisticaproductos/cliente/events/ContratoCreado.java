package co.com.example.logisticaproductos.cliente.events;
import co.com.example.logisticaproductos.cliente.values.ContratoId;
import co.com.example.logisticaproductos.cliente.values.CuentaId;
import co.com.example.logisticaproductos.cliente.values.Detalle;
import co.com.sofka.domain.generic.DomainEvent;

public class ContratoCreado extends DomainEvent {

    private final CuentaId cuentaId;
    private final ContratoId contratoId;
    private final Detalle detalle;

    public ContratoCreado(CuentaId cuentaId, ContratoId contratoId, Detalle detalle) {
        super("co.com.example.logisticaproductos.ContratoCreado");
        this.cuentaId = cuentaId;
        this.contratoId = contratoId;
        this.detalle = detalle;
    }

    public CuentaId cuentaId() {
        return cuentaId;
    }

    public ContratoId contratoId() {
        return contratoId;
    }

    public Detalle detalle() {
        return detalle;
    }
}