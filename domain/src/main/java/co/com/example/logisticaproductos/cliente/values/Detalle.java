package co.com.example.logisticaproductos.cliente.values;
import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class Detalle implements ValueObject<String> {

    private final String detalle;

    public Detalle(String detalle) {
        this.detalle = Objects.requireNonNull(detalle);
    }

    @Override
    public String value() {
        return detalle;
    }

}
