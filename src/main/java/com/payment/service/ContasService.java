package com.payment.service;

import com.payment.model.Contas;
import com.payment.repository.ContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContasService {

    @Autowired
    private ContasRepository contasRepository;

    public List<Contas> buscarTodasContas(){
        return contasRepository.findAll();
    }
}
