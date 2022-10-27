package com.Loja.Ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Loja.Ecommerce.models.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository <Categoria, Long> {

}