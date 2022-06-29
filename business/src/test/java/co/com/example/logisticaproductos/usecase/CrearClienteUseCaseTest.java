package co.com.example.logisticaproductos.usecase;

import co.com.example.logisticaproductos.cliente.commands.CrearClienteCommand;
import co.com.example.logisticaproductos.cliente.events.ClienteCreado;
import co.com.example.logisticaproductos.cliente.values.*;
import co.com.example.logisticaproductos.usecase.CrearClienteUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearClienteUseCaseTest {

    @InjectMocks
    CrearClienteUseCase useCase;

    @Test
    public void crearCliente(){
        //arrange
        ClienteId clienteId = ClienteId.of(ClienteId.Type.CC, "32212234");
        DatosUsuario datosUsuario = new DatosUsuario("Raul", 322123, "Buga", "calle 433#asd");
        Rol rol = new Rol("Usuario");
        TipoSuscripcion tipoSuscripcion = new TipoSuscripcion(30000, Boolean.FALSE);
        var command = new CrearClienteCommand( clienteId,  datosUsuario,  rol,  tipoSuscripcion);


        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        var event = (ClienteCreado)events.get(0);
        Assertions.assertEquals("Usuario", event.getRol().value());
        Assertions.assertEquals("Usuario", event.getRol().value());

    }
}