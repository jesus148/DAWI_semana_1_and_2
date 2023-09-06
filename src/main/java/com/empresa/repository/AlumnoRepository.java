package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	//JpaRepository es 1 plantilla que tiene todos los elementos basicos y todos esos metodos producto de la herencia lo pasa a AlumnoRepository
	//<Alumno, Integer> : alumno la clase guia y Integer q seria su pk
	//osea e JpaRepository tiene todos los metodos de buscar , listar etc es como un modelo aun que los metodos no se vean
	//pon dentro de aqui control + espacio y saldra los metodos
	//osea JpaRepository crea los metodos autotamitcamente ya no es nesecario crear metodos y conection
	//este repositiry accede a la bd directmanete 
	
	
		
	//recordar qe esta interface esta dentro del paquete controller 
		// ademas cuando cremaos clases o interfaces(dentro tambien el paquete en el package) 
		// lo hacemos desde el paquete com.empresa(imporatante)

	
	

}
