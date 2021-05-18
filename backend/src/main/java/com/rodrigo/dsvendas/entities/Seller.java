package com.rodrigo.dsvendas.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sellers")
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cpf;
	private String email;
	private String telefone;
	private String password;
	private Date date;
	private Double balance;

	@OneToMany(mappedBy = "seller")
	private List<Sale> sales = new ArrayList<>();
	
	public Seller() {
	}
	
	public Seller(Long id, String name, String cpf, String email, String telefone, String password, Date date,
			List<Sale> sales) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.password = password;
		this.date = date;
		this.sales = sales;
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

	public Double getBalance() {
		return balance;
	}

	public List<Sale> getSales() {
		return sales;
	}
	
}
