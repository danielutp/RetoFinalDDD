package co.com.example.logisticaproductos.domiciliario.events;
import co.com.example.logisticaproductos.domiciliario.values.Descripcion;
import co.com.example.logisticaproductos.domiciliario.values.InformeId;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionInformeCambiada extends DomainEvent {
    private final InformeId informeId;
    private final Descripcion descripcion;

    public DescripcionInformeCambiada(InformeId informeId, Descripcion descripcion) {
        super("co.com.example.logisticaproductos.DescripcionInformeCambiada");
        this.informeId = informeId;
        this.descripcion = descripcion;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public InformeId informeId() {
        return informeId;
    }

}
