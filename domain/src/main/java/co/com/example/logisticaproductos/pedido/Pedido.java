package co.com.example.logisticaproductos.pedido;
import co.com.example.logisticaproductos.pedido.events.CategoriaCreada;
import co.com.example.logisticaproductos.pedido.events.FacturaCreada;
import co.com.example.logisticaproductos.pedido.events.PedidoCreado;
import co.com.example.logisticaproductos.pedido.events.ProveedorCreado;
import co.com.example.logisticaproductos.pedido.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import java.util.List;

public class Pedido extends AggregateEvent<PedidoId> {

    protected Proveedor proveedor;
    protected Factura factura;
    protected Categoria categoria;
    protected MedioDePago medioDePago;

    public Pedido(PedidoId id, ProveedorId proveedorId, Producto producto, FacturaId facturaId, Valor valor, CategoriaId categoriaId, TipoDeCategoria tipoDeCategoria, MedioDePago medioDePago) {
        super(id);
        appendChange(new PedidoCreado(proveedorId,producto,facturaId,valor,categoriaId,tipoDeCategoria,medioDePago)).apply();
        subscribe(new PedidoEventChange(this));
    }

    private Pedido(PedidoId id) {
        super(id);
        subscribe(new PedidoEventChange(this));
    }

    public void crearFactura(PedidoId id, FacturaId facturaId, Valor valor){
        appendChange(new FacturaCreada(id,facturaId,valor)).apply();
    }

    public void crearProveedor(PedidoId id, ProveedorId proveedorId, Producto producto){
        appendChange(new ProveedorCreado(id,proveedorId,producto)).apply();
    }

    public void crearCategoria(PedidoId id, CategoriaId categoriaId, TipoDeCategoria tipoDeCategoria){
        appendChange(new CategoriaCreada(id,categoriaId,tipoDeCategoria)).apply();
    }

    public static Pedido from(PedidoId id, List<DomainEvent> events){
        var pedido = new Pedido((id));
        events.forEach(pedido::applyEvent);
        return pedido;
    }
}
