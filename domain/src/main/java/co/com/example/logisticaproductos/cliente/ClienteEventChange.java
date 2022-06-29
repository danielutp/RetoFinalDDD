package co.com.example.logisticaproductos.cliente;
import co.com.example.logisticaproductos.cliente.events.*;
import co.com.sofka.domain.generic.EventChange;

public class ClienteEventChange extends EventChange {
         public ClienteEventChange(Cliente cliente) {

            apply((ClienteCreado event) ->{
                cliente.cuentaCliente = new CuentaCliente(event.getCuentaId(), event.getRol());
                cliente.suscripcion= new Suscripcion(event.getSuscripcionId(), event.getTipoSuscripcion());
                cliente.datosUsuario = null;
            });

             apply((ContratoCreado event) ->{
                 cliente.contrato = new Contrato(event.getContratoId(),event.getDetalle());
             });

            apply((AsociarCuenta event) ->{
                cliente.cuentaCliente = event.getCuenta();
            });

            apply((RolCuentaCambiada event) ->{
                if(!cliente.cuentaCliente.identity().equals(event.getCuentaId())){
                    throw new IllegalArgumentException("La cuenta no existe para este identificador");
                }
                cliente.cuentaCliente.cambiarRol(event.getRolCuenta());
            });

             apply((TipoDeSuscripcionCambiada event) ->{
                 cliente.suscripcion.cambiarTipoDeSuscripcion(event.getValor(),event.getTipoSuscripcion());
             });

         }
}