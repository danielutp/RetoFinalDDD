package co.com.example.logisticaproductos.usecase;

import co.com.example.logisticaproductos.cliente.Cliente;
import co.com.example.logisticaproductos.cliente.events.TipoDeSuscripcionCambiada;
import co.com.example.logisticaproductos.cliente.values.ClienteId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

import java.util.List;

public class NotificarCambioDeSubscripcionUseCase extends UseCase<TriggeredEvent<TipoDeSuscripcionCambiada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<TipoDeSuscripcionCambiada> tipoDeSuscripcionCambiadaTriggeredEvent) {
        var event = tipoDeSuscripcionCambiadaTriggeredEvent.getDomainEvent();


        /*
        var cuenta = Cuenta.from(
                event.getCuentaId(),
                repository().getEventsBy(event.getCuentaId().value())
        );*/

        var service = getService(EmailService.class).orElseThrow();

        String body = String.format("Su subscripción cambio a %s", event.getValor());
        service.enviarCorreo(event.getId(), body);

        emit().onResponse(new ResponseEvents(List.of()));


    }
}
