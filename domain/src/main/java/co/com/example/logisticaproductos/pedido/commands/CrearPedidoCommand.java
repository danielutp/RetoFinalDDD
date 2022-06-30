package co.com.example.logisticaproductos.pedido.commands;

import co.com.example.logisticaproductos.pedido.values.*;
import co.com.sofka.domain.generic.Command;

public class CrearPedidoCommand extends Command {
   private final PedidoId id;
   private final ProveedorId proveedorId;
   private final Producto producto;
   private final FacturaId facturaId;
   private final Valor valor;
   private final CategoriaId categoriaId;
   private final TipoDeCategoria tipoDeCategoria;
   private final MedioDePago medioDePago;

    public CrearPedidoCommand(PedidoId id, ProveedorId proveedorId, Producto producto, FacturaId facturaId, Valor valor, CategoriaId categoriaId, TipoDeCategoria tipoDeCategoria, MedioDePago medioDePago) {
        this.id = id;
        this.proveedorId = proveedorId;
        this.producto = producto;
        this.facturaId = facturaId;
        this.valor = valor;
        this.categoriaId = categoriaId;
        this.tipoDeCategoria = tipoDeCategoria;
        this.medioDePago = medioDePago;
    }

    public PedidoId id() {
        return id;
    }

    public ProveedorId proveedorId() {
        return proveedorId;
    }

    public Producto producto() {
        return producto;
    }

    public FacturaId facturaId() {
        return facturaId;
    }

    public Valor valor() {
        return valor;
    }

    public CategoriaId categoriaId() {
        return categoriaId;
    }

    public TipoDeCategoria tipoDeCategoria() {
        return tipoDeCategoria;
    }

    public MedioDePago medioDePago() {
        return medioDePago;
    }
}
