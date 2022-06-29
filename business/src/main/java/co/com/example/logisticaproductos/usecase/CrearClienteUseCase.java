package co.com.example.logisticaproductos.usecase;

import co.com.example.logisticaproductos.cliente.Cliente;
import co.com.example.logisticaproductos.cliente.values.ClienteId;
import co.com.example.logisticaproductos.cliente.values.CuentaId;
import co.com.example.logisticaproductos.cliente.values.SuscripcionId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.example.logisticaproductos.cliente.commands.CrearClienteCommand;

public class CrearClienteUseCase extends UseCase<RequestCommand<CrearClienteCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearClienteCommand> crearClienteCommandRequestCommand) {
            var command = crearClienteCommandRequestCommand.getCommand();
            var cliente = new Cliente(
                    command.getClienteId(),
                    new CuentaId(),
                    new SuscripcionId(),
                    command.getRol(),
                    command.getTipoSuscripcion()
            );

            emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
