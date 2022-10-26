package com.LojaZuleide.EcommerceZuleide.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.LojaZuleide.EcommerceZuleide.enums.RoleName;

@Entity
@Table(name = "tb_roles")
public class Roles implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	private RoleName roleName;

	public Roles() {

	}

	public Roles(Long roleId, RoleName roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Roles(Long roleId) {
		this.roleId = roleId;
	}

	
}
