package co.com.example.logisticaproductos.pedido;
import co.com.example.logisticaproductos.pedido.events.NombreProductoCambiado;
import co.com.example.logisticaproductos.pedido.events.NombreTipoDeCategoriaCambiado;
import co.com.example.logisticaproductos.pedido.events.PedidoCreado;
import co.com.example.logisticaproductos.pedido.events.ValorFacturaCambiado;
import co.com.sofka.domain.generic.EventChange;

public class PedidoEventChange extends EventChange {
    public PedidoEventChange(Pedido pedido) {
        apply((PedidoCreado event) ->{
            pedido.categoria = new Categoria(event.categoriaId(),event.tipoDeCategoria());
            pedido.factura = new Factura(event.facturaId(),event.valor());
            pedido.proveedor = new Proveedor(event.proveedorId(),event.producto());
            pedido.medioDePago = null;
        });

        apply((NombreProductoCambiado event) ->{
            pedido.proveedor.cambiarNombreProducto(event.producto());
        });

        apply((NombreTipoDeCategoriaCambiado event) ->{
            pedido.categoria.cambiarTipoDeCategoria(event.tipoDeCategoria());
        });

        apply((ValorFacturaCambiado event) ->{
            pedido.factura.cambiarValorFactura(event.valor());
        });

    }
}
