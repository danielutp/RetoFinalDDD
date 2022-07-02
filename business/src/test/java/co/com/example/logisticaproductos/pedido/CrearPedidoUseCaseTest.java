package co.com.example.logisticaproductos.pedido;
import co.com.example.logisticaproductos.domiciliario.values.DomiciliarioId;
import co.com.example.logisticaproductos.pedido.commands.CrearPedidoCommand;
import co.com.example.logisticaproductos.pedido.events.PedidoCreado;
import co.com.example.logisticaproductos.pedido.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.example.logisticaproductos.pedido.values.ClienteId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CrearPedidoUseCaseTest {

    @InjectMocks
    CrearPedidoUseCase useCase;

    @Test
    public void crearPedido() {
        //arrange
        PedidoId pedidoId = PedidoId.of("1");
        ProveedorId proveedorId = ProveedorId.of("1");
        Producto producto = new Producto("leche", "lactios");
        FacturaId facturaId = FacturaId.of("1");
        Valor valor = new Valor(1);
        CategoriaId categoriaId = CategoriaId.of("1");
        TipoDeCategoria tipoDeCategoria = new TipoDeCategoria("bla", "blabla");
        MedioDePago medioDePago = new MedioDePago("a", 2);
        DomiciliarioId domiciliarioId = DomiciliarioId.of("1");
        ClienteId clienteId = ClienteId.of("1");
        var command = new CrearPedidoCommand(pedidoId, proveedorId, producto, facturaId, valor, categoriaId, tipoDeCategoria, medioDePago,domiciliarioId,clienteId);


        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        var event = (PedidoCreado) events.get(0);
        Assertions.assertEquals("leche", event.producto().value().nombre());
    }
}
