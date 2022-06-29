package co.com.example.logisticaproductos.cliente.events;

import co.com.example.logisticaproductos.cliente.values.ClienteId;
import co.com.example.logisticaproductos.cliente.values.CuentaId;
import co.com.example.logisticaproductos.cliente.values.Rol;
import co.com.sofka.domain.generic.DomainEvent;

public class RolCuentaCambiada extends DomainEvent {

    private final Rol rolCuenta;
    private final CuentaId cuentaId;

    public RolCuentaCambiada(CuentaId cuentaId, Rol rolCuenta) {
        super("co.com.sofka.logisticaproductos.RolCuentaCambiada");
        this.cuentaId = cuentaId;
        this.rolCuenta = rolCuenta;
    }

    public Rol getRolCuenta() {
        return rolCuenta;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }
}
