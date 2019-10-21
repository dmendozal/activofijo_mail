/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DEstado;
import Datos.DReporteActivos_usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class NReporte {

    private DReporteActivos_usuario reporte;

    public NReporte() throws Exception {
        this.reporte = new DReporteActivos_usuario();
    }

    public DReporteActivos_usuario getInfo() {
        return reporte;
    }

    private List<DReporteActivos_usuario> getAll() throws Exception {
        List<DReporteActivos_usuario> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.reporte.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DReporteActivos_usuario oo = new DReporteActivos_usuario();

                oo.setNombre_usuario(obj.get(0).toString());
                oo.setApellido(obj.get(1).toString());
                oo.setCodigo(obj.get(2).toString());
                oo.setNombre_bien(obj.get(3).toString());
                oo.setSigla(obj.get(4).toString());
                oo.setNombre_estado(obj.get(5).toString());
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
            List<DReporteActivos_usuario> lObj = this.getAll();

            rx = "<center><h2>REPORTE POR USUARIO CON SUS ACTIVOS CORRESPONDIENTES</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >"
                    + "             <thead>\n"
                    + "                   <tr >\n"
                    + "                         <th>USUARIO</th>\n"
                    + "                         <th>APELLIDO</th>\n"
                    + "                         <th>CODIGO</th>\n"
                    + "                         <th>ACTIVO</th>\n"
                    + "                         <th>SIGLA</th>\n"
                    + "                         <th>ESTADO</th>\n"
                    + "                   </tr>\n"
                    + "             </thead>\n"
                    + "                  <tbody> ";
            for (DReporteActivos_usuario obj : lObj) {
                rx = rx
                        + "<tr style=\"\">\n"
                        + "   <td>" + obj.getNombre_usuario() + "</td>\n"
                        + "   <td>" + obj.getApellido() + "</td>\n"
                        + "   <td>" + obj.getCodigo() + "</td>\n"
                        + "   <td>" + obj.getNombre_bien() + "</td>\n"
                        + "   <td>" + obj.getSigla() + "</td>\n"
                        + "   <td>" + obj.getNombre_estado() + "</td>\n"
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
