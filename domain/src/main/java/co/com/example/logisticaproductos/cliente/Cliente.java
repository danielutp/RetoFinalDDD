package co.com.example.logisticaproductos.cliente;
import co.com.example.logisticaproductos.cliente.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.example.logisticaproductos.cliente.events.AsociarCuenta;
import co.com.example.logisticaproductos.cliente.events.ClienteCreado;
import co.com.example.logisticaproductos.cliente.events.RolCuentaCambiada;
import co.com.example.logisticaproductos.cliente.events.TipoDeSuscripcionCambiada;

import java.util.List;

public class Cliente extends AggregateEvent<ClienteId> {

    protected DatosUsuario datosUsuario;
    protected Cuenta cuenta;
    protected Suscripcion suscripcion;


    public Cliente(ClienteId clienteId, CuentaId cuentaId, SuscripcionId suscripcionId, Rol rol,TipoSuscripcion tipoSuscripcion) {
        super(clienteId);
        appendChange(new ClienteCreado(cuentaId,suscripcionId, tipoSuscripcion, rol)).apply();
        subscribe(new ClienteEventChange(this));
    }

    private Cliente(ClienteId id) {
        super(id);
        subscribe(new ClienteEventChange(this));
    }

    public void asociarCuenta(Cuenta cuenta){
        appendChange(new AsociarCuenta(cuenta)).apply();

    }

    public void cambiarRolCuenta(CuentaId cuentaId,Rol rolCuenta){
        appendChange(new RolCuentaCambiada(cuentaId, rolCuenta)).apply();
    }

    public void cambiarTipoDeSuscripcion(ClienteId id,Integer valor, boolean tipoSuscripcionCuenta){
        appendChange(new TipoDeSuscripcionCambiada(id, valor ,tipoSuscripcionCuenta)).apply();
    }


    public static Cliente from(ClienteId id, List<DomainEvent> events){
        var cliente = new Cliente((id));
        events.forEach(cliente::applyEvent);
        return cliente;
    }

}