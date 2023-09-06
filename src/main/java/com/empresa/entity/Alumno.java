package com.empresa.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;



//el getter y setter lo da el lombok 
//@Entity : relacionamos esta clase con la tabla alumno del mysql(redsocial)
//@Table(name = "alumno") : con que tabla se va a relacionar

@Getter
@Setter
@Entity
@Table(name = "alumno")
public class Alumno {
	
	
	//recordar qe esta clase esta dentro del paquete entity 
	// ademas cuando cremaos clases(dentro tambien el paquete en el package) o 
	//paquetes lo hacemos desde el paquete com.empresa(imporatante)
	
	
	//CLASE GUIA (usamos la bd redsocial)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//si los atributos sus nombre son  iguales a la tabla no es nesecario poner @column para relacionarlos
	//con cada columna , ademas los atributos deben estar ordenados
	
	//@Id : esto define que el atributo es un pk
	//	@GeneratedValue(strategy = GenerationType.IDENTITY) : genera id diferentes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAlumno;
	
	private String nombre;
	private String dni;
	private String correo;
	
	
	
	
	
	
	//usamos esto por que el dato que obtendremos del jsp son string , debemos convertilos a los typedate q nesecita la bd, en esta caso la fecha
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	
	
	private String estado;
	
	
	

}
