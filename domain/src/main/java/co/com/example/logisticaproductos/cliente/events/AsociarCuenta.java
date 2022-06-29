package co.com.example.logisticaproductos.cliente.events;

import co.com.example.logisticaproductos.cliente.CuentaCliente;
import co.com.sofka.domain.generic.DomainEvent;

public class AsociarCuenta extends DomainEvent {
    private final CuentaCliente cuentaCliente;
    public AsociarCuenta(CuentaCliente cuentaCliente) {
        super("co.com.sofka.logisticaproductos.asociarCuenta");
        this.cuentaCliente = cuentaCliente;
    }

    public CuentaCliente getCuenta() {
        return cuentaCliente;
    }
}
