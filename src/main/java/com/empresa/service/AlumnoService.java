package com.empresa.service;

import com.empresa.entity.Alumno;

public interface AlumnoService {
	
	//= esta interface esta creada dentro paquete com.empresa , es 1 interface y tambien esta creada juntamente con su paquete 
	//todo esto se crea en paquete com.empresa
	
	//service interactua con el repositorio , esto es 1 interface por lo tanto se hereda en el serivice....impl
	
	
	public abstract Alumno insertaAlumno(Alumno obj);

}
