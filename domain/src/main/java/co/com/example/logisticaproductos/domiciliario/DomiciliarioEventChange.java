package co.com.example.logisticaproductos.domiciliario;

import co.com.example.logisticaproductos.cliente.Contrato;
import co.com.example.logisticaproductos.cliente.events.ContratoCreado;
import co.com.example.logisticaproductos.domiciliario.events.DomiciliarioCreado;
import co.com.sofka.domain.generic.EventChange;

public class DomiciliarioEventChange extends EventChange {
    public DomiciliarioEventChange(Domiciliario domiciliario) {
        apply((DomiciliarioCreado event) ->{
            domiciliario.vehiculo = new Vehiculo(event.getVehiculoId(),event.getTipoDeVehiculo());
            domiciliario.informe = null;
            domiciliario.cuentaDomiciliario = event.getCuentaDomiciliario();
        });

        apply((InformeCreado event) ->{
            domiciliario.informe = new Informe(event.getInformeId(),event.getDescripcion());
        });

    }
}
