package com.Loja.Ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Loja.Ecommerce.models.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository <Produto, Long> {

}