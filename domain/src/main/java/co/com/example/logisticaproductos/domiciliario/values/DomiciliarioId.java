package co.com.example.logisticaproductos.domiciliario.values;

import co.com.sofka.domain.generic.Identity;

public class DomiciliarioId extends Identity {

    public static DomiciliarioId of(String id) {
        return new DomiciliarioId(id);
    }

    public DomiciliarioId(String uuid) {
        super(uuid);
    }

    public DomiciliarioId() {
    }
}
