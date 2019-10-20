/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DBien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author D-M-7
 */
public class NBien {

    private DBien o;

    public NBien() throws Exception {
        this.o = new DBien();
    }

    public DBien getInfo() {
        return o;
    }

    public void add(String nombre, String descripcion) throws Exception {
        try {
            o.setNombre(nombre);
            o.setDescripcion(descripcion);
            o.setEstado(1);
            o.add();
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(int id, String nombre, String descripcion) throws Exception {
        try {
            o.setIdbien(id);
            o.setNombre(nombre);
            o.setDescripcion(descripcion);
            o.update();
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(int id) throws Exception {
        try {
            o.setIdbien(id);
            o.delete();
        } catch (Exception e) {
            throw e;
        }

    }

    private List<DBien> getAll() throws Exception {
        List<DBien> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DBien oo = new DBien();
                oo.setIdbien(Integer.valueOf(obj.get(0).toString()));
                oo.setNombre(obj.get(1).toString());
                oo.setDescripcion(obj.get(2).toString());
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
            List<DBien> lObj = this.getAll();

            rx = "<center><h2>LISTA DE BIENES</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >"
                    + "             <thead>\n"
                    + "                   <tr >\n"
                    + "                         <th>ID</th>\n"
                    + "                         <th>NOMBRE</th>\n"
                    + "                         <th>DESCRIPCION</th>\n"
                    + "                   </tr>\n"
                    + "             </thead>\n"
                    + "                  <tbody> ";
            for (DBien obj : lObj) {
                rx = rx
                        + "<tr style=\"\">\n"
                        + "   <td>" + obj.getIdbien() + "</td>\n"
                        + "   <td>" + obj.getNombre() + "</td>\n"
                        + "   <td>" + obj.getDescripcion() + "</td>\n"
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
