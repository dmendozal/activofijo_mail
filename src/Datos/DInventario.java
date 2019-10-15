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
public class DInventario extends Template {

    private int idinventario;
    private int idbien;
    private String estado;
    private int cantidad;
    private String nombre;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public DInventario() throws Exception {
    }

    public int getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(int idinventario) {
        this.idinventario = idinventario;
    }

    public int getIdbien() {
        return idbien;
    }

    public void setIdbien(int idbien) {
        this.idbien = idbien;
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO inventario( fkidbien, estado )"
                + "    VALUES (" + getIdbien() + " ,'1');";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE inventario"
                + " SET fkidbien=" + getIdbien()
                + " WHERE idinventario = " + getIdinventario() + ";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE inventario"
                + " SET estado='0' "
                + " WHERE idinventario = " + getIdinventario() + ";";
    }

    @Override
    protected String getAllT() throws Exception {
      return  "SELECT b.nombre,i.cantidad"
                +"FROM bien b, inventario i"
                +"where b.idbien = i.fkidbien and i.estado='1'";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 2;
    }

}
