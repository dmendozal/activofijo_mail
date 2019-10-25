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
public class DCargo extends Template {
    
    private int idcargo;
    private String nombre;
    private String descripcion;
    private int estado;
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
   
    
    public DCargo() throws Exception{}

    public int getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "Cargo{" +
                "idcargo='" + idcargo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\''+
                ", estado='" + estado + '\'' +
                '}';
    }
    
    @Override
    protected String addT() throws Exception {
        return "INSERT INTO cargo(nombre,descripcion,estado)"
                + " VALUES ('" + getNombre() + "','" + getDescripcion()+"','"+ getEstado() +"');";
    }
    
    @Override
    protected String updateT() throws Exception {
        return "UPDATE cargo" +
                " SET nombre='"+getNombre()+"', descripcion='"+ getDescripcion()+"'" +
                " WHERE idcargo = "+ getIdcargo()+";";                                                                                                                                                                               
    }
    
        @Override
    protected String deleteT() throws Exception {
        return "UPDATE cargo " +
                "SET estado='0' "+"WHERE idcargo="+getIdcargo()+";";
    }
        @Override
    protected String getAllT() throws Exception {
            return "SELECT nombre, descripcion" +
                " FROM Cargo" +
                " WHERE estado='1'";
    }

    @Override
    protected int currentColumn() throws Exception {
       return 2;
    }
}
