package com.contaBancaria.Conta.Bancaria.Repository;

import com.contaBancaria.Conta.Bancaria.Model.ContaBancariaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancariaModel, Long> {

}
