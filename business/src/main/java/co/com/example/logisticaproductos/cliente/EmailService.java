package co.com.example.logisticaproductos.cliente;

import co.com.example.logisticaproductos.cliente.values.ClienteId;

public interface EmailService {

    void enviarCorreo(ClienteId clienteId, String body);
}
