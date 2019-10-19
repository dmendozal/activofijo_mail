/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author D-M-7
 */
public class DEstado extends Template {

    private int idestado;
    private String sigla;
    private String nombre;
    private int estado;

    public DEstado() throws Exception{}

     public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


   @Override
    public String toString() {
        return "Estado{" +
                "idestado='" + idestado + '\'' +
                ", sigla='" + sigla + '\'' +
                ", nombre='" + nombre + '\''+
                ", estado='" + estado + '\'' +
                '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO estado( sigla, nombre, estado)" +
                "    VALUES ('"+ getSigla() +"', '"+ getNombre() +"', '"+ getEstado() +"');";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE estado" +
                " SET sigla='"+getSigla()+"', nombre='"+ getNombre()+"'" +
                " WHERE idestado = "+ getIdestado()+";";                                                                                                                                                                               
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE estado " +
                "SET estado='0' "+"WHERE idestado="+getIdestado()+";";
    }

    @Override
    protected String getAllT() throws Exception {
            return "SELECT nombre, sigla" +
                " FROM Estado" +
                " WHERE estado='1'";
    }

    @Override
    protected int currentColumn() throws Exception {
       return 2;
    }
}
