package co.com.example.logisticaproductos.domiciliario.events;
import co.com.example.logisticaproductos.domiciliario.values.CuentaDomiciliarioId;
import co.com.example.logisticaproductos.domiciliario.values.DomiciliarioId;
import co.com.sofka.domain.generic.DomainEvent;

public class CuentaDomiciliarioCreada extends DomainEvent {
    private final DomiciliarioId id;
    private final CuentaDomiciliarioId cuentaDomiciliarioId;

    public CuentaDomiciliarioCreada(DomiciliarioId id, CuentaDomiciliarioId cuentaDomiciliarioId) {
        super("co.com.example.logisticaproductos.CuentaDomiciliarioCreada");
        this.id = id;
        this.cuentaDomiciliarioId = cuentaDomiciliarioId;
    }

    public DomiciliarioId getId() {
        return id;
    }

    public CuentaDomiciliarioId getCuentaDomiciliarioId() {
        return cuentaDomiciliarioId;
    }

}
