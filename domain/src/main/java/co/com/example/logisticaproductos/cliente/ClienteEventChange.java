package co.com.example.logisticaproductos.cliente;
import co.com.sofka.domain.generic.EventChange;
import co.com.example.logisticaproductos.cliente.events.AsociarCuenta;
import co.com.example.logisticaproductos.cliente.events.ClienteCreado;
import co.com.example.logisticaproductos.cliente.events.RolCuentaCambiada;
import co.com.example.logisticaproductos.cliente.events.TipoDeSuscripcionCambiada;

public class ClienteEventChange extends EventChange {
         public ClienteEventChange(Cliente cliente) {

            apply((ClienteCreado event) ->{
                cliente.cuenta = new Cuenta(event.getCuentaId(), event.getRol());
                cliente.suscripcion= new Suscripcion(event.getSuscripcionId(), event.getTipoSuscripcion());
                cliente.datosUsuario = null;
            });

            apply((AsociarCuenta event) ->{
                cliente.cuenta = event.getCuenta();
            });

            apply((RolCuentaCambiada event) ->{
                if(!cliente.cuenta.identity().equals(event.getCuentaId())){
                    throw new IllegalArgumentException("La cuenta no existe para este identificador");
                }
                cliente.cuenta.cambiarRol(event.getRolCuenta());
            });

             apply((TipoDeSuscripcionCambiada event) ->{
                 cliente.suscripcion.cambiarTipoDeSuscripcion(event.getValor(),event.getTipoSuscripcion());
             });

         }
}