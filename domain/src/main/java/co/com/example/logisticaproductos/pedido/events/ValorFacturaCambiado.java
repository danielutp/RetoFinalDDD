package co.com.example.logisticaproductos.pedido.events;

import co.com.example.logisticaproductos.pedido.values.FacturaId;
import co.com.example.logisticaproductos.pedido.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class ValorFacturaCambiado extends DomainEvent {
    private final FacturaId facturaId;
    private final Valor valor;

    public ValorFacturaCambiado(FacturaId facturaId, Valor valor) {
        super("co.com.example.logisticaproductos.ValorFacturaCambiado");
        this.facturaId = facturaId;
        this.valor = valor;
    }

    public Valor getValor() {
        return valor;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }
}
