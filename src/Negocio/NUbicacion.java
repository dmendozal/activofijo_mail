/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DUbicacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joalgt
 */
public class NUbicacion {

    private DUbicacion o;

    public NUbicacion() throws Exception {
        this.o = new DUbicacion();
    }

    public DUbicacion getInfo() {
        return o;
    }

    public void add(int piso, int aula) throws Exception {
        try {
            o.setPiso(piso);
            o.setAula(aula);
            o.setEstado(1);
            o.add();
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(int id, int piso, int aula) throws Exception {
        try {
            o.setIdubicacion(id);
            o.setPiso(piso);
            o.setAula(aula);
            o.update();
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(int id) throws Exception {
        try {
            o.setIdubicacion(id);
            o.delete();
        } catch (Exception e) {
            throw e;
        }

    }

    private List<DUbicacion> getAll() throws Exception {
        List<DUbicacion> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DUbicacion oo = new DUbicacion();
                oo.setIdubicacion(Integer.valueOf(obj.get(0).toString()));
                oo.setPiso(Integer.parseInt(obj.get(1).toString()));
                oo.setAula(Integer.parseInt(obj.get(2).toString()));

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
            List<DUbicacion> lObj = this.getAll();

            rx = "<center><h2>LISTA DE TIPO DE OFERTAS</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >"
                    + "             <thead>\n"
                    + "                   <tr >\n"
                    + "                         <th>ID_UBICACION</th>\n"
                    + "                         <th>AULA</th>\n"
                    + "                         <th>PISO</th>\n"
                    + "                   </tr>\n"
                    + "             </thead>\n"
                    + "                  <tbody> ";
            for (DUbicacion obj : lObj) {
                rx = rx
                        + "<tr style=\"\">\n"
                        + "   <td>" + obj.getIdubicacion() + "</td>\n"
                        + "   <td>" + obj.getPiso() + "</td>\n"
                        + "   <td>" + obj.getAula() + "</td>\n"
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
