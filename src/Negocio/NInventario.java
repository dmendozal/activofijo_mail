/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DInventario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class NInventario {

    private DInventario inventario;

    public NInventario() throws Exception {
        this.inventario = new DInventario();
    }

    public DInventario getInfo() {
        return inventario;
    }
    
    public void add(int idbien) throws Exception {
        try {
            inventario.setIdbien(idbien);
            inventario.setEstado("1");
            inventario.add();
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(int idinventario, int idabien) throws Exception {
        try {
            inventario.setIdinventario(idinventario);
            inventario.setIdbien(idabien);
            inventario.update();
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(int idinventario) throws Exception {
        try {
            inventario.setIdinventario(idinventario);
            inventario.delete();
        } catch (Exception e) {
            throw e;
        }

    }
    
        private List<DInventario> getAll() throws Exception {
        List<DInventario> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.inventario.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DInventario oo = new DInventario();

                oo.setNombre(obj.get(0).toString());
                oo.setCantidad(Integer.parseInt(obj.get(1).toString()));

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
            List<DInventario> lObj = this.getAll();

            rx = "<center><h2>LISTA DE TIPO DE OFERTAS</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >"
                    + "             <thead>\n"
                    + "                   <tr >\n"
                    + "                         <th>Activo</th>\n"
                    + "                         <th>Cantidad</th>\n"
                    + "                   </tr>\n"
                    + "             </thead>\n"
                    + "                  <tbody> ";
            for (DInventario obj : lObj) {
                rx = rx
                        + "<tr style=\"\">\n"
                        + "   <td>" + obj.getNombre() + "</td>\n"
                        + "   <td>" + obj.getCantidad()+ "</td>\n"
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
