package com.LojaZuleide.EcommerceZuleide.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LojaZuleide.EcommerceZuleide.models.Roles;

@Repository
public interface RolesRepository  extends JpaRepository <Roles, Long> {

}