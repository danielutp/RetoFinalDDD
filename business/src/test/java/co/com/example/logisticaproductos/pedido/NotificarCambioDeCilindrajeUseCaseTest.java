package co.com.example.logisticaproductos.pedido;
import co.com.example.logisticaproductos.domiciliario.events.CilindrajeVehiculoCambiado;
import co.com.example.logisticaproductos.domiciliario.values.TipoDeVehiculo;
import co.com.example.logisticaproductos.domiciliario.values.VehiculoId;
import co.com.example.logisticaproductos.pedido.services.EmailServicePedido;
import co.com.example.logisticaproductos.pedido.values.PedidoId;
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
class NotificarCambioDeCilindrajeUseCaseTest {
    @Mock
    EmailServicePedido service;

    @InjectMocks
    NotificarCambioDeCilindrajeUseCase usecase;

    @Test
    void enviarCorreoPedido(){
        VehiculoId vehiculoId = new VehiculoId();
        TipoDeVehiculo tipoDeVehiculo = new TipoDeVehiculo("m",1);
        var event = new CilindrajeVehiculoCambiado(PedidoId.of("1"), "vehiculoId" ,1);
        Mockito.doNothing().when(service).enviarCorreoPedido(PedidoId.of("1"), "Su cilindraje cambio a 1");
        usecase.addServiceBuilder(new ServiceBuilder().addService(service));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        Mockito.verify(service).enviarCorreoPedido(PedidoId.of("1"), "Su cilindraje cambio a 1");
        Assertions.assertEquals(0, events.size());
    }
}