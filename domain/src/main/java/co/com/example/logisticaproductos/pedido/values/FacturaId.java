package co.com.example.logisticaproductos.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class FacturaId extends Identity {

    public static FacturaId of(String id) {
        return new FacturaId(id);
    }
    public FacturaId(String uuid) {
        super(uuid);
    }

    public FacturaId() {
    }
}
