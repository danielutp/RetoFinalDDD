package co.com.example.logisticaproductos.usecase;
import co.com.example.logisticaproductos.cliente.Cliente;
import co.com.example.logisticaproductos.cliente.commands.CambiarRolCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CambiarRolDeClienteUseCase extends UseCase<RequestCommand<CambiarRolCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarRolCommand> cambiarRolCommandRequestCommand) {

        var command = cambiarRolCommandRequestCommand.getCommand();
        var cliente = Cliente.from(
                command.getClienteId(), repository().getEventsBy(command.getClienteId().value())
        );

        cliente.cambiarRolCuenta(command.getCuentaId(), command.getRolCuenta());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));


    }
}
