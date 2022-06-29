package co.com.example.logisticaproductos.domiciliario.values;
import co.com.sofka.domain.generic.ValueObject;

public class Puntuacion implements ValueObject<Integer> {
    private final Integer puntaje;

    public Puntuacion(Integer puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public Integer value() {
        return puntaje;
    }
}
