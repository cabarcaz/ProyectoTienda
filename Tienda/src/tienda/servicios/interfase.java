package tienda.servicios;

import java.util.Scanner;

public class interfase {

  ProductoService ps = new ProductoService();
  FabricanteService fs = new FabricanteService();

  public void menu() throws Exception {
    int opc;
    
    Scanner read = new Scanner(System.in);
    do {
      System.out.println("Seleccione una opción:\n" + " 1. Mostrar nombre de todos los productos.\n"
          + " 2. Mostrar nombre y precio de todos los prodcutos.\n"
          + " 3. Mostrar prodcutos con precios entre 120 y 200.\n" + " 4. Mostrar los Portátiles (notebook).\n"
          + " 5. Mostrar el prodcuto mas barato.\n" + " 6. Ingresar un nuevo producto.\n"
          + " 7. Ingresar un nuevo fabricante.\n" + " 8. Editar los datos de un producto existente.\n" + " 0. Salir.");
      opc = read.nextInt();
      switch (opc) {
      case 1:
        ps.imprimirProducto();
        break;
      case 2:
        ps.imprimirPrecio();
        break;
      case 3:
        ps.imprimirEntrePrecios();
        break;
      case 4:
        ps.imprimirPortatiles();
        break;
      case 5:
        ps.imprimirMasBarato();
        break;
      case 6:
        ps.crearProducto();
        break;
      case 7:
        fs.crearFabricante();
        break;
      case 8:
        ps.modificarProducto();
        break;
      case 0:
        System.out.println("Proceso terminado.");
        break;
      default:
        System.out.println("Ingrese una opción correcta.");
      }
    } while (opc != 0);

  }

}