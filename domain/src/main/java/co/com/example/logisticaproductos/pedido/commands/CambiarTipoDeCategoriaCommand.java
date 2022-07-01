package co.com.example.logisticaproductos.pedido.commands;
import co.com.example.logisticaproductos.pedido.values.CategoriaId;
import co.com.example.logisticaproductos.pedido.values.PedidoId;
import co.com.example.logisticaproductos.pedido.values.TipoDeCategoria;
import co.com.sofka.domain.generic.Command;

public class CambiarTipoDeCategoriaCommand extends Command {

    private final PedidoId pedidoId;
    private final CategoriaId categoriaId;
    private final TipoDeCategoria tipoDeCategoria;

    public CambiarTipoDeCategoriaCommand(PedidoId pedidoId, CategoriaId categoriaId, TipoDeCategoria tipoDeCategoria) {
        this.pedidoId = pedidoId;
        this.categoriaId = categoriaId;
        this.tipoDeCategoria = tipoDeCategoria;
    }

    public CategoriaId categoriaId() {
        return categoriaId;
    }

    public TipoDeCategoria tipoDeCategoria() {
        return tipoDeCategoria;
    }

    public PedidoId pedidoId() {
        return pedidoId;
    }
}
