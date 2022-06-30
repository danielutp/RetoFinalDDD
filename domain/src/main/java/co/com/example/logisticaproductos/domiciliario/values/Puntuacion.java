package co.com.example.logisticaproductos.domiciliario.values;
import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class Puntuacion implements ValueObject<Integer> {
    private final Integer puntaje;

    public Puntuacion(Integer puntaje) {
        this.puntaje = Objects.requireNonNull(puntaje);
    }

    @Override
    public Integer value() {
        return puntaje;
    }

}
