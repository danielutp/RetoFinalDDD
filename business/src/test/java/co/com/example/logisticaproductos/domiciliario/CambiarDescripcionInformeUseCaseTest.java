package co.com.example.logisticaproductos.domiciliario;
import co.com.example.logisticaproductos.domiciliario.commands.CambiarDescripcionInformeCommand;
import co.com.example.logisticaproductos.domiciliario.events.DescripcionInformeCambiada;
import co.com.example.logisticaproductos.domiciliario.events.DomiciliarioCreado;
import co.com.example.logisticaproductos.domiciliario.events.InformeCreado;
import co.com.example.logisticaproductos.domiciliario.values.*;
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
class CambiarDescripcionInformeUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarDescripcionInformeUseCase usecase;

    @Test
    void cambiarDescripcionInformeCuentaDomiciliario() {
        //arrange
        DomiciliarioId domiciliarioId = DomiciliarioId.of("1");
        InformeId informeId = InformeId.of("1");
        Descripcion descripcion = new Descripcion("perdida");
        var command = new CambiarDescripcionInformeCommand(domiciliarioId, informeId, descripcion);
        when(repository.getEventsBy(domiciliarioId.value())).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance().syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (DescripcionInformeCambiada)events.get(0);
        Assertions.assertEquals("perdida" , event.descripcion().value());

    }

    private List<DomainEvent> history() {
        VehiculoId vehiculoId = VehiculoId.of("1");
        TipoDeVehiculo tipoDeVehiculo = new TipoDeVehiculo("merce",20);
        CuentaDomiciliario cuentaDomiciliario =  new CuentaDomiciliario(new CuentaDomiciliarioId());
        DomiciliarioId domiciliarioId = new DomiciliarioId();
        InformeId informeId = new InformeId();
        Descripcion descripcion = new Descripcion("perdida");
        return List.of(
                new DomiciliarioCreado(vehiculoId, tipoDeVehiculo, cuentaDomiciliario),
                new InformeCreado(domiciliarioId,informeId,descripcion)
        );
    }

}