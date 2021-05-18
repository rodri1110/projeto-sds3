package com.rodrigo.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.dsvendas.dto.SellerDTO;
import com.rodrigo.dsvendas.entities.Seller;
import com.rodrigo.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;

	public List<SellerDTO> findAll() {
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}

	public Seller save(Seller obj) throws ValidationException{
		sellerValidation(obj);
		return repository.save(obj);
	}

	private void sellerValidation(Seller seller) throws ValidationException {
			
			if (seller.getCpf() == null || seller.getCpf().isEmpty())
				throw new ValidationException("Campo CPF  obrigatrio.");
			
			if (!seller.getCpf().matches("[0-9]+"))
				throw new ValidationException("CPF invlido.");
			
			if (seller.getCpf().length() != 11)
				throw new ValidationException("CPF invlido.");
			
			if (seller.getName() == null || seller.getName().isEmpty())
				throw new ValidationException("O campo 'nome'  obrigatrio.");
			
			if (seller.getName().length() > 100)
				throw new ValidationException("Utilize no mximo 100 caracteres para o campo 'nome'.");
			
			if (seller.getDate() == null)
				throw new ValidationException("O campo 'date' é obrigatório.");
		}
}
