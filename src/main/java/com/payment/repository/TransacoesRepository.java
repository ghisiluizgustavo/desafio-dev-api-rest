package com.payment.repository;

import com.payment.model.Contas;
import com.payment.model.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransacoesRepository extends JpaRepository<Transacoes, Integer> {

    @Query("select t from Transacoes t where t.conta = :idConta")
    Optional<List<Transacoes>> findAllTransacoesByContaId(@Param("idConta") Contas idConta);
}
