package com.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Alumno;
import com.empresa.repository.AlumnoRepository;


@Service
public class AlumnoServiceImpl implements AlumnoService  {

	//esta clase se crea en el paquete com.empresa.service > 
	//service interactua con el repositorio
	// este hereda con el implements del AlumnoService(interface) por ende debe heredar sus metodos
	
	
	
	
	//llama al repositorio AlumnoRepository , hara new  , osea llamamos a esta repsositorio para elegir q metodo usar 
	//autoinyectamos @Autowired
	@Autowired
	private AlumnoRepository repository;

	
	
	//este metodo hereda de AlumnoService
	//METODO PARA INSERTAR, osea de ese repository debemos elegir el metodo q ya esta creado 
	@Override
	public Alumno insertaAlumno(Alumno obj) {
		
		//entonces llama al metodo save es que insertar que lo tiene ya creado el AlumnoRepository y ya lo conecta con la bd
		return repository.save(obj);
			
		
	}
	
	

	

}
