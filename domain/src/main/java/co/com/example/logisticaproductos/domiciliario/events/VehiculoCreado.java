package co.com.example.logisticaproductos.domiciliario.events;
import co.com.example.logisticaproductos.domiciliario.values.DomiciliarioId;
import co.com.example.logisticaproductos.domiciliario.values.TipoDeVehiculo;
import co.com.example.logisticaproductos.domiciliario.values.VehiculoId;
import co.com.sofka.domain.generic.DomainEvent;

public class VehiculoCreado extends DomainEvent {
    private final DomiciliarioId id;
    private final VehiculoId vehiculoId;
    private final TipoDeVehiculo tipoDeVehiculo;

    public VehiculoCreado(DomiciliarioId id, VehiculoId vehiculoId, TipoDeVehiculo tipoDeVehiculo) {
        super("co.com.example.logisticaproductos.Vehiculocreado");
        this.id = id;
        this.vehiculoId = vehiculoId;
        this.tipoDeVehiculo = tipoDeVehiculo;
    }

    public DomiciliarioId getId() {
        return id;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }

    public TipoDeVehiculo getTipoDeVehiculo() {
        return tipoDeVehiculo;
    }

}