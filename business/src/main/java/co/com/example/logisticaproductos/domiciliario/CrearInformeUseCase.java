package co.com.example.logisticaproductos.domiciliario;
import co.com.example.logisticaproductos.domiciliario.commands.AsociarInformeCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearInformeUseCase extends UseCase<RequestCommand<AsociarInformeCommand>,ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsociarInformeCommand> asociarInformeCommandRequestCommand) {
        var command = asociarInformeCommandRequestCommand.getCommand();
       // var domiciliario = new Domiciliario(
       // );
       // emit().onResponse(new ResponseEvents(domiciliario.getUncommittedChanges()));
    }
}
