package modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductoModelo extends Conector {
	MarcaModelo marcaModelo = new MarcaModelo();
	
	public ArrayList<Producto> selectAll() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM PRODUCTOS");
			
			while(rs.next()){
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setFecha_compra(rs.getDate("fecha_compra"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setMarca(marcaModelo.selectMarcaId(rs.getInt("id_marca")));
				
				
				
				productos.add(producto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return productos;
	}

	public Producto selectProductoId(int idProducto) {
		
	
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT * FROM productos where id=?");
			pst.setInt(1, idProducto);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setFecha_compra(rs.getDate("fecha_compra"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setMarca(marcaModelo.selectMarcaId(rs.getInt("id_marca")));
				
				return producto;
			}else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public void update(Producto producto) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("UPDATE PRODUCTOS SET nombre=?, precio=?, fecha_compra=?, id_marca=? where id=?");
			
			pst.setString(1, producto.getNombre());
			pst.setDouble(2, producto.getPrecio());
			pst.setDate(3, new java.sql.Date(producto.getFecha_compra().getTime()));
			pst.setInt(4, producto.getMarca().getId());
			pst.setInt(5, producto.getId());
			
			pst.execute();
			}
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deleteProducto(Producto producto) {
		PreparedStatement pst;
		
		try {
			pst = super.conexion.prepareStatement("DELETE FROM PRODUCTOS WHERE id=?");
			pst.setInt(1, producto.getId());
			
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	public void crearProducto(Producto producto) {
		PreparedStatement pst;
		
		try {
			pst = super.conexion.prepareStatement("INSERT INTO PRODUCTOS(nombre, fecha_compra, precio, id_marca) VALUES (?,?,?,?)");
			pst.setString(1, producto.getNombre());
			pst.setDate(2, new java.sql.Date(producto.getFecha_compra().getTime()));
			pst.setDouble(3, producto.getPrecio());
			pst.setInt(4, producto.getMarca().getId());
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
