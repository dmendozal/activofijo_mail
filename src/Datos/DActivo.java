/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.PreparedStatement;

/**
 *
 * @author D-M-7
 */
public class DActivo extends Template {

    private int idactivo;
    private String codigo;
    private int estado;
    private int fkidestado;
    private int fkidbien;
    private int fkidubicacion;
    private String qr;

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public int getIdactivo() {
        return idactivo;
    }

    public void setIdactivo(int idactivo) {
        this.idactivo = idactivo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getFkidestado() {
        return fkidestado;
    }

    public void setFkidestado(int fkidestado) {
        this.fkidestado = fkidestado;
    }

    public int getFkidbien() {
        return fkidbien;
    }

    public void setFkidbien(int fkidbien) {
        this.fkidbien = fkidbien;
    }

    public int getFkidubicacion() {
        return fkidubicacion;
    }

    public void setFkidubicacion(int fkidubicacion) {
        this.fkidubicacion = fkidubicacion;
    }

    public DActivo() throws Exception {
    }
    
    Conexion conexion;

    private void sql(String sql) throws Exception {
                this.conexion = Conexion.getConexion();

        System.out.println("sql = [" + sql + "]");
        try {
            PreparedStatement st = this.conexion.conectar().prepareStatement(sql);
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.conexion.desconectar();
        }
    }


    @Override
    public String toString() {
        return "Activo{"
                + "idactivo='" + getIdactivo() + '\''
                + ", codigo='" + getCodigo() + '\''
                + ", estado='" + getEstado() + '\''
                + ", fkidestado='" + getFkidestado() + '\''
                + ", fkidbien='" + getFkidbien() + '\''
                + ", fkidubicacion='" + getFkidubicacion() + '\''
                + '}';
    }

    @Override
    protected String addT() throws Exception {
        String sql = "INSERT INTO activo( codigo, estado, fkidestado, fkidbien, fkidubicacion, qr) "
                + "VALUES ('" + getCodigo() + "', '" + getEstado() + "'," + getFkidestado() + "," + getFkidbien() + "," + getFkidubicacion() + ",'"+getQr()+ "'" + ");";
        System.out.println(sql);
        return sql;
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE activo"
                + " SET codigo='" + getCodigo() + "', "
                + "fkidestado=" + getFkidestado() + ", "
                + "fkidbien=" + getFkidbien()
                + ", fkidubicacion=" + getFkidubicacion()
                + " WHERE idactivo= " + getIdactivo() + ";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE activo "
                + "SET estado='0' " + "WHERE idactivo=" + getIdactivo() + ";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT idactivo, codigo, fkidestado, fkidbien, fkidubicacion, qr"
                + " FROM activo"
                + " WHERE estado='1'";
    }

    public String findUbicaion(int fkidubicacion) {
        String s = "SELECT aula, piso"
                + " FROM ubicacion"
                + " WHERE idubicacion="+fkidubicacion;
       
        return s;
    }

    @Override
    protected int currentColumn() throws Exception {
        return 6;
    }
}
