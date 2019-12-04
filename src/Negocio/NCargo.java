/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DCargo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joalgt
 */
public class NCargo {
    private DCargo o;

    public NCargo() throws Exception {
        this.o = new DCargo();
    }

    public DCargo getInfo() {
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
            o.setIdcargo(id);
            o.setNombre(nombre);
            o.setDescripcion(descripcion);
            o.update();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void delete(int id) throws Exception {
        try {
            o.setIdcargo(id);
            o.delete();
        } catch (Exception e) {
            throw e;
        }

    }
    
    private List<DCargo> getAll() throws Exception {
        List<DCargo> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DCargo oo = new DCargo();

                oo.setNombre(obj.get(0).toString());
                oo.setDescripcion(obj.get(1).toString());

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
            List<DCargo> lObj = this.getAll();

            rx = "<center><h2>LISTA DE TIPO DE CARGOS</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >"
                    + "             <thead>\n"
                    + "                   <tr >\n"
                    + "                         <th>NOMBRE</th>\n"
                    + "                         <th>DESCRIPCION</th>\n"
                    + "                   </tr>\n"
                    + "             </thead>\n"
                    + "                  <tbody> ";
            for (DCargo obj : lObj) {
                rx = rx
                        + "<tr style=\"\">\n"
                        + "   <td>" + obj.getNombre() + "</td>\n"
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
