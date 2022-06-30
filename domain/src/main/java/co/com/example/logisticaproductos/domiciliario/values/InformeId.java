package co.com.example.logisticaproductos.domiciliario.values;

import co.com.example.logisticaproductos.pedido.values.ProveedorId;
import co.com.sofka.domain.generic.Identity;

public class InformeId extends Identity {

    public static InformeId of(String id) {
        return new InformeId(id);
    }

    public InformeId(String uuid) {
        super(uuid);
    }

    public InformeId() {
    }
}
