package com.Loja.Ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Loja.Ecommerce.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

}