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
public class DBien extends Template {

    private int idbien;
    private String nombre;
    private String descripcion;
    private int estado;

    public int getIdbien() {
        return idbien;
    }

    public void setIdbien(int idbien) {
        this.idbien = idbien;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public DBien() throws Exception {
    }

    @Override
    public String toString() {
        return "Bien{"
                + "idbien='" + getIdbien() + '\''
                + ", nombre='" + getNombre() + '\''
                + ", descripcion='" + getDescripcion() + '\''
                + '}';
    }

    @Override
    protected String addT() throws Exception {
        String sql = "INSERT INTO bien( nombre, descripcion, estado) "
                + "VALUES ('" + getNombre() + "', '" + getDescripcion() + "','" + getEstado() + "');";
        System.out.println(sql);
        return sql;
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE bien"
                + " SET nombre='" + getNombre()+ "', "
                + "descripcion='" + getDescripcion()+ "'"
                + " WHERE idbien= " + getIdbien() + ";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE bien "
                + "SET estado='0' " + "WHERE idbien=" + getIdbien() + ";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT idbien, nombre, descripcion"
                + " FROM bien"
                + " WHERE estado='1'";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 3;
    }
}
