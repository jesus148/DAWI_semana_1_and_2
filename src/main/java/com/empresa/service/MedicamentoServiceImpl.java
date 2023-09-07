package com.empresa.service;

import com.empresa.entity.Medicamento;
import com.empresa.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class MedicamentoServiceImpl implements MedicamentoService {

	
	
	@Autowired
	private MedicamentoRepository repository;
	
	
	@Override
	public Medicamento insertaMedicamente(Medicamento obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}
	
	
	
	
	

}
