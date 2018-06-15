package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Producto;
import modelo.ProductoModelo;

/**
 * Servlet implementation class Listar
 */
@WebServlet("/Listar")
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DECLARAMOS PRODUCTOMODELO
		ProductoModelo productoModelo = new ProductoModelo();
		
		//OBTENEMOS LOS PRODUCTOS DE LA BASE DE DATOS
		ArrayList<Producto> productos = productoModelo.selectAll();
		
		//GUARDAMOS EL RESULTADO EN EL REQUEST
		request.setAttribute("productos", productos);
		
		//ENVIAMOS A LA VISTA listado.jsp
		request.getRequestDispatcher("listado.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
