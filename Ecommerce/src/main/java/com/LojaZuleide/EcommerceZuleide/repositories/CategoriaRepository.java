package com.LojaZuleide.EcommerceZuleide.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LojaZuleide.EcommerceZuleide.models.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository <Categoria, Long> {

}