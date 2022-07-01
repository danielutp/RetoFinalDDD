package co.com.example.logisticaproductos.pedido;
import co.com.example.logisticaproductos.domiciliario.events.CilindrajeVehiculoCambiado;
import co.com.example.logisticaproductos.pedido.services.EmailServicePedido;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

import java.util.List;

public class NotificarCambioDeCilindrajeUseCase extends UseCase<TriggeredEvent<CilindrajeVehiculoCambiado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CilindrajeVehiculoCambiado> cilindrajeVehiculoCambiadoTriggeredEvent) {

        var event = cilindrajeVehiculoCambiadoTriggeredEvent.getDomainEvent();

        var service = getService(EmailServicePedido.class).orElseThrow();

        String body = String.format("Su cilindraje cambio a %s", event.cilindraje());
        service.enviarCorreoPedido(event.id(), body);

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
