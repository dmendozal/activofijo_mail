/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DEmpresa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joalgt
 */
public class NEmpresa {
    
    private DEmpresa o;

    public NEmpresa() throws Exception {
        this.o = new DEmpresa();
    }

    public DEmpresa getInfo() {
        return o;
    }

    public void add(String razon_social, String email, String direccion, String telefono) throws Exception {
        try {
            o.setRazon_social(razon_social);
            o.setEmail(email);
            o.setDireccion(direccion);
            o.setTelefono(telefono);
            o.setEstado(1);
            o.add();
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(int id,String razon_social, String email, String direccion, String telefono) throws Exception {
        try {
            o.setIdempresa(id);
            o.setRazon_social(razon_social);
            o.setEmail(email);
            o.setDireccion(direccion);
            o.setTelefono(telefono);
            o.update();
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(int id) throws Exception {
        try {
            o.setIdempresa(id);
            o.delete();
        } catch (Exception e) {
            throw e;
        }

    }

    private List<DEmpresa> getAll() throws Exception {
        List<DEmpresa> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DEmpresa oo = new DEmpresa();

                oo.setRazon_social(obj.get(0).toString());
                oo.setEmail(obj.get(1).toString());
                oo.setDireccion(obj.get(2).toString());
                oo.setTelefono(obj.get(3).toString());

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
            List<DEmpresa> lObj = this.getAll();

            rx = "<center><h2>LISTA DE TIPO DE OFERTAS</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >"
                    + "             <thead>\n"
                    + "                   <tr >\n"
                    + "                         <th>RAZON_SOCIAL</th>\n"
                    + "                         <th>EMAIL</th>\n"
                    + "                         <th>DIRECCION</th>\n"
                    + "                         <th>TELEFONO</th>\n"
                    + "                   </tr>\n"
                    + "             </thead>\n"
                    + "                  <tbody> ";
            for (DEmpresa obj : lObj) {
                rx = rx
                        + "<tr style=\"\">\n"
                        + "   <td>" + obj.getRazon_social()+ "</td>\n"
                        + "   <td>" + obj.getEmail()+ "</td>\n"
                        + "   <td>" + obj.getDireccion()+ "</td>\n"
                        + "   <td>" + obj.getTelefono()+ "</td>\n"
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


