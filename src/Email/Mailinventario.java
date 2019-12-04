/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import Negocio.NInventario;
import Nucleo.procesador.Anacom;
import Nucleo.utilidades.Herramientas;

/**
 *
 * @author USUARIO
 */
public class Mailinventario extends TemplateMail {

    private NInventario inventario;

    public Mailinventario() throws Exception {
        this.inventario = new NInventario();
    }

    @Override
    protected boolean insertar(Anacom anacom, String correo) throws Exception {
        try {
            anacom.Avanzar();
            int idbien = anacom.Preanalisis().getAtributo();
            anacom.Avanzar();
            anacom.Avanzar();

            inventario.add(idbien);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    protected boolean modificar(Anacom anacom, String correo) throws Exception {
        try {
            anacom.Avanzar();
            int idinventario = anacom.Preanalisis().getAtributo();
            anacom.Avanzar();
            anacom.Avanzar();
            int idbien = anacom.Preanalisis().getAtributo();

            inventario.update(idinventario,idbien);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected boolean eliminar(Anacom anacom, String correo) throws Exception {
       try {
            anacom.Avanzar(); 
            int idinventario = anacom.Preanalisis().getAtributo();
            inventario.delete(idinventario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected String listar() throws Exception {
            try {
            return inventario.Mostrar();
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    protected String messageCreate(boolean sw) {
        return (sw) ? "Contenido registrado exitosamente con id: "  + inventario.getInfo().toString() : "No se pudo registrar el contenido";
    }

    @Override
    protected String messageEdit(boolean sw) {
        return (sw) ? "Contenido modificado exitosamente con id: " + inventario.getInfo().toString() : "No se pudo modificar el contenido";
    }

    @Override
    protected String messageRemove(boolean sw) {
        return (sw) ? "Contenido eliminado exitosamente con id: " + inventario.getInfo().toString() : "No se pudo eliminar el contenido";
    }

    @Override
    protected String messageFindAll(boolean sw) {
        return (sw) ? "Listado de contenidos: " : "No se pudo encontrar en listado de contenidos";
    }

}
