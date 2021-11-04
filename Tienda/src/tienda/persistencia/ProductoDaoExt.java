package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;

public final class ProductoDaoExt extends DAO {

  public Collection<Producto> listarProductos() throws Exception {
    try {
      String sql = "SELECT nombre FROM producto";
      consultarBase(sql);
      Producto producto = null;
      Collection<Producto> productos = new ArrayList<>();
      while (resultado.next()) {
        producto = new Producto();
        producto.setNombre(resultado.getString("nombre"));
        productos.add(producto);
      }
      desconectarBase();
      return productos;
    } catch (Exception e) {
      e.printStackTrace();
      desconectarBase();
      throw new Exception("Error de sistema");
    } finally {
      desconectarBase();
    }
  }

  public Collection<Producto> nombrePrecio() throws Exception {
    try {
      String sql = "SELECT nombre,precio FROM producto";
      consultarBase(sql);
      Producto producto = null;
      Collection<Producto> productos = new ArrayList<>();
      while (resultado.next()) {
        producto = new Producto();
        producto.setNombre(resultado.getString("nombre"));
        producto.setPrecio(resultado.getDouble("precio"));
        productos.add(producto);
      }
      desconectarBase();
      return productos;
    } catch (Exception e) {
      e.printStackTrace();
      desconectarBase();
      throw new Exception("Error del sistema");
    }
  }

  public Collection<Producto> entrePrecios() throws Exception {
    try {
      String sql = " select nombre,precio from producto where precio between 120 and 200";
      consultarBase(sql);
      Producto producto = null;
      Collection<Producto> productos = new ArrayList<>();
      while (resultado.next()) {
        producto = new Producto();
        producto.setNombre(resultado.getString("nombre"));
        producto.setPrecio(resultado.getDouble("precio"));
        productos.add(producto);
      }
      desconectarBase();
      return productos;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Error del sistema");
    }
  }

  public Collection<Producto> portatiles() throws Exception {
    try {
      String sql = "SELECT * from producto WHERE nombre like '%Portátil%'";
      consultarBase(sql);
      Producto producto = null;
      Collection<Producto> productos = new ArrayList<>();
      while (resultado.next()) {
        producto = new Producto();
        producto.setCodigo(resultado.getInt("codigo"));
        producto.setNombre(resultado.getString("nombre"));
        producto.setPrecio(resultado.getDouble("precio"));
        producto.setCodigoFabricante(resultado.getInt("codigo_fabricante"));
        productos.add(producto);
      }
      desconectarBase();
      return productos;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Error del sistema");
    }
  }

  public Collection<Producto> masBarato() throws Exception {
    try {
      String sql = "SELECT * FROM producto ORDER BY precio asc LIMIT 1";
      consultarBase(sql);
      Producto producto = null;
      Collection<Producto> productos = new ArrayList<>();
      while (resultado.next()) {
        producto = new Producto();
        producto.setCodigo(resultado.getInt("codigo"));
        producto.setNombre(resultado.getString("nombre"));
        producto.setPrecio(resultado.getDouble("precio"));
        producto.setCodigoFabricante(resultado.getInt("codigo_fabricante"));
        productos.add(producto);
      }
      desconectarBase();
      return productos;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Error del sistema");
    }
  }

  public void guardarProducto(Producto producto) throws Exception {
    try {
      if (producto == null) {
        throw new Exception("Debe llenar los datos");
      }
      String sql = "INSERT INTO producto (codigo,nombre,precio,codigo_fabricante)" + "VALUES ( '" + producto.getCodigo()
          + "' , '" + producto.getNombre() + "' , '" + producto.getPrecio() + "' , '" + producto.getCodigoFabricante()
          + "' );";
      // System.out.println(sql);
      insertarModificarEliminar(sql);
    } catch (Exception e) {
      throw e;
    } finally {
      desconectarBase();
    }
  }

  public Collection<Producto> todosLosProductos() throws Exception {
    try {
      String sql = "select * from producto";
      consultarBase(sql);
      Producto producto = null;
      Collection<Producto> productos = new ArrayList<>();
      while (resultado.next()) {
        producto = new Producto();
        producto.setCodigo(resultado.getInt("codigo"));
        producto.setNombre(resultado.getString("nombre"));
        producto.setPrecio(resultado.getDouble("precio"));
        producto.setCodigoFabricante(resultado.getInt("codigo_fabricante"));
        productos.add(producto);
      }
      desconectarBase();
      return productos;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Error de sistema");
    }
  }

  public void modificarNombreProducto(Producto producto, Integer codigo) throws Exception {
    try {
      if (producto == null) {
        throw new Exception("Debe indicar el codigo del producto que desea modificar.");
      }
      String sql = "UPDATE producto SET nombre ='" + producto.getNombre() + "' where codigo = " + "'" + codigo + "';";
      insertarModificarEliminar(sql);
    } catch (Exception e) {
      throw e;
    } finally {
      desconectarBase();
    }
  }

  public void modificarPrecioProducto(Producto producto, Integer codigo) throws Exception {
    try {
      if (producto == null) {
        throw new Exception("Debe indicar el codigo del producto que desea modificar.");
      }
      String sql = "UPDATE producto SET precio ='" + producto.getPrecio() + "' where codigo = " + "'" + codigo + "';";
      insertarModificarEliminar(sql);
    } catch (Exception e) {
      throw e;
    } finally {
      desconectarBase();
    }
  }

  public void modificarcodigoProducto(Producto producto, Integer codigo) throws Exception {
    try {
      if (producto == null) {
        throw new Exception("Debe indicar el codigo del producto que desea modificar.");
      }
      String sql = "UPDATE producto SET codigo ='" + producto.getCodigo() + "' where codigo = " + "'" + codigo + "';";
      insertarModificarEliminar(sql);
    } catch (Exception e) {
      throw e;
    } finally {
      desconectarBase();
    }
  }

  public void modificarCodigoFProducto(Producto producto, Integer codigo) throws Exception {
    try {
      if (producto == null) {
        throw new Exception("Debe indicar el codigo del producto que desea modificar.");
      }
      String sql = "UPDATE producto SET codigo_fabricante ='" + producto.getCodigoFabricante() + "' where codigo = "
          + "'" + codigo + "';";
      insertarModificarEliminar(sql);
    } catch (Exception e) {
      throw e;
    } finally {
      desconectarBase();
    }
  }

  public Producto buscarProductoPorCodigo(Integer codigo) throws Exception {
    try {
      String sql = "SELECT * FROM producto where codigo=" + codigo;
      consultarBase(sql);
      Producto producto = null;
      while (resultado.next()) {
        producto = new Producto();
        producto.setCodigo(resultado.getInt("codigo"));
        producto.setNombre(resultado.getString("nombre"));
        producto.setPrecio(resultado.getDouble("precio"));
        producto.setCodigoFabricante(resultado.getInt("codigo_fabricante"));
      }
      desconectarBase();
      return producto;
    } catch (Exception e) {
      desconectarBase();
      throw e;
    }
    
    
    
    
  }
}