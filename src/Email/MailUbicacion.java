/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import Negocio.NUbicacion;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;
/**
 *
 * @author Joalgt
 */
public class MailUbicacion extends TemplateMail {
    private NUbicacion o;

    public MailUbicacion() throws Exception{
        this.o = new NUbicacion();
    }

    @Override
    protected boolean insertar(Anacom anacom, String correo) throws Exception {
        try {
            anacom.Avanzar();
            int aula = Integer.parseInt(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));
            anacom.Avanzar();
            anacom.Avanzar();
            int piso = Integer.parseInt(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));

            o.add(aula,piso);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected boolean modificar(Anacom anacom, String correo) throws Exception{
        try {
            anacom.Avanzar();
            int idempresa = Integer.parseInt(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));
            anacom.Avanzar();
            anacom.Avanzar();
            int aula = Integer.parseInt(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));
            anacom.Avanzar();
            anacom.Avanzar();
            int piso = Integer.parseInt(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));
            o.update(idempresa, aula, piso);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected boolean eliminar(Anacom anacom, String correo) throws Exception{
        try {
            anacom.Avanzar();
            int id = Integer.parseInt(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));
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

