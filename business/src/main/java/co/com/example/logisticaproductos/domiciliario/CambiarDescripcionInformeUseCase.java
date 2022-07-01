package co.com.example.logisticaproductos.domiciliario;

import co.com.example.logisticaproductos.domiciliario.commands.CambiarDescripcionInformeCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CambiarDescripcionInformeUseCase extends UseCase<RequestCommand<CambiarDescripcionInformeCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarDescripcionInformeCommand> cambiarDescripcionInformeCommandRequestCommand) {
        var command = cambiarDescripcionInformeCommandRequestCommand.getCommand();
        var domiciliario = Domiciliario.from(
                command.domiciliarioId(), repository().getEventsBy(command.domiciliarioId().value())
        );

        domiciliario.cambiarDescripcionInforme(command.informeId(), command.descripcion());

        emit().onResponse(new ResponseEvents(domiciliario.getUncommittedChanges()));


    }
}
