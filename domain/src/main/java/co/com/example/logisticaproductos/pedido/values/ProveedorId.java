package co.com.example.logisticaproductos.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class ProveedorId extends Identity {

    public static ProveedorId of(String id) {
        return new ProveedorId(id);
    }

    public ProveedorId(String uuid) {
        super(uuid);
    }

    public ProveedorId() {
    }
}
