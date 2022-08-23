package com.contaBancaria.Conta.Bancaria.Model.FactoryPattern;

public class servicoDeposito implements ContasInterface{

    @Override
    public Long calcularValorFinal(Long valorInicial, Long valorInserido) {
        Long valorFinal;
        valorFinal = valorInicial + valorInserido;
        return valorFinal;
    }
}
