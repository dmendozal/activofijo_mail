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
            ClienteSMTP.sendMail(destinatario, "Ayudas - Marketing\n el formato es COMANDO[\"texto\",numero,...]", Ayuda.HELP_GLOBAL);
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
            default:
                break;
        }
    }

//    private boolean verificarPermisos(String destinatario, int token) {
//        boolean b = false;
//
//        int[] usuario = {
//            Token.INSERTARUSUARIO,
//            Token.MODIFICARUSUARIO,
//            Token.ELIMINARUSUARIO,
//            Token.LISTARUSUARIOS};
//        	       
//        int[] evento = {
//            Token.INSERTAREVENTO,
//            Token.MODIFICAREVENTO,
//            Token.ELIMINAREVENTO,
//            Token.LISTAREVENTOS,
//            Token.AGREGARSERVICIOEVENTO,
//            Token.QUITARSERVICIOEVENTO,
//            Token.AGREGARFOTOS};
//        int[] zona = {
//            Token.INSERTARZONA,
//            Token.MODIFICARZONA,
//            Token.ELIMINARZONA,
//            Token.LISTARZONAS};
//        int[] promocion = {
//            Token.INSERTARPROMOCION,
//            Token.MODIFICARPROMOCION,
//            Token.ELIMINARPROMOCION,
//            Token.LISTARPROMOCIONES};
//        int[] servicio = {
//            Token.INSERTARSERVICIO,
//            Token.MODIFICARSERVICIO,
//            Token.ELIMINARSERVICIO,
//            Token.LISTARSERVICIOS,
//            Token.AGREGARPROMOCION,
//            Token.QUITARPROMOCION,
//            Token.VERPROMOCIONES};
//        int[] pedido = {
//            Token.INSERTARPEDIDO,
//            Token.MODIFICARPEDIDO,
//            Token.ELIMINARPEDIDO,
//            Token.LISTARPEDIDOS,
//            Token.AGREGAREVENTOPEDIDO,
//            Token.QUITAREVENTOPEDIDO};
//        int[] proforma = {
//            Token.INSERTARPROFORMA,
//            //Token.MODIFICARPROFORMA,
//            Token.ELIMINARPROFORMA,
//            Token.LISTARPROFORMAS,
//            Token.AGREGARSERVICIOPROFORMA,
//            Token.QUITARSERVICIOPROFORMA};
//        int[] reporte = {Token.MOSTRARESTADISTICA};
//        if(token == Token.INSERTARUSUARIO){
//            return true;
//        }
//        DPersona u = nu.obtenerUsuarioPorCorreo(destinatario);
//        if(u == null){
//            ClienteSMTP.sendMail(destinatario, "Verificacion de permisos", "Usted no se encuentra registrado en el sistema");
//            return false;
//        }
//        int tipo = u.getTipo();
//        System.out.println("DUsuario tipo:"+tipo);
//        switch (tipo) {
//            case 1:
//                b = buscarComando(usuario, token);
////                if (!b) {
////                    b = buscarComando(evento, token);
////                }
////                if (!b) {
////                    b = buscarComando(pedido, token);
////                }
////                if (!b) {
////                    b = buscarComando(proforma, token);
////                }
//                break;
//            case 2:
////                if (token == Token.AGREGARFOTOS) {
////                    b = true;
////                }
//                break;
//            case 3:
//                b = true;
//                break;
//        }
//        return b;
//    }
    private boolean buscarComando(int[] array, int valor) {
        boolean b = false;
        int i = 0;
        while (i < array.length && b == false) {
            if (valor == array[i]) {
                b = true;
            }
            i++;
        }
        return b;
    }
}
