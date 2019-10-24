/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import Negocio.NReporte;
import Nucleo.procesador.Anacom;

/**
 *
 * @author USUARIO
 */
public class MailReportes extends TemplateMail {

    private NReporte reporte;

    public MailReportes() throws Exception {
        this.reporte = new NReporte();
    }

    @Override
    protected boolean insertar(Anacom anacom, String correo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean modificar(Anacom anacom, String correo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean eliminar(Anacom anacom, String correo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String listar() throws Exception {
        try {
            return reporte.Mostrar();
        } catch (Exception e) {
            throw e;
        }
    }

    public String listarUsuarioActivo() throws Exception {
        try {
            return reporte.MostrarActivosUsuarios();

        } catch (Exception e) {
                        throw e;
        }
    }

    @Override
    protected String messageCreate(boolean sw) {
        return (sw) ? "Contenido registrado exitosamente con id: " + reporte.getInfo().toString() : "No se pudo registrar el contenido";
    }

    @Override
    protected String messageEdit(boolean sw) {
        return (sw) ? "Contenido modificado exitosamente con id: " + reporte.getInfo().toString() : "No se pudo modificar el contenido";
    }

    @Override
    protected String messageRemove(boolean sw) {
        return (sw) ? "Contenido eliminado exitosamente con id: " + reporte.getInfo().toString() : "No se pudo eliminar el contenido";
    }

    @Override
    protected String messageFindAll(boolean sw) {
        return (sw) ? "Listado de contenidos: " : "No se pudo encontrar en listado de contenidos";
    }

}
