package co.com.example.logisticaproductos.pedido.events;

import co.com.example.logisticaproductos.pedido.values.Producto;
import co.com.example.logisticaproductos.pedido.values.ProveedorId;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreProductoCambiado extends DomainEvent {
    private final ProveedorId proveedorId;
    private final Producto producto;

    public NombreProductoCambiado(ProveedorId proveedorId, Producto producto) {
        super("co.com.example.logisticaproductos.NombreProductoCambiado");
        this.proveedorId = proveedorId;
        this.producto = producto;
    }

    public Producto producto() {
        return producto;
    }

    public ProveedorId proveedorId() {
        return proveedorId;
    }
}
