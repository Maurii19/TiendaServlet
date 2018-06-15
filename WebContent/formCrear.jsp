<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
			<h1>Datos del producto</h1>
				<form action="AlmacenarProducto" method="post">
					<table>
						<tr>
							<td>Nombre:</td>
							<td><input type="text" name="nombre" value=""/></td>
						</tr>
						<tr>
							<td>Precio:</td>
							<td><input type="text" name="precio" value=""/></td>
						</tr>

						<tr>
							<td>Marca:</td>
							<td><select name="marca">
								<c:forEach items="${marcas}" var="marca">
									<option value="${marca.id}">${marca.nombre }</option>
								</c:forEach>
							</select></td>
						</tr>

						<tr>
							<td>Fecha Compra:</td>
							<td><input type="text" name="fecha_compra" placeholder="dd-MM-yyyy" value=""/></td>
						</tr>
					</table>
					<input class="btn" type="submit" value="Guardar Cambios" name="update" />
				</form>
			</div>
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</html>