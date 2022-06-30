package co.com.example.logisticaproductos.pedido;

import co.com.example.logisticaproductos.pedido.values.FacturaId;
import co.com.example.logisticaproductos.pedido.values.Valor;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Factura extends Entity<FacturaId> {
    private Valor valor;

    public Factura(FacturaId id,Valor valor) {
        super(id);
        this.valor = Objects.requireNonNull(valor);
    }

    public void cambiarValorFactura(Valor valorACambiar){
        this.valor= valor.cambiarValor(valorACambiar.value());
    }

}
