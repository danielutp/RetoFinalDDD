package co.com.example.logisticaproductos.pedido;
import co.com.example.logisticaproductos.pedido.values.Producto;
import co.com.example.logisticaproductos.pedido.values.ProveedorId;
import co.com.sofka.domain.generic.Entity;

public class Proveedor extends Entity<ProveedorId> {
    private Producto producto;

    public Proveedor(ProveedorId id,Producto producto) {
        super(id);
        this.producto=producto;
    }

    public void cambiarNombreProducto(Producto productoACambiar){
        this.producto = producto.cambiarNombreProducto(productoACambiar.value().nombre());
    }

}
