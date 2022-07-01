package co.com.example.logisticaproductos.domiciliario.events;
import co.com.example.logisticaproductos.pedido.values.PedidoId;
import co.com.sofka.domain.generic.DomainEvent;

public class CilindrajeVehiculoCambiado extends DomainEvent {
    private final PedidoId id;
    private final String marca;
    private final Integer cilindraje;

    public CilindrajeVehiculoCambiado(PedidoId id, String marca, Integer cilindraje) {
        super("co.com.example.logisticaproductos.CilindrajeVehiculoCambiado");
        this.id = id;
        this.marca = marca;
        this.cilindraje = cilindraje;
    }

    public PedidoId id() {
        return id;
    }

    public Integer cilindraje() {
        return cilindraje;
    }

    public String marca() {
        return marca;
    }
}
