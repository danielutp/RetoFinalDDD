package co.com.example.logisticaproductos.pedido;
import co.com.example.logisticaproductos.pedido.commands.CambiarValorFacturaCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CambiarValorFacturaUseCase extends UseCase<RequestCommand<CambiarValorFacturaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarValorFacturaCommand> cambiarValorFacturaCommandRequestCommand) {
        var command = cambiarValorFacturaCommandRequestCommand.getCommand();
        var pedido = Pedido.from(
                command.pedidoId(), repository().getEventsBy(command.facturaId().value())
        );

        pedido.cambiarValorFactura(command.facturaId(), command.valor());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
