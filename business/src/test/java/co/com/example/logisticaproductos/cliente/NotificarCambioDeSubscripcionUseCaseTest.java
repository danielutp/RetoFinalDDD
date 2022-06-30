package co.com.example.logisticaproductos.cliente;

import co.com.example.logisticaproductos.cliente.events.TipoDeSuscripcionCambiada;
import co.com.example.logisticaproductos.cliente.services.EmailService;
import co.com.example.logisticaproductos.cliente.values.ClienteId;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NotificarCambioDeSubscripcionUseCaseTest {
    @Mock
    EmailService service;

    @InjectMocks
    NotificarCambioDeSubscripcionUseCase usecase;

    @Test
    void enviarCorreo(){
        var event = new TipoDeSuscripcionCambiada(ClienteId.of("CC-12312312"), 300000, Boolean.FALSE);
        Mockito.doNothing().when(service).enviarCorreo(ClienteId.of("CC-12312312"), "Su subscripción cambio a 300000");
        usecase.addServiceBuilder(new ServiceBuilder().addService(service));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        Mockito.verify(service).enviarCorreo(ClienteId.of("CC-12312312"), "Su subscripción cambio a 300000");
        Assertions.assertEquals(0, events.size());
    }

}