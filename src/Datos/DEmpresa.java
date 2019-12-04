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
public class DEmpresa extends Template {

    private int idempresa;
    private String razon_social;
    private String email;
    private String direccion;
    private String telefono;
    private int estado;

    public DEmpresa() throws Exception {
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Empresa{"
                + "idempresa='" + idempresa + '\''
                + ", razon_social='" + razon_social + '\''
                + ", email='" + email + '\''
                + ", direccion='" + direccion + '\''
                + ", telefono='" + telefono + '\''
                + ", estado='" + estado + '\''
                + '}';
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO empresa( razon_social, email, direccion, telefono,estado )"
                + "    VALUES ('" + getRazon_social() + "', '" + getEmail() + "', '" + getDireccion() + "', '" + getTelefono() + "', '" + getEstado() + "' );";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE empresa"
                + " SET razon_social='" + getRazon_social() + "', email='" + getEmail() + "'" + ", direccion='" + getDireccion() + "', telefono='" + getTelefono() + "'"
                + " WHERE idempresa = " + getIdempresa() + ";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE empresa "
                + "SET estado='0' " + "WHERE idempresa=" + getIdempresa() + ";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT idempresa, razon_social, email, direccion, telefono"
                + " FROM empresa"
                + " WHERE estado='1'";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 5;
    }
}
