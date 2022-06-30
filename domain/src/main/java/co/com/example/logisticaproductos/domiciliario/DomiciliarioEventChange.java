package co.com.example.logisticaproductos.domiciliario;
import co.com.example.logisticaproductos.domiciliario.events.*;
import co.com.sofka.domain.generic.EventChange;

public class DomiciliarioEventChange extends EventChange {
    public DomiciliarioEventChange(Domiciliario domiciliario) {
        apply((DomiciliarioCreado event) ->{
            domiciliario.vehiculo = new Vehiculo(event.vehiculoId(),event.tipoDeVehiculo());
            domiciliario.informe = null;
            domiciliario.cuentaDomiciliario = event.cuentaDomiciliario();
        });

        apply((InformeCreado event) ->{
            domiciliario.informe = new Informe(event.informeId(),event.descripcion());
        });

        apply((DescripcionInformeCambiada event) ->{
            domiciliario.informe.cambiarDescripcion(event.descripcion());
        });

        apply((MarcaVehiculoCambiada event) ->{
            domiciliario.vehiculo.cambiarMarcaVehiculo(event.tipoDeVehiculo());
        });

        apply((PuntajeCuentaDomiciliarioAgregada event) ->{
            domiciliario.cuentaDomiciliario.agregarPuntuacion(event.puntaje());
        });

    }

}