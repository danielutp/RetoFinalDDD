package co.com.example.logisticaproductos.domiciliario.events;
import co.com.example.logisticaproductos.cliente.values.ClienteId;
import co.com.example.logisticaproductos.domiciliario.values.DomiciliarioId;
import co.com.example.logisticaproductos.domiciliario.values.TipoDeVehiculo;
import co.com.example.logisticaproductos.domiciliario.values.VehiculoId;
import co.com.example.logisticaproductos.pedido.values.PedidoId;
import co.com.sofka.domain.generic.DomainEvent;

public class CilindrajeVehiculoCambiado extends DomainEvent {
    private final PedidoId id;
    private final VehiculoId vehiculoId;
    private final TipoDeVehiculo tipoDeVehiculo;


    public CilindrajeVehiculoCambiado(PedidoId id, VehiculoId vehiculoId, TipoDeVehiculo tipoDeVehiculo) {
        super("co.com.example.logisticaproductos.CilindrajeVehiculoCambiado");
        this.id = id;
        this.vehiculoId = vehiculoId;
        this.tipoDeVehiculo = tipoDeVehiculo;
    }


    public VehiculoId vehiculoId() {
        return vehiculoId;
    }

    public TipoDeVehiculo tipoDeVehiculo() {
        return tipoDeVehiculo;
    }

    public PedidoId id() {
        return id;
    }
}
