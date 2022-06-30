package co.com.example.logisticaproductos.pedido;
import co.com.example.logisticaproductos.cliente.Contrato;
import co.com.example.logisticaproductos.cliente.events.ContratoCreado;
import co.com.example.logisticaproductos.pedido.events.NombreProductoCambiado;
import co.com.example.logisticaproductos.pedido.events.NombreTipoDeCategoriaCambiado;
import co.com.example.logisticaproductos.pedido.events.PedidoCreado;
import co.com.example.logisticaproductos.pedido.events.ValorFacturaCambiado;
import co.com.sofka.domain.generic.EventChange;

public class PedidoEventChange extends EventChange {
    public PedidoEventChange(Pedido pedido) {
        apply((PedidoCreado event) ->{
            pedido.categoria = new Categoria(event.getCategoriaId(),event.getTipoDeCategoria());
            pedido.factura = new Factura(event.getFacturaId(),event.getValor());
            pedido.proveedor = new Proveedor(event.getProveedorId(),event.getProducto());
            pedido.medioDePago = null;
        });

        apply((NombreProductoCambiado event) ->{
            pedido.proveedor.cambiarNombreProducto(event.getProducto());
        });

        apply((NombreTipoDeCategoriaCambiado event) ->{
            pedido.categoria.cambiarTipoDeCategoria(event.getTipoDeCategoria());
        });

        apply((ValorFacturaCambiado event) ->{
            pedido.factura.cambiarValorFactura(event.getValor());
        });

    }
}
