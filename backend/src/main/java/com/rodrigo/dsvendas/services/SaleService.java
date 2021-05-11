package com.rodrigo.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rodrigo.dsvendas.dto.SaleDTO;
import com.rodrigo.dsvendas.dto.SaleSumDTO;
import com.rodrigo.dsvendas.dto.SuccessDTO;
import com.rodrigo.dsvendas.entities.Sale;
import com.rodrigo.dsvendas.repositories.SaleRepository;
import com.rodrigo.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository; //recurso utilizado para poucos vendedores, diminui a qtdade de selects no banco
	
	@Transactional(readOnly = true)//recurso utilizado para poucos vendedores, diminui a qtdade de selects no banco
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();//recurso utilizado para poucos vendedores, diminui a qtdade de selects no banco
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)//recurso utilizado para poucos vendedores, diminui a qtdade de selects no banco
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)//recurso utilizado para poucos vendedores, diminui a qtdade de selects no banco
	public List<SuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}	
}