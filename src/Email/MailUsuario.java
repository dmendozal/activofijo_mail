/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import Negocio.NUsuario;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

/**
 *
 * @author USUARIO
 */
public class MailUsuario extends TemplateMail {

    private NUsuario usuario;

    public MailUsuario() throws Exception {
        this.usuario = new NUsuario();
    }

    @Override
    protected boolean insertar(Anacom anacom, String correo) throws Exception {
        try {
            anacom.Avanzar();
            String nombre = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
            anacom.Avanzar();
            anacom.Avanzar();
            String apellido = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
            anacom.Avanzar();
            anacom.Avanzar();
            String email = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
            anacom.Avanzar();
            anacom.Avanzar();
            String password = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
            anacom.Avanzar();
            anacom.Avanzar();
            String direccion = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
            anacom.Avanzar();
            anacom.Avanzar();
            String telefono = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
            anacom.Avanzar();
            anacom.Avanzar();
            int idcargo = anacom.Preanalisis().getAtributo();

            usuario.add(nombre, apellido, email, password, direccion, telefono, idcargo);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    protected boolean modificar(Anacom anacom, String correo) throws Exception {
        try {
            anacom.Avanzar();
            int idusuario = anacom.Preanalisis().getAtributo();
            anacom.Avanzar();
            anacom.Avanzar();
            String nombre = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
            anacom.Avanzar();
            anacom.Avanzar();
            String apellido = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
            anacom.Avanzar();
            anacom.Avanzar();
            String direccion = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
            anacom.Avanzar();
            anacom.Avanzar();
            String telefono = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
            anacom.Avanzar();
            anacom.Avanzar();
            usuario.update(idusuario, nombre, apellido, direccion, telefono);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    protected boolean eliminar(Anacom anacom, String correo) throws Exception {
        try {
            anacom.Avanzar();
            int idusuario = anacom.Preanalisis().getAtributo();
            usuario.delete(idusuario);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    @Override
    protected String listar() throws Exception {
        try {
            return usuario.Mostrar();
        } catch (Exception e){
            throw e;
        }    }

    @Override
    protected String messageCreate(boolean sw) {
        return (sw) ? "Contenido registrado exitosamente con id: "  + usuario.getInfo().toString() : "No se pudo registrar el contenido";
    }

    @Override
    protected String messageEdit(boolean sw) {
        return (sw) ? "Contenido modificado exitosamente con id: " + usuario.getInfo().toString() : "No se pudo modificar el contenido";
    }

    @Override
    protected String messageRemove(boolean sw) {
        return (sw) ? "Contenido eliminado exitosamente con id: " + usuario.getInfo().toString() : "No se pudo eliminar el contenido";
    }

    @Override
    protected String messageFindAll(boolean sw) {
        return (sw) ? "Listado de contenidos: " : "No se pudo encontrar en listado de contenidos";
    }

}
