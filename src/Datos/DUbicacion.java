/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Joalgt
 */
public class DUbicacion extends Template {
    
    private int idubicacion;
    private int aula;
    private int piso;
    private int estado;

    public DUbicacion() throws Exception{}
    
    public int getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(int idubicacion) {
        this.idubicacion = idubicacion;
    }

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
   @Override
    public String toString() {
        return "Ubicacion{" +
                "idubicacion='" + idubicacion + '\'' +
                ", aula='" + aula + '\'' +
                ", piso='" + piso + '\''+
                ", estado='" + estado + '\'' +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO ubicacion( aula, piso, estado)" +
                "    VALUES ('"+ getAula()+"', '"+ getPiso()+"', '"+ getEstado() +"');";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE ubicacion" +
                " SET aula='"+getAula()+"', piso='"+ getPiso()+"'" +
                " WHERE idubicacion = "+ getIdubicacion()+";";                                                                                                                                                                               
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE ubicacion " +
                "SET estado='0' "+"WHERE idubicacion="+getIdubicacion()+";";
    }

    @Override
    protected String getAllT() throws Exception {
            return "SELECT aula, piso" +
                " FROM ubicacion" +
                " WHERE estado='1'";
    }

    @Override
    protected int currentColumn() throws Exception {
       return 2;
    }
}


