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
import javax.swing.JOptionPane;

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
    private MailReportes mail_reporte = new MailReportes();

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
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "INSERTARESTADO");

                mail_estado.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITARESTADO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "EDITARESTADO");

                mail_estado.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARESTADO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "LISTARESTADO");

                mail_estado.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARESTADO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "ELIMINARESTADO");

                mail_estado.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.INSERTARMANTENIMIENTO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "INSERTARMANTENIMIENTO");

                mail_mantenimiento.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITARMANTENIMIENTO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "EDITARMANTENIMIENTO");

                mail_mantenimiento.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARMANTENIMIENTO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "LISTARMANTENIMIENTO");
                mail_mantenimiento.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARMANTENIMIENTO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "ELIMINARMANTENIMIENTO");
                mail_mantenimiento.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.INSERTARBIEN:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "INSERTARBIEN");
                mail_bien.create(anacom, destinatario, Ayuda.HELP_GLOBAL);

                break;
            case Token.EDITARBIEN:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "EDITARBIEN");
                mail_bien.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARBIEN:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "LISTARBIEN");
                mail_bien.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARBIEN:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "ELIMINARBIEN");
                mail_bien.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.INSERTARACTIVO:
                mail_activo.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "INSERTARACTIVO");

                break;
            case Token.EDITARACTIVO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "EDITARACTIVO");

                mail_activo.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARACTIVO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "LISTARACTIVO");
                mail_activo.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARACTIVO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "ELIMINARACTIVO");
                mail_activo.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            ///Modulo Usuario
            case Token.INSERTARUSUARIO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "INSERTARUSUARIO");

                mail_usaurio.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITARUSUARIO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "EDITARUSUARIO");
                mail_usaurio.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARUSUARIO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "ELIMINARUSUARIO");
                mail_usaurio.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARUSUARIO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "LISTARUSUARIO");
                mail_usaurio.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            ///Modulo Asignaciones
            case Token.INSERTARASIGNACION:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "INSERTARASIGNACION");
                mail_asignacion.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITARASIGNACION:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "EDITARASIGNACION");
                mail_asignacion.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARASIGNACION:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "ELIMINARASIGNACION");
                mail_asignacion.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARASIGNACION:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "LISTARASIGNACION");
                mail_asignacion.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            ///Modulo Inventario
            case Token.INSERTARINVENTARIO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "INSERTARINVENTARIO");
                mail_inventario.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITARINVENTARIO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "EDITARINVENTARIO");
                mail_inventario.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARINVENTARIO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "ELIMINARINVENTARIO");
                mail_inventario.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARINVENTARIO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "LISTARINVENTARIO");
                mail_inventario.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.INSERTARCARGO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "INSERTARCARGO");
                mail_cargo.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITARCARGO:
                mail_cargo.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "EDITARCARGO");

                break;
            case Token.ELIMINARCARGO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "ELIMINARCARGO");
                mail_cargo.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARCARGO:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "LISTARCARGO");
                mail_cargo.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.INSERTAREMPRESA:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "INSERTAREMPRESA");
                mail_empresa.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITAREMPRESA:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "EDITAREMPRESA");
                mail_empresa.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINAREMPRESA:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "ELIMINAREMPRESA");
                mail_empresa.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTAREMPRESA:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "LISTAREMPRESA");
                mail_empresa.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.INSERTARUBICACION:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "INSERTARUBICACION");
                mail_ubicacion.create(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.EDITARUBICACION:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "EDITARUBICACION");
                mail_ubicacion.edit(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.ELIMINARUBICACION:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "ELIMINARUBICACION");
                mail_ubicacion.remove(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARUBICACION:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "LISTARUBICACION");
                mail_ubicacion.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            case Token.LISTARREPORTE:
                JOptionPane.showMessageDialog(null, "De = " + destinatario + "\n" + "Asunto =" + "LISTARREPORTE");
                mail_reporte.findAll(anacom, destinatario, Ayuda.HELP_GLOBAL);
                break;
            default:
                break;
        }
    }

}
