package co.com.example.logisticaproductos.domiciliario.commands;

import co.com.example.logisticaproductos.domiciliario.values.Descripcion;
import co.com.example.logisticaproductos.domiciliario.values.DomiciliarioId;
import co.com.example.logisticaproductos.domiciliario.values.InformeId;
import co.com.sofka.domain.generic.Command;

public class CambiarDescripcionInformeCommand extends Command {
    private final DomiciliarioId domiciliarioId;
    private final InformeId informeId;
    private final Descripcion descripcion;

    public CambiarDescripcionInformeCommand(DomiciliarioId domiciliarioId, InformeId informeId, Descripcion descripcion) {
        this.domiciliarioId = domiciliarioId;
        this.informeId = informeId;
        this.descripcion = descripcion;
    }

    public InformeId informeId() {
        return informeId;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public DomiciliarioId domiciliarioId() {
        return domiciliarioId;
    }
}
