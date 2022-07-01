package co.com.example.logisticaproductos.domiciliario;
import co.com.example.logisticaproductos.domiciliario.commands.AgregarPuntajeCuentaDomiciliarioCommand;
import co.com.example.logisticaproductos.domiciliario.commands.CambiarMarcaVehiculoCommand;
import co.com.example.logisticaproductos.domiciliario.events.DomiciliarioCreado;
import co.com.example.logisticaproductos.domiciliario.events.MarcaVehiculoCambiada;
import co.com.example.logisticaproductos.domiciliario.events.PuntajeCuentaDomiciliarioAgregada;
import co.com.example.logisticaproductos.domiciliario.values.CuentaDomiciliarioId;
import co.com.example.logisticaproductos.domiciliario.values.DomiciliarioId;
import co.com.example.logisticaproductos.domiciliario.values.TipoDeVehiculo;
import co.com.example.logisticaproductos.domiciliario.values.VehiculoId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarPuntajeCuentaDomiciliarioUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AgregarPuntajeCuentaDomiciliarioUseCase usecase;

    @Test
    void AgregarPuntajeCuentaDomiciliario() {
        //arrange
        DomiciliarioId domiciliarioId = DomiciliarioId.of("1");
        CuentaDomiciliarioId cuentaDomiciliarioId = CuentaDomiciliarioId.of("1");
        var puntaje = 1;
        var command = new AgregarPuntajeCuentaDomiciliarioCommand(domiciliarioId,cuentaDomiciliarioId,puntaje);
        when(repository.getEventsBy(domiciliarioId.value())).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance().syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (PuntajeCuentaDomiciliarioAgregada)events.get(0);
        Assertions.assertEquals(1 , event.puntaje());

    }

    private List<DomainEvent> history() {
        VehiculoId vehiculoId = VehiculoId.of("1");
        TipoDeVehiculo tipoDeVehiculo = new TipoDeVehiculo("merce",20);
        CuentaDomiciliario cuentaDomiciliario =  new CuentaDomiciliario(new CuentaDomiciliarioId());
        return List.of(
                new DomiciliarioCreado(vehiculoId, tipoDeVehiculo, cuentaDomiciliario)
        );
    }

}