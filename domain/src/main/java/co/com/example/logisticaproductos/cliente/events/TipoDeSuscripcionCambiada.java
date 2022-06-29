package co.com.example.logisticaproductos.cliente.events;

import co.com.example.logisticaproductos.cliente.values.ClienteId;
import co.com.sofka.domain.generic.DomainEvent;

public class TipoDeSuscripcionCambiada extends DomainEvent {
    private final ClienteId id;
    private final Integer valor;
    private final Boolean tipoSuscripcion;

    public TipoDeSuscripcionCambiada(ClienteId id,Integer valor, Boolean tipoSuscripcion) {
        super("co.com.sofka.logisticaproductos.TipoDeSuscripcionCambiada");
        this.id = id;
        this.valor = valor;
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public ClienteId getId() {
        return id;
    }

    public Integer getValor() {
        return valor;
    }

    public Boolean getTipoSuscripcion() {
        return tipoSuscripcion;
    }
}