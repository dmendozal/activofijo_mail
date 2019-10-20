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
public class DMantenimiento extends Template {

    private int idmantenimiento;
    private String fecha_ingreso;
    private String fecha_devolucion;
    private int estado;
    private int fkidactivo;
    private int fkidempresa;

    public int getIdmantenimiento() {
        return idmantenimiento;
    }

    public void setIdmantenimiento(int idmantenimiento) {
        this.idmantenimiento = idmantenimiento;
    }

    public String getFechaIngreso() {
        return fecha_ingreso;
    }

    public void setFechaIngreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getFechaDevolucion() {
        return fecha_devolucion;
    }

    public void setFechaDevolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getFkidactivo() {
        return fkidactivo;
    }

    public void setFkidactivo(int fkidactivo) {
        this.fkidactivo = fkidactivo;
    }

    public int getFkidempresa() {
        return fkidempresa;
    }

    public void setFkidempresa(int fkidempresa) {
        this.fkidempresa = fkidempresa;
    }

    public DMantenimiento() throws Exception {
    }

    @Override
    public String toString() {
        return "Mantenimiento{"
                + "idmantenimiento='" + getIdmantenimiento() + '\''
                + ", fecha_ingreso='" + getFechaIngreso() + '\''
                + ", fecha_devolucion='" + getFechaDevolucion() + '\''
                + ", fkidactivo='" + getFkidactivo() + '\''
                + ", fkidempresa='" + getFkidempresa() + '\''
                + ", estado='" + getEstado() + '\''
                + '}';
    }

    @Override
    protected String addT() throws Exception {
        String sql = "INSERT INTO mantenimiento( fecha_ingreso, fecha_devolucion, fkidactivo, fkidempresa, estado) "
                + "VALUES ('" + getFechaIngreso() + "', '" + getFechaDevolucion() + "'," + getFkidactivo() + "," + getFkidempresa() + ",'"+ getEstado() +"');";
        System.out.println(sql);
        return "INSERT INTO mantenimiento( fecha_ingreso, fecha_devolucion, fkidactivo, fkidempresa, estado) "
                + "VALUES ('" + getFechaIngreso() + "', '" + getFechaDevolucion() + "'," + getFkidactivo() + "," + getFkidempresa() + ",'"+ getEstado() +"');";
    }

    @Override
    protected String updateT() throws Exception {
        return "UPDATE mantenimiento"
                + " SET fecha_ingreso='" + getFechaIngreso()+ "', "
                + "fecha_devolucion='" + getFechaDevolucion()+"', "
                + "fkidactivo="+getFkidactivo()
                +", fkidempresa="+getFkidempresa()
                + " WHERE idmantenimiento= " + getIdmantenimiento()+ ";";
    }

    @Override
    protected String deleteT() throws Exception {
        return "UPDATE mantenimiento "
                + "SET estado='0' " + "WHERE idmantenimiento=" + getIdmantenimiento()+ ";";
    }

    @Override
    protected String getAllT() throws Exception {
        return "SELECT idmantenimiento, fecha_ingreso, fecha_devolucion, fkidactivo, fkidempresa"
                + " FROM mantenimiento"
                + " WHERE estado='1'";
    }

    @Override
    protected int currentColumn() throws Exception {
        return 5;
    }
}
