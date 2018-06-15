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
 * Servlet implementation class AlmacenarProducto
 */
@WebServlet("/AlmacenarProducto")
public class AlmacenarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlmacenarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//OBTENEMOS LOS DATOS
		try {
			String nombre = request.getParameter("nombre");
			double precio = Double.parseDouble(request.getParameter("precio"));
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Date fecha_compra = format.parse(request.getParameter("fecha_compra"));
			int idMarca = Integer.parseInt(request.getParameter("marca"));
			
		//CREAMOS EL PRODUCTO
			Producto producto = new Producto();
			producto.setNombre(nombre);
			producto.setPrecio(precio);
			producto.setFecha_compra(fecha_compra);
			Marca marca = new Marca();
			marca.setId(idMarca);
			producto.setMarca(marca);
		
			//MODELO
			ProductoModelo productoModelo = new ProductoModelo();
			
			productoModelo.crearProducto(producto);
			
			
			//ENVIAMOS A LA VISTA
			response.sendRedirect("Listar");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
