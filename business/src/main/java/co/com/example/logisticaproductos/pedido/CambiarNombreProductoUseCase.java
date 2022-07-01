package co.com.example.logisticaproductos.pedido;
import co.com.example.logisticaproductos.pedido.commands.CambiarNombreProductoCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CambiarNombreProductoUseCase extends UseCase<RequestCommand<CambiarNombreProductoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarNombreProductoCommand> cambiarNombreProductoCommandRequestCommand) {
        var command = cambiarNombreProductoCommandRequestCommand.getCommand();
        var pedido = Pedido.from(
                command.pedidoId(), repository().getEventsBy(command.proveedorId().value())
        );

        pedido.cambiarNombreProducto(command.proveedorId(), command.producto());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}