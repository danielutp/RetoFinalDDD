package co.com.example.logisticaproductos.pedido;
import co.com.example.logisticaproductos.pedido.commands.CrearPedidoCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearPedidoUseCase extends UseCase<RequestCommand<CrearPedidoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPedidoCommand> crearPedidoCommandRequestCommand) {
        var command = crearPedidoCommandRequestCommand.getCommand();
        var pedido = new Pedido(
                command.id(),
                command.proveedorId(),
                command.producto(),
                command.facturaId(),
                command.valor(),
                command.categoriaId(),
                command.tipoDeCategoria(),
                command.medioDePago()
        );
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
