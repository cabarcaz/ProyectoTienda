package tienda.persistencia;

import tienda.entidades.Fabricante;

public class FabricanteDaoExt extends DAO {

  public void guardarFabricante(Fabricante fabricante) throws Exception {
    try {
      if (fabricante == null) {
        throw new Exception("Debe ingresar los datos");
      }
      String sql = "INSERT INTO fabricante(codigo,nombre)" + "VALUES ('" + fabricante.getCodigo() + "' , '"
          + fabricante.getNombre() + "');";
      insertarModificarEliminar(sql);
    } catch (Exception e) {
      throw e;
    } finally {
      desconectarBase();
    }
  }

}

