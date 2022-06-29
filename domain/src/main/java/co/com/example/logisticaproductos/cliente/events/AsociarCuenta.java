package co.com.example.logisticaproductos.cliente.events;

import co.com.example.logisticaproductos.cliente.Cuenta;
import co.com.sofka.domain.generic.DomainEvent;

public class AsociarCuenta extends DomainEvent {
    private final Cuenta cuenta;
    public AsociarCuenta(Cuenta cuenta) {
        super("co.com.sofka.logisticaproductos.asociarCuenta");
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}
