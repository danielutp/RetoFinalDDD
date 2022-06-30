package co.com.example.logisticaproductos.pedido.events;
import co.com.example.logisticaproductos.pedido.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class PedidoCreado extends DomainEvent {
    private final ProveedorId proveedorId;
    private final Producto producto;
    private final FacturaId facturaId;
    private final Valor valor;
    private final CategoriaId categoriaId;
    private final TipoDeCategoria tipoDeCategoria;
    private final MedioDePago medioDePago;

    public PedidoCreado(ProveedorId proveedorId, Producto producto, FacturaId facturaId, Valor valor, CategoriaId categoriaId, TipoDeCategoria tipoDeCategoria, MedioDePago medioDePago) {
        super("co.com.example.logisticaproductos.PedidoCreado");
        this.proveedorId = proveedorId;
        this.producto = producto;
        this.facturaId = facturaId;
        this.valor = valor;
        this.categoriaId = categoriaId;
        this.tipoDeCategoria = tipoDeCategoria;
        this.medioDePago = medioDePago;
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
}
