package co.com.example.logisticaproductos.domiciliario.values;

import co.com.sofka.domain.generic.Identity;

public class VehiculoId extends Identity {

    public static VehiculoId of(String id) {
        return new VehiculoId(id);
    }

    public VehiculoId(String uuid) {
        super(uuid);
    }

    public VehiculoId() {
    }
}
