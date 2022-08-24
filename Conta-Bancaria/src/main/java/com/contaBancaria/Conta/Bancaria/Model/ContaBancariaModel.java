package com.contaBancaria.Conta.Bancaria.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contabancaria")
public class ContaBancariaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    private String numeroDaConta;

    @Column(nullable = false)
    private String agencia;

    @Column(nullable = false)
    private String nomeDoUsuario;

    @Column(nullable = false)
    private Long valorAtualDaConta;

    @Column
    private Long valorFinal;

    @Column(nullable = false)
    private Long valorFornecido;

    @Column(nullable = false)
    private String tipoDeService;

}
