package Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Template {

    protected abstract String addT() throws Exception;
    protected abstract String updateT() throws Exception;
    protected abstract String deleteT() throws Exception;
//    protected abstract String getByIdT() throws Exception;
    protected abstract String getAllT() throws Exception;

    protected abstract int currentColumn() throws Exception;

    Conexion conexion;

    public Template() throws Exception{
        this.conexion = Conexion.getConexion();
    }

    private void sql(String sql) throws Exception {
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

    private List<Object> listar(String sql) throws Exception{
        System.out.println("sql = [" + sql + "]");
        List<Object> lista = new ArrayList<>();
        try {
            Statement st = this.conexion.conectar().createStatement();
            ResultSet rx = st.executeQuery(sql);
            while (rx.next()) {
                List<Object> tupla = new ArrayList<>();
                for (int i = 1; i <= currentColumn(); i++) {
                    tupla.add(rx.getObject(i));
                }
                lista.add(tupla);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.conexion.desconectar();
        }
        return lista;
    }

    public void add() throws Exception{
        System.out.println("conexion add --> " + this.conexion.toString().hashCode());
        this.sql(addT());
    }

    public void update() throws Exception{
        System.out.println("conexion update --> " + this.conexion.toString().hashCode());
        this.sql(updateT());
    }

    public void delete() throws Exception{
        System.out.println("conexion delete --> " + this.conexion.toString().hashCode());
        this.sql(deleteT());
    }

    public List<Object> getAll() throws Exception{
        System.out.println("conexion getAll --> " + this.conexion.toString().hashCode());
        return this.listar(getAllT());
    }


    public ResultSet consultarDatos(String consulta) throws Exception{
        //Connection conn = (Connection) conexion.getConexion();
        ResultSet result = null;
        try {
            Statement st = this.conexion.conectar().createStatement();
            result = st.executeQuery(consulta);
            //st.close();
        } catch (SQLException e) {
            System.out.println("error en Template consultarDatos capa Datos");
            System.out.println(e);
        }
        return result;
    }

//    public T getById() throws Exception{
//        System.out.println("conexion getById --> " + this.conexion.toString().hashCode());
//        return this.listar(getByIdT());
//    }
}
