package co.com.example.logisticaproductos.domiciliario;
import co.com.example.logisticaproductos.domiciliario.values.Descripcion;
import co.com.example.logisticaproductos.domiciliario.values.InformeId;
import co.com.sofka.domain.generic.Entity;

public class Informe extends Entity<InformeId> {
    private Descripcion descripcion;

    public Informe(InformeId id,Descripcion descripcion) {
        super(id);
        this.descripcion = descripcion;
    }
}
