package co.com.example.logisticaproductos.pedido.commands;

import co.com.example.logisticaproductos.pedido.values.FacturaId;
import co.com.example.logisticaproductos.pedido.values.PedidoId;
import co.com.example.logisticaproductos.pedido.values.Valor;
import co.com.sofka.domain.generic.Command;

public class CambiarValorFacturaCommand extends Command {
    private final PedidoId pedidoId;
    private final FacturaId facturaId;
    private final Valor valor;

    public CambiarValorFacturaCommand(PedidoId pedidoId, FacturaId facturaId, Valor valor) {
        this.pedidoId = pedidoId;
        this.facturaId = facturaId;
        this.valor = valor;
    }

    public FacturaId facturaId() {
        return facturaId;
    }

    public Valor valor() {
        return valor;
    }

    public PedidoId pedidoId() {
        return pedidoId;
    }

}
