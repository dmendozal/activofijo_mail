/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DEstado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author D-M-7
 */
public class NEstado {

    private DEstado o;

    public NEstado() throws Exception {
        this.o = new DEstado();
    }

    public DEstado getInfo() {
        return o;
    }

    public void add(String sigla, String nombre) throws Exception {
        try {
            o.setSigla(sigla);
            o.setNombre(nombre);
            o.setEstado(1);
            o.add();
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(int id, String sigla, String nombre) throws Exception {
        try {
            o.setIdestado(id);
            o.setNombre(nombre);
            o.setSigla(sigla);
            o.update();
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(int id) throws Exception {
        try {
            o.setIdestado(id);
            o.delete();
        } catch (Exception e) {
            throw e;
        }

    }

    private List<DEstado> getAll() throws Exception {
        List<DEstado> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DEstado oo = new DEstado();

                oo.setNombre(obj.get(0).toString());
                oo.setSigla(obj.get(1).toString());

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
            List<DEstado> lObj = this.getAll();

            rx = "<center><h2>LISTA DE TIPO DE OFERTAS</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >"
                    + "             <thead>\n"
                    + "                   <tr >\n"
                    + "                         <th>SIGLA</th>\n"
                    + "                         <th>NOMBRE</th>\n"
                    + "                   </tr>\n"
                    + "             </thead>\n"
                    + "                  <tbody> ";
            for (DEstado obj : lObj) {
                rx = rx
                        + "<tr style=\"\">\n"
                        + "   <td>" + obj.getNombre() + "</td>\n"
                        + "   <td>" + obj.getSigla() + "</td>\n"
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
