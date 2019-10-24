/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software;

import Email.*;
import Nucleo.procesador.Anacom;
import Nucleo.procesador.Checker;
import Nucleo.procesador.Cinta;
import Nucleo.procesador.Token;
import Nucleo.protocolos.ClienteSMTP;
import Nucleo.utilidades.Ayuda;

public class ProcesadorMensaje {

    private MailEstado mail_estado = new MailEstado();
    private MailMantenimiento mail_mantenimiento = new MailMantenimiento();
    private MailBien mail_bien = new MailBien();
    private MailActivo mail_activo = new MailActivo();
    private MailUsuario mail_usaurio = new MailUsuario();
    private MailAsignacion mail_asignacion = new MailAsignacion();
    private Mailinventario mail_inventario = new Mailinventario();
    private MailCargo mail_cargo = new MailCargo();
    private MailEmpresa mail_empresa = new MailEmpresa();
    private MailUbicacion mail_ubicacion = new MailUbicacion();

    public ProcesadorMensaje() throws Exception {
    }

    public void processMessage(String content, String destinatario, String url, String tipo) throws Exception {

        Cinta cinta = new Cinta(content);
        Anacom anacom = new Anacom(cinta);
        Checker checker = new Checker(anacom);

        // Verificar Orden
        checker.Expresion();

        if (checker.errorFlag) {
            // Enviar Correo de Error
            ClienteSMTP.sendMail(destinatario, "ERROR DE COMANDO",
                    "El comando introducido es incorrecto, trate consultando las ayudas con el comando HELP"
            );
            System.out.println("El comando introducido es incorrecto, trate consultando las ayudas con el comando HELP");
            //System.out.println(Ayuda.HELP_INSERTARMULTIMEDIA);
            return;
        }

//      Si todo va bien, procesar el Comando
        anacom.Init();
        Token token = anacom.Preanalisis();

        if (token.getNombre() == Token.HELP) {
            // Mostrar Ayudas
            ClienteSMTP.sendMail(destinatario, "Ayudas - Activo Fijo\n el formato es COMANDO[\"texto\",numero,...]", Ayuda.HELP_GLOBAL);
            //System.out.println(Ayuda.HELP_GLOBAL);
            return;
        }

        switch (token.getAtributo()) {
            case Token.INSERTARESTADO:
                mail_estado.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITARESTADO:
                mail_estado.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARESTADO:
                mail_estado.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARESTADO:
                mail_estado.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.INSERTARMANTENIMIENTO:
                mail_mantenimiento.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITARMANTENIMIENTO:
                mail_mantenimiento.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARMANTENIMIENTO:
                mail_mantenimiento.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARMANTENIMIENTO:
                mail_mantenimiento.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.INSERTARBIEN:
                mail_bien.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITARBIEN:
                mail_bien.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARBIEN:
                mail_bien.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARBIEN:
                mail_bien.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.INSERTARACTIVO:
                mail_activo.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITARACTIVO:
                mail_activo.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARACTIVO:
                mail_activo.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARACTIVO:
                mail_activo.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
            ///Modulo Usuario
            case Token.INSERTARUSUARIO:
                mail_usaurio.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITARUSUARIO:
                mail_usaurio.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARUSUARIO:
                mail_usaurio.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARUSUARIO:
                mail_usaurio.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            ///Modulo Asignaciones
            case Token.INSERTARASIGNACION:
                mail_asignacion.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITARASIGNACION:
                mail_asignacion.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARASIGNACION:
                mail_asignacion.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARASIGNACION:
                mail_asignacion.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            ///Modulo Inventario
            case Token.INSERTARINVENTARIO:
                mail_inventario.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITARINVENTARIO:
                mail_inventario.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARINVENTARIO:
                mail_inventario.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARINVENTARIO:
                mail_inventario.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.INSERTARCARGO:
                mail_cargo.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITARCARGO:
                mail_cargo.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARCARGO:
                mail_cargo.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARCARGO:
                mail_cargo.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.INSERTAREMPRESA:
                mail_empresa.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITAREMPRESA:
                mail_empresa.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINAREMPRESA:
                mail_empresa.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTAREMPRESA:
                mail_empresa.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.INSERTARUBICACION:
                mail_ubicacion.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITARUBICACION:
                mail_ubicacion.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARUBICACION:
                mail_ubicacion.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARUBICACION:
                mail_ubicacion.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            default:
                break;
        }
    }

}
