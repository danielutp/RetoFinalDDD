package co.com.example.logisticaproductos.pedido.values;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Producto implements ValueObject<Producto.Props> {
    private final String nombre;
    private final String tipoDeProducto;

    public Producto(String nombre, String tipoDeProducto) {
        this.nombre = Objects.requireNonNull(nombre);
        this.tipoDeProducto = Objects.requireNonNull(tipoDeProducto);

}

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String tipoDeProducto() {
                return tipoDeProducto;
            }
        };
    }

    public interface Props {
        String nombre();
        String tipoDeProducto();
    }
}
