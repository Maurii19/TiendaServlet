package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Marca;
import modelo.Producto;
import modelo.ProductoModelo;

/**
 * Servlet implementation class UpdateProducto
 */
@WebServlet("/UpdateProducto")
public class UpdateProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			// obtenemos los datos
			int id = Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			double precio = Double.parseDouble(request.getParameter("precio"));
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Date fecha_compra = format.parse(request.getParameter("fecha_compra"));
			
			int idMarca = Integer.parseInt(request.getParameter("marca"));
			
			//Definimos el modelo producto
			ProductoModelo productoModelo = new ProductoModelo();
			
			// asignamos los nuevos datos al producto
			Producto producto = new Producto();
			
			producto.setId(id);
			producto.setNombre(nombre);
			producto.setPrecio(precio);
			producto.setFecha_compra(fecha_compra);
			
			Marca marca = new Marca();
			marca.setId(idMarca);
			
			producto.setMarca(marca);
			
			// Ejecutamos la funcion update
				
			productoModelo.update(producto);
			
			// Abrimos la vista
			response.sendRedirect("VerProducto?id=" + id);
			

			
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
