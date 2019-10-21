/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import Negocio.NAsignacion;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

/**
 *
 * @author USUARIO
 */
public class MailAsignacion extends TemplateMail {

    private NAsignacion asignacion;

    public MailAsignacion() throws Exception {
        this.asignacion = new NAsignacion();
    }

    @Override
    protected boolean insertar(Anacom anacom, String correo) throws Exception {
        try {
            anacom.Avanzar();
            int idusuario = Integer.parseInt(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));
            anacom.Avanzar();
            anacom.Avanzar();
            int idactivo = Integer.parseInt(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));

            asignacion.add(idusuario, idactivo);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    protected boolean modificar(Anacom anacom, String correo) throws Exception {
        try {
            anacom.Avanzar();
            int idusuario = Integer.parseInt(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));
            anacom.Avanzar();
            anacom.Avanzar();
            int idactivo = Integer.parseInt(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));

            asignacion.update(idusuario, idactivo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected boolean eliminar(Anacom anacom, String correo) throws Exception {
        try {
            anacom.Avanzar();
            int idusuario = Integer.parseInt(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));
            anacom.Avanzar();
            anacom.Avanzar();
            int idactivo = Integer.parseInt(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));

            asignacion.delete(idusuario, idactivo);
            return true;
        } catch (Exception e) {
            return false;
        }    }

    @Override
    protected String listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String messageCreate(boolean sw) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String messageEdit(boolean sw) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String messageRemove(boolean sw) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String messageFindAll(boolean sw) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
