package co.com.example.logisticaproductos.domiciliario;
import co.com.example.logisticaproductos.domiciliario.values.DomiciliarioId;
import co.com.example.logisticaproductos.domiciliario.values.TipoDeVehiculo;
import co.com.example.logisticaproductos.domiciliario.values.VehiculoId;
import co.com.sofka.domain.generic.DomainEvent;

public class Vehiculocreado extends DomainEvent {
    private final DomiciliarioId id;
    private final VehiculoId vehiculoId;
    private final TipoDeVehiculo tipoDeVehiculo;

    public Vehiculocreado(DomiciliarioId id, VehiculoId vehiculoId, TipoDeVehiculo tipoDeVehiculo) {
        super("co.com.example.logisticaproductos.Vehiculocreado");
        this.id = id;
        this.vehiculoId = vehiculoId;
        this.tipoDeVehiculo = tipoDeVehiculo;
    }
}
