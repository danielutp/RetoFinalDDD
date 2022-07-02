package co.com.example.logisticaproductos.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class ClienteId extends Identity  {

    public static ClienteId of(String id) {
        return new ClienteId(id);
    }

    public ClienteId(String uuid) {
        super(uuid);
    }
    public ClienteId() {
    }
}
