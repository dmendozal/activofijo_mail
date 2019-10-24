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
public class DReporteActivos_usuario extends Template {

    private String nombre_usuario;
    private String apellido;
    private String codigo;
    private String nombre_bien;
    private String sigla;
    private String nombre_estado;

    public DReporteActivos_usuario() throws Exception {
    }

    @Override
    protected String addT() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre_bien() {
        return nombre_bien;
    }

    public void setNombre_bien(String nombre_bien) {
        this.nombre_bien = nombre_bien;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre_estado() {
        return nombre_estado;
    }

    public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
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
        return "SELECT  u.nombre,u.apellido,ac.codigo,b.nombre,e.sigla,e.nombre"
                + " FROM usuario u,activo ac,asignacion asg,bien b,estado e"
                + " WHERE asg.fkidusuario=u.idusuario and asg.fkidactivo=ac.idactivo and ac.fkidbien=b.idbien and ac.fkidestado=e.idestado";

    }

    @Override
    protected int currentColumn() throws Exception {
        return 6;
    }

}
