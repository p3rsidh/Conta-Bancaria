package com.contaBancaria.Conta.Bancaria.Controller;

import com.contaBancaria.Conta.Bancaria.Model.ContaBancariaModel;
import com.contaBancaria.Conta.Bancaria.Model.FactoryPattern.ContaBancariaFactory;
import com.contaBancaria.Conta.Bancaria.Service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService contaBancariaService;



    @GetMapping(path = "/contabancaria")
    public ResponseEntity<List<ContaBancariaModel>> buscarContas (){
        List<ContaBancariaModel> listaDeContas = contaBancariaService.exibirContas();

        return ResponseEntity.ok(listaDeContas);
    }

    @GetMapping(path = "/contabancaria/{codigo}")
    public ResponseEntity<Optional<ContaBancariaModel>> buscarContaEspecifica(@PathVariable Long codigo){
        Optional<ContaBancariaModel> contaEspecifica =  contaBancariaService.exibirUmaConta(codigo);
        return ResponseEntity.ok(contaEspecifica);
    }

    @PostMapping(path = "/contabancaria")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContaBancariaModel> cadastrarConta(@RequestBody ContaBancariaModel contaBancariaModel, ContaBancariaFactory contaBancariaFactory){
        ContaBancariaModel novaConta =  contaBancariaService.adicionarConta(contaBancariaModel, contaBancariaFactory);
        return ResponseEntity.ok(novaConta);
    }

    @DeleteMapping(path = "/contabancaria/{codigo}")
    public ResponseEntity< List<ContaBancariaModel>> deletarconta(@RequestBody Long codigo){
        contaBancariaService.deletarConta(codigo);
        List<ContaBancariaModel> listaDeContas = contaBancariaService.exibirContas();

        return ResponseEntity.ok(listaDeContas);
    }




}
