package com.rodrigo.dsvendas.dto;

import java.io.Serializable;
import java.util.Date;

import com.rodrigo.dsvendas.entities.Seller;

public class SellerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String cpf;
	private String email;
	private String telefone;
	private String password;
	private Date date;
	private Double balance;

	public SellerDTO() {
	}
	
	public SellerDTO(Long id, String name, String cpf, String email, String telefone, String password, Date date, 
			Double balance) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.password = password;
		this.date = date;
		this.balance = balance;
	}
	
	public SellerDTO(Seller entity) {
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		email = entity.getEmail();
		telefone = entity.getTelefone();
		password = entity.getPassword();
		date = entity.getDate();
		balance = entity.getBalance();
	}	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

}
