package co.com.example.logisticaproductos.domiciliario;

import co.com.example.logisticaproductos.domiciliario.values.DomiciliarioId;
import co.com.sofka.domain.generic.AggregateEvent;

public class Domiciliario extends AggregateEvent<DomiciliarioId> {

    protected Vehiculo vehiculo;
    protected Informe informe;
    protected CuentaDomiciliario cuentaCliente;


    public Domiciliario(DomiciliarioId id,Vehiculo vehiculo,CuentaDomiciliario cuentaCliente) {
        super(id);
    }
}
