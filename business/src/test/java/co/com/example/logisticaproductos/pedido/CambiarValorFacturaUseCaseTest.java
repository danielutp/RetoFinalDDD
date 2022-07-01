package co.com.example.logisticaproductos.pedido;
import co.com.example.logisticaproductos.pedido.commands.CambiarValorFacturaCommand;
import co.com.example.logisticaproductos.pedido.events.PedidoCreado;
import co.com.example.logisticaproductos.pedido.events.ValorFacturaCambiado;
import co.com.example.logisticaproductos.pedido.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.mockito.Mockito.when;


    @ExtendWith(MockitoExtension.class)
    class CambiarValorFacturaUseCaseTest {

        @Mock
        DomainEventRepository repository;

        @InjectMocks
        CambiarValorFacturaUseCase usecase;

        @Test
        void cambiarRol() {
            //arrange
            PedidoId pedidoId = PedidoId.of("1");
            FacturaId facturaId = FacturaId.of("1");
            Valor valor = new Valor(2);
            var command = new CambiarValorFacturaCommand(pedidoId, facturaId, valor);
            when(repository.getEventsBy(pedidoId.value())).thenReturn(history());
            usecase.addRepository(repository);

            //act
            var events = UseCaseHandler
                    .getInstance().syncExecutor(usecase, new RequestCommand<>(command))
                    .orElseThrow()
                    .getDomainEvents();

            //assert
            var event = (ValorFacturaCambiado)events.get(0);
            // Assertions.assertEquals(1 , event.valor());

        }

        private List<DomainEvent> history() {
            PedidoId pedidoId = PedidoId.of("1");
            ProveedorId proveedorId = ProveedorId.of("1");
            Producto producto = new Producto("leche", "lactios");
            FacturaId facturaId = FacturaId.of("1");
            Valor valor = new Valor(1);
            CategoriaId categoriaId = CategoriaId.of("1");
            TipoDeCategoria tipoDeCategoria = new TipoDeCategoria("bla", "blabla");
            MedioDePago medioDePago = new MedioDePago("a", 2);
            return List.of(
                    new PedidoCreado( proveedorId, producto, facturaId,valor,categoriaId,tipoDeCategoria,medioDePago)
            );
        }
    }