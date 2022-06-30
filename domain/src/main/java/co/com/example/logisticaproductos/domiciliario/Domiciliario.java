package co.com.example.logisticaproductos.domiciliario;
import co.com.example.logisticaproductos.domiciliario.events.*;
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

    public void asociarInforme(DomiciliarioId id, InformeId informeId, Descripcion descripcion){
        appendChange(new InformeCreado(id,informeId,descripcion)).apply();
    }

    public void cambiarDescripcionInforme(InformeId informeId, Descripcion descripcion){
        appendChange(new DescripcionInformeCambiada(informeId, descripcion)).apply();
    }

    public void cambiarMarcaVehiculo(VehiculoId vehiculoId, TipoDeVehiculo tipoDeVehiculo){
        appendChange(new MarcaVehiculoCambiada(vehiculoId, tipoDeVehiculo)).apply();
    }

    public void agregarPuntuacionCuentaDomiciliarion(CuentaDomiciliarioId cuentaDomiciliarioId,Integer puntaje){
        appendChange(new PuntajeCuentaDomiciliarioAgregada(cuentaDomiciliarioId, puntaje)).apply();
    }

    public static Domiciliario from(DomiciliarioId id, List<DomainEvent> events){
        var domiciliario = new Domiciliario((id));
        events.forEach(domiciliario::applyEvent);
        return domiciliario;
    }

}