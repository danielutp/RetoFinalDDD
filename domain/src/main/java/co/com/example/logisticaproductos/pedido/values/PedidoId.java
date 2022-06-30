package co.com.example.logisticaproductos.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class PedidoId extends Identity {

    public static PedidoId of(String id) {
        return new PedidoId(id);
    }
    public PedidoId(String uuid) {
        super(uuid);
    }

    public PedidoId() {
    }
}
