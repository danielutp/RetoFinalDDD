package co.com.example.logisticaproductos.cliente.services;

import co.com.example.logisticaproductos.cliente.values.ClienteId;

public interface EmailService {

    void enviarCorreo(ClienteId clienteId, String body);
}
