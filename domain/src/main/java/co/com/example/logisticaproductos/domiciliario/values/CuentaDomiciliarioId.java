package co.com.example.logisticaproductos.domiciliario.values;

import co.com.sofka.domain.generic.Identity;

public class CuentaDomiciliarioId extends Identity {

    public static CuentaDomiciliarioId of(String id) {
        return new CuentaDomiciliarioId(id);
    }

    public CuentaDomiciliarioId(String uuid) {
        super(uuid);
    }

    public CuentaDomiciliarioId() {
    }
}
