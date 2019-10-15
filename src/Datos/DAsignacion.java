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
public class DAsignacion extends Template {

    private int idactivo;
    private int idusuario;
    private String estado;

    public int getIdactivo() {
        return idactivo;
    }

    public void setIdactivo(int idactivo) {
        this.idactivo = idactivo;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public DAsignacion() throws Exception {
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO asignacion( fkidactivo, fkidusuario, estado)"
                + "    VALUES (" + getIdusuario() + ", " + getIdactivo() + ", '" + getEstado() + "');";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE asignacion"
                + " SET fkidusuario=" + getIdusuario() + ", fkidactivo=" + getIdactivo()
                + " WHERE fkidusuario = " + getIdusuario() + ";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE asignacion "
                + "SET estado='0' " + "WHERE fkidusuario=" + getIdusuario() + " and fkidactivo=" + getIdactivo() + ";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT DISTINCT u.nombre,ac.codigo,b.nombre,b.descripcion"
                + "FROM asignacion asg ,activo ac,usuario u,bien b"
                + "where asg.fkidusuario = u.idusuario and asg.fkidactivo = ac.idactivo and ac.fkidbien = b.idbien";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 2;
    }

}
