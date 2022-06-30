package co.com.example.logisticaproductos.domiciliario.events;

import co.com.example.logisticaproductos.domiciliario.values.TipoDeVehiculo;
import co.com.example.logisticaproductos.domiciliario.values.VehiculoId;
import co.com.sofka.domain.generic.DomainEvent;

public class MarcaVehiculoCambiada extends DomainEvent {
    private final VehiculoId vehiculoId;
    private final TipoDeVehiculo tipoDeVehiculo;

    public MarcaVehiculoCambiada(VehiculoId vehiculoId, TipoDeVehiculo tipoDeVehiculo) {
        super("co.com.example.logisticaproductos.MarcaVehiculoCambiada");
        this.vehiculoId = vehiculoId;
        this.tipoDeVehiculo = tipoDeVehiculo;
    }

    public TipoDeVehiculo getTipoDeVehiculo() {
        return tipoDeVehiculo;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }
}
