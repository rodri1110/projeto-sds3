package com.rodrigo.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.dsvendas.dto.SaleDTO;
import com.rodrigo.dsvendas.entities.Sale;
import com.rodrigo.dsvendas.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public List<SaleDTO> findAll() {
		List<Sale> result = repository.findAll();
		return result.stream().map(x -> new SaleDTO(x)).collect(Collectors.toList());
	}
}
