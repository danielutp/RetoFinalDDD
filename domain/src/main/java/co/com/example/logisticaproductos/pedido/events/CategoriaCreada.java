package co.com.example.logisticaproductos.pedido.events;
import co.com.example.logisticaproductos.pedido.values.CategoriaId;
import co.com.example.logisticaproductos.pedido.values.PedidoId;
import co.com.example.logisticaproductos.pedido.values.TipoDeCategoria;
import co.com.sofka.domain.generic.DomainEvent;

public class CategoriaCreada extends DomainEvent {
    private final PedidoId id;
    private final CategoriaId categoriaId;
    private final TipoDeCategoria tipoDeCategoria;

    public CategoriaCreada(PedidoId id, CategoriaId categoriaId, TipoDeCategoria tipoDeCategoria) {
        super("co.com.example.logisticaproductos.CategoriaCreada");
        this.id = id;
        this.categoriaId = categoriaId;
        this.tipoDeCategoria = tipoDeCategoria;
    }

    public PedidoId getId() {
        return id;
    }

    public CategoriaId getCategoriaId() {
        return categoriaId;
    }

    public TipoDeCategoria getTipoDeCategoria() {
        return tipoDeCategoria;
    }
}
