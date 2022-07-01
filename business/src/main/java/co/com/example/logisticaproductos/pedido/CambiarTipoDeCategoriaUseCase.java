package co.com.example.logisticaproductos.pedido;

import co.com.example.logisticaproductos.pedido.commands.CambiarTipoDeCategoriaCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CambiarTipoDeCategoriaUseCase extends UseCase<RequestCommand<CambiarTipoDeCategoriaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarTipoDeCategoriaCommand> cambiarTipoDeCategoriaCommandRequestCommand) {

    }
}
