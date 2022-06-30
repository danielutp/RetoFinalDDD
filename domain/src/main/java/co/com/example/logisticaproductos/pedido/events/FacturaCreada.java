package co.com.example.logisticaproductos.pedido.events;
import co.com.example.logisticaproductos.pedido.values.FacturaId;
import co.com.example.logisticaproductos.pedido.values.PedidoId;
import co.com.example.logisticaproductos.pedido.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class FacturaCreada extends DomainEvent {
    private final PedidoId id;
    private final FacturaId facturaId;
    private final Valor valor;

    public FacturaCreada(PedidoId id, FacturaId facturaId, Valor valor) {
        super("co.com.example.logisticaproductos.FacturaCreado");
        this.id = id;
        this.facturaId = facturaId;
        this.valor = valor;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public PedidoId getId() {
        return id;
    }

    public Valor getValor() {
        return valor;
    }
}
