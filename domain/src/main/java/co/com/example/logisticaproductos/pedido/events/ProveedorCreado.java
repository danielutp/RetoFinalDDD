package co.com.example.logisticaproductos.pedido.events;
import co.com.example.logisticaproductos.pedido.values.PedidoId;
import co.com.example.logisticaproductos.pedido.values.Producto;
import co.com.example.logisticaproductos.pedido.values.ProveedorId;
import co.com.sofka.domain.generic.DomainEvent;

public class ProveedorCreado extends DomainEvent {
    private final PedidoId id;
    private final ProveedorId proveedorId;
    private final Producto producto;

    public ProveedorCreado(PedidoId id, ProveedorId proveedorId, Producto producto) {
        super("co.com.example.logisticaproductos.ProveedorCreado");
        this.id = id;
        this.proveedorId = proveedorId;
        this.producto = producto;
    }

    public PedidoId getId() {
        return id;
    }

    public ProveedorId getProveedorId() {
        return proveedorId;
    }

    public Producto getProducto() {
        return producto;
    }
}
