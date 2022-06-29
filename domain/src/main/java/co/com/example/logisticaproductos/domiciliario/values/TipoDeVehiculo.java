package co.com.example.logisticaproductos.domiciliario.values;
import co.com.sofka.domain.generic.ValueObject;

public class TipoDeVehiculo implements ValueObject<TipoDeVehiculo.Props> {
    private final String Marca;
    private final Integer Cilindraje;

    public TipoDeVehiculo(String marca, Integer cilindraje) {
        Marca = marca;
        Cilindraje = cilindraje;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String Marca() {
                return Marca;
            }

            @Override
            public Integer Cilindraje() {
                return Cilindraje;
            }
        };
    }

    public interface Props {
        String Marca();
        Integer Cilindraje();
    }
}
