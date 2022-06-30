package co.com.example.logisticaproductos.cliente;
import co.com.example.logisticaproductos.cliente.events.*;
import co.com.sofka.domain.generic.EventChange;

public class ClienteEventChange extends EventChange {
         public ClienteEventChange(Cliente cliente) {

            apply((ClienteCreado event) ->{
                cliente.cuentaCliente = new CuentaCliente(event.cuentaId(), event.rol());
                cliente.suscripcion= new Suscripcion(event.suscripcionId(), event.tipoSuscripcion());
                cliente.datosUsuario = null;
            });

             apply((ContratoCreado event) ->{
                 cliente.contrato = new Contrato(event.contratoId(),event.detalle());
             });

            apply((AsociarCuenta event) ->{
                cliente.cuentaCliente = event.cuenta();
            });

            apply((RolCuentaCambiada event) ->{
                if(!cliente.cuentaCliente.identity().equals(event.cuentaId())){
                    throw new IllegalArgumentException("La cuenta no existe para este identificador");
                }
                cliente.cuentaCliente.cambiarRol(event.rolCuenta());
            });

             apply((TipoDeSuscripcionCambiada event) ->{
                 cliente.suscripcion.cambiarTipoDeSuscripcion(event.valor(),event.tipoSuscripcion());
             });

         }
}