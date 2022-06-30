package co.com.example.logisticaproductos.domiciliario.values;
import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class Pago implements ValueObject<Integer> {

    private final Integer valor;

    public Pago(Integer valor) {
        this.valor = Objects.requireNonNull(valor);
    }

    @Override
    public Integer value() {
        return valor;
    }
}
