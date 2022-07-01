package co.com.example.logisticaproductos.domiciliario;

import co.com.example.logisticaproductos.domiciliario.commands.AgregarPuntajeCuentaDomiciliarioCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarPuntajeCuentaDomiciliarioUseCase extends UseCase<RequestCommand<AgregarPuntajeCuentaDomiciliarioCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPuntajeCuentaDomiciliarioCommand> agregarPuntajeCuentaDomiciliarioCommandRequestCommand) {
        var command = agregarPuntajeCuentaDomiciliarioCommandRequestCommand.getCommand();
        var domiciliario = Domiciliario.from(
                command.domiciliarioId(), repository().getEventsBy(command.cuentaDomiciliarioId().value())
        );

        domiciliario.agregarPuntuacionCuentaDomiciliarion(command.cuentaDomiciliarioId(), command.puntaje());

        emit().onResponse(new ResponseEvents(domiciliario.getUncommittedChanges()));

    }
}
