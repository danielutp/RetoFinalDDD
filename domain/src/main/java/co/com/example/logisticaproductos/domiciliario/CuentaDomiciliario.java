package co.com.example.logisticaproductos.domiciliario;
import co.com.example.logisticaproductos.domiciliario.values.CuentaDomiciliarioId;
import co.com.example.logisticaproductos.domiciliario.values.Pago;
import co.com.example.logisticaproductos.domiciliario.values.Puntuacion;
import co.com.sofka.domain.generic.Entity;

public class CuentaDomiciliario extends Entity<CuentaDomiciliarioId> {
    private Pago pago;
    private Puntuacion puntuacion;

    public CuentaDomiciliario(CuentaDomiciliarioId id) {
        super(id);
        this.pago = null;
        this.puntuacion = null;
    }

    public void agregarPuntuacion(Integer puntuacion){
        this.puntuacion = new Puntuacion(puntuacion);
    }

}
