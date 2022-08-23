package com.contaBancaria.Conta.Bancaria.Service;

import com.contaBancaria.Conta.Bancaria.Model.ContaBancariaModel;
import com.contaBancaria.Conta.Bancaria.Model.FactoryPattern.ContaBancariaFactory;
import com.contaBancaria.Conta.Bancaria.Repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    public List<ContaBancariaModel> exibirContas(){
        return contaBancariaRepository.findAll();
    }

    public Optional<ContaBancariaModel> exibirUmaConta(Long id){
        return contaBancariaRepository.findById(id);

    }

    public ContaBancariaModel adicionarConta(ContaBancariaModel contaBancariaModel,  ContaBancariaFactory contaBancariaFactory){

        contaBancariaModel.getCodigo();
        contaBancariaModel.getNomeroDaConta();
        contaBancariaModel.getValorAtualDaConta();
        contaBancariaModel.getAgencia();
        contaBancariaModel.getNomeDoUsuario();
        contaBancariaModel.getTipoDeService();
        contaBancariaModel.getValorFornecido();
        contaBancariaModel.setValorFinal(contaBancariaFactory.getContaBancaria(contaBancariaModel.getTipoDeService()).calcularValorFinal(contaBancariaModel.getValorAtualDaConta(), contaBancariaModel.getValorFornecido()));

        return contaBancariaRepository.save(contaBancariaModel);
    }

    public List<ContaBancariaModel> deletarConta(Long codigo){
        contaBancariaRepository.deleteById(codigo);
        return contaBancariaRepository.findAll();
    }




}
