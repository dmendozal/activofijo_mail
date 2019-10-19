package Datos;

import Nucleo.utilidades.Constantes;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static Connection cnx;
    private static final String DB_URL = Constantes.DB_URL;
    private static final String DRIVER = Constantes.DRIVER;
    private static final String USER = Constantes.USER;
    private static final String PASS = Constantes.PASS;

    // private static Conexion conexion = new Conexion();
    private static Conexion conexion;

    // para evitar la instancia mediante el operador new
    private Conexion() {
    }

    public static Conexion getConexion() {
        if(conexion == null){
            conexion = new Conexion();
        }
        return conexion;
    }

    /**
     * @return
     * @throws Exception
     */
    public Connection conectar() throws Exception {
        try {
            cnx = DriverManager.getConnection(DB_URL,USER,PASS);
            Class.forName(DRIVER);
        } catch (Exception e) {
            throw e;
        }
        return cnx;
    }

    /**
     *
     * @throws Exception
     */
    public void desconectar() throws Exception {
        if(cnx != null){
            if(!cnx.isClosed()){
                cnx.close();
            }
        }
    }


}
