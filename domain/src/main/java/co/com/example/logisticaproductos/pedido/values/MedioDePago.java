package co.com.example.logisticaproductos.pedido.values;
import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class MedioDePago implements ValueObject<MedioDePago.Props> {
    private final String tipoDePago;
    private final Integer valor;

    public MedioDePago(String tipoDePago, Integer valor) {
        this.tipoDePago = Objects.requireNonNull(tipoDePago);
        this.valor = Objects.requireNonNull(valor);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String tipoDePago() {
                return tipoDePago;
            }

            @Override
            public Integer valor() {
                return valor;
            }
        };
    }

    public interface Props {
        String tipoDePago();
        Integer valor();

    }
}
