package co.com.example.logisticaproductos.pedido;

import co.com.example.logisticaproductos.pedido.values.CategoriaId;
import co.com.example.logisticaproductos.pedido.values.TipoDeCategoria;
import co.com.sofka.domain.generic.Entity;

public class Categoria extends Entity<CategoriaId> {
    private TipoDeCategoria tipoDeCategoria;

    public Categoria(CategoriaId id,TipoDeCategoria tipoDeCategoria) {
        super(id);
        this.tipoDeCategoria = tipoDeCategoria;
    }
}
