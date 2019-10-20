/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DMantenimiento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author D-M-7
 */
public class NMantenimiento {
    private DMantenimiento o;

    public NMantenimiento() throws Exception {
        this.o = new DMantenimiento();
    }

    public DMantenimiento getInfo() {
        return o;
    }

    public void add(String fecha_ingreso, String fecha_devolucion,int fkidactivo, int fkidempresa) throws Exception {
        try {
            o.setFechaIngreso(fecha_ingreso);
            o.setFechaDevolucion(fecha_devolucion);
            o.setFkidactivo(fkidactivo);
            o.setFkidempresa(fkidempresa);
            o.setEstado(1);
            o.add();
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(int id, String fecha_ingreso, String fecha_devolucion,int fkidactivo, int fkidempresa) throws Exception {
        try {
            o.setIdmantenimiento(id);
            o.setFechaIngreso(fecha_ingreso);
            o.setFechaDevolucion(fecha_devolucion);
            o.setFkidactivo(fkidactivo);
            o.setFkidempresa(fkidempresa);
            o.update();
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(int id) throws Exception {
        try {
            o.setIdmantenimiento(id);
            o.delete();
        } catch (Exception e) {
            throw e;
        }

    }

    private List<DMantenimiento> getAll() throws Exception {
        List<DMantenimiento> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DMantenimiento oo = new DMantenimiento();
                oo.setIdmantenimiento(Integer.valueOf(obj.get(0).toString()));
                oo.setFechaIngreso(obj.get(1).toString());
                oo.setFechaDevolucion(obj.get(2).toString());
                oo.setFkidactivo(Integer.valueOf(obj.get(3).toString()));
                oo.setFkidempresa(Integer.valueOf(obj.get(4).toString()));

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
            List<DMantenimiento> lObj = this.getAll();

            rx = "<center><h2>LISTA DE ACTIVOS EN MANTENIMIENTOS</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >"
                    + "             <thead>\n"
                    + "                   <tr >\n"
                    + "                         <th>FECHA DE INGRESO</th>\n"
                    + "                         <th>FECHA DE DEVOLUCION</th>\n"
                    + "                         <th>ACTIVO</th>\n"
                    + "                         <th>EMPRESA</th>\n"
                    + "                   </tr>\n"
                    + "             </thead>\n"
                    + "                  <tbody> ";
            for (DMantenimiento obj : lObj) {
                rx = rx
                        + "<tr style=\"\">\n"
                        + "   <td>" + obj.getFechaIngreso() + "</td>\n"
                        + "   <td>" + obj.getFechaDevolucion() + "</td>\n"
                        + "   <td>" + obj.getFkidactivo() + "</td>\n"
                        + "   <td>" + obj.getFkidempresa() + "</td>\n"
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
