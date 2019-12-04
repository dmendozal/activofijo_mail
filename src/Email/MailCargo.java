/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;


import Negocio.NCargo;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

/**
 *
 * @author Joalgt
 */
public class MailCargo extends TemplateMail {
        private NCargo o;

    public MailCargo() throws Exception{
        this.o = new NCargo();
    }
    
    @Override
    protected boolean insertar(Anacom anacom, String correo) throws Exception {
        try {
            anacom.Avanzar();
            String nombre = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
            anacom.Avanzar();
            anacom.Avanzar();
            String descripcion = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());

            o.add(nombre,descripcion);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    protected boolean modificar(Anacom anacom, String correo) throws Exception{
        try {
            anacom.Avanzar();
            int idcargo = anacom.Preanalisis().getAtributo();
            anacom.Avanzar();
            anacom.Avanzar();
            String nombre = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
            anacom.Avanzar();
            anacom.Avanzar();
            String descripcion = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
            o.update(idcargo, nombre, descripcion);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected boolean eliminar(Anacom anacom, String correo) throws Exception{
        try {
            anacom.Avanzar();
            int id = anacom.Preanalisis().getAtributo();
            o.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    protected String listar() throws Exception {
        try {
            return o.Mostrar();
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    protected String messageCreate(boolean sw) {
        return (sw) ? "Contenido registrado exitosamente con id: "  + o.getInfo().toString() : "No se pudo registrar el contenido";

    }

    @Override
    protected String messageEdit(boolean sw) {
        return (sw) ? "Contenido modificado exitosamente con id: " + o.getInfo().toString() : "No se pudo modificar el contenido";

    }

    @Override
    protected String messageRemove(boolean sw) {
        return (sw) ? "Contenido eliminado exitosamente con id: " + o.getInfo().toString() : "No se pudo eliminar el contenido";
    }

    @Override
    protected String messageFindAll(boolean sw) {
        return (sw) ? "Listado de contenidos: " : "No se pudo encontrar en listado de contenidos";
    }

}
