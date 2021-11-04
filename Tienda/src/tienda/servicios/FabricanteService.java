package tienda.servicios;

import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDaoExt;

public class FabricanteService {

  private FabricanteDaoExt dao;

  public FabricanteService() {
    this.dao = new FabricanteDaoExt();
  }

  public void crearFabricante() throws Exception {
    try {

      Scanner read = new Scanner(System.in).useDelimiter("\n");
      Fabricante f = new Fabricante();
      System.out.println("Ingrese el codigo del Fabricante.");
      Integer codigo = read.nextInt();
      System.out.println("Ingrese el nombre del Fabricante.");
      String nombre = read.next();
      f.setCodigo(codigo);
      f.setNombre(nombre);
      dao.guardarFabricante(f);
    } catch (Exception e) {
      throw e;
    }
  }

}