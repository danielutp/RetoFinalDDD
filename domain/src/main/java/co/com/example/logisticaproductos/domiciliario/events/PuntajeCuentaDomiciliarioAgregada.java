package co.com.example.logisticaproductos.domiciliario.events;
import co.com.example.logisticaproductos.domiciliario.values.CuentaDomiciliarioId;
import co.com.sofka.domain.generic.DomainEvent;

public class PuntajeCuentaDomiciliarioAgregada extends DomainEvent {
    private final CuentaDomiciliarioId cuentaDomiciliarioId;
    private final Integer puntaje;

    public PuntajeCuentaDomiciliarioAgregada(CuentaDomiciliarioId cuentaDomiciliarioId, Integer puntaje) {
        super("co.com.example.logisticaproductos.PuntajeCuentaDomiciliarioAgregada");
        this.cuentaDomiciliarioId = cuentaDomiciliarioId;
        this.puntaje = puntaje;
    }

    public CuentaDomiciliarioId cuentaDomiciliarioId() {
        return cuentaDomiciliarioId;
    }

    public Integer puntaje() {
        return puntaje;
    }
}
