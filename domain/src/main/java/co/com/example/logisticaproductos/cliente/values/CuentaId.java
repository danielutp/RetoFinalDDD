package co.com.example.logisticaproductos.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class CuentaId extends Identity {
    private CuentaId(String value) {
        super(value);
    }

    public CuentaId(){
        //super -> auto generarlo
    }

    public static CuentaId of(String value) {
        return new CuentaId(value);
    }
}
