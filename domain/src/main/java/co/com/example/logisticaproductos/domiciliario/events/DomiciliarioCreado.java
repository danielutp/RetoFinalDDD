package co.com.example.logisticaproductos.domiciliario.events;
import co.com.example.logisticaproductos.domiciliario.CuentaDomiciliario;
import co.com.example.logisticaproductos.domiciliario.values.TipoDeVehiculo;
import co.com.example.logisticaproductos.domiciliario.values.VehiculoId;
import co.com.sofka.domain.generic.DomainEvent;

public class DomiciliarioCreado extends DomainEvent {

    private final VehiculoId vehiculoId;
    private final TipoDeVehiculo tipoDeVehiculo;
    private final CuentaDomiciliario cuentaDomiciliario;

    public DomiciliarioCreado(VehiculoId vehiculoId, TipoDeVehiculo tipoDeVehiculo, CuentaDomiciliario cuentaDomiciliario) {
        super("co.com.example.logisticaproductos.DomiciliarioCreado");
        this.tipoDeVehiculo = tipoDeVehiculo;
        this.cuentaDomiciliario = cuentaDomiciliario;
        this.vehiculoId = vehiculoId;
    }

    public CuentaDomiciliario getCuentaDomiciliario() {
        return cuentaDomiciliario;
    }

    public TipoDeVehiculo getTipoDeVehiculo() {
        return tipoDeVehiculo;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }

}