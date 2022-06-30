package co.com.example.logisticaproductos.domiciliario;
import co.com.example.logisticaproductos.domiciliario.values.TipoDeVehiculo;
import co.com.example.logisticaproductos.domiciliario.values.VehiculoId;
import co.com.sofka.domain.generic.Entity;

public class Vehiculo extends Entity<VehiculoId> {
    private TipoDeVehiculo tipoDeVehiculo;

    public Vehiculo(VehiculoId id,TipoDeVehiculo tipoDeVehiculo) {
        super(id);
        this.tipoDeVehiculo= tipoDeVehiculo;
    }

    public void cambiarMarcaVehiculo(TipoDeVehiculo tipoDeVehiculoACambiar){
        this.tipoDeVehiculo = tipoDeVehiculo.cambiarMarcaVehiculo(tipoDeVehiculoACambiar.value().marca());
    }

}