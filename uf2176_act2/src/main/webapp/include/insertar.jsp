<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   



    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

	<!-- Datatables -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="css/estilo.css">

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
<div id="accordion">
  <div class="card">
    <div class="card-header" id="headingOne">
      <h5 class="mb-0">
        <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          Insertar un elemento en este formulario
        </button>
      </h5>
      
    </div>

    <div id="collapseOne" class="collapse hide" aria-labelledby="headingOne" data-parent="#accordion">
      <div class="card-body">
  		<header>MINIMALISTIC FORM</header>

	<form id="form" class="topBefore" method="post" action="inicio">
		
		  <input id="nombre" name="nombre" type="text" placeholder="NAME">
		  <input id="cif" name="cif" type="text" placeholder="CIF">
		  <input id="apellido" name="ape1" type="text" placeholder="APELLIDO">
		  <input id="apellidodos" name="ape2" type="text" placeholder="APELLIDODOS">
		  <input id="departamento" name="dpt" type="text" placeholder="DEPARTAMENTO">
  		  <input id="submit" type="submit" value="GO!">
  
	</form>
      
    </div>
  </div>

   
  </div>

</body>
</html>