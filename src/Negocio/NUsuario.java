/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DUsuario;
import java.util.ArrayList;
import java.util.List;
import java.security.AccessControlContext;
/**
 *
 * @author USUARIO
 */
public class NUsuario {

    private DUsuario dUsuario;

    public NUsuario() throws Exception {
        this.dUsuario = new DUsuario();
    }

    public DUsuario getInfo() {
        return dUsuario;
    }

    public void add(String nombre, String apellido, String email, String password, String direccion, String telefono, int idCargo) throws Exception {
        try {
            dUsuario.setNombre(nombre);
            dUsuario.setApellido(apellido);
            dUsuario.setEmail(email);
            dUsuario.setPassword(password);
            dUsuario.setDireccion(direccion);
            dUsuario.setTelefono(telefono);
            dUsuario.setIdcargo(idCargo);
            dUsuario.setEstado("1");
            dUsuario.add();
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(int idusuario, String nombre, String apellido, String direccion, String telefono) throws Exception {
        try {
            dUsuario.setIdusuario(idusuario);
            dUsuario.setNombre(nombre);
            dUsuario.setApellido(apellido);
            dUsuario.setDireccion(direccion);
            dUsuario.setTelefono(telefono);
            dUsuario.update();
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(int idusuario) throws Exception {
        try {
            dUsuario.setIdusuario(idusuario);
            dUsuario.delete();
        } catch (Exception e) {
            throw e;
        }

    }

    private List<DUsuario> getAll() throws Exception {
        List<DUsuario> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.dUsuario.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DUsuario oo = new DUsuario();

                oo.setNombre(obj.get(0).toString());
                oo.setApellido(obj.get(1).toString());
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
            List<DUsuario> lObj = this.getAll();

            rx = "<center><h2>LISTA DE TIPO DE OFERTAS</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >"
                    + "             <thead>\n"
                    + "                   <tr >\n"
                    + "                         <th>SIGLA</th>\n"
                    + "                         <th>NOMBRE</th>\n"
                    + "                   </tr>\n"
                    + "             </thead>\n"
                    + "                  <tbody> ";
            for (DUsuario obj : lObj) {
                rx = rx
                        + "<tr style=\"\">\n"
                        + "   <td>" + obj.getNombre() + "</td>\n"
                        + "   <td>" + obj.getApellido() + "</td>\n"
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
