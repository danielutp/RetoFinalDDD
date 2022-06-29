package co.com.example.logisticaproductos.pedido;

import co.com.example.logisticaproductos.pedido.values.MedioDePago;
import co.com.example.logisticaproductos.pedido.values.PedidoId;
import co.com.sofka.domain.generic.AggregateEvent;

public class Pedido extends AggregateEvent<PedidoId> {

    protected Proveedor proveedor;
    protected Factura factura;
    protected Categoria categoria;
    protected MedioDePago medioDePago;

    public Pedido(PedidoId id,Proveedor proveedor,MedioDePago medioDePago) {
        super(id);
    }
}
