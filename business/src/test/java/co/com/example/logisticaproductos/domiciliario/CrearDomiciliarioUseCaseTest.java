package co.com.example.logisticaproductos.domiciliario;
import co.com.example.logisticaproductos.domiciliario.commands.CrearDomiciliarioCommand;
import co.com.example.logisticaproductos.domiciliario.events.DomiciliarioCreado;
import co.com.example.logisticaproductos.domiciliario.values.CuentaDomiciliarioId;
import co.com.example.logisticaproductos.domiciliario.values.DomiciliarioId;
import co.com.example.logisticaproductos.domiciliario.values.TipoDeVehiculo;
import co.com.example.logisticaproductos.domiciliario.values.VehiculoId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CrearDomiciliarioUseCaseTest {

    @InjectMocks
    CrearDomiciliarioUseCase useCase;

    @Test
    public void crearDomiciliario(){
        //arrange
        DomiciliarioId domiciliarioId = DomiciliarioId.of("1");
        VehiculoId vehiculoId = VehiculoId.of("1");
        CuentaDomiciliario cuentaDomiciliario = new CuentaDomiciliario(CuentaDomiciliarioId.of("c1"));
        TipoDeVehiculo tipoDeVehiculo = new TipoDeVehiculo("merce",20);
        var command = new CrearDomiciliarioCommand( domiciliarioId,  vehiculoId,  cuentaDomiciliario,  tipoDeVehiculo);


        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        var event = (DomiciliarioCreado)events.get(0);
        Assertions.assertEquals("merce", event.tipoDeVehiculo().value().marca());
    }
}