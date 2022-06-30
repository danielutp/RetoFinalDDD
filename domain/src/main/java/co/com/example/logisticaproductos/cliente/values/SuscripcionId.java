package co.com.example.logisticaproductos.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class SuscripcionId extends Identity {

    public static SuscripcionId of(String id) {
        return new SuscripcionId(id);
    }

    public SuscripcionId(String uuid) {
        super(uuid);
    }

    public SuscripcionId() {
    }
}
