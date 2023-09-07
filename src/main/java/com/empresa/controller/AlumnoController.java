package com.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;

@Controller
public class AlumnoController {

	
	
	//Esto llamara a los service a los 2  sobre todo a la interface
	@Autowired
	private AlumnoService service;
	
	
	
	
	
	
	
//	 @RequestMapping anotaciones para asignar todas las URL de solicitud HTTP entrantes a los métodos de controlador correspondientes.
	  //osea es como 1 estandar el spring te dira qu lo cambies por los metodos especificos como postMapping , getMapping .etc
	
	
	
	
	
	//PARA ENTRAR AL JSP
	//cuando ejecutes en el spring y en tu navegador entra aca localhost:3306/verAlumno
	//llama aqui y lo retorna o lo redirige a registraAlumno.jsp
	//el getmapping es un request manejan las solicitudes HTTPGET que coinciden con la expresión URI dada. esto es parecido al @RequestMapping
	//@GetMapping(value = "/verAlumno" ) : es como el id al poner en la url inmediatamente entra al controlador y redirige al jsp
	@GetMapping(value = "/verAlumno" )
	public String ver() {
		return "registraAlumno";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//hashmap :es una coleccion que almcena datos , es como 1 tabla con 2 columnas (pk : objeto)(algo asi como clave valor) , 
	//los hashmap tiene 2 columnas
	//en donde las pk(clave) no se repiten pero los objetos(valor) si se pueden repetir , y sirve para enviar mensajes
	
	//	@ResponseBody :convierte a json los return de los metodos para q regresen a los jsp de forma segura
	//@RequestMapping("/registraAlumno") : este es como el id que lo llama desde el jsp y entra aqui
	
	
	
	@RequestMapping("/registraAlumno")
	@ResponseBody
	public HashMap<String , String> registra(Alumno obj){
		
		//crea el obejto hashmap donde se guardara el mensaje de regreso al jsp
		HashMap<String, String> salida= new HashMap<>();
		
		//este llama al metodo insertar del service y le retorna 1 objeto
		Alumno obSalida= service.insertaAlumno(obj);
		
	
		//verifica que se haya insertado
		if(obSalida == null) {
		             //   PK(CLAVE)              OBJETO(VALOR)
 			salida.put("MENSAJE", "error en el registro");
			
		}else {
			salida.put("MENSAJE", "resgistro exitoso");
		}
		
		
		return salida;
		
	}
	
	
	

}
