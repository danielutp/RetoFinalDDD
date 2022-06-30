package co.com.example.logisticaproductos.pedido;
import co.com.example.logisticaproductos.pedido.events.CategoriaCreada;
import co.com.example.logisticaproductos.pedido.events.FacturaCreada;
import co.com.example.logisticaproductos.pedido.events.PedidoCreado;
import co.com.example.logisticaproductos.pedido.events.ProveedorCreado;
import co.com.sofka.domain.generic.EventChange;

public class PedidoEventChange extends EventChange {
    public PedidoEventChange(Pedido pedido) {
        apply((PedidoCreado event) ->{
            pedido.categoria = new Categoria(event.getCategoriaId(),event.getTipoDeCategoria());
            pedido.factura = new Factura(event.getFacturaId(),event.getValor());
            pedido.proveedor = new Proveedor(event.getProveedorId(),event.getProducto());
            pedido.medioDePago = null;
        });

        apply((FacturaCreada event) ->{
            pedido.factura = new Factura(event.getFacturaId(),event.getValor());
        });

        apply((ProveedorCreado event) ->{
            pedido.proveedor = new Proveedor(event.getProveedorId(),event.getProducto());
        });

        apply((CategoriaCreada event) ->{
            pedido.categoria = new Categoria(event.getCategoriaId(),event.getTipoDeCategoria());
        });
    }
}
