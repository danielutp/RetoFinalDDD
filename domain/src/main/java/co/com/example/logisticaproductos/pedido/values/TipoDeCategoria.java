package co.com.example.logisticaproductos.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDeCategoria implements ValueObject<TipoDeCategoria.Props> {
    private final String nombre;
    private final String descripcion;

    public TipoDeCategoria(String nombreTipoCategoria, String descripcion) {
        this.nombre = Objects.requireNonNull(nombreTipoCategoria);
        this.descripcion = Objects.requireNonNull(descripcion);
    }


    @Override
    public Props value() {
        return new Props() {
            @Override
            public String nombreTipoCategoria() {
                return nombre;
            }

            @Override
            public String descripcion() {
                return descripcion;
            }
        };
    }

    public interface Props {
        String nombreTipoCategoria();
        String descripcion();
    }
}
