package com.rodrigo.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rodrigo.dsvendas.dto.SaleSumDTO;
import com.rodrigo.dsvendas.dto.SuccessDTO;
import com.rodrigo.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new com.rodrigo.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))"  
			+ "FROM Sale as obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller(); 

	@Query("SELECT new com.rodrigo.dsvendas.dto.SuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))"  
			+ "FROM Sale as obj GROUP BY obj.seller")
	List<SuccessDTO> successGroupedBySeller(); 
}
