package com.payment.repository;

import com.payment.model.Contas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ContasRepository extends JpaRepository<Contas, Integer> {

    @Query("select c.saldo from Contas c where c.idConta = :idConta")
    BigDecimal findSaldoById(@Param("idConta") Integer id);
}
