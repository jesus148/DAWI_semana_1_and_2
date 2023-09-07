<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<script type="text/javascript" src="js/global.js"></script>

<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>
<title>Ejemplos de CIBERTEC - Jorge Jacinto </title>
</head>
<body>




<div class="container">









<h1>Registra Medicamento</h1>

	<form id="id_form"> 
	
	
<!-- 	recordar quq cuando enviamos el form enviamos inmediatamente los inputs ya sea atraves sus id o sus name
ademas tienen que estar dentro de 1 formgroup  , es atraves de los form-control   -->
	
	
	
	
	
	<div class="row" style="margin-top: 5%">
			<div class="form-group col-sm-6">
				<div class="col-sm-4">
					<label class="control-label" for="id_nombre">Nombre Medicamento </label>
				</div>
				<div class="col-sm-8">
<!-- 				    recordar que los name debe ser igual a la clase guia y el de la bd -->
					<input class="form-control" type="text" id="id_nombre" name="nombre" placeholder="Ingrese el nombre" maxlength="40">
				</div>
			</div>
			<div class="form-group  col-sm-6">
				<div class="col-sm-4">
					<label class="control-label" for="id_precio">Precio</label>
				</div>
				<div class="col-sm-6">
					<input class="form-control" type="text" id="id_precio" name="precio" placeholder="Ingrese el precio" maxlength="8">
		 		</div>
			</div>
		</div>
		<div class="row" style="margin-top: 0%">
			<div class="form-group col-sm-6">
				<div class="col-sm-4">
					<label class="control-label" for="id_stock">Stock</label>
				</div>
				<div class="col-sm-8">
					<input class="form-control" type="text" id="id_stock" name="stock" placeholder="Ingrese el stock" >
				</div>
			</div>
			<div class="form-group  col-sm-6">
				<div class="col-sm-4">
					<label class="control-label" for="id_laboratorio">Laboratorio</label>
				</div>
				<div class="col-sm-6">
					<input class="form-control" type="text" id="id_laboratorio" name="laboratorio" placeholder="Ingrese laboratorio" >
		 		</div>
			</div>
		</div>
		
		
		




		
		<div class="row" style="margin-top: 2%" align="center"	>
				<button id="id_registrar" type="button" class="btn btn-primary" >Crea Medicamento</button>
		</div>	
	
	
	
	
	
	
	
		
	</form>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</div>
































<script type="text/javascript">

$("#id_registrar").click(function (){ 
	

	
	
	

	//Lanza la validacion
	var validator = $('#id_form').data('bootstrapValidator');
    validator.validate();
    
    //Pregunta si es valido el formulario(Si no tiene errores)
	if (validator.isValid()){
		$.ajax({
    		type: "POST",
    		//con esto ingresa al controladro y buscar 
            url: "registraMedicamento", 
            // con el id_form envia los inputs directamente , pero a traves de los form control q son los inputs 
            data: $('#id_form').serialize(),
            
            //todo correcto
           // MENSAJE: es la pk en controller en tabla map debe ser igual y apartir de la pk sabra el objeto
            success: function(data){
            	//desenvolsando la data de regreso q nos envia el controller 
            	mostrarMensaje(data.MENSAJE);
            	validator.resetForm();   
            	limpiar();  //limpia
            },
            //si hay error
            error: function(){
            	mostrarMensaje(data.MSG_ERROR);
            }
    	});
	}   
    	
	
	
	
	
	
	
	
});














function limpiar(){
	$('#id_nombre').val('');
	$('#id_precio').val('');
	$('#id_stock').val('');
	$('#id_laboratorio').val('');
}









$(document).ready(function() {
    $('#id_form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	
        	
        	//nombre : el name de los inputs debe ser igual a los de la clase guia cuando usamos spring , osea debe ser igual al de la 
        	//la base datos sus columnas
        	// selector: "#id_nombre" : es el id de los inputs
        		nombre:{
                    selector: "#id_nombre",
                    validators:{
                        notEmpty: {
                             message: 'El nombre es obligatorio'
                        },
                        stringLength: {
                            min: 3,
                            max: 40,
                            message: 'El nombre es de 3 a 40 caracteres'
                        },
                    }
                },
                precio:{
                    selector: "#id_precio",
                    validators:{
                        notEmpty: {
                             message: 'El precio es obligatorio'
                        },
                        regexp: {
                            regexp: /^[0-9]+([,][0-9]+)?$/,
                            message: 'el precio es 8 dígitos'
                        }
                    }
                },
                stock:{
                    selector: "#id_stock",
                    validators:{
                        notEmpty: {
                             message: 'El stock es obligatorio'
                        },
                        regexp: {
                            regexp: /^[0-9]{2}$/,
                            message: 'el stock es 2 dígitos'
                        }
                     
                    }
                },
                laboratorio:{
                    selector: "#id_laboratorio",
                    validators:{
                        notEmpty: {
                             message: 'el laboratorio es obligatorio'
                        }
                    }
                }
               
                
                
                
        }   
    });

    
});








</script>

</body>
</html>




