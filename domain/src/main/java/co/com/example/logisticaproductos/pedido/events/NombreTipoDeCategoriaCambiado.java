package co.com.example.logisticaproductos.pedido.events;

import co.com.example.logisticaproductos.pedido.values.CategoriaId;
import co.com.example.logisticaproductos.pedido.values.TipoDeCategoria;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreTipoDeCategoriaCambiado extends DomainEvent {
    private final CategoriaId categoriaId;
    private final TipoDeCategoria tipoDeCategoria;

    public NombreTipoDeCategoriaCambiado(CategoriaId categoriaId, TipoDeCategoria tipoDeCategoria) {
        super("co.com.example.logisticaproductos.NombreTipoDeCategoriaCambiado");
        this.categoriaId = categoriaId;
        this.tipoDeCategoria = tipoDeCategoria;
    }

    public TipoDeCategoria tipoDeCategoria() {
        return tipoDeCategoria;
    }

    public CategoriaId categoriaId() {
        return categoriaId;
    }
}
