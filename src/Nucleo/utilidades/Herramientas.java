/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nucleo.utilidades;

import Nucleo.presentador.Bloque;
import Nucleo.presentador.Tablero;
import Nucleo.presentador.Tabla;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class Herramientas {

    public static Date convertirFechas(String fecha) {
        // Formato de fecha a ingresar dd-MM-yyyy
        Date fechaNueva = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date fechaJava = formato.parse(fecha);
            fechaNueva = new Date(fechaJava.getTime());
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return fechaNueva;
    }

    public static Date convertirFecha(String fecha) {
        // Formato de fecha a ingresar dd-MM-yyyy
        return Date.valueOf(fecha);
    }

    public static boolean ValidarFecha(String fecha) {
        // Formato de fecha a ingresar dd-MM-yyyy
        try {
            Date.valueOf(fecha);
        } catch (Exception ex) {
            return false;
            //  return "Fecha incorrecta, debe tener el formato yyyy-MM-dd";
        }
        return true;
    }

    public static boolean ValidarHora(String hora) {
        // Formato de fecha a ingresar dd-MM-yyyy

        String s[] = hora.split(":");
        if (s.length == 0) {
            return false;
        } else {
            try {
                if (Integer.valueOf(s[0]) <= 24 && Integer.valueOf(s[1]) <= 59) {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }

        }

        return false;
    }

    public static String crearUUID() {
        String result = java.util.UUID.randomUUID().toString();
        result = result.replaceAll("-", "");
        result = result.substring(0, 5);
        return result;
    }

    public static String getDestinatario(String contenido) {
        String destinatario = "";
        // Dividir en lineas
        String[] lines = contenido.split("\n");
        int index = -1;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].length() > 5
                    && lines[i].substring(0, 5).toUpperCase().equals("FROM:")) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            // Quitar la palabra 'From: '
            destinatario = lines[index].substring(6);
            lines = destinatario.split(" ");
            if (lines.length == 1) { // Correo del Server
                destinatario = lines[0];
            } else { // Desde otro Servidor de Correo
                destinatario = lines[lines.length - 1];
                destinatario = destinatario.split("<")[1].split(">")[0];
            }
        }
        return destinatario;
    }

    public static String getSubjectOrden(String contenido) {
        String orden = "";
        // Dividir en lineas
        String[] lines = contenido.split("\n");
        int index = -1;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].length() > 8
                    && lines[i].substring(0, 8).toUpperCase().equals("SUBJECT:")) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            // Quitar la palabra 'Subject: '
            orden = lines[index].substring(8);
        }
        return orden;
    }

    public static String dibujarTabla(DefaultTableModel tabla) {
        String tableString = "";
        ArrayList<String> headers = new ArrayList<>();
        ArrayList<List<String>> rowList = new ArrayList<>();

        // Agregando Los Headers
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            headers.add(tabla.getColumnName(i));
        }

        // Agregando Content
        for (int i = 0; i < tabla.getRowCount(); i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < tabla.getColumnCount(); j++) {
                row.add(String.valueOf(tabla.getValueAt(i, j)));
            }
            rowList.add(row.subList(0, row.size()));
        }

        if (rowList.size() < 1) {
            return "(Tabla Vacia)";
        }

        // Creando Tabla para mostrar
        Tablero board = new Tablero(190);
        Tabla table = new Tabla(board, 190, headers, rowList);
        Bloque tableBlock = table.tableToBlocks();
        board.setInitialBlock(tableBlock);
        board.build();
        tableString = board.getPreview();

        return tableString;
    }

    public static String quitarComillas(String texto) {
        int len = texto.length() - 1;
        return texto.substring(1, len);
    }
}
