package co.com.example.logisticaproductos.cliente;
import co.com.example.logisticaproductos.cliente.events.*;
import co.com.example.logisticaproductos.cliente.values.*;
import co.com.example.logisticaproductos.pedido.values.PedidoId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Cliente extends AggregateEvent<ClienteId> {

    protected DatosUsuario datosUsuario;
    protected  Contrato contrato;
    protected CuentaCliente cuentaCliente;
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

    public void crearContrato(CuentaId cuentaId,ContratoId contratoId,Detalle detalle){
        appendChange(new ContratoCreado(cuentaId,contratoId,detalle)).apply();
    }

    public void asociarCuenta(CuentaCliente cuentaCliente){
        appendChange(new AsociarCuenta(cuentaCliente)).apply();
    }

    public void cambiarRolCuenta(CuentaId cuentaId,Rol rolCuenta){
        appendChange(new RolCuentaCambiada(cuentaId, rolCuenta)).apply();
    }

    public void cambiarValorDeSuscripcion(ClienteId id,Integer valor, boolean tipoSuscripcionCuenta){
        appendChange(new TipoDeSuscripcionCambiada(id, valor ,tipoSuscripcionCuenta)).apply();
    }

    public static Cliente from(ClienteId id, List<DomainEvent> events){
        var cliente = new Cliente((id));
        events.forEach(cliente::applyEvent);
        return cliente;
    }

}