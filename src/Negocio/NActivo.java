/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DActivo;
import Datos.DBien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author D-M-7
 */
public class NActivo {

    private DActivo o;

    public NActivo() throws Exception {
        this.o = new DActivo();
    }

    public DActivo getInfo() {
        return o;
    }

    public void add(String codigo, int fkidestado, int fkidbien, int fkidubicacion) throws Exception {
        try {
            o.setCodigo(codigo);
            o.setFkidestado(fkidestado);
            o.setFkidbien(fkidbien);
            o.setFkidubicacion(fkidubicacion);
            o.setEstado(1);
            o.add();
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(int id, String codigo, int fkidestado, int fkidbien, int fkidubicacion) throws Exception {
        try {
            o.setIdactivo(id);
            o.setCodigo(codigo);
            o.setFkidestado(fkidestado);
            o.setFkidbien(fkidbien);
            o.setFkidubicacion(fkidubicacion);
            o.update();
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(int id) throws Exception {
        try {
            o.setIdactivo(id);
            o.delete();
        } catch (Exception e) {
            throw e;
        }

    }

    private List<DActivo> getAll() throws Exception {
        List<DActivo> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DActivo oo = new DActivo();
                oo.setIdactivo(Integer.valueOf(obj.get(0).toString()));
                oo.setCodigo(obj.get(1).toString());
                oo.setFkidestado(Integer.valueOf(obj.get(2).toString()));
                oo.setFkidbien(Integer.valueOf(obj.get(3).toString()));
                oo.setFkidubicacion(Integer.valueOf(obj.get(4).toString()));
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
            List<DActivo> lObj = this.getAll();

            rx = "<center><h2>LISTA DE ACTIVOS</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >"
                    + "             <thead>\n"
                    + "                   <tr >\n"
                    + "                         <th>ID</th>\n"
                    + "                         <th>CODIGO</th>\n"
                    + "                         <th>ESTADO</th>\n"
                    + "                         <th>BIEN</th>\n"
                    + "                         <th>UBICACION</th>\n"
                    + "                   </tr>\n"
                    + "             </thead>\n"
                    + "                  <tbody> ";
            for (DActivo obj : lObj) {
                rx = rx
                        + "<tr style=\"\">\n"
                        + "   <td>" + obj.getIdactivo()+ "</td>\n"
                        + "   <td>" + obj.getCodigo() + "</td>\n"
                        + "   <td>" + obj.getFkidestado() + "</td>\n"
                        + "   <td>" + obj.getFkidbien() + "</td>\n"
                        + "   <td>" + obj.getFkidubicacion() + "</td>\n"
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
