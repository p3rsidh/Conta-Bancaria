package com.contaBancaria.Conta.Bancaria.Model.FactoryPattern;

import java.math.BigDecimal;

public class servicoSaque implements ContasInterface {

    @Override
    public Long calcularValorFinal(Long valorInicial, Long valorInserido) {
        Long valorFinal;
        valorFinal = valorInicial - valorInserido;
        return valorFinal;
    }
}
