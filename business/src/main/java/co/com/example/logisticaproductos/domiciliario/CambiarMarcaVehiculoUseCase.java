package co.com.example.logisticaproductos.domiciliario;
import co.com.example.logisticaproductos.domiciliario.commands.CambiarMarcaVehiculoCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CambiarMarcaVehiculoUseCase extends UseCase<RequestCommand<CambiarMarcaVehiculoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarMarcaVehiculoCommand> cambiarMarcaVehiculoCommandRequestCommand) {
        var command = cambiarMarcaVehiculoCommandRequestCommand.getCommand();
        var domiciliario = Domiciliario.from(
                command.domiciliarioId(), repository().getEventsBy(command.domiciliarioId().value())
        );

        domiciliario.cambiarMarcaVehiculo(command.vehiculoId(), command.tipoDeVehiculo());

        emit().onResponse(new ResponseEvents(domiciliario.getUncommittedChanges()));

    }
}
