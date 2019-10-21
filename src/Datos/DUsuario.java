/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.util.*;
/**
 *
 * @author USUARIO
 */
public class DUsuario extends Template {

    private int idusuario;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String direccion;
    private String telefono;
    private int idcargo;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public DUsuario() throws Exception {
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }

    @Override
    protected String addT() throws Exception {
        return "INSERT INTO usuario( nombre, apellido, email, password, direccion, telefono, fkidcargo, estado)"
                + " VALUES ('" + getNombre() + "', '" + getApellido() + "', '" + getEmail() + "', '"
                + getPassword() + "', '" + getDireccion() + "', '" + getTelefono() + "', " + getIdcargo() + ", '" + getEstado() + "');";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE usuario"
                + " SET nombre='" + getNombre() + "', apellido='" + getApellido() 
                + "', direccion='" + getDireccion()+ "', telefono='" + getTelefono() + "'" 
                + " WHERE idusuario = " + getIdusuario() + ";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE usuario "
                + "SET estado='0' " + "WHERE idusuario=" + getIdusuario() + ";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT nombre, apellido, email, direccion, telefono"
                + " FROM usuario";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 2;
    }

}
