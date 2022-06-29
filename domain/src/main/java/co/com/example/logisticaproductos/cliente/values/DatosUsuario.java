package co.com.example.logisticaproductos.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DatosUsuario implements ValueObject<DatosUsuario.Props> {
    private final String nombre;
    private final Integer telefono;
    private final String Barrio;
    private final String Direccion;

    public DatosUsuario(String nombre, Integer telefono, String barrio, String direccion) {
        this.nombre = Objects.requireNonNull(nombre,"No puede ser null");
        this.telefono = Objects.requireNonNull(telefono,"No puede ser null");
        Barrio = Objects.requireNonNull(barrio,"No puede ser null");
        Direccion = Objects.requireNonNull(direccion,"No puede ser null");
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String nombre() {
                return null;
            }

            @Override
            public Integer telefono() {
                return null;
            }

            @Override
            public String barrio() {
                return null;
            }

            @Override
            public String direccion() {
                return null;
            }
        };
    }

    public interface Props {

        String nombre();
        Integer telefono();
        String barrio();
        String direccion();

    }
}
