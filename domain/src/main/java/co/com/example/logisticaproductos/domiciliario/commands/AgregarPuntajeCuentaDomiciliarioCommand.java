package co.com.example.logisticaproductos.domiciliario.commands;

import co.com.example.logisticaproductos.domiciliario.values.CuentaDomiciliarioId;
import co.com.example.logisticaproductos.domiciliario.values.DomiciliarioId;
import co.com.sofka.domain.generic.Command;

public class AgregarPuntajeCuentaDomiciliarioCommand extends Command {
    private final DomiciliarioId domiciliarioId;
    private final CuentaDomiciliarioId cuentaDomiciliarioId;
    private final Integer puntaje;

    public AgregarPuntajeCuentaDomiciliarioCommand(DomiciliarioId domiciliarioId, CuentaDomiciliarioId cuentaDomiciliarioId, Integer puntaje) {
        this.domiciliarioId = domiciliarioId;
        this.cuentaDomiciliarioId = cuentaDomiciliarioId;
        this.puntaje = puntaje;
    }

    public DomiciliarioId domiciliarioId() {
        return domiciliarioId;
    }

    public CuentaDomiciliarioId cuentaDomiciliarioId() {
        return cuentaDomiciliarioId;
    }

    public Integer puntaje() {
        return puntaje;
    }
}
