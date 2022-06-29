package co.com.example.logisticaproductos.domiciliario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Pago implements ValueObject<Integer> {

    private final Integer pago;

    public Pago(Integer pago) {
        this.pago = Objects.requireNonNull(pago);
    }

    @Override
    public Integer value() {
        return pago;
    }
}
