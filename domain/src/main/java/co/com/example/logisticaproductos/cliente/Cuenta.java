package co.com.example.logisticaproductos.cliente;
import co.com.example.logisticaproductos.cliente.values.Preferencia;
import co.com.sofka.domain.generic.Entity;
import co.com.example.logisticaproductos.cliente.values.CuentaId;
import co.com.example.logisticaproductos.cliente.values.Rol;
import java.util.HashSet;
import java.util.Set;

public class Cuenta extends Entity<CuentaId> {
    private Set<Preferencia> preferencias;
    private Rol rol;


    public Cuenta(CuentaId id,Rol rol) {
        super(id);
        this.rol = rol;
        this.preferencias = new HashSet<>();
    }

    public void cambiarRol(Rol role){
        this.rol = rol.cambiarRol(role.value());
    }


    public void agregarPreferencia(Preferencia preferencia){
        this.preferencias.add(preferencia);
    }
}