package co.com.example.logisticaproductos.pedido.services;
import co.com.example.logisticaproductos.pedido.values.PedidoId;

public interface EmailServicePedido {
    void enviarCorreoPedido(PedidoId pedidoId, String body);
}
