package co.com.example.logisticaproductos.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class CategoriaId extends Identity {

    public static CategoriaId of(String id) {
        return new CategoriaId(id);
    }

    public CategoriaId(String uuid) {
        super(uuid);
    }

    public CategoriaId() {
    }
}
