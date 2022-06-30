package co.com.example.logisticaproductos.domiciliario.values;
import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class TipoDeVehiculo implements ValueObject<TipoDeVehiculo.Props> {
    private final String marca;
    private final Integer cilindraje;

    public TipoDeVehiculo(String marca, Integer cilindraje) {
        this.marca = Objects.requireNonNull(marca);
        this.cilindraje = Objects.requireNonNull(cilindraje);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String marca() {
                return marca;
            }

            @Override
            public Integer cilindraje() {
                return cilindraje;
            }
        };
    }

    public interface Props {
        String marca();
        Integer cilindraje();
    }

    public TipoDeVehiculo cambiarMarcaVehiculo(String marca){
        return new TipoDeVehiculo(marca,this.cilindraje);
    }

}
