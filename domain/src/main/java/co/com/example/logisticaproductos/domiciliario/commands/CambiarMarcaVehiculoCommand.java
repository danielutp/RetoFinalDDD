package co.com.example.logisticaproductos.domiciliario.commands;

import co.com.example.logisticaproductos.domiciliario.values.DomiciliarioId;
import co.com.example.logisticaproductos.domiciliario.values.TipoDeVehiculo;
import co.com.example.logisticaproductos.domiciliario.values.VehiculoId;
import co.com.sofka.domain.generic.Command;

public class CambiarMarcaVehiculoCommand extends Command {

    private final DomiciliarioId domiciliarioId;
    private final VehiculoId vehiculoId;
    private final TipoDeVehiculo tipoDeVehiculo;

    public CambiarMarcaVehiculoCommand(DomiciliarioId domiciliarioId, VehiculoId vehiculoId, TipoDeVehiculo tipoDeVehiculo) {
        this.domiciliarioId = domiciliarioId;
        this.vehiculoId = vehiculoId;
        this.tipoDeVehiculo = tipoDeVehiculo;
    }

    public VehiculoId vehiculoId() {
        return vehiculoId;
    }

    public TipoDeVehiculo tipoDeVehiculo() {
        return tipoDeVehiculo;
    }

    public DomiciliarioId domiciliarioId() {
        return domiciliarioId;
    }
}
