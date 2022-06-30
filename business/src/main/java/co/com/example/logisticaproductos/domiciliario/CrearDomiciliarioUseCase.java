package co.com.example.logisticaproductos.domiciliario;
import co.com.example.logisticaproductos.domiciliario.commands.CrearDomiciliarioCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearDomiciliarioUseCase extends UseCase<RequestCommand<CrearDomiciliarioCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearDomiciliarioCommand> crearDomiciliarioCommandRequestCommand) {
        var command = crearDomiciliarioCommandRequestCommand.getCommand();
        var domiciliario = new Domiciliario(
                command.getDomiciliarioId(),
                command.getVehiculoId(),
                command.getTipoDeVehiculo(),
                command.getCuentaDomiciliario()
        );
        emit().onResponse(new ResponseEvents(domiciliario.getUncommittedChanges()));
    }
}
