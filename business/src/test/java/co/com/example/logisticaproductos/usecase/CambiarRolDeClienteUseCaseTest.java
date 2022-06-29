package co.com.example.logisticaproductos.usecase;

import co.com.example.logisticaproductos.cliente.commands.CambiarRolCommand;
import co.com.example.logisticaproductos.cliente.events.ClienteCreado;
import co.com.example.logisticaproductos.cliente.events.RolCuentaCambiada;
import co.com.example.logisticaproductos.cliente.values.*;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CambiarRolDeClienteUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarRolDeClienteUseCase usecase;

    @Test
    void cambiarRol() {
        //arrange
        ClienteId clientId = ClienteId.of(ClienteId.Type.CC, "22123123");
        CuentaId cuentaId = CuentaId.of("fffff");
        String rol = "General";
        var command = new CambiarRolCommand(clientId, cuentaId, new Rol(rol));
        when(repository.getEventsBy(clientId.value())).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance().syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (RolCuentaCambiada)events.get(0);
        Assertions.assertEquals("General", event.getRolCuenta().value());

    }

    private List<DomainEvent> history() {
        Rol rol = new Rol("Usuario");
        CuentaId cuentaId = CuentaId.of("fffff");
        SuscripcionId suscripcionId = new SuscripcionId();
        TipoSuscripcion tipoSuscripcion = new TipoSuscripcion(30000, Boolean.FALSE);
        return List.of(
                new ClienteCreado(cuentaId, suscripcionId, tipoSuscripcion, rol)
        );
    }
}