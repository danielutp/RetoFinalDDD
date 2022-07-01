package co.com.example.logisticaproductos.pedido.commands;
import co.com.example.logisticaproductos.pedido.values.PedidoId;
import co.com.example.logisticaproductos.pedido.values.Producto;
import co.com.example.logisticaproductos.pedido.values.ProveedorId;
import co.com.sofka.domain.generic.Command;

public class CambiarNombreProductoCommand extends Command {

    private final PedidoId pedidoId;
    private final ProveedorId proveedorId;
    private final Producto producto;

    public CambiarNombreProductoCommand(PedidoId pedidoId, ProveedorId proveedorId, Producto producto) {
        this.pedidoId = pedidoId;
        this.proveedorId = proveedorId;
        this.producto = producto;
    }

    public Producto producto() {
        return producto;
    }

    public ProveedorId proveedorId() {
        return proveedorId;
    }

    public PedidoId pedidoId() {
        return pedidoId;
    }
}
