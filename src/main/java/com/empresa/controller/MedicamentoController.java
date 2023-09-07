package com.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;


import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;







@Controller
public class MedicamentoController {

	
	
	
	@Autowired
	private MedicamentoService service;
	
	
	
	
	//recordar que esto es para dirigir al jsp , ose spring mapea todos los controladores(pueden haber varios) 
	//y busca el 	@GetMapping(value = "/verMedicamento" )
	//y con eso lo redirige al jsp
	
	@GetMapping(value = "/verMedicamento" )
	public String ver() {
		return "registraMedicamento";
	}
	
	
	
	
	
	
	
	@RequestMapping("/registraMedicamento")
	@ResponseBody
	public HashMap<String , String> registra(Medicamento obj){
		
		
		
		HashMap<String , String> salida = new HashMap<>();
		
		
		Medicamento obSalida=service.insertaMedicamente(obj);
		
		
		if( obSalida == null ) {
			
			salida.put("MENSAJE", "error en el registro");
		}else {
			salida.put("MENSAJE", "exitoso registro");
		}
		
		return salida;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
