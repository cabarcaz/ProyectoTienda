package tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDaoExt;

public class ProductoService {

  private ProductoDaoExt dao;

  public ProductoService() {
    this.dao = new ProductoDaoExt();
  }

  public void crearProducto() throws Exception {
    try {
      Scanner read = new Scanner(System.in).useDelimiter("\n");
      Producto p = new Producto();

      System.out.println("Ingrese el código del producto.");
      int codigo = read.nextInt();
      System.out.println("Ingrese el nombre del producto.");
      String nombre = read.next();
      System.out.println("Ingrese el precio del prodcuto.");
      double precio = read.nextDouble();
      System.out.println("Ingrese el código del fabricante.");
      int codigoF = read.nextInt();

      p.setCodigo(codigo);
      p.setNombre(nombre);
      p.setPrecio(precio);
      p.setCodigoFabricante(codigoF);
      dao.guardarProducto(p);
    } catch (Exception e) {
      throw e;
    }

  }

  public Collection<Producto> listarProducto() throws Exception {
    try {
      Collection<Producto> productos = dao.listarProductos();
      return productos;

    } catch (Exception e) {
      throw e;
    }
  }

  public void imprimirProducto() throws Exception {

    try {
      Collection<Producto> productos = listarProducto();

      if (productos.isEmpty()) {
        throw new Exception("No existen productos para mostrar");
      } else {
        for (Producto p : productos) {
          System.out.println("Producto= " + p.getNombre());
        }
        System.out.println("");
      }
    } catch (Exception e) {
      throw e;
    }

  }

  public Collection<Producto> nombrePrecio() throws Exception {
    try {
      Collection<Producto> productos = dao.nombrePrecio();
      return productos;
    } catch (Exception e) {
      throw e;
    }
  }

  public void imprimirPrecio() throws Exception {
    try {
      Collection<Producto> productos = nombrePrecio();
      if (productos.isEmpty()) {
        throw new Exception("No existen productos para mostrar.");
      } else {
        for (Producto p : productos) {
          System.out.println("| Producto= " + p.getNombre() + " | Precio= " + p.getPrecio() + "|");
        }
        System.out.println("");
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public Collection<Producto> entrePrecios() throws Exception {
    try {
      Collection<Producto> productos = dao.entrePrecios();
      return productos;
    } catch (Exception e) {
      throw e;
    }
  }

  public void imprimirEntrePrecios() throws Exception {
    try {
      Collection<Producto> productos = entrePrecios();
      if (productos.isEmpty()) {
        throw new Exception("No existen productos para mostrar.");
      } else {
        for (Producto p : productos) {
          System.out.println("Prodcuto= " + p.getNombre() + " | Precio= " + p.getPrecio() + " |");
        }
        System.out.println("");
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public Collection<Producto> portatiles() throws Exception {
    try {
      Collection<Producto> productos = dao.portatiles();
      return productos;
    } catch (Exception e) {
      throw e;
    }
  }

  public void imprimirPortatiles() throws Exception {
    try {
      Collection<Producto> productos = portatiles();
      if (productos.isEmpty()) {
        throw new Exception("No se encontraron productos para mostrar.");
      } else {
        for (Producto p : productos) {
          System.out.println("Código= " + p.getCodigo() + " | Producto= " + p.getNombre() + " | Precio= "
              + p.getPrecio() + " | Codigo Fabricante= " + p.getCodigoFabricante() + " |");
        }
        System.out.println("");
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public Collection<Producto> masBarato() throws Exception {
    try {
      Collection<Producto> productos = dao.masBarato();
      return productos;
    } catch (Exception e) {
      throw e;
    }
  }

  public void imprimirMasBarato() throws Exception {
    try {
      Collection<Producto> productos = masBarato();
      if (productos.isEmpty()) {
        throw new Exception("No existen productos para mostrar.");
      } else {
        for (Producto p : productos) {
          System.out.println("Codigo= " + p.getCodigo() + " | Producto= " + p.getNombre() + " | Precio= "
              + p.getPrecio() + " | Codigo Fabricante= " + p.getCodigoFabricante() + " |");
        }
        System.out.println("");
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public Collection<Producto> todosLosProductos() throws Exception {
    try {
      Collection<Producto> prodcutos = dao.todosLosProductos();
      return prodcutos;
    } catch (Exception e) {
      throw e;
    }
  }

  public void imprimirTodo() throws Exception {
    try {
      Collection<Producto> productos = todosLosProductos();
      if (productos.isEmpty()) {
        throw new Exception("No existen productos para mostrar.");
      } else {
        for (Producto p : productos) {
          System.out.println("Codigo= " + p.getCodigo() + " | Producto= " + p.getNombre() + " | Precio= "
              + p.getPrecio() + " | Codigo Fabricante= " + p.getCodigoFabricante() + " |");
        }
      }
      System.out.println();
    } catch (Exception e) {
      throw e;
    }
  }

  public Producto buscarProductoPorCodigo(Integer codigo) throws Exception {
    try {
      if (codigo == null) {
        throw new Exception("Debe indicar el código del producto a modificar.");
      }
      Producto producto = dao.buscarProductoPorCodigo(codigo);
      return producto;
    } catch (Exception e) {
      throw e;
    }
  }

  public void modificarProducto() throws Exception {
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    System.out.println("Ingrese el código del producto que desea modificar.");
    imprimirTodo();
    int cod = read.nextInt();
    System.out.println("Que parámetro desea modificar.\n" + " 1. Código\n" + " 2. Nombre\n" + " 3. Precio\n"
        + " 4. Codigo del Fabricante\n" + " 0. Ninguno.");
    int parametro = read.nextInt();
    Producto producto = dao.buscarProductoPorCodigo(cod);
    switch (parametro) {
    case 1:
      System.out.println("Ingrese el nuevo código del producto");
      Integer nuevoCodigo = read.nextInt();
      producto.setCodigo(nuevoCodigo);
      dao.modificarcodigoProducto(producto, cod);
      break;
    case 2:
      System.out.println("Ingrese el nuevo nombre del producto");
      String nuevoNombre = read.next();
      producto.setNombre(nuevoNombre);
      dao.modificarNombreProducto(producto, cod);
      break;
    case 3:
      System.out.println("Ingrese el nuevo precio del producto");
      Double nuevoPrecio = read.nextDouble();
      producto.setPrecio(nuevoPrecio);
      dao.modificarPrecioProducto(producto, cod);
      break;
    case 4:
      System.out.println("Ingrese el nuevo código de fabricante del producto");
      Integer nuevoCodigoF = read.nextInt();
      producto.setCodigoFabricante(nuevoCodigoF);
      dao.modificarCodigoFProducto(producto, cod);
      break;
    }

  }

}
