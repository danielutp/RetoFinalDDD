package co.com.example.logisticaproductos.domiciliario.values;
import co.com.sofka.domain.generic.ValueObject;

public class Descripcion implements ValueObject<String> {
    private final String descripcion;

    public Descripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String value() {
        return descripcion;
    }

    public Descripcion cambiarDescripcion(String descripcionACambiar){
        return new Descripcion(descripcionACambiar);
    }

}
