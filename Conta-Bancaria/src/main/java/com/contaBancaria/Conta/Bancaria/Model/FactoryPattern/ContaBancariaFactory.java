package com.contaBancaria.Conta.Bancaria.Model.FactoryPattern;

import com.contaBancaria.Conta.Bancaria.Model.ContaBancariaModel;

public class ContaBancariaFactory {

    public ContasInterface getContaBancaria(String tipoDeServico){
        
        if (tipoDeServico == null){
            return null;
        } else if (tipoDeServico.equalsIgnoreCase("SAQUE")) {
            return new servicoSaque();
        } else if (tipoDeServico.equalsIgnoreCase("DEPOSITO")) {
            return new servicoDeposito();
        }
        return null;
    }
}
