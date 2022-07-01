package co.com.example.logisticaproductos.domiciliario.commands;
import co.com.example.logisticaproductos.domiciliario.values.Descripcion;
import co.com.example.logisticaproductos.domiciliario.values.DomiciliarioId;
import co.com.example.logisticaproductos.domiciliario.values.InformeId;
import co.com.sofka.domain.generic.Command;

public class AsociarInformeCommand extends Command {

    private final DomiciliarioId id;
    private final InformeId informeId;
    private final Descripcion descripcion;


    public AsociarInformeCommand(DomiciliarioId id, InformeId informeId, Descripcion descripcion) {
        this.id = id;
        this.informeId = informeId;
        this.descripcion = descripcion;
    }

    public DomiciliarioId id() {
        return id;
    }

    public InformeId informeId() {
        return informeId;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
