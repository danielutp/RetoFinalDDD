package co.com.example.logisticaproductos.domiciliario.commands;
import co.com.example.logisticaproductos.domiciliario.CuentaDomiciliario;
import co.com.example.logisticaproductos.domiciliario.values.DomiciliarioId;
import co.com.example.logisticaproductos.domiciliario.values.TipoDeVehiculo;
import co.com.example.logisticaproductos.domiciliario.values.VehiculoId;
import co.com.sofka.domain.generic.Command;

public class CrearDomiciliarioCommand extends Command {
    private final DomiciliarioId domiciliarioId;
    private final VehiculoId vehiculoId;
    private final CuentaDomiciliario cuentaDomiciliario;

    private final TipoDeVehiculo tipoDeVehiculo;


    public CrearDomiciliarioCommand(DomiciliarioId domiciliarioId, VehiculoId vehiculoId, CuentaDomiciliario cuentaDomiciliario, TipoDeVehiculo tipoDeVehiculo) {
        this.domiciliarioId = domiciliarioId;
        this.vehiculoId = vehiculoId;
        this.cuentaDomiciliario = cuentaDomiciliario;
        this.tipoDeVehiculo = tipoDeVehiculo;
    }

    public DomiciliarioId getDomiciliarioId() {
        return domiciliarioId;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }

    public CuentaDomiciliario getCuentaDomiciliario() {
        return cuentaDomiciliario;
    }

    public TipoDeVehiculo getTipoDeVehiculo() {
        return tipoDeVehiculo;
    }
}
