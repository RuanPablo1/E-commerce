package com.LojaZuleide.EcommerceZuleide.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LojaZuleide.EcommerceZuleide.models.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository <Produto, Long> {

}