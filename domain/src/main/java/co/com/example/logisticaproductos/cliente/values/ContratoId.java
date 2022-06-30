package co.com.example.logisticaproductos.cliente.values;
import co.com.example.logisticaproductos.domiciliario.values.CuentaDomiciliarioId;
import co.com.sofka.domain.generic.Identity;

public class ContratoId extends Identity {

    public static ContratoId of(String id) {
        return new ContratoId(id);
    }

    public ContratoId(String uuid) {
        super(uuid);
    }

    public ContratoId() {
    }

}
