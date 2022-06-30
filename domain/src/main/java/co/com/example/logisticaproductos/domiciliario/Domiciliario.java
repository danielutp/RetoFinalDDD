package co.com.example.logisticaproductos.domiciliario;

import co.com.example.logisticaproductos.cliente.Cliente;
import co.com.example.logisticaproductos.cliente.ClienteEventChange;
import co.com.example.logisticaproductos.cliente.events.ContratoCreado;
import co.com.example.logisticaproductos.cliente.values.ClienteId;
import co.com.example.logisticaproductos.cliente.values.ContratoId;
import co.com.example.logisticaproductos.cliente.values.CuentaId;
import co.com.example.logisticaproductos.cliente.values.Detalle;
import co.com.example.logisticaproductos.domiciliario.events.DomiciliarioCreado;
import co.com.example.logisticaproductos.domiciliario.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Domiciliario extends AggregateEvent<DomiciliarioId> {

    protected Vehiculo vehiculo;
    protected Informe informe;
    protected CuentaDomiciliario cuentaDomiciliario;

    public Domiciliario(DomiciliarioId id, VehiculoId vehiculoId, TipoDeVehiculo tipoDeVehiculo, CuentaDomiciliario cuentaDomiciliario) {
        super(id);
        appendChange(new DomiciliarioCreado(vehiculoId,tipoDeVehiculo,cuentaDomiciliario)).apply();
        subscribe(new DomiciliarioEventChange(this));
    }

    private Domiciliario(DomiciliarioId id) {
        super(id);
        subscribe(new DomiciliarioEventChange(this));
    }

    public void crearInforme(DomiciliarioId id, InformeId informeId, Descripcion descripcion){
        appendChange(new InformeCreado(id,informeId,descripcion)).apply();
    }

    public void crearVehiculo(DomiciliarioId id, VehiculoId vehiculoId, TipoDeVehiculo tipoDeVehiculo){
        appendChange(new Vehiculocreado(id,vehiculoId,tipoDeVehiculo)).apply();
    }


    public static Domiciliario from(DomiciliarioId id, List<DomainEvent> events){
        var domiciliario = new Domiciliario((id));
        events.forEach(domiciliario::applyEvent);
        return domiciliario;
    }


}
