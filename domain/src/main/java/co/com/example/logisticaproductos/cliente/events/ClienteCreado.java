package co.com.example.logisticaproductos.cliente.events;

import co.com.example.logisticaproductos.cliente.Cuenta;
import co.com.example.logisticaproductos.cliente.Suscripcion;
import co.com.example.logisticaproductos.cliente.values.CuentaId;
import co.com.example.logisticaproductos.cliente.values.Rol;
import co.com.example.logisticaproductos.cliente.values.SuscripcionId;
import co.com.example.logisticaproductos.cliente.values.TipoSuscripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteCreado extends DomainEvent {


    private final CuentaId cuentaId;
    private final SuscripcionId suscripcionId;
    private final TipoSuscripcion tipoSuscripcion;
    private final Rol rol;


    public ClienteCreado(CuentaId cuentaId, SuscripcionId suscripcionId, TipoSuscripcion tipoSuscripcion, Rol rol) {
        super("co.com.sofka.logisticaproductos.ClienteCreado");
        this.cuentaId = cuentaId;
        this.suscripcionId = suscripcionId;
        this.tipoSuscripcion = tipoSuscripcion;
        this.rol = rol;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public SuscripcionId getSuscripcionId() {
        return suscripcionId;
    }

    public Rol getRol() {
        return rol;
    }

    public TipoSuscripcion getTipoSuscripcion() {
        return tipoSuscripcion;
    }
}
