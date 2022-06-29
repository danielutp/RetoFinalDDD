package co.com.example.logisticaproductos.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoSuscripcion implements ValueObject<TipoSuscripcion.Props> {
     private final Integer valor;
     private final Boolean suscrito;

    public TipoSuscripcion(Integer valor, Boolean suscrito) {
        this.valor = Objects.requireNonNull(valor,"No puede ser null");
        this.suscrito = Objects.requireNonNull(suscrito,"No puede ser null");
    }


    @Override
    public Props value() {
        return new Props() {
            @Override
            public Integer valor() {
                return null;
            }

            @Override
            public Boolean suscrito() {
                return null;
            }
        };
    }

    public TipoSuscripcion cambiarSuscripcion(Integer valor,Boolean suscrito){
        return new TipoSuscripcion(valor,suscrito);
    }

    public interface Props {

        Integer valor();
        Boolean suscrito();

    }
}
