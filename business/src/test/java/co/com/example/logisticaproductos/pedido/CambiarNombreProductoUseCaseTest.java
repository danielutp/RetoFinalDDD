package co.com.example.logisticaproductos.pedido;
import co.com.example.logisticaproductos.domiciliario.values.DomiciliarioId;
import co.com.example.logisticaproductos.pedido.commands.CambiarNombreProductoCommand;
import co.com.example.logisticaproductos.pedido.events.NombreProductoCambiado;
import co.com.example.logisticaproductos.pedido.events.PedidoCreado;
import co.com.example.logisticaproductos.pedido.values.*;
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
class CambiarNombreProductoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarNombreProductoUseCase usecase;

    @Test
    void cambiarNombreProducto() {
        //arrange
        PedidoId pedidoId = PedidoId.of("1");
        ProveedorId proveedorId = ProveedorId.of("1");
        Producto producto = new Producto("ee","prueba");
        var command = new CambiarNombreProductoCommand(pedidoId, proveedorId, producto);
        when(repository.getEventsBy(pedidoId.value())).thenReturn(history());
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance().syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (NombreProductoCambiado)events.get(0);
        Assertions.assertEquals("prueba" , event.producto().value().tipoDeProducto());

    }

    private List<DomainEvent> history() {
        ProveedorId proveedorId = ProveedorId.of("1");
        Producto producto = new Producto("leche", "lactios");
        FacturaId facturaId = FacturaId.of("1");
        Valor valor = new Valor(1);
        CategoriaId categoriaId = CategoriaId.of("1");
        TipoDeCategoria tipoDeCategoria = new TipoDeCategoria("bla", "blabla");
        MedioDePago medioDePago = new MedioDePago("a", 2);
        DomiciliarioId domiciliarioId = DomiciliarioId.of("1");
        ClienteId clienteId = ClienteId.of("1");
        return List.of(
                new PedidoCreado( proveedorId, producto, facturaId,valor,categoriaId,tipoDeCategoria,medioDePago,domiciliarioId,clienteId)
        );
    }

}