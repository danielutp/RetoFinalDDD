package co.com.example.logisticaproductos.domiciliario.events;

import co.com.example.logisticaproductos.domiciliario.values.Descripcion;
import co.com.example.logisticaproductos.domiciliario.values.DomiciliarioId;
import co.com.example.logisticaproductos.domiciliario.values.InformeId;
import co.com.sofka.domain.generic.DomainEvent;

public class InformeCreado extends DomainEvent {
    private final DomiciliarioId id;
    private final InformeId informeId;
    private final Descripcion descripcion;

    public InformeCreado(DomiciliarioId id, InformeId informeId, Descripcion descripcion) {
        super("co.com.example.logisticaproductos.InformeCreado");
        this.id = id;
        this.informeId = informeId;
        this.descripcion = descripcion;
    }

    public DomiciliarioId id() {
        return id;
    }

    public InformeId informeId() {
        return informeId;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
