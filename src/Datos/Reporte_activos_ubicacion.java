/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

/**
 *
 * @author USUARIO
 */
public class Reporte_activos_ubicacion extends Template{
   private String codigo;
    private String nombre_activo;
    private String aula;
    private String piso;

    public Reporte_activos_ubicacion() throws Exception {
    }

    @Override
    protected String addT() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre_activo() {
        return nombre_activo;
    }

    public void setNombre_activo(String nombre_activo) {
        this.nombre_activo = nombre_activo;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }


    @Override
    protected String updateT() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String deleteT() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT  ac.codigo,b.nombre,ub.aula,ub.piso"
               + " FROM  activo ac,bien b,ubicacion ub"
               + " WHERE ac.fkidbien=b.idbien and ac.fkidubicacion=ub.idubicacion";

    }

    @Override
    protected int currentColumn() throws Exception {
        return 6;
    } 
}
