package co.com.example.logisticaproductos.pedido.events;
import co.com.example.logisticaproductos.domiciliario.values.DomiciliarioId;
import co.com.example.logisticaproductos.pedido.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.example.logisticaproductos.pedido.values.ClienteId;

public class PedidoCreado extends DomainEvent {

    private final DomiciliarioId domiciliarioId;
    private final ClienteId clienteId;
    private final ProveedorId proveedorId;
    private final Producto producto;
    private final FacturaId facturaId;
    private final Valor valor;
    private final CategoriaId categoriaId;
    private final TipoDeCategoria tipoDeCategoria;
    private final MedioDePago medioDePago;
    public PedidoCreado(ProveedorId proveedorId, Producto producto, FacturaId facturaId, Valor valor, CategoriaId categoriaId, TipoDeCategoria tipoDeCategoria, MedioDePago medioDePago, DomiciliarioId domiciliarioId, ClienteId clienteId) {
        super("co.com.example.logisticaproductos.PedidoCreado");
        this.proveedorId = proveedorId;
        this.producto = producto;
        this.facturaId = facturaId;
        this.valor = valor;
        this.categoriaId = categoriaId;
        this.tipoDeCategoria = tipoDeCategoria;
        this.medioDePago = medioDePago;
        this.domiciliarioId = domiciliarioId;

        this.clienteId = clienteId;
    }

    public ProveedorId proveedorId() {
        return proveedorId;
    }

    public Producto producto() {
        return producto;
    }

    public FacturaId facturaId() {
        return facturaId;
    }

    public Valor valor() {
        return valor;
    }

    public CategoriaId categoriaId() {
        return categoriaId;
    }

    public TipoDeCategoria tipoDeCategoria() {
        return tipoDeCategoria;
    }

    public MedioDePago medioDePago() {
        return medioDePago;
    }

    public DomiciliarioId domiciliarioId() {
        return domiciliarioId;
    }

    public ClienteId clienteId() {
        return clienteId;
    }
}
