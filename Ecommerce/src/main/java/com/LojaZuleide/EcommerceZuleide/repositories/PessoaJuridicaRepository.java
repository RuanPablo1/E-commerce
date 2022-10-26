package com.LojaZuleide.EcommerceZuleide.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LojaZuleide.EcommerceZuleide.models.PessoaJuridica;

@Repository
public interface PessoaJuridicaRepository  extends JpaRepository <PessoaJuridica, Long> {

}