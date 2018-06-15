package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Marca;
import modelo.MarcaModelo;
import modelo.Producto;
import modelo.ProductoModelo;

/**
 * Servlet implementation class EditarProducto
 */
@WebServlet("/EditarProducto")
public class EditarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtenemos el id del producto
		
		int idProducto = Integer.parseInt(request.getParameter("id"));
		
		//definimos el modelo
		ProductoModelo productoModelo = new ProductoModelo();
		
		Producto producto = productoModelo.selectProductoId(idProducto);
		
		MarcaModelo marcaModelo = new MarcaModelo();
		ArrayList<Marca> marcas = marcaModelo.selectAll();
	
		//lo guardamos en el request
		request.setAttribute("producto", producto);
		request.setAttribute("marcas", marcas);
		
		//lo enviamos a la vista
		request.getRequestDispatcher("formEdicion.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
