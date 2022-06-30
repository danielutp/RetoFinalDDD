package co.com.example.logisticaproductos.pedido;
import co.com.example.logisticaproductos.pedido.events.NombreProductoCambiado;
import co.com.example.logisticaproductos.pedido.events.NombreTipoDeCategoriaCambiado;
import co.com.example.logisticaproductos.pedido.events.PedidoCreado;
import co.com.example.logisticaproductos.pedido.events.ValorFacturaCambiado;
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

    public void cambiarNombreProducto(ProveedorId proveedorId, Producto producto){
        appendChange(new NombreProductoCambiado(proveedorId, producto)).apply();
    }

    public void cambiarNombreTipoDeCategoria(CategoriaId categoriaId, TipoDeCategoria tipoDeCategoria){
        appendChange(new NombreTipoDeCategoriaCambiado(categoriaId, tipoDeCategoria)).apply();
    }

    public void cambiarValorFactura(FacturaId facturaId, Valor valor){
        appendChange(new ValorFacturaCambiado(facturaId, valor)).apply();
    }

    public static Pedido from(PedidoId id, List<DomainEvent> events){
        var pedido = new Pedido((id));
        events.forEach(pedido::applyEvent);
        return pedido;
    }
}
