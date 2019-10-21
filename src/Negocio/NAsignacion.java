/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DAsignacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class NAsignacion {

    private DAsignacion asignacion;

    public NAsignacion() throws Exception {
        this.asignacion = new DAsignacion();
    }

    public DAsignacion getInfo() {
        return asignacion;
    }

    public void add(int idusuario, int idactivo) throws Exception {
        try {
            asignacion.setIdusuario(idusuario);
            asignacion.setIdactivo(idactivo);
            asignacion.setEstado("1");
            asignacion.add();
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(int idusuario, int idactivo) throws Exception {
        try {
            asignacion.setIdusuario(idusuario);
            asignacion.setIdactivo(idactivo);
            asignacion.update();
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(int idusuario, int idactivo) throws Exception {
        try {
            asignacion.setIdusuario(idusuario);
            asignacion.setIdactivo(idactivo);
            asignacion.delete();
        } catch (Exception e) {
            throw e;
        }

    }

    private List<Objeto> getAll() throws Exception {
        List<Objeto> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.asignacion.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                Objeto oo = new Objeto();

                oo.setNombreUsuario(obj.get(0).toString());
                oo.setCodigo(obj.get(1).toString());
                oo.setNombreBien(obj.get(2).toString());
                oo.setDescripcion(obj.get(3).toString());
                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }

    public String Mostrar() throws Exception {
        String rx = "";
        try {
            List<Objeto> lObj = this.getAll();

            rx = "<center><h2>LISTA DE ASIGNACIONES</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >"
                    + "             <thead>\n"
                    + "                   <tr >\n"
                    + "                         <th>NOMBRE</th>\n"
                    + "                         <th>CODIGO</th>\n"
                    + "                         <th>NOMBRE DEL BIEN</th>\n"  
                    + "                         <th>DESCRIPCION</th>\n"
                    + "                   </tr>\n"
                    + "             </thead>\n"
                    + "                  <tbody> ";
            for (Objeto obj : lObj) {
                rx = rx
                        + "<tr style=\"\">\n"
                        + "   <td>" + obj.getNombreUsuario() + "</td>\n"
                        + "   <td>" + obj.getCodigo() + "</td>\n"
                        + "   <td>" + obj.getNombreBien()+ "</td>\n"
                        + "   <td>" + obj.getDescripcion()+ "</td>\n"
                        + "</tr>\n";
            }
            rx += "  </tbody>\n"
                    + "</table>\n";
        } catch (Exception e) {
            throw e;
        }
        return rx;
    }

}
