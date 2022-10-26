package com.LojaZuleide.EcommerceZuleide.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LojaZuleide.EcommerceZuleide.models.Pedido;

@Repository
public interface PedidoRepository  extends JpaRepository <Pedido, Long> {

}