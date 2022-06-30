package co.com.example.logisticaproductos.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Valor implements ValueObject<Integer> {
    private final Integer valor;

    public Valor(Integer valor) {
        this.valor = Objects.requireNonNull(valor);
    }

    @Override
    public Integer value() {
        return valor;
    }

    public Valor cambiarValor(Integer valor){
        return new Valor(valor);
    }
}
